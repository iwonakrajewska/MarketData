package com.iva.marketdata;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.iva.dto.marketdata.MarketData;

public class MarketDataParserTest {

	@InjectMocks
	private MarketDataParser marketDataParser;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNull() {
		List<MarketData> result = marketDataParser.parse(null);
		Assert.assertNull(result);
	}

	@Test
	public void testIncorrectInput() {
		List<MarketData> result = marketDataParser.parse("dummy");
		Assert.assertNull(result);
	}

	@Test
	public void testCorrectInput() {
		String testData = "[{  \"currency\": \"USD\",  \"ticker\": \"H\",  \"exchange\": \"USNYSE\",  \"id\": \"US4485791028\",  \"price\": 51.3100,  \"name\": \"Hyatt Hotels Corporation\"},{  \"currency\": \"USD\",  \"ticker\": \"WNRP\",  \"exchange\": \"USOTC\",    \"id\": \"US9561524094\",  \"price\": 465.0000,  \"name\": \"West Suburban Bancorp Inc\"}]";
		List<MarketData> result = marketDataParser.parse(testData);
		Assert.assertEquals(2, result.size());
	}

	@Test
	public void testsingleInput() {
		String testData = "[ { \"currency\": \"EUR\", \"price\": 1.4700,  \"exchange\": \"XDUB\",\"name\":\"my name\",  \"id\": \"IE0003295239\"}]";
		List<MarketData> result = marketDataParser.parse(testData);
		Assert.assertEquals(1, result.size());
		Assert.assertEquals("EUR", result.get(0).getCurrency());
		Assert.assertEquals("XDUB", result.get(0).getExchange());
		Assert.assertEquals("my name", result.get(0).getName());
		Assert.assertTrue(new BigDecimal("1.47").compareTo(result.get(0).getPrice()) == 0);
		Assert.assertEquals("IE0003295239", result.get(0).getId());
		Assert.assertNull(result.get(0).getTicker());
	}

}
