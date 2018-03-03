package com.iva;

import org.apache.commons.lang3.StringUtils;

import com.iva.inputargs.ArgumentParser;
import com.iva.stockticker.StockTickerBuilder;

public class App {

    public static void main(String[] args) {
		ArgumentParser argumentParser = new ArgumentParser();
		StockTickerBuilder builder = new StockTickerBuilder();

		String url = argumentParser.parseInutArguments(args);
		if (StringUtils.isBlank(url)) {
			System.out.println(argumentParser.prepareHelp());
		} else {
			System.out.println(builder.prepareData(url));
		}
	}
    
}
