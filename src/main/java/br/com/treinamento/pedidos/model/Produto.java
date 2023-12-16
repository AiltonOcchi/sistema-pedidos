package br.com.treinamento.pedidos.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class Produto {
	
	public Produto(Integer codigo, String nome, BigDecimal preco) {
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
	}

	@Getter  @Setter
	private Integer codigo;

	@Getter @Setter
	private String nome;
	
	@Getter @Setter
	private BigDecimal preco;
	
}
