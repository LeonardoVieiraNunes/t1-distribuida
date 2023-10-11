package com.distribuida.trabalho1.model;

import lombok.Getter;
import lombok.Setter;
import com.distribuida.trabalho1.enums.FuncionalidadeEnum;

@Getter
@Setter
public class Cliente {
	private String nome;
	private FuncionalidadeEnum funcionalidade;
}
