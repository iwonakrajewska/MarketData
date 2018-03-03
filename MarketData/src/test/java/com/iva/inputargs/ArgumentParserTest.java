package com.iva.inputargs;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class ArgumentParserTest {

	@InjectMocks
	private ArgumentParser argumentParser;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNull() {
		String result = argumentParser.parseInutArguments(null);
		Assert.assertNull(result);
	}

	@Test
	public void testEmpt() {
		String result = argumentParser.parseInutArguments(new String[] {});
		Assert.assertNull(result);
	}

	@Test
	public void testOneParameter() {
		String result = argumentParser.parseInutArguments(new String[] { "1" });
		Assert.assertEquals("1", result);
	}

	@Test
	public void testTwoParameters() {
		String result = argumentParser.parseInutArguments(new String[] { "1", "2" });
		Assert.assertNull(result);
	}

	@Test
	public void testHelp() {
		String result = argumentParser.prepareHelp();
		Assert.assertTrue(result.contains("Help"));
	}

}
