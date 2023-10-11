package com.distribuida.trabalho1.cliente;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.distribuida.trabalho1.throttler.CallsCounter;
import com.distribuida.trabalho1.throttler.Throttler;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController() {
		CallsCounter callsCounter = new CallsCounter();
		Throttler throttler = new Throttler(1000, callsCounter);
		this.clienteService = new ClienteService(throttler, callsCounter);
	}

	@PostMapping("/adicionar")
	public String adicionar(@RequestBody ClienteModel clienteModel) {
		return clienteService.request(clienteModel);
	}
}
