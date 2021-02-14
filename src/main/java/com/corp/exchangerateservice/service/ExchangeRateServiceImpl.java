package com.corp.exchangerateservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corp.exchangerateservice.AppConstants;
import com.corp.exchangerateservice.dto.ConvertCurrenciesRequest;
import com.corp.exchangerateservice.dto.CurrencyExchangHistoryResponse;
import com.corp.exchangerateservice.entity.BaseCurrencyExchangeRate;
import com.corp.exchangerateservice.entity.CurrencyExchangeRequestHistory;
import com.corp.exchangerateservice.exception.CurrencyNotFoundException;
import com.corp.exchangerateservice.repository.BaseCurrencyExchangeRepository;
import com.corp.exchangerateservice.repository.CurrencyExchangeHistoryRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ExchangeRateServiceImpl implements ExchangeRateService {

	@Autowired
	private BaseCurrencyExchangeRepository baseCurrencyExchangeRepository;

	@Autowired
	private CurrencyExchangeHistoryRepository currencyExchangeHistoryRepository;
	

	/**
	 * {@inheritDoc}
	 */
    @Override
	public double getBaseExchangeRate(String fromCurrency) {
    	BaseCurrencyExchangeRate baseExchargeRate =baseCurrencyExchangeRepository.findByCurrencyTo(fromCurrency);
    	if(baseExchargeRate==null) {
    		throw new CurrencyNotFoundException(AppConstants.CURRENCY_NOT_FOUND);
    	}
    	
    	log.info("Rate in getBaseExchangeRate " + baseExchargeRate.getRate());
    	
		return baseExchargeRate.getRate();
	}

    /**
	 * {@inheritDoc}
	 */
	@Override
	public double deriveExchangeRate(String fromCurrency, String toCurrency) {
		BaseCurrencyExchangeRate fromBaseRate =baseCurrencyExchangeRepository.findByCurrencyTo(fromCurrency);
		
		if(fromBaseRate==null) {
    		throw new CurrencyNotFoundException(AppConstants.CURRENCY_NOT_FOUND);
    	}
    	
    	log.info("fromBaseRate in getBaseExchangeRate " + fromBaseRate.getRate());
    	
		BaseCurrencyExchangeRate toBaseRate =baseCurrencyExchangeRepository.findByCurrencyTo(toCurrency);
		
		if(toBaseRate==null) {
    		throw new CurrencyNotFoundException(AppConstants.CURRENCY_NOT_FOUND);
    	}
    	
    	log.info("toBaseRate in getBaseExchangeRate " + toBaseRate.getRate());
    	
		double derivedExrate = toBaseRate.getRate()/fromBaseRate.getRate();
		
		return derivedExrate;
	}

	@Override
	public double convertCurrencies(ConvertCurrenciesRequest convertCurrenciesRequest) {
		double conversionRate =this.deriveExchangeRate(convertCurrenciesRequest.getFromCurrency(), convertCurrenciesRequest.getToCurrency());
		double calculatedAmount = conversionRate*(Double.parseDouble(convertCurrenciesRequest.getAmount()));
		
		CurrencyExchangeRequestHistory exchnageHistory = CurrencyExchangeRequestHistory.builder()
				.baseCurrency(convertCurrenciesRequest.getFromCurrency()).currencyTo(convertCurrenciesRequest.getToCurrency())
				.amount(convertCurrenciesRequest.getAmount()).build();
		
		this.currencyExchangeHistoryRepository.save(exchnageHistory);
		
		return calculatedAmount;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CurrencyExchangHistoryResponse> getExchangeHistory() {
		List<CurrencyExchangHistoryResponse> exchangeHistoryList = new ArrayList<>();
		List<String> supportedCurrencies = this.baseCurrencyExchangeRepository.findAll()
				.stream()
				.map(BaseCurrencyExchangeRate::getCurrencyTo)
				.collect(Collectors.toList());
		
		supportedCurrencies.forEach(
				c->{
					CurrencyExchangHistoryResponse exRespone = CurrencyExchangHistoryResponse.builder()
							.currency(c).requestCount(this.currencyExchangeHistoryRepository.findByCurrencyTo(c).size()).build();
					exchangeHistoryList.add(exRespone);
				}
				);			
		
		return exchangeHistoryList;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPublicUrl() {
		return AppConstants.PUBLIC_URL;
	}
}