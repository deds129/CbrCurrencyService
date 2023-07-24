package com.deds.cbrcurrency.service;


import com.deds.cbrcurrency.domain.CurrencyRate;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@AllArgsConstructor
public class CurrencyRateService {
	
	private final CurrencyGettingService currencyGettingService;

	public CurrencyRate getRateByCharCode(String charCode) {
		
		//todo: add custom exception
		return currencyGettingService.getCurrencyRates().stream()
				.filter(currencyRate -> charCode.equalsIgnoreCase(currencyRate.getCharCode()))
				.findFirst().orElseThrow(() -> new RuntimeException("Currency rate not found"));
	}
}
