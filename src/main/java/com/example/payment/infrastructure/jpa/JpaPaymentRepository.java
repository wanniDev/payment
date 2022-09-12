package com.example.payment.infrastructure.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.payment.domain.Payment;

public interface JpaPaymentRepository extends JpaRepository<Payment, Long> {
}
