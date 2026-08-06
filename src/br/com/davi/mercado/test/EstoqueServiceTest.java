package br.com.davi.mercado.test;

import br.com.davi.mercado.service.EstoqueService;
import br.com.davi.mercado.service.MovimentacaoService;
import br.com.davi.mercado.service.ProdutoService;

import java.util.Scanner;

public class EstoqueServiceTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ProdutoService produtoService = new ProdutoService();
        MovimentacaoService movimentacaoService = new MovimentacaoService();

        EstoqueService estoqueService = new EstoqueService(produtoService, movimentacaoService, scanner);

        produtoService.cadastrarProduto();

        System.out.println("\n=== Produtos Cadastrados ===");
        produtoService.listarProdutos();

        System.out.println("\n=== Entrada de Estoque ===");
        estoqueService.entradaEstoque();

        System.out.println("\n=== Produtos Após Entrada ===");
        produtoService.listarProdutos();

        System.out.println("\n=== Histórico ===");
        movimentacaoService.listarMovimentacoes();

        scanner.close();
    }
}