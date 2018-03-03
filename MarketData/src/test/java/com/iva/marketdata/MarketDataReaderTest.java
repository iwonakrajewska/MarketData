package com.iva.marketdata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class MarketDataReaderTest {

	@InjectMocks
	private MarketDataReader marketDataReader;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNull() {
		String result = marketDataReader.readRest(null);
		Assert.assertNull(result);
	}

	@Test
	public void testInvalidUrl() {
		String result = marketDataReader.readRest("dummy");
		Assert.assertNull(result);
	}

	@Test
	public void testWrongResponse() {
		String result = marketDataReader.readRest("http://alert-generation-question.rockall-laser.com");
		Assert.assertNull(result);
	}

	@Test
	public void testCorrectResponse() {
		String result = marketDataReader.readRest("http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/marketdata.json");
		Assert.assertTrue(result.contains("\"currency\": \"USD\""));
	}

}
