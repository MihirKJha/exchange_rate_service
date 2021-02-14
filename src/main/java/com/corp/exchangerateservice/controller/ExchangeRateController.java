package com.corp.exchangerateservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corp.exchangerateservice.dto.ConvertCurrenciesRequest;
import com.corp.exchangerateservice.dto.CurrencyExchangHistoryResponse;
import com.corp.exchangerateservice.service.ExchangeRateService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api("Rest controller for exchnage rate")
@RestController
@RequestMapping(value = "/exchangeService",
	produces = MediaType.APPLICATION_JSON_VALUE,
	consumes = MediaType.APPLICATION_JSON_VALUE)
public class ExchangeRateController {

	@Autowired
	private ExchangeRateService exchangeService;

	@ApiOperation("API to get exchange rate with base currency")
	@GetMapping("/baseExchangeRate/{fromCurrency}")
	public double baseExchangeRate(@PathVariable @Validated String fromCurrency) {
		return exchangeService.getBaseExchangeRate(fromCurrency);
	}
	
	@ApiOperation("API to get exchange rate between two currency")
	@GetMapping("/derivedExchangeRate/{fromCurrency}/{toCurrency}")
	public double deriveExchangeRate(@PathVariable @Validated String fromCurrency,@PathVariable @Validated String toCurrency) {
		return exchangeService.deriveExchangeRate(fromCurrency,toCurrency);
	}
	
	
	@ApiOperation("API to convert one currency to another currency")
	@PostMapping("/convertCurrencies")
	public double convertCurrencies(@RequestBody @Validated ConvertCurrenciesRequest convertCurrenciesRequest) {
		return exchangeService.convertCurrencies(convertCurrenciesRequest);
	}
		

	@ApiOperation("API to get supported currencies and exchangeHistory ")
	@GetMapping("/exchangeHistory")
	public List<CurrencyExchangHistoryResponse>  exchangeHistory() {
		return exchangeService.getExchangeHistory();
	}
	
	@ApiOperation("API to get public link for currencies conversion rate")
	@GetMapping("/publicLink")
	public String publicLink() {
		return exchangeService.getPublicUrl();
	}	
}