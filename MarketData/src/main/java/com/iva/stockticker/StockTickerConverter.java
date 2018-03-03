package com.iva.stockticker;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.collections4.CollectionUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.iva.dto.marketdata.MarketData;
import com.iva.dto.stockticker.StockTicker;

public class StockTickerConverter {

	public List<StockTicker> convert(List<MarketData> marketDataList) {
		if (CollectionUtils.isEmpty(marketDataList)) {
			return Collections.emptyList();
		}
		List<StockTicker> stockTickerList = marketDataList.stream()
				.map(p -> new StockTicker(p.getTicker(), p.getPrice(), p.getId()))
				.collect(Collectors.toList());
		return stockTickerList;
	}

	public String convertToJSon(List<StockTicker> stockTickerList) {
		if (CollectionUtils.isEmpty(stockTickerList)) {
			return "";
		}
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
		try {
			String arrayToJson = objectMapper.writeValueAsString(stockTickerList);
			return arrayToJson;
		} catch (JsonProcessingException e) {
			System.err.println("Failed converting JSON " + e.getMessage());
		}
		return "";
	}

}
