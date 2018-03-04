package com.iva.dto.transform;

import java.math.BigDecimal;
import java.util.List;

import com.iva.dto.inputdata.LoanData;

public class LoanDataExtended {

	private String id;
	private String creditpolicy;
	private BigDecimal amountBorrowed;
	private BigDecimal eligible_collateral;
	private String creditPolicyCurrency;
	private BigDecimal creditPolicyMinimumAcceptableEquityPrice;
	private BigDecimal sumOfColaterals;
	private boolean sumOfCollateralSmallerThanAmountBorrowed;
	private List<LoanDataEquityPositions> loanDataEquityPositions;

	public LoanDataExtended() {
	}

	public LoanDataExtended(String id, String creditpolicy, BigDecimal amount) {
		super();
		this.id = id;
		this.creditpolicy = creditpolicy;
		this.amountBorrowed = amount;
	}

	public LoanDataExtended(LoanData loanData) {
		super();
		this.id = loanData.getId();
		this.creditpolicy = loanData.getCreditpolicy();
		this.amountBorrowed = loanData.getAmount();
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

	public BigDecimal getAmountBorrowed() {
		return amountBorrowed;
	}

	public void setAmountBorrowed(BigDecimal amount) {
		this.amountBorrowed = amount;
	}

	public BigDecimal getEligible_collateral() {
		return eligible_collateral;
	}

	public void setEligible_collateral(BigDecimal eligible_collateral) {
		this.eligible_collateral = eligible_collateral;
	}

	public String getCreditPolicyCurrency() {
		return creditPolicyCurrency;
	}

	public void setCreditPolicyCurrency(String creditPolicyCurrency) {
		this.creditPolicyCurrency = creditPolicyCurrency;
	}

	public BigDecimal getCreditPolicyMinimumAcceptableEquityPrice() {
		return creditPolicyMinimumAcceptableEquityPrice;
	}

	public void setCreditPolicyMinimumAcceptableEquityPrice(BigDecimal creditPolicyMinimumAcceptableEquityPrice) {
		this.creditPolicyMinimumAcceptableEquityPrice = creditPolicyMinimumAcceptableEquityPrice;
	}

	public List<LoanDataEquityPositions> getLoanDataEquityPositions() {
		return loanDataEquityPositions;
	}

	public void setLoanDataEquityPositions(List<LoanDataEquityPositions> loanDataExtendedPositions) {
		this.loanDataEquityPositions = loanDataExtendedPositions;
	}

	public BigDecimal getSumOfColaterals() {
		return sumOfColaterals;
	}

	public void setSumOfColaterals(BigDecimal sumOfColaterals) {
		this.sumOfColaterals = sumOfColaterals;
	}

	public boolean isSumOfCollateralSmallerThanAmountBorrowed() {
		return sumOfCollateralSmallerThanAmountBorrowed;
	}

	public void setSumOfCollateralSmallerThanAmountBorrowed(boolean sumOfCollateralSmallerThanAmountBorrowed) {
		this.sumOfCollateralSmallerThanAmountBorrowed = sumOfCollateralSmallerThanAmountBorrowed;
	}

}
