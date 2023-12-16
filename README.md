# sistema-pedidos
Exercicio de desenvolvimento com Java para a turma de Férias 2023/2024

Objetivo: Desenvolver um sistema de compras em Java que simula um ambiente de vendas. Este sistema deve permitir o cadastro de clientes e produtos, a criação de pedidos, e a visualização de informações sobre clientes, produtos e pedidos.

O projeto visa fortalecer o entendimento sobre programação orientada a objetos, manipulação de listas e tratamento de exceções.

Vocês podem seguir a sugestão da seguinte estrutura, todavia fiquem à vontade para incrementar algo se acharem interessante:

Estrutura Básica do Projeto	

Classe Cliente:
- Atributos: código (único), nome, e-mail.
- Métodos: Getters e Setters.
- Detalhe: Implementar uma verificação para assegurar que cada código de cliente seja único.


Classe Produto:
- Atributos: código (único), nome, preço.
- Métodos: Getters e Setters.
- Detalhe: Similar ao Cliente, garantir unicidade no código do produto.
  
Classe ItemPedido:
-  Atributos: produto (referência ao objeto Produto), quantidade, valorUnitario, valorTotal (calculado automaticamente).
- Métodos: Getters e Setters, método para calcular o valorTotal baseado na quantidade e no valorUnitario.


Classe Pedido:
- Atributos: cliente (referência ao objeto Cliente), itensPedido (lista de ItemPedido), totalPedido (calculado automaticamente).
- Métodos: Getters e Setters, adicionarItem (para incluir itens ao pedido), calcularTotal (para somar o valor total dos itens).


Classe SistemaCompras (Classe principal de execução):
- Funcionalidades: Exibir menu, cadastrar/listar/buscar clientes e produtos, criar/listar/buscar pedidos e sair do sistema. 
 
Instruções Adicionais:
- Organização: Organizar as funcionalidades do sistema em pacotes e métodos. A camada service (pacote service) deve ter as classes com as regras de negócios para cada assunto (Entidade)
- Armazenamento: Utilizar listas para guardar os objetos.
- Entrada de Dados: Usar Scanner para entrada de dados.
- Tratamento de Valores: Utilizar BigDecimal para lidar com valores monetários.
- Tratamento de Exceções: Implementar estruturas try-catch para prevenir erros em entradas de dados inválidas (exemplo, texto no lugar de número).
- Compilação e Execução: Ao finalizar, os alunos devem compilar o projeto e gerar um arquivo .jar para execução fora da IDE (Eclipse).


EXTRA:

Caso acharem muito fácil e terminarem rápido 😊, ao invés de um menu gigante com  11 opções, agrupem um menu principal e os recursos dele dentro de um subgrupo de menu, exemplo:

Opções do sistema:
- 1 – Clientes 
- 2 – Produtos
- 3 – Pedidos

Ao acessar uma das opções, por exemplo 1, deverá abrir outro menu:

“Selecione a opção do menu Clientes”
- 1 – Cadastrar um cliente
- 2 – Buscar um cliente
- 3 – Listar os clientes
