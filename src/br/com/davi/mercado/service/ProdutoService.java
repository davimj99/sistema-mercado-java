package br.com.davi.mercado.service;

import br.com.davi.mercado.dominio.Produto;

import java.util.Scanner;

public class ProdutoService {
    private Produto[] produtos = new Produto[100];
    private int quantidadeProdutos = 0;
    private Scanner scanner = new Scanner(System.in);


    public void cadastrarProduto(){
        System.out.println("Cadastrando produto...");

        System.out.println("ID: ");
        int id = scanner.nextInt();

        System.out.println("Nome: ");
        String nome = scanner.next();

        System.out.println("Preço: ");
        double preco = scanner.nextDouble();

        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();

        Produto produto = new Produto(id, nome, preco, quantidade);
        produtos[quantidadeProdutos] = produto;

        quantidadeProdutos++;
        System.out.println("Produto cadastrado com sucesso!");
    }
}
