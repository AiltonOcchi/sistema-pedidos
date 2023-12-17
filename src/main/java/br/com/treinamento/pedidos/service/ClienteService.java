package br.com.treinamento.pedidos.service;

import br.com.treinamento.pedidos.main.SistemaCompras;
import br.com.treinamento.pedidos.model.Cliente;

public class ClienteService {

	/**
	 * Método para cadastrar um cliente
	 */
	public static void cadastrarCliente() {
		System.out.println("\nCadastro de Clientes");
		System.out.println("--------------------------------------------");

		/*// Verifica se o código informado já existe de modo simples (sem laço)
		 Integer codigo = MercadoService.getCodigo();
		// verifica se já existe um cliente com o código informado
		for (Cliente cliente : SistemaCompras.clienteList) {
			if (cliente.getCodigo().equals(codigo)) {
				System.out.println("Erro: Já existe um cliente com o código " + codigo);
				return; 
			}
		}
		*/
		

		// Verifica se o código informado já existe de modo mais elaborado (com laço)
		boolean codigoValido = false;
		Integer codigo = null;
	
		while (!codigoValido) {
			codigo = MercadoService.getCodigo("Código do Cliente: ");
	
			// verifica se já existe um cliente com o mesmo código informado
			boolean codigoDuplicado = false;
			for (Cliente cliente : SistemaCompras.clienteList) {
				if (cliente.getCodigo().equals(codigo)) {
					System.out.println("Erro: Já existe um cliente com o código " + codigo);
					codigoDuplicado = true;
					break; // sai do for
				}
			}
	
			if (!codigoDuplicado) {
				codigoValido = true;
			}
		}
	

		System.out.print("Nome: ");
		String nome = SistemaCompras.scanner.nextLine();
		
		System.out.print("E-mail:");
		String email = SistemaCompras.scanner.nextLine();
		System.out.print("\n");
		
		SistemaCompras.clienteList.add(new Cliente(codigo, nome, email));
	}

	
	/**
	 * Método para listar os clientes cadastrados
	 */
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
		System.out.println("Pressione Enter para continuar...");
        SistemaCompras.scanner.nextLine();

	}
	
}
