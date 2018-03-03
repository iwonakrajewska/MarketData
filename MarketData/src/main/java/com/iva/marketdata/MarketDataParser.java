package com.iva.marketdata;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iva.dto.marketdata.MarketData;

public class MarketDataParser {

	public List<MarketData> parse(String jsonString) {
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

}
