package br.com.davi.mercado.service;

import br.com.davi.mercado.dominio.Produto;
import br.com.davi.mercado.dominio.TipoMovimentacao;
import br.com.davi.mercado.util.Entrada;

import java.util.Scanner;

public class EstoqueService {
    private ProdutoService produtoService;
    private MovimentacaoService movimentacaoService;
    private final Scanner scanner;

    public EstoqueService(ProdutoService produtoService, MovimentacaoService movimentacaoService, Scanner scanner) {
        this.produtoService = produtoService;
        this.movimentacaoService = movimentacaoService;
        this.scanner = scanner;
    }

    public void entradaEstoque() {
        System.out.println("Total de produtos já em estoque: " + produtoService.totalProdutos());
        produtoService.listarProdutos();

        int id = Entrada.lerInteiro(scanner, "Digite o ID do produto: ", 1, Integer.MAX_VALUE);
        Produto produto = produtoService.buscarPorId(id);
        int quantidade = Entrada.lerInteiro(scanner, "Digite a quantidade de entrada: ", 1, Integer.MAX_VALUE);

        produto.setQuantidade(produto.getQuantidade() + quantidade);

        movimentacaoService.registrarMovimentacao(produto, TipoMovimentacao.ENTRADA, quantidade);

        System.out.println("\nEntrada de estoque realizada com sucesso!");
    }

    public void saidaEstoque(){
    }

}