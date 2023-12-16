package br.com.treinamento.pedidos.service;

import br.com.treinamento.pedidos.main.SistemaCompras;
import br.com.treinamento.pedidos.model.Cliente;

public class ClienteService {

	public static void cadastrarCliente() {
		System.out.println("\nCadastro de Clientes");
		System.out.println("--------------------------------------------");
		
		System.out.print("Código: ");
		Integer codigo = SistemaCompras.scanner.nextInt();
		SistemaCompras.scanner.nextLine();
		
		System.out.print("Nome: ");
		String nome = SistemaCompras.scanner.nextLine();
		
		System.out.print("E-mail:");
		String email = SistemaCompras.scanner.nextLine();
		System.out.print("\n");
		
		SistemaCompras.clienteList.add(new Cliente(codigo, nome, email));
	}
	
	public static void listarClientes() {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("Listagem de Clientes");
	    System.out.println("--------------------------------------------------------------------");
	    System.out.printf("%-10s %-30s %-30s", "Código", "Nome", "E-mail");
	    System.out.println("\n--------------------------------------------------------------------");
	    
	    SistemaCompras.clienteList.forEach(c -> {
	    	System.out.printf("%-10d %-30s %-30s\n",c.getCodigo(),c.getNome(),c.getEmail());
	    });
	    
	    System.out.println("--------------------------------------------------------------------");
	}
	
}
