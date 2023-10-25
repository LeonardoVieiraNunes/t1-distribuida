package com.distribuida.trabalho1.tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.web.client.RestTemplate;

import com.distribuida.trabalho1.cliente.ClienteModel;

public class ClienteHttp {
	public static void main(String[] args) {
		// Crie um ExecutorService com duas threads
		ExecutorService executorService = Executors.newFixedThreadPool(2);

		// Execute as duas threads simultaneamente
		executorService.execute(() -> makeCalls("COMUM"));
		executorService.execute(() -> makeCalls("PRIORITARIO"));

		// Aguarde a conclusão das threads
		executorService.shutdown();
	}

	private static void makeCalls(String clientName) {
		for (int i = 0; i < 50; i++) {
			RestTemplate restTemplate = new RestTemplate();
			ClienteModel clienteModel = new ClienteModel();
			clienteModel.setNome(clientName);
			String response = restTemplate.postForObject("http://localhost:8080/cliente/adicionar", clienteModel, String.class);
			System.out.println(response + " Thread:" + Thread.currentThread().getName());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
