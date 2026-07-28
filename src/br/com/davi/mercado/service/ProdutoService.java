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
        System.out.println("Quantidade de produtos: " + quantidadeProdutos);
    }

    public void listarProdutos(){
        System.out.println("Quantidade de produtos cadastrados: " + quantidadeProdutos);
        for (int i = 0; i < quantidadeProdutos; i++) {
            Produto produto = produtos[i];
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
            System.out.println("Quantidade: " + produto.getQuantidade());
            System.out.println("-------------------------");

        }
    }
    public Produto buscarPorId(int id) {
        for (int i = 0; i < quantidadeProdutos; i++) {

            Produto produto = produtos[i];

            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public void atualizarProduto() {
        System.out.println("\n=== Atualizar Produto ===");

        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();

        Produto produto = buscarPorId(id);

        if (produto != null) {

            System.out.print("Novo nome: ");
            String nome = scanner.next();

            System.out.print("Novo preço: ");
            double preco = scanner.nextDouble();

            System.out.print("Nova quantidade: ");
            int quantidade = scanner.nextInt();

            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
            System.out.println("\nProduto atualizado com sucesso!");

        } else {
            System.out.println("\nProduto não encontrado.");
        }
    }
}
