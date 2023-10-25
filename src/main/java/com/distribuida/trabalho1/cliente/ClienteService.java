package com.distribuida.trabalho1.cliente;

import java.util.Map;


import lombok.Getter;

import com.distribuida.trabalho1.throttler.CallsCounter;
import com.distribuida.trabalho1.throttler.Throttler;

public class ClienteService {

	@Getter
	private final Map<String, Long> mapAllowedClientsMaxRequestsPerSecond = Map.of(
			"PRIORITARIO", 300L,
			"COMUM", 200L,
			"POSTERGADO", 100L
	);

	private final CallsCounter callsCounter;


	public ClienteService(Throttler throttler, CallsCounter callsCounter) {
		this.callsCounter = callsCounter;
		throttler.start();
	}

	public String request(ClienteModel clienteModel) {
		if (checkIfAvailable(clienteModel)) {
			callsCounter.incrementCount(clienteModel.getNome());
			System.out.println("Requisição feita para " + clienteModel.getNome() + " (nro de requisições: " + callsCounter.getCount(clienteModel.getNome()) + ")");
//			queueManager.send(clienteModel.getNome(), Prioridade.prioridadePorNome(clienteModel.getNome()));
			return "Requisição recebida com sucesso!";
		} else {
			System.out.println("Requisição negada para " + clienteModel.getNome() + " (nro de requisições: " + callsCounter.getCount(clienteModel.getNome()) + ")");
			return "Número máximo de requisições por segundo atingida. Tente novamente, mais tarde.";
		}

	}

	private boolean checkIfAvailable(ClienteModel clienteModel) {
		var nroRequisicoes = callsCounter.getCount(clienteModel.getNome());
		return nroRequisicoes <= mapAllowedClientsMaxRequestsPerSecond.get(clienteModel.getNome());
	}
}
