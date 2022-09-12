package com.example.payment.application;


public record PaymentApprovalCommand(String orderId, String paymentKey, Integer amount) {}
