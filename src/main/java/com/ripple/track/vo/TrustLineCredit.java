package com.ripple.track.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TrustLineCredit {
	
	@JsonProperty("credit")
    private Number credit;
	
	@JsonProperty("debt")
	private Number debt;

	public Number getCredit() {
		return credit;
	}

	public void setCredit(Number credit) {
		this.credit = credit;
	}

	public Number getDebt() {
		return debt;
	}

	public void setDebt(Number debt) {
		this.debt = debt;
	}

}
