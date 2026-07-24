package br.com.davi.mercado;

import br.com.davi.mercado.service.ProdutoService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoService produtoService = new ProdutoService();

        String[] menu = {
                "1 - Cadastrar Produto",
                "2 - Listar Produtos",
                "3 - Buscar Produto",
                "4 - Atualizar Produto",
                "5 - Remover Produto",
                "0 - Sair"
        };
        int opcao;

        // O menu ficará repetindo até o usuário escolher 0
        do {

            System.out.println("\n==========================");
            System.out.println("      MERCADO JAVA");
            System.out.println("==========================");

            for (int i = 0; i < menu.length; i++) {
                System.out.println(menu[i]);
            }

            System.out.print("\nEscolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    produtoService.cadastrarProduto();
                    break;

                case 2:
                    System.out.println("\n>> Você escolheu LISTAR PRODUTOS.");
                    break;

                case 3:
                    System.out.println("\n>> Você escolheu BUSCAR PRODUTO.");
                    break;

                case 4:
                    System.out.println("\n>> Você escolheu ATUALIZAR PRODUTO.");
                    break;

                case 5:
                    System.out.println("\n>> Você escolheu REMOVER PRODUTO.");
                    break;

                case 0:
                    System.out.println("\nObrigado por utilizar o Mercado Java!");
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}