package br.com.treinamento.pedidos.model;

import lombok.Getter;
import lombok.Setter;

public class Cliente {

	public Cliente(Integer codigo, String nome, String email) {
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
	}

	@Getter  @Setter
	private Integer codigo;
	
	@Getter  @Setter
	private String nome;
	
	@Getter @Setter
	private String email;

}
