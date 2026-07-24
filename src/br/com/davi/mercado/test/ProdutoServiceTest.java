package br.com.davi.mercado.test;

import br.com.davi.mercado.service.ProdutoService;

public class ProdutoServiceTest {
    public static void main(String[] args) {

        ProdutoService produtoService = new ProdutoService();

        produtoService.cadastrarProduto();

    }
}