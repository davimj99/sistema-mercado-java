package br.com.davi.mercado;
import br.com.davi.mercado.dominio.Produto;
import br.com.davi.mercado.service.ProdutoService;
import br.com.davi.mercado.service.EstoqueService;
import br.com.davi.mercado.service.MovimentacaoService;
import br.com.davi.mercado.util.Entrada;
import br.com.davi.mercado.exception.ProdutoNaoEncontradoException;
import br.com.davi.mercado.exception.ProdutoInvalidoException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ProdutoService produtoService = new ProdutoService();
        MovimentacaoService movimentacaoService = new MovimentacaoService();
        EstoqueService estoqueService = new EstoqueService(produtoService, movimentacaoService,scanner);

        String[] menu = {

                "1 - Cadastrar Produto",
                "2 - Listar Produtos",
                "3 - Buscar Produto",
                "4 - Atualizar Produto",
                "5 - Remover Produto",
                "6 - Entrada de Estoque",
                "7 - Saída de Estoque",
                "8 - Histórico de Movimentações",
                "0 - Sair"
        };
        int opcao;

        do {
            System.out.println("\n==========================");
            System.out.println("      MERCADO JAVA");
            System.out.println("==========================");

            for (String item : menu) {
                System.out.println(item);
            }

            opcao = Entrada.lerInteiro(scanner, "Escolha uma opção: ", 0, 8);

            switch (opcao) {
                case 1:
                    try {
                        produtoService.cadastrarProduto();
                    } catch (ProdutoInvalidoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    produtoService.listarProdutos();
                    break;

                case 3:
                    try {
                        int id = Entrada.lerInteiro(scanner, "Digite o ID: ", 1, Integer.MAX_VALUE);

                        Produto produto = produtoService.buscarPorId(id);

                        System.out.println("\nProduto encontrado!");
                        System.out.println("ID: " + produto.getId());
                        System.out.println("Nome: " + produto.getNome());
                        System.out.println("Preço: " + produto.getPreco());
                        System.out.println("Quantidade: " + produto.getQuantidade());


                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    try {
                        produtoService.atualizarProduto();
                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 5:
                    try {
                        int idExcluir = Entrada.lerInteiro(scanner, "Digite o ID do produto: ", 1, Integer.MAX_VALUE);
                        produtoService.excluirProduto(idExcluir);
                    } catch (ProdutoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 6:
                    estoqueService.entradaEstoque();
                    break;

                case 7:
                    estoqueService.saidaEstoque();
                    break;

                case 8:
                    movimentacaoService.listarMovimentacoes();
                    break;

                case 0:
                    System.out.println("\nObrigado por utilizar o Mercado Java!");
                    System.out.println("Sistema encerrado.");
                    break;

                    default:
                    System.out.println("Opção inválida.");
            }
        } while(opcao != 0);
        scanner.close();
    }
}