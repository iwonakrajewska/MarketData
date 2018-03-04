
package com.iva.dto.inputdata;

import java.math.BigDecimal;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanData {

	@JsonProperty("amount")
	private BigDecimal amount;
	@JsonProperty("creditpolicy")
	private String creditpolicy;
	@JsonProperty("id")
	private String id;
	@JsonProperty("positions")
	private List<LoanDataPositionItem> positions;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getCreditpolicy() {
		return creditpolicy;
	}

	public void setCreditpolicy(String creditpolicy) {
		this.creditpolicy = creditpolicy;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<LoanDataPositionItem> getPositions() {
		return positions;
	}

	public void setPositions(List<LoanDataPositionItem> positions) {
		this.positions = positions;
	}


}
