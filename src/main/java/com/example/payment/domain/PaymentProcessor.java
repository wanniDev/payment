package com.example.payment.domain;

public interface PaymentProcessor {
	void payed(String orderId, String paymentKey, Integer amount);
}
