package br.com.davi.mercado.service;

import br.com.davi.mercado.dominio.Produto;

public class ProdutoService {
    private Produto[] produtos = new Produto[100];
    private int quantidadeProdutos = 0;

    public void cadastrarProduto(){
        System.out.println("Cadastrando produto");
    }

}
