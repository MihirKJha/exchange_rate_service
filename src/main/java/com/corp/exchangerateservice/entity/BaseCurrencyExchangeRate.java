package com.corp.exchangerateservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "BASE_CURRENCY_EXCHANGE_RATE")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseCurrencyExchangeRate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "BASE_CURRENCY")
	private String baseCurrency;

	@Column(name = "CURRENCY_TO")
	private String currencyTo;

	@Column(name = "CONVERSION_MULTIPLE")
	private double rate;
}