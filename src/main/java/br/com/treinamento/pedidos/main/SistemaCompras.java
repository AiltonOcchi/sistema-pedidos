package br.com.treinamento.pedidos.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.treinamento.pedidos.model.Cliente;
import br.com.treinamento.pedidos.model.Pedido;
import br.com.treinamento.pedidos.model.Produto;
import br.com.treinamento.pedidos.service.ClienteService;
import br.com.treinamento.pedidos.service.MercadoService;
import br.com.treinamento.pedidos.service.PedidoService;
import br.com.treinamento.pedidos.service.ProdutoService;

public class SistemaCompras {

	public static Scanner scanner = new Scanner(System.in);
	public static List<Cliente> clienteList = new ArrayList<Cliente>();
	public static List<Produto> produtoList = new ArrayList<Produto>();	
	public static List<Pedido> pedidoList = new ArrayList<Pedido>();	

	public static void main(String[] args) {

		while (true) {

			MercadoService.montarMenu();

			System.out.print("\nInforme uma opção:");
			// Integer opcao = null;
			Integer opcao = 20;

			try {
				opcao = scanner.nextInt();
			} catch (Exception e) {
				// System.out.println("Opção inválida. Por favor, digite um número.");
				scanner.nextLine();
				// continue;
			}

			switch (opcao) {
			case 1: {
				ClienteService.cadastrarCliente();
				System.out.println("Cliente cadastrado com sucesso!\nPressione Enter para continuar...");
				scanner.nextLine();
				break;
			}
			case 2: {
				ClienteService.listarClientes();
				scanner.nextLine();
				break;
			}
			case 3: {
				ProdutoService.cadastrarProduto();
				System.out.println("Produto cadastrado com sucesso!\nPressione Enter para continuar...");
				scanner.nextLine();
				break;
			}
			case 4: {
				ProdutoService.listarClientes();
				scanner.nextLine();
				break;
			}
			case 5: {
				PedidoService.criarPedido();
				//scanner.nextLine();
				break;
			}
			case 6: {
				PedidoService.listarPedidos();
				//scanner.nextLine();
				break;
			}
			case 11: {
				scanner.close();
				System.out.println("Saindo do programa...");
				System.exit(0);
			}
			default:
				System.out.println("Opção inválida. Tente novamente");
			}

		}
	}

}
