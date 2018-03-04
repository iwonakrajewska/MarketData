
package com.iva.dto.inputdata;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

import com.iva.dto.transform.LoanDataExtended;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LoanInDefault {

	@JsonProperty("id")
	private String id;
	@JsonProperty("creditpolicy")
	private String creditpolicy;
	@JsonProperty("amount")
	private BigDecimal amount;
	@JsonProperty("eligible_collateral")
	private BigDecimal eligible_collateral;

	public LoanInDefault() {
		super();
	}

	public LoanInDefault(LoanDataExtended loanDataExtended) {
		super();
		this.id = loanDataExtended.getId();
		this.creditpolicy = loanDataExtended.getCreditpolicy();
		this.amount = loanDataExtended.getAmountBorrowed();
		this.eligible_collateral = loanDataExtended.getSumOfColaterals();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	public String getCreditpolicy() {
		return creditpolicy;
	}
	public void setCreditpolicy(String creditpolicy) {
		this.creditpolicy = creditpolicy;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getEligible_collateral() {
		return eligible_collateral;
	}

	public void setEligible_collateral(BigDecimal eligible_collateral) {
		this.eligible_collateral = eligible_collateral;
	}

}
