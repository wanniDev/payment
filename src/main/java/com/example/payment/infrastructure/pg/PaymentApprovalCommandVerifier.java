package com.example.payment.infrastructure.pg;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PaymentApprovalCommandVerifier {
	private final RestTemplate restTemplate;
	private final PaymentProperties paymentProperties;

	public void verify(String orderId, String paymentKey, Integer amount) {
		var request = createRequest(createHeaders());
		var response = restTemplate.exchange(
			paymentProperties.getUrl() + paymentKey,
			HttpMethod.GET, request, PaymentApprovalVerifyResponse.class);

		if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
			// TODO PaymentsKey가 변조됨에 따라 적절한 예외 처리가 필요함.
		}

		var paymentResponse = response.getBody();
		if (!paymentResponse.isSatisfiedBy(orderId, amount)) {
			// TODO 클라이언트가 OrderId와 Amount를 변조시켰으므로 예외 처리 필요함.
		}
	}

	private HttpEntity<String> createRequest(HttpHeaders headers) {
		return new HttpEntity<>(headers);
	}

	private HttpHeaders createHeaders() {
		var headers = new HttpHeaders();
		headers.setBasicAuth(paymentProperties.getSecretKey());
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
}
