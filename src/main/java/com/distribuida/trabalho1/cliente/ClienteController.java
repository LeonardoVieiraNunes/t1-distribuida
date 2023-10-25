package com.distribuida.trabalho1.cliente;

import com.distribuida.trabalho1.throttler.CallsCounter;
import com.distribuida.trabalho1.throttler.Throttler;
import org.springframework.web.bind.annotation.*;

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

	@GetMapping("/fila")
	public String pegarItemFila() {
		return this.clienteService.pegarItemFila();
	}
}
