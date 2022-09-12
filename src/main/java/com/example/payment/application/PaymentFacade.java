package com.example.payment.application;

import org.springframework.stereotype.Service;

import com.example.payment.domain.PaymentProcessor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentFacade {
	private final PaymentProcessor paymentProcessor;

	public void payed(PaymentApprovalCommand command) {
		paymentProcessor.payed(command.orderId(), command.paymentKey(), command.amount());
	}
}
