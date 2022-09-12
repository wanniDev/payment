package com.example.payment.domain;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class PaymentCancelInfo {
	private Integer cancelAmount;
	private Integer refundableAmount;
	private String cancelReason;
	private Integer taxFreeAmountCancel;
	private LocalDateTime canceledAt;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		PaymentCancelInfo that = (PaymentCancelInfo)o;
		return Objects.equals(cancelAmount, that.cancelAmount) && Objects.equals(refundableAmount,
			that.refundableAmount) && Objects.equals(cancelReason, that.cancelReason) && Objects.equals(
			taxFreeAmountCancel, that.taxFreeAmountCancel) && Objects.equals(canceledAt, that.canceledAt);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cancelAmount, refundableAmount, cancelReason, taxFreeAmountCancel, canceledAt);
	}
}
