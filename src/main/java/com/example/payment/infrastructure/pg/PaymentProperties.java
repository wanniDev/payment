package com.example.payment.infrastructure.pg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "toss.payments")
@Setter
@Getter
public class PaymentProperties {
	private String secretKey;
	private String url;
}
