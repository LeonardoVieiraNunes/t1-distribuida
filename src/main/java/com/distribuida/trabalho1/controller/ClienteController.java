package com.distribuida.trabalho1.controller;

import java.util.List;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.distribuida.trabalho1.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Getter
	private final List<String> allowedClients = List.of("João", "Maria", "José");

	@PostMapping("/adicionar")
	public String adicionar(@RequestBody Cliente cliente) {
		if (allowedClients.contains(cliente.getNome())) {
			return "Cliente adicionado";
		} else {
			throw new ForbiddenException();
		}
	}

	@ResponseStatus(HttpStatus.FORBIDDEN)
	public static class ForbiddenException extends RuntimeException {

		public ForbiddenException() {
			super();
		}
	}
}
