package com.example.payment.infrastructure.pg;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentApprovalProcessor {
	private final RestTemplate restTemplate;
	private final PaymentProperties paymentProperties;

	// TODO 결제 승인 요청 과정에서 실패한 경우 예외처리 필요.
	public PaymentCompletedResponse approval(String orderId, String paymentKey,
		Integer amount) {
		HttpEntity<Map<String, String>> request = createRequest(
			createHeaders(),
			orderId, amount);
		ResponseEntity<PaymentCompletedResponse> result = restTemplate.postForEntity(
			paymentProperties.getUrl() + paymentKey, request,
			PaymentCompletedResponse.class);
		return result.getBody();
	}

	private HttpEntity<Map<String, String>> createRequest(HttpHeaders headers,
		String orderId, Integer amount) {
		var payloadMap = new HashMap<String, String>();
		payloadMap.put("orderId", orderId);
		payloadMap.put("amount", String.valueOf(amount));
		return new HttpEntity<>(payloadMap, headers);
	}

	private HttpHeaders createHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(paymentProperties.getSecretKey());
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
