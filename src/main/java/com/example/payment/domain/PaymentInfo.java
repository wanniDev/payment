package com.example.payment.domain;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class PaymentInfo {
	private String version;
	private String orderId;
	private String orderName;
	private String paymentKey;
	private String type;
	private String mid;
	private Integer totalAmount;
	private Integer balanceAmount;
	private Integer suppliedAmount;
	private String status;
	private LocalDateTime requestedAt;
	private LocalDateTime approvedAt;
	private String transactionKey;
	private Integer vat;
	private Integer taxFreeAmount;

}
