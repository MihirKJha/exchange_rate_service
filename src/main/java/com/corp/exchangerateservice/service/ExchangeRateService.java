package com.corp.exchangerateservice.service;

import java.util.List;

import com.corp.exchangerateservice.dto.ConvertCurrenciesRequest;
import com.corp.exchangerateservice.dto.CurrencyExchangHistoryResponse;

public interface ExchangeRateService {
    
	/**
	 * Method to get exchange rate with base currency
	 * 
	 * @param fromCurrency
	 * @return
	 */
	public double getBaseExchangeRate(String fromCurrency);
    
	/**
	 * Method to get exchange rate between two currency
	 * 
	 * @param fromCurrency
	 * @param toCurrency
	 * @return
	 */
	public double deriveExchangeRate(String fromCurrency,String toCurrency);
	
	/**
	 * Method to convert one currency to another currency
	 * 
	 * @param ConvertCurrenciesRequest convertCurrenciesRequest
	 * @return
	 */
	public double convertCurrencies(ConvertCurrenciesRequest convertCurrenciesRequest);
	
	/**
	 * Method to get supported currencies and exchangeHistory 
	 * 
	 * @return List<CurrencyExchangHistoryResponse>
	 */
	public List<CurrencyExchangHistoryResponse> getExchangeHistory();
	
	/**
	 * Method to get public link for currencies conversion rate
	 * 
	 * @return
	 */
	public String getPublicUrl();

}