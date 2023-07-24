package com.deds.cbrcurrency.parser;

import com.deds.cbrcurrency.domain.CurrencyNominalRate;

import java.util.List;

public interface Parser {
	
	//todo use generics
	List<CurrencyNominalRate> parse(String ratesAsString);
}
