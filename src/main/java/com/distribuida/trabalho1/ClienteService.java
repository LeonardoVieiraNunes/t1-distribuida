package com.distribuida.trabalho1;

public class ClienteService {
	private final CallsCounter callsCounter;

	public ClienteService(Throttler throttler, CallsCounter callsCounter) {
		this.callsCounter = callsCounter;
		throttler.start();
	}

	public void request(Cliente cliente) {

	}

	private checkIfAvailable(Cliente cliente) {
		var count = callsCounter.getCount(cliente.getNome());
		//TODO: servidor precisa saber qual o nro de requisições o cliente pode mandar

	}
}
