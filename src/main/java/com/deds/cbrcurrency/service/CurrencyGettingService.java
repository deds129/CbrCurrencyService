package com.deds.cbrcurrency.service;


import com.deds.cbrcurrency.cbrclient.CbrClient;
import com.deds.cbrcurrency.domain.CurrencyNominalRate;
import com.deds.cbrcurrency.domain.CurrencyRate;
import com.deds.cbrcurrency.parser.Parser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CurrencyGettingService {
	
	private final CbrClient cbrClient;
	private final Parser parser;
	
	public List<CurrencyRate> getCurrencyRates() {
		String currencyRate = cbrClient.getCurrencyRate();
		List<CurrencyNominalRate> nominalRate = parser.parse(currencyRate);
		return nominalRate.stream().map(nominal -> 
			new CurrencyRate(nominal.getCharCode(),
					Double.parseDouble(nominal.getValue()) / Double.parseDouble(nominal.getNominal())))
				.collect(Collectors.toList());
	}
}
