package com.iva.dto.stockticker;

import java.math.BigDecimal;

public class StockTicker {

	private String ticker;
	private BigDecimal price;
	private String isin;

	public StockTicker() {
	}

	public StockTicker(String ticker, BigDecimal price, String isin) {
		super();
		this.ticker = ticker;
		this.price = price;
		this.isin = isin;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getIsin() {
		return isin;
	}

	public void setIsin(String isin) {
		this.isin = isin;
	}

}
