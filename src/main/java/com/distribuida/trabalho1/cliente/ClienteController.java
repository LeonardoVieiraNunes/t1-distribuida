package com.distribuida.trabalho1.cliente;

import com.distribuida.trabalho1.Application;
import com.distribuida.trabalho1.enums.Prioridade;
import com.distribuida.trabalho1.queuemanager.QueueManager;
import com.distribuida.trabalho1.tests.WorkerCall;
import org.springframework.boot.autoconfigure.web.reactive.function.client.WebClientAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import com.distribuida.trabalho1.throttler.CallsCounter;
import com.distribuida.trabalho1.throttler.Throttler;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	private final ClienteService clienteService;
	private final QueueManager queueManager;

	public ClienteController() {
		CallsCounter callsCounter = new CallsCounter();
		Throttler throttler = new Throttler(1000, callsCounter);
		this.clienteService = new ClienteService(throttler, callsCounter);
		this.queueManager = new QueueManager();

	}

	@PostMapping("/adicionar")
	public String adicionar(@RequestBody ClienteModel clienteModel) {
		this.queueManager.send(clienteModel.getNome(), Prioridade.prioridadePorNome(clienteModel.getNome()));
		return clienteService.request(clienteModel);
	}

	@GetMapping("/fila")
	public String pegarItemFila() {
		return this.queueManager.receive();
	}
}
