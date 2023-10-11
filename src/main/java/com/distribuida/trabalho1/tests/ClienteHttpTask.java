package com.distribuida.trabalho1.tests;

import org.springframework.web.client.RestTemplate;
import com.distribuida.trabalho1.model.Cliente;

public class ClienteHttpTask implements Runnable {
	private final RestTemplate restTemplate;

	public ClienteHttpTask(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			Cliente cliente = new Cliente();
			cliente.setNome("Maria");
			String response = restTemplate.postForObject("http://localhost:8080/cliente/adicionar", cliente, String.class);
			System.out.println(response + " Thread:" + Thread.currentThread().getName());
		}
	}
}
