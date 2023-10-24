package com.distribuida.trabalho1.enums;

public enum Prioridade {
	JOAO(3),
	MARIA(2),
	PEDRO(1);

	public final Integer priority;

	private Prioridade(Integer priority) {
		this.priority = priority;
	}

	public static Integer prioridadePorNome(String nome) {
		for (Prioridade prioridade : Prioridade.values()) {
			if (prioridade.name().equalsIgnoreCase(nome)) {
				return prioridade.priority;
			}
		}
		throw new IllegalArgumentException("Prioridade não encontrada: " + nome);
	}



}
