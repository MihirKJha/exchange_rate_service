package com.corp.exchangerateservice.dto;

import javax.annotation.Nonnull;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ConvertCurrenciesRequest {
	@Nonnull
	private String fromCurrency;
	@Nonnull
	private String toCurrency;
	@Nonnull
	private String amount;
}
