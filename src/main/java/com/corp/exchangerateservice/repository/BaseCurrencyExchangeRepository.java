package com.corp.exchangerateservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corp.exchangerateservice.entity.BaseCurrencyExchangeRate;

public interface BaseCurrencyExchangeRepository extends JpaRepository<BaseCurrencyExchangeRate, Long> {	
	BaseCurrencyExchangeRate findByCurrencyTo(String currencyTo);
}
