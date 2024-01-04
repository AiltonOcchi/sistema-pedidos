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

		System.out.println("Cliente cadastrado com sucesso!\nPressione Enter para continuar...");
		SistemaCompras.scanner.nextLine();
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
		System.out.println("Fim da lista.\nPressione Enter para retornar...");
        SistemaCompras.scanner.nextLine();

	}

	/**
	 * Método para buscar um cliente pelo código	 
	 */
	static Cliente getCliente() {
	    
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
	
}
