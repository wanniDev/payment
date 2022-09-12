package com.example.payment.infrastructure.pg;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class PaymentCardInfoResponse {
	private String company;
	private String number;
	private Integer installmentPlanMonths;
	private String approveNo;
	private boolean useCardPoint;
	private String cardType;
	private String ownerType;
	private String receiptUrl;
	private String acquireStatus;
	private boolean isInterestFree;
}
