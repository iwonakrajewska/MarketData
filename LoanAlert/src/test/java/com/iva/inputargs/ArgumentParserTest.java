package com.iva.inputargs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.iva.dto.data.UrlSource;

public class ArgumentParserTest {

	@InjectMocks
	private ArgumentParser argumentParser;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNull() {
		UrlSource result = argumentParser.parseInutArguments(null);
		Assert.assertNull(result);
	}

	@Test
	public void testEmpt() {
		UrlSource result = argumentParser.parseInutArguments(new String[] {});
		Assert.assertNull(result);
	}

	@Test
	public void testOneParameter() {
		UrlSource result = argumentParser.parseInutArguments(new String[] { "1" });
		Assert.assertNull(result);
	}

	@Test
	public void testTwoParameters() {
		UrlSource result = argumentParser.parseInutArguments(new String[] { "1", "2" });
		Assert.assertNull(result);
	}

	@Test
	public void testThreeParameters() {
		UrlSource result = argumentParser.parseInutArguments(new String[] { "1", "2", "3" });
		Assert.assertNotNull(result);
	}

	@Test
	public void testFourParameters() {
		UrlSource result = argumentParser.parseInutArguments(new String[] { "1", "2", "3", "4" });
		Assert.assertNull(result);
	}

	@Test
	public void testHelp() {
		String result = argumentParser.prepareHelp();
		Assert.assertTrue(result.contains("Help"));
	}

}
