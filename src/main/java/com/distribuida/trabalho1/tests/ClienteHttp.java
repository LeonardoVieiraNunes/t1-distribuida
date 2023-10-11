package com.distribuida.trabalho1.tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.web.client.RestTemplate;

public class ClienteHttp {
	public static void main(String[] args) {
		// Crie um RestTemplate
		RestTemplate restTemplate = new RestTemplate();

		// Crie um ExecutorService com duas threads
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// Execute as duas threads simultaneamente
		executorService.execute(new ClienteHttpTask(restTemplate));
		executorService.execute(new ClienteHttpTask(restTemplate));

		// Aguarde a conclusão das threads
		executorService.shutdown();
	}
}
