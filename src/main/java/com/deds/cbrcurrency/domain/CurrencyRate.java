package com.deds.cbrcurrency.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@AllArgsConstructor
@Builder
public class CurrencyRate {
	String charCode;
	Double value;
}
