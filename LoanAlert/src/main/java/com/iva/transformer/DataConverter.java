package com.iva.transformer;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.iva.dto.inputdata.MarketData;

public class DataConverter {

	public String convertToJSon(List<? extends Object> list) {
		if (CollectionUtils.isEmpty(list)) {
			return "";
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			String arrayToJson = objectMapper.writeValueAsString(list);
			return arrayToJson;
		} catch (JsonProcessingException e) {
			System.err.println("Failed converting JSON " + e.getMessage());
		}
		return "";
	}

	public String convertMapToJSon(Map<String, ? extends Object> map) {
		if (map == null) {
			return "";
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			String arrayToJson = objectMapper.writeValueAsString(map);
			return arrayToJson;
		} catch (JsonProcessingException e) {
			System.err.println("Failed converting JSON " + e.getMessage());
		}
		return "";
	}

	public Map<String, MarketData> getMarketDataAsMap(List<MarketData> marketDataList) {
		return marketDataList.stream().collect(Collectors.toMap(MarketData::getId, Function.identity()));
	}


}
