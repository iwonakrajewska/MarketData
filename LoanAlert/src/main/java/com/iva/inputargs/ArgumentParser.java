package com.iva.inputargs;

import com.iva.dto.data.UrlSource;

public class ArgumentParser {

	public UrlSource parseInutArguments(String[] args) {
		if (args == null) {
			return null;
		}
		if (args.length < 3 || args.length >= 4) {
			return null;
		}
		UrlSource urlSource = new UrlSource();
		urlSource.setMarketDataUrl(args[0]);
		urlSource.setLoanDataUrl(args[1]);
		urlSource.setCreditPolicyUrl(args[2]);
		return urlSource;
	}

	public String prepareHelp() {
		StringBuilder sb = new StringBuilder();
		sb.append("Help. LoanAlerts usage:");
		sb.append(System.getProperty("line.separator"));
		sb.append(System.getProperty("line.separator"));
		sb.append("myprogram2.sh marketdataURL loandataURL creditpolicyURL");
		return sb.toString();
	}

}
