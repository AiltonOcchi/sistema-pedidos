package br.com.treinamento.pedidos.service;

import br.com.treinamento.pedidos.main.SistemaCompras;
import br.com.treinamento.pedidos.model.Cliente;
import br.com.treinamento.pedidos.model.ItemPedido;
import br.com.treinamento.pedidos.model.Pedido;
import br.com.treinamento.pedidos.model.Produto;

public class PedidoService {

    public static void criarPedido() {
        
        System.out.println("Criar Pedido");
        System.out.println("--------------------------------------------");
       
        Cliente cliente = getCliente();
        System.out.println("Cliente: " + cliente.getNome());
        
        Produto produto = getProduto();
        System.out.println("Produto: " + produto.getNome());
        
        Pedido pedido = new Pedido(cliente);
        Integer quantidade = MercadoService.getNumero("Informe a quantidade: ");

        ItemPedido itemPedido = new ItemPedido(produto, quantidade, produto.getPreco());
        pedido.adicionarItem(itemPedido);

        System.out.println("Deseja adicionar mais itens ao pedido? (S/N)");
        String resposta = SistemaCompras.scanner.nextLine();
        
        while (resposta.equalsIgnoreCase("S")) {
            Produto produtoLoop = getProduto();
            System.out.println("Produto: " + produtoLoop.getNome());
            quantidade = MercadoService.getNumero("Informe a quantidade: ");
            itemPedido = new ItemPedido(produtoLoop, quantidade, produtoLoop.getPreco());
            pedido.adicionarItem(itemPedido);
            System.out.println("Deseja adicionar mais itens ao pedido? (S/N)");
            resposta = SistemaCompras.scanner.nextLine();
            SistemaCompras.pedidoList.add(pedido);
        }

        System.out.println("Pedido cadastrado com sucesso!\nPressione Enter para continuar...");
        SistemaCompras.scanner.nextLine();

    }

    private static Produto getProduto() {
        
        Produto produtoPedido = null;
        boolean produtoValido = false;
	
		while (!produtoValido) {
			Integer codigoProduto = MercadoService.getCodigo("Informe o código do produto: ");
	
			for (Produto produto : SistemaCompras.produtoList) {
				if (produto.getCodigo().equals(codigoProduto)) {
					produtoPedido = produto;
					break; // sai do for
				}
			}
	
			if (produtoPedido!=null) {
				produtoValido = true;
			}else{
                System.out.println("Erro: Não existe um produto com o código " + codigoProduto);
            }
		}
        return produtoPedido;
    }

    private static Cliente getCliente() {
        
        Cliente clientePedido = null;
        boolean clienteValido = false;
	 
		while (!clienteValido) {
			Integer codigoCliente = MercadoService.getCodigo("Informe o código do cliente: ");
	
			// verifica se existe um cliente com código informado
			for (Cliente cliente : SistemaCompras.clienteList) {
				if (cliente.getCodigo().equals(codigoCliente)) {
					clientePedido = cliente;
					break; // sai do for
				}
			}
	
			if (clientePedido!=null) {
				clienteValido = true;
                
			}else{
                System.out.println("Erro: Não existe um cliente com o código " + codigoCliente);
            }
		}
        return clientePedido;
    }

    public static void listarPedidos() {

        System.out.println("--------------------------------------------------------------------");
        System.out.println("Listagem de Pedidos");
        System.out.println("--------------------------------------------------------------------");
        System.out.printf("%-10s %-30s %-30s", "Código", "Cliente", "Valor Total");
        System.out.println("\n--------------------------------------------------------------------");
        
        int i = 1;
        for(Pedido pedido : SistemaCompras.pedidoList){
            System.out.printf("%-10d %-30s %-30s\n", i, pedido.getCliente().getNome(), pedido.getTotalPedido());
            i++;
        }        

        System.out.println("--------------------------------------------------------------------");

    }

}