package br.com.treinamento.pedidos.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

public class ItemPedido {
	
	public ItemPedido(Produto produto, Integer quantidade, BigDecimal valorUnitario) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
		this.valorTotal = valorUnitario.multiply(new BigDecimal(quantidade));
	}

	@Getter  @Setter
	private Produto produto;
	
	@Getter  @Setter
	private Integer quantidade;

	@Getter  @Setter
	private BigDecimal valorUnitario;
	
	@Getter  @Setter
	private BigDecimal valorTotal;


	
}
