package com.example.payment.infrastructure.jpa;

import com.example.payment.domain.Payment;
import com.example.payment.domain.PaymentRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class PaymentRepositoryAdapter implements PaymentRepository {

	private final JpaPaymentRepository jpaPaymentRepository;

	@Override
	public Payment save(Payment entity) {
		return jpaPaymentRepository.save(entity);
	}
}
