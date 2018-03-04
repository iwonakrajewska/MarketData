package com.iva;

import com.iva.dto.data.UrlSource;
import com.iva.inputargs.ArgumentParser;
import com.iva.transformer.DataBuilder;

public class App {

    public static void main(String[] args) {
		ArgumentParser argumentParser = new ArgumentParser();
		DataBuilder builder = new DataBuilder();

		UrlSource urlSource = argumentParser.parseInutArguments(args);
		if (urlSource == null) {
			System.out.println(argumentParser.prepareHelp());
		} else {
			builder.prepareData(urlSource);
		}
	}
    
}
