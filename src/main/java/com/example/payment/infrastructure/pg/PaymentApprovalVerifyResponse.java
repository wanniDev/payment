package com.example.payment.infrastructure.pg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaymentApprovalVerifyResponse {
	private String orderId;
	private Integer totalAmount;

	public boolean isSatisfiedBy(String orderId, Integer totalAmount) {
		return this.orderId.equals(orderId)
			&& this.totalAmount.intValue() == totalAmount.intValue();
	}
}
