package com.iva.transformer;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.iva.dto.inputdata.CreditPolicyDetails;
import com.iva.dto.inputdata.LoanData;
import com.iva.dto.inputdata.LoanInDefault;
import com.iva.dto.inputdata.MarketData;
import com.iva.dto.transform.LoanDataEquityPositions;
import com.iva.dto.transform.LoanDataExtended;

public class DataCalculator {


	public List<LoanDataExtended> extendLoanDateWithPolicyDetails(List<LoanData> loanDataList, Map<String, CreditPolicyDetails> creditPolicyMap, Map<String, MarketData> marketDataMap) {
		if (CollectionUtils.isEmpty(loanDataList)) {
			return Collections.emptyList();
		}
		List<LoanDataExtended> loanDataExtendedList = loanDataList.stream().map(p -> {
			LoanDataExtended loanDataExtended = new LoanDataExtended(p);
			List<LoanDataEquityPositions> list = p.getPositions().stream().map(pos -> {
				LoanDataEquityPositions equityPosition = new LoanDataEquityPositions(pos);
				MarketData marketData = marketDataMap.get(equityPosition.getId_isin());
				if (marketData != null) {
					equityPosition.setShareCurrency(marketData.getCurrency());
					equityPosition.setSharePrice(marketData.getPrice());
				}
				return equityPosition;

			}).collect(Collectors.toList());
			loanDataExtended.setLoanDataEquityPositions(list);
			return loanDataExtended;
		}).map(p -> {
			CreditPolicyDetails cpd = creditPolicyMap.get(p.getCreditpolicy());
			if (cpd != null) {
				p.setCreditPolicyCurrency(cpd.getCurrency());
				p.setCreditPolicyMinimumAcceptableEquityPrice(cpd.getPrice());
			}
			return p;
		}).collect(Collectors.toList());

		return loanDataExtendedList;
	}

	public List<LoanDataExtended> markCurrencyMismatch(List<LoanDataExtended> loanDataExtendedList) {
		List<LoanDataExtended> marked = loanDataExtendedList.stream().map(loanDataExtended -> {
			List<LoanDataEquityPositions> loanPositions = loanDataExtended.getLoanDataEquityPositions();
			String loanCurrency = loanDataExtended.getCreditPolicyCurrency();
			BigDecimal loanMinPrice = loanDataExtended.getCreditPolicyMinimumAcceptableEquityPrice();

			loanPositions.stream().map(p -> {
				updateCurrencyMatch(p, loanCurrency, loanMinPrice);
				return p;
			}).collect(Collectors.toList());

			return loanDataExtended;
		}).collect(Collectors.toList());

		return marked;
	}

	private void updateCurrencyMatch(LoanDataEquityPositions loanDataEquityPositions, String loanCurrency, BigDecimal loanMinPrice) {
		if (loanCurrency.equals(loanDataEquityPositions.getShareCurrency())) {
			loanDataEquityPositions.setCurrencyMatch(true);
		}
		if (loanMinPrice.compareTo(loanDataEquityPositions.getSharePrice()) < 0) {
			loanDataEquityPositions.setMinPriceMatch(true);
		}
		boolean currencyMatch = loanDataEquityPositions.isCurrencyMatch();
		boolean priceMatch = loanDataEquityPositions.isMinPriceMatch();
		if (currencyMatch && priceMatch) {
			Long shareNumber = loanDataEquityPositions.getNumberOfSharesOwned();
			BigDecimal sharePrice = loanDataEquityPositions.getSharePrice();
			loanDataEquityPositions.setColateralValue(sharePrice.multiply(new BigDecimal(shareNumber.longValue())));
		} else {
			loanDataEquityPositions.setColateralValue(BigDecimal.ZERO);
		}

	}

	public List<LoanDataExtended> sumColaterals(List<LoanDataExtended> loanDataExtendedList) {
		List<LoanDataExtended> sumarized = loanDataExtendedList.stream().map(loanDataExtended -> {
			List<LoanDataEquityPositions> loanPositions = loanDataExtended.getLoanDataEquityPositions();
			BigDecimal sumOfColaterals = loanPositions.stream().map(LoanDataEquityPositions::getColateralValue).reduce(BigDecimal.ZERO, BigDecimal::add);

			loanDataExtended.setSumOfColaterals(sumOfColaterals);
			if (sumOfColaterals.compareTo(BigDecimal.ZERO) > 0) {
				if (sumOfColaterals.compareTo(loanDataExtended.getAmountBorrowed()) < 0) {
					loanDataExtended.setSumOfCollateralSmallerThanAmountBorrowed(true);
				}
			}

			return loanDataExtended;
		}).collect(Collectors.toList());
		return sumarized;
	}

	public List<LoanInDefault> filterSmallerCollaterals(List<LoanDataExtended> loanDataExtendedList) {
		return loanDataExtendedList.stream()
				 .filter(p -> p.isSumOfCollateralSmallerThanAmountBorrowed() )
				 .map(p -> new LoanInDefault(p))
				 .collect(Collectors.toList());
	}
}
