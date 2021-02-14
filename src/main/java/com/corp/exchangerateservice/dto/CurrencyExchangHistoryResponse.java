package com.corp.exchangerateservice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class CurrencyExchangHistoryResponse {
	private String currency;
	private int requestCount;
}