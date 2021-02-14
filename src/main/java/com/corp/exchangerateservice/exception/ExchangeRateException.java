package com.corp.exchangerateservice.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ExchangeRateException {
	private Date timestamp;
	private String message;
	private String details;
}