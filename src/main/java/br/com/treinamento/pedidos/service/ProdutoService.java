package br.com.treinamento.pedidos.service;

import java.math.BigDecimal;

import br.com.treinamento.pedidos.main.SistemaCompras;
import br.com.treinamento.pedidos.model.Produto;

public class ProdutoService {

	public static void cadastrarProduto() {
		System.out.println("Cadastro de Produtos");
		System.out.println("--------------------------------------------");
		
		// Verifica se o código informado já existe de modo mais elaborado (com laço)
		boolean codigoValido = false;
		Integer codigo = null;
	
		while (!codigoValido) {
			codigo = MercadoService.getCodigo("Código do Produto: ");
	
			// verifica se já existe um cliente com o mesmo código informado
			boolean codigoDuplicado = false;
			for (Produto produto : SistemaCompras.produtoList) {
				if (produto.getCodigo().equals(codigo)) {
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
		
		System.out.print("Preço: ");
		String precoString = SistemaCompras.scanner.nextLine().replace(",", ".");
		BigDecimal preco = new BigDecimal(precoString);
		
		SistemaCompras.produtoList.add(new Produto(codigo, nome, preco));
	}

    public static void listarClientes() {

		System.out.println("--------------------------------------------------------------------");
		System.out.println("Listagem de Produtos");
	    System.out.println("--------------------------------------------------------------------");
	    System.out.printf("%-10s %-30s %-30s", "Código", "Nome", "Preço");
	    System.out.println("\n--------------------------------------------------------------------");
	    
	    SistemaCompras.produtoList.forEach(p -> {
	    	System.out.printf("%-10d %-30s %-30s\n",p.getCodigo(),p.getNome(),p.getPreco());
	    });
	   
	    System.out.println("--------------------------------------------------------------------");
		System.out.println("Pressione Enter para continuar...");
        SistemaCompras.scanner.nextLine();

	}

		
}
