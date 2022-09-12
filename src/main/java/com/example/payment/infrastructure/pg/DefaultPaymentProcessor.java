package com.example.payment.infrastructure.pg;

import com.example.payment.domain.PaymentProcessor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultPaymentProcessor implements PaymentProcessor {

	private final PaymentApprovalCommandVerifier commandVerifier;
	private final PaymentApprovalProcessor approvalProcessor;

	@Override
	public void payed(String orderId, String paymentKey, Integer amount) {
		commandVerifier.verify(orderId, paymentKey, amount);
		PaymentCompletedResponse response = approvalProcessor
			.approval(orderId, paymentKey, amount);
	}
}
