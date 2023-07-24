package com.deds.cbrcurrency;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CbrCurrencyRateServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void testJsonParsing() {
		String source = "{\n" +
				"    \"Date\": \"2023-07-25T11:30:00+03:00\",\n" +
				"    \"PreviousDate\": \"2023-07-22T11:30:00+03:00\",\n" +
				"    \"PreviousURL\": \"\\/\\/www.cbr-xml-daily.ru\\/archive\\/2023\\/07\\/22\\/daily_json.js\",\n" +
				"    \"Timestamp\": \"2023-07-24T20:00:00+03:00\",\n" +
				"    \"Valute\": {\n" +
				"        \"AUD\": {\n" +
				"            \"ID\": \"R01010\",\n" +
				"            \"NumCode\": \"036\",\n" +
				"            \"CharCode\": \"AUD\",\n" +
				"            \"Nominal\": 1,\n" +
				"            \"Name\": \"Австралийский доллар\",\n" +
				"            \"Value\": 60.9534,\n" +
				"            \"Previous\": 61.2356\n" +
				"        },\n" +
				"        \"AZN\": {\n" +
				"            \"ID\": \"R01020A\",\n" +
				"            \"NumCode\": \"944\",\n" +
				"            \"CharCode\": \"AZN\",\n" +
				"            \"Nominal\": 1,\n" +
				"            \"Name\": \"Азербайджанский манат\",\n" +
				"            \"Value\": 53.2288,\n" +
				"            \"Previous\": 53.1674\n" +
				"        },\n" +
				"        \"GBP\": {\n" +
				"            \"ID\": \"R01035\",\n" +
				"            \"NumCode\": \"826\",\n" +
				"            \"CharCode\": \"GBP\",\n" +
				"            \"Nominal\": 1,\n" +
				"            \"Name\": \"Фунт стерлингов Соединенного королевства\",\n" +
				"            \"Value\": 116.2331,\n" +
				"            \"Previous\": 116.1532\n" +
				"        }\n" +
				"    }\n" +
				"}";

		try {
			JsonNode productNode = new ObjectMapper().readTree(source).get("Valute");
			if (productNode.isObject()) {
				for (final JsonNode objNode : productNode) {
					JsonNode jsonNode = objNode.get(1);
					System.out.println(jsonNode);
				}
			}
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

}
