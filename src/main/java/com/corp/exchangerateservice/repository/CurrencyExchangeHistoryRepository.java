package com.corp.exchangerateservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.corp.exchangerateservice.entity.CurrencyExchangeRequestHistory;

public interface CurrencyExchangeHistoryRepository extends JpaRepository<CurrencyExchangeRequestHistory, Long> {
	List<CurrencyExchangeRequestHistory> findByCurrencyTo(String currencyTo);
}
