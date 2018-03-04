package com.iva;

import org.junit.Test;


public class AppTest {

	// @Test
    public void testApp() {
		App.main(new String[] {});
    }

	// @Test
	public void testApp2params() {
		App.main(new String[] { "1", "2" });
	}

	// @Test
	public void testApp1param() {
		App.main(new String[] { "1" });
	}

	// @Test
	public void testApp3param() {
		App.main(new String[] { "1", "2", "3" });
	}

	@Test
	public void testUrl() {
		App.main(new String[] { "http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/marketdata.json", "http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/loandata.json",
				"http://alert-generation-question.rockall-laser.com/ffc9c8e9-f929-46db-ac5c-7c483c647568/creditpolicy.json" });
	}

}
