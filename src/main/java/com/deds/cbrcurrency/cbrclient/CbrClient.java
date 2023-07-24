package com.deds.cbrcurrency.cbrclient;

import com.deds.cbrcurrency.domain.CurrencyRate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.util.retry.Retry;

import java.time.Duration;

@Slf4j
@Service
@RequiredArgsConstructor
public class CbrClient {

	private final WebClient webClient;

	public String getCurrencyRate() {
		return webClient
				.get()
				.retrieve()
				.bodyToMono(String.class)
				//.retryWhen(Retry.fixedDelay(3, Duration.ofMillis(100)))
				.block();
	}
}