package com.iva.stockticker;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.iva.dto.marketdata.MarketData;
import com.iva.dto.stockticker.StockTicker;

public class StockTickerConverterTest {

	@InjectMocks
	private StockTickerConverter stockTickerConverter;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNull() {
		List<StockTicker> result = stockTickerConverter.convert(null);
		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testOne() {
		List<MarketData> marketDataList = new ArrayList<>();
		MarketData md = new MarketData();
		md.setCurrency("cur");
		md.setExchange("ex");
		md.setId("id");
		md.setName("name");
		md.setTicker("tic");
		md.setPrice(new BigDecimal("1.2345678"));
		marketDataList.add(md);
		List<StockTicker> result = stockTickerConverter.convert(marketDataList);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("id", result.get(0).getIsin());
		Assert.assertEquals("tic", result.get(0).getTicker());
		Assert.assertEquals("1.2345678", result.get(0).getPrice().toString());
	}

	@Test
	public void testNullToJson() {
		String result = stockTickerConverter.convertToJSon(null);
		Assert.assertEquals("", result);
	}

	@Test
	public void testOneTicker() {
		List<StockTicker> stockTickerList = new ArrayList<>();
		stockTickerList.add(new StockTicker("tic", new BigDecimal("1.23456789"), "isin"));
		String result = stockTickerConverter.convertToJSon(stockTickerList);
		Assert.assertTrue(result.contains("\"ticker\" : \"tic\""));
		Assert.assertTrue(result.contains("\"isin\" : \"isin\""));
		Assert.assertTrue(result.contains("\"price\" : 1.23456789"));
	}

	@Test
	public void testEmptyTicker() {
		List<StockTicker> stockTickerList = new ArrayList<>();
		stockTickerList.add(new StockTicker());
		String result = stockTickerConverter.convertToJSon(stockTickerList);
		Assert.assertTrue(result.contains("\"ticker\" : null"));
		Assert.assertTrue(result.contains("\"isin\" : null"));
		Assert.assertTrue(result.contains("\"price\" : null"));
	}

}
