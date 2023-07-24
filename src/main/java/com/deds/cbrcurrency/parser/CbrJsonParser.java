package com.deds.cbrcurrency.parser;

import com.deds.cbrcurrency.domain.CurrencyNominalRate;
import com.deds.cbrcurrency.domain.CurrencyRate;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class CbrJsonParser implements Parser {
	
	//todo add caching using caffeine
	@Override
	public List<CurrencyNominalRate> parse(String ratesAsString) {
		List<CurrencyNominalRate> rates = new ArrayList<>();
		try {
			JsonNode productNode = new ObjectMapper().readTree(ratesAsString).get("Valute");
			if (productNode.isObject()) {
				for (final JsonNode nominalRate : productNode) {
					CurrencyNominalRate currencyNominalRate = CurrencyNominalRate.builder()
							.numCode(nominalRate.get("NumCode").textValue())
							.charCode(nominalRate.get("CharCode").textValue())
							.nominal(String.valueOf(nominalRate.get("Nominal").decimalValue()))
							.name(nominalRate.get("Name").textValue())
							.value(String.valueOf(nominalRate.get("Value").decimalValue()))
							.build();
					rates.add(currencyNominalRate);
				}
			}
		} catch (JsonProcessingException e) {
			//todo add custom exception
			throw new RuntimeException(e);
		}


		return rates;
	}
}
