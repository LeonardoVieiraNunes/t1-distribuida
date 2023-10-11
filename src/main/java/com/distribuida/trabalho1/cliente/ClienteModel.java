package com.distribuida.trabalho1.cliente;

import lombok.Getter;
import lombok.Setter;
import com.distribuida.trabalho1.enums.FuncionalidadeEnum;

@Getter
@Setter
public class ClienteModel {
	private String nome;
	private FuncionalidadeEnum funcionalidade;
}
