package com.iva.inputdata;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iva.dto.inputdata.CreditPolicyDetails;
import com.iva.dto.inputdata.LoanData;
import com.iva.dto.inputdata.MarketData;

public class DataParser {

	public  List<MarketData> parseMarketData(String jsonString) {
		if (StringUtils.isBlank(jsonString)) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return Arrays.asList(mapper.readValue(jsonString, MarketData[].class));
		} catch (IOException e) {
			System.err.println("Failed parsing data. " + e.getMessage());
		}
		return null;
	}

	public Map<String, CreditPolicyDetails> parseMap(String jsonString) {
		if (StringUtils.isBlank(jsonString)) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.readValue(jsonString, new TypeReference<Map<String, CreditPolicyDetails>>() {
			});
		} catch (IOException e) {
			System.err.println("Failed parsing data. " + e.getMessage());
		}
		return null;
	}

	public List<LoanData> parseLoanData(String jsonString) {
		if (StringUtils.isBlank(jsonString)) {
			return null;
		}
		ObjectMapper mapper = new ObjectMapper();
		try {
			return Arrays.asList(mapper.readValue(jsonString, LoanData[].class));
		} catch (IOException e) {
			System.err.println("Failed parsing data. " + e.getMessage());
		}
		return null;
	}
}
