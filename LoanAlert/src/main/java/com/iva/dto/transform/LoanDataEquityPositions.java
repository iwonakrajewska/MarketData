package com.iva.dto.transform;

import java.math.BigDecimal;

import com.iva.dto.inputdata.LoanDataPositionItem;

public class LoanDataEquityPositions {

	private String id_isin;
	private Long numberOfSharesOwned;
	private String shareCurrency;
	private BigDecimal sharePrice;
	private boolean currencyMatch;
	private boolean minPriceMatch;
	private BigDecimal colateralValue;

	public LoanDataEquityPositions() {
		super();
	}

	public LoanDataEquityPositions(LoanDataPositionItem loanDataPositionItem) {
		super();
		this.id_isin = loanDataPositionItem.getId();
		this.numberOfSharesOwned = loanDataPositionItem.getQuantity();
	}

	public Long getNumberOfSharesOwned() {
		return numberOfSharesOwned;
	}

	public void setNumberOfSharesOwned(Long quantity) {
		this.numberOfSharesOwned = quantity;
	}

	public String getShareCurrency() {
		return shareCurrency;
	}

	public void setShareCurrency(String shareCurrency) {
		this.shareCurrency = shareCurrency;
	}

	public BigDecimal getSharePrice() {
		return sharePrice;
	}

	public void setSharePrice(BigDecimal sharePrice) {
		this.sharePrice = sharePrice;
	}

	public String getId_isin() {
		return id_isin;
	}

	public void setId_isin(String id_isin) {
		this.id_isin = id_isin;
	}

	public boolean isCurrencyMatch() {
		return currencyMatch;
	}

	public void setCurrencyMatch(boolean currencyMatch) {
		this.currencyMatch = currencyMatch;
	}

	public boolean isMinPriceMatch() {
		return minPriceMatch;
	}

	public void setMinPriceMatch(boolean minPriceMatch) {
		this.minPriceMatch = minPriceMatch;
	}

	public BigDecimal getColateralValue() {
		return colateralValue;
	}

	public void setColateralValue(BigDecimal colateralValue) {
		this.colateralValue = colateralValue;
	}

}
