package com.iva.transformer;

import java.util.List;
import java.util.Map;

import com.iva.dto.data.UrlSource;
import com.iva.dto.inputdata.CreditPolicyDetails;
import com.iva.dto.inputdata.LoanData;
import com.iva.dto.inputdata.LoanInDefault;
import com.iva.dto.inputdata.MarketData;
import com.iva.dto.transform.LoanDataExtended;
import com.iva.inputdata.DataParser;
import com.iva.inputdata.DataReader;

public class DataBuilder {

	DataReader reader = new DataReader();
	DataParser parser = new DataParser();
	DataConverter converter = new DataConverter();
	DataCalculator calculator = new DataCalculator();

	public void prepareData(UrlSource urlSource) {
		List<MarketData> marketDataList = parser.parseMarketData(reader.readRest(urlSource.getMarketDataUrl()));
		List<LoanData> loanDataList = parser.parseLoanData(reader.readRest(urlSource.getLoanDataUrl()));
		Map<String, CreditPolicyDetails> creditPolicyMap = parser.parseMap(reader.readRest(urlSource.getCreditPolicyUrl()));
		// System.out.println(converter.convertToJSon(marketDataList));
		// System.out.println(converter.convertMapToJSon(creditPolicyMap));
		// System.out.println(converter.convertToJSon(loanDataList));
		Map<String, MarketData> marketDataMap = converter.getMarketDataAsMap(marketDataList);
		List<LoanDataExtended> loanDataExtendedList = calculator.extendLoanDateWithPolicyDetails(loanDataList, creditPolicyMap, marketDataMap);
		// System.out.println(converter.convertToJSon(loanDataExtendedList));
		List<LoanDataExtended> marked = calculator.markCurrencyMismatch(loanDataExtendedList);
		// System.out.println(converter.convertToJSon(loanDataExtendedList));
		List<LoanDataExtended> sumarized = calculator.sumColaterals(loanDataExtendedList);
		// System.out.println(converter.convertToJSon(loanDataExtendedList));
		List<LoanInDefault> filtered = calculator.filterSmallerCollaterals(sumarized);
		System.out.println(converter.convertToJSon(filtered));
	}


}
