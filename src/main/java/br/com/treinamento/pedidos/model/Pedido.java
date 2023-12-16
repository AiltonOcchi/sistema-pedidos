package br.com.treinamento.pedidos.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class Pedido {
	
	public Pedido(Cliente cliente) {
		this.cliente = cliente;
	}

	@Getter @Setter
	private Cliente cliente;
	
	@Getter @Setter
	private List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
	
	@Getter @Setter
	private BigDecimal totalPedido = BigDecimal.ZERO;
	
	public void adicionarItem(ItemPedido item) {
		itensPedido.add(item);
		
	}

}
