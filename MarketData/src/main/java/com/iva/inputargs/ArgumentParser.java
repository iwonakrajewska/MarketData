package com.iva.inputargs;

public class ArgumentParser {

	public String parseInutArguments(String[] args) {
		if (args == null) {
			return null;
		}
		if (args.length < 1 || args.length >= 2) {
			return null;
		}
		String url = args[0];
		return url;
	}

	public String prepareHelp() {
		StringBuilder sb = new StringBuilder();
		sb.append("Help. MarketData usage:");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("myprogram.sh url");
		return sb.toString();
	}

}
