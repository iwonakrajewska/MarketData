package com.iva.inputdata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DataReader {

	public String readRest(String urlText) {
		try {

			URL url = new URL(urlText);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				System.err.println("Failed : HTTP error code : " + conn.getResponseCode());
				return null;
			}

			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				content.append(inputLine);
			}
			in.close();
			conn.disconnect();
			// System.out.println(content.toString());
			return content.toString();

		} catch (MalformedURLException e) {
			System.err.println("Failed : Incorrect URL. " + e.getMessage());
		} catch (IOException e) {
			System.err.println("Failed : There was a problem. " + e.getMessage());
		}
		return null;
	}
}
