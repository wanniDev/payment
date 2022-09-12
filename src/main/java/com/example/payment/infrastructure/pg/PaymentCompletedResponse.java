package com.example.payment.infrastructure.pg;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public final class PaymentCompletedResponse {
	private String version;
	private String orderId;
	private String orderName;
	private String paymentKey;
	private String type;
	private String method;
	private String mid;
	private String currency;
	private boolean useEscrow;
	private boolean cultureExpense;
	private String secret;
	private Integer totalAmount;
	private Integer balanceAmount;
	private Integer suppliedAmount;
	private String status;
	private LocalDateTime requestedAt;
	private LocalDateTime approvedAt;
	private String transactionKey;
	private Integer vat;
	private Integer taxFreeAmount;
	private PaymentCardInfoResponse card;
}
