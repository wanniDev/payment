package com.example.payment.domain;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class PaymentCardInfo {
	private String company;
	private String number;
	private Integer installmentPlanMonths;
	private String approveNo;
	private boolean useCardPoint;
	private String cardType;
	private String ownerType;
	private String receiptUrl;
	@Enumerated(EnumType.STRING)
	private PaymentsAcquireStatus acquireStatus;
	private boolean isInterestFree;

	public enum PaymentsAcquireStatus {
		READY("매입 대기"),
		REQUESTED("매입 요청됨"),
		COMPLETED("매입 완료"),
		CANCEL_REQUESTED("매입 취소 요청됨"),
		CANCELED("매입 취소 완료");

		private final String description;

		PaymentsAcquireStatus(String description) {
			this.description = description;
		}
	}
}
