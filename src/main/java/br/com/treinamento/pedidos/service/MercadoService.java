package br.com.treinamento.pedidos.service;

import br.com.treinamento.pedidos.main.SistemaCompras;

public class MercadoService {

	/**
	 * Monta o menu principal do sistema
	 */
	public static void montarMenu() {
		System.out.println("**************************************************");
		System.out.println("*          SISTEMA DE PEDIDO DE COMPRAS          *");
		System.out.println("**************************************************");
		System.out.println("1 - Cadastrar Cliente");
		System.out.println("2 - Listar Clientes");
		System.out.println("3 - Cadastrar Produto");
		System.out.println("4 - Listar Produtos");
		System.out.println("5 - Criar Pedido");
		System.out.println("6 - Listar Pedidos");
		System.out.println("7 - Detalhes do Pedido");
		System.out.println("9 - Sair");
	}

	/**
	 * Método para ler o código do cliente ou do produto
	 */
	public static Integer getCodigo(String textoEntrada) {
		Integer codigo = null;
		while (codigo == null) {
			try {
				System.out.print(textoEntrada);
				codigo = SistemaCompras.scanner.nextInt();
				SistemaCompras.scanner.nextLine(); 
			} catch (Exception e) {
				System.out.println("Erro: Por favor, digite um número inteiro para o código.");
				SistemaCompras.scanner.nextLine();
			}
		}
		return codigo;
	}

	/**
	 * Método para validar um numero inteiro
	 */
	public static Integer getNumero(String textoEntrada) {
		Integer numero = null;
		while (numero == null) {
			try {
				System.out.print(textoEntrada);
				numero = SistemaCompras.scanner.nextInt();
				SistemaCompras.scanner.nextLine(); 
			} catch (Exception e) {
				System.out.println("Erro: Por favor, digite um número inteiro.");
				SistemaCompras.scanner.nextLine();
			}
		}
		return numero;
	}

}
