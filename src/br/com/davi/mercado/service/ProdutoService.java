package br.com.davi.mercado.service;

import br.com.davi.mercado.dominio.Produto;
import br.com.davi.mercado.exception.ProdutoInvalidoException;
import br.com.davi.mercado.exception.ProdutoNaoEncontradoException;
import br.com.davi.mercado.util.Entrada;

import java.util.Scanner;

public class ProdutoService {

    private Produto[] produtos = new Produto[100];
    private int quantidadeProdutos = 0;
    private Scanner scanner = new Scanner(System.in);

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new ProdutoInvalidoException("O nome do produto não pode estar vazio.");
        }

        if (!nome.matches("[a-zA-ZÀ-ÿ ]+")) {
            throw new ProdutoInvalidoException("O nome do produto deve conter apenas letras.");
        }
    }

    public void cadastrarProduto() {
        System.out.println("Cadastrando produto...");
        int id;
        while (true) {
            id = Entrada.lerInteiro(scanner, "DIGITE O ID: ", 1, Integer.MAX_VALUE);

            try {
                buscarPorId(id);
                System.out.println("Erro: ID " + id + " já cadastrado. Tente outro ID.");
            } catch (ProdutoNaoEncontradoException e) {
                break;
            }
        }

        String nome;
        while (true) {
            System.out.print("Nome: ");
            nome = scanner.nextLine();
            try {
                validarNome(nome);
                break;
            } catch (ProdutoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        double preco;
        while (true) {
            System.out.print("Preço: ");
            preco = scanner.nextDouble();

            if (preco > 0) {
                break;
            } else {
                System.out.println("Preço inválido! Digite um valor maior que zero.");
            }
        }

        System.out.println("Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();
        Produto produto = new Produto(id, nome, preco, quantidade);

        produtos[quantidadeProdutos] = produto;
        quantidadeProdutos++;
        System.out.println("Produto cadastrado com sucesso!");
        System.out.println("Quantidade de produtos: " + quantidadeProdutos);
    }

    public void listarProdutos() {
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
        throw new ProdutoNaoEncontradoException("Produto com ID " + id + " não encontrado.");
    }

    public void atualizarProduto() {
        System.out.println("\n=== Atualizar Produto ===");
        System.out.print("Digite o ID do produto: ");
        int id = scanner.nextInt();

        Produto produto = buscarPorId(id);

        scanner.nextLine();

        System.out.print("Novo nome: ");
        String nome = scanner.nextLine();

        System.out.print("Novo preço: ");
        double preco = scanner.nextDouble();

        System.out.print("Nova quantidade: ");
        int quantidade = scanner.nextInt();

        scanner.nextLine();
        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        System.out.println("\nProduto atualizado com sucesso!");
    }

    public void excluirProduto(int id) {
        Produto produto = buscarPorId(id);

        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i].equals(produto)) {
                for (int j = i; j < quantidadeProdutos - 1; j++) {produtos[j] = produtos[j + 1];}
                produtos[quantidadeProdutos - 1] = null;
                quantidadeProdutos--;
                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
    }
}