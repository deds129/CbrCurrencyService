package com.deds.cbrcurrency.controller;

import com.deds.cbrcurrency.domain.CurrencyRate;
import com.deds.cbrcurrency.service.CurrencyRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${app.rest.api.prefix}")
public class CbrCurrencyController {
	
	private final CurrencyRateService currencyRateService;

	//todo add some endpoints 
	//todo add openApi + swagger(springdoc)
	@GetMapping("/{currencyCode}")
	public CurrencyRate getRateByCharCode(@PathVariable String currencyCode) {
		return currencyRateService.getRateByCharCode(currencyCode);
	}
	
}
