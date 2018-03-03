package com.iva.stockticker;

import java.util.List;

import com.iva.dto.marketdata.MarketData;
import com.iva.dto.stockticker.StockTicker;
import com.iva.marketdata.MarketDataParser;
import com.iva.marketdata.MarketDataReader;

public class StockTickerBuilder {

	MarketDataReader reader = new MarketDataReader();
	MarketDataParser parser = new MarketDataParser();
	StockTickerConverter converter = new StockTickerConverter();

	public String prepareData(String url) {
		String jsonString = reader.readRest(url);
		List<MarketData> marketDataList = parser.parse(jsonString);
		List<StockTicker> stockTickerList = converter.convert(marketDataList);
		return converter.convertToJSon(stockTickerList);
	}

}
