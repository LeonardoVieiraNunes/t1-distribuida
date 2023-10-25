package com.distribuida.trabalho1.enums;

public enum Prioridade {
	PRIORITARIO(3),
	COMUM(2),
	POSTERGADO(1);

	public final Integer priority;

	Prioridade(Integer priority) {
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
