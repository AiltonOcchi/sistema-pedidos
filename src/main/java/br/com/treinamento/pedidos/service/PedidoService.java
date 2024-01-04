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
        
        Cliente cliente = ClienteService.getCliente();
        System.out.println("Cliente: " + cliente.getNome());
        
        Pedido pedido = new Pedido(cliente);        
        
        Produto produto = ProdutoService.getProduto();
        System.out.println("Produto: " + produto.getNome() + " - R$" + produto.getPreco());
                
        Integer quantidade = MercadoService.getNumero("Informe a quantidade: ");

        ItemPedido itemPedido = new ItemPedido(produto, quantidade, produto.getPreco());
        pedido.adicionarItem(itemPedido);

        System.out.print("Deseja adicionar mais itens ao pedido? (S/N)");
        String resposta = SistemaCompras.scanner.nextLine();
        
        while (resposta.equalsIgnoreCase("S")) {            
            Produto produtoLoop = ProdutoService.getProduto();
            System.out.println("\nProduto: " + produtoLoop.getNome() + " - R$" + produtoLoop.getPreco());
            quantidade = MercadoService.getNumero("Informe a quantidade: ");
            itemPedido = new ItemPedido(produtoLoop, quantidade, produtoLoop.getPreco());
            pedido.adicionarItem(itemPedido);
            System.out.print("Deseja adicionar mais itens ao pedido? (S/N)");
            resposta = SistemaCompras.scanner.nextLine();            
        }
        
        SistemaCompras.pedidoList.add(pedido);

        System.out.println("\nPedido criado com sucesso!\nValor Total: R$"+pedido.getTotalPedido());

        System.out.println("\nPressione Enter para continuar...");
        SistemaCompras.scanner.nextLine();

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
		System.out.println("Fim da lista.\nPressione Enter para retornar...");
        SistemaCompras.scanner.nextLine();

    }

    public static void detalharPedido() {
            
        Pedido pedido = getPedido();    
    
        System.out.println("Pedido nº " + pedido.getNumero());
        System.out.println("--------------------------------------------");       

        System.out.println("Cliente: " + pedido.getCliente().getNome());
        System.out.println("Valor Total: R$" + pedido.getTotalPedido());
        System.out.println("Itens do Pedido: ");
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-30s %-20s %-20s %-20s", "Código", "Produto", "Valor Unit", "Qtd", "Valor Total");
        System.out.println("\n--------------------------------------------------------------------------------------------------");
        
        int i = 1;
        for(ItemPedido item : pedido.getItensPedido()){
            System.out.printf("%-10d %-30s %-20s %-20s %-20s\n", i, item.getProduto().getNome(), item.getValorUnitario(), item.getQuantidade(), item.getValorTotal());
            i++;
        }        

        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.println("Fim do pedido.\nPressione Enter para retornar...");
        SistemaCompras.scanner.nextLine();

    }

    public static Pedido getPedido() {
        
        Pedido pedidoBusca = null;
        boolean pedidoValido = false;
    
    	while (!pedidoValido) {
    		Integer numeroPedido = MercadoService.getCodigo("Informe o número do pedido: ");
    
    		for (Pedido pedido : SistemaCompras.pedidoList) {
    			if (pedido.getNumero().equals(numeroPedido)) {
    				pedidoBusca = pedido;
    				break; // sai do for
    			}
    		}
    
    		if (pedidoBusca!=null) {
    			pedidoValido = true;
    		}else{
                System.out.println("Erro: Pedido não econtrado");
            }
    	}
        return pedidoBusca;
    }

}