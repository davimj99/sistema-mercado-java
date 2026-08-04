package br.com.davi.mercado.service;

import br.com.davi.mercado.dominio.Produto;
import br.com.davi.mercado.exception.ProdutoInvalidoException;
import br.com.davi.mercado.exception.ProdutoNaoEncontradoException;
import br.com.davi.mercado.util.Entrada;

import java.util.Scanner;

public class ProdutoService {

    private final Produto[] produtos = new Produto[100];
    private int quantidadeProdutos = 0;
    private final Scanner scanner = new Scanner(System.in);

    private void validarNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new ProdutoInvalidoException("O nome do produto não pode estar vazio.");
        }

        if (!nome.matches("[a-zA-ZÀ-ÿ ]+")) {
            throw new ProdutoInvalidoException("O nome do produto deve conter apenas letras.");
        }
    }

    private void validarPreco(double preco) {
        if (preco <= 0) {
            throw new ProdutoInvalidoException("O preço deve ser maior que zero.");
        }
    }

    private void validarQuantidade(int quantidade) {
        if (quantidade < 0) {
            throw new ProdutoInvalidoException("A quantidade não pode ser negativa.");
        }
    }

    private void validarCapacidade() {
        if (quantidadeProdutos >= produtos.length) {
            throw new ProdutoInvalidoException("Limite de produtos atingido.");
        }
    }

    public int totalProdutos() {
        return quantidadeProdutos;
    }

    public void cadastrarProduto() {
        validarCapacidade();
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
            nome = Entrada.lerString(scanner, "Nome: ");
            try {
                validarNome(nome);
                break;
            } catch (ProdutoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        double preco;
        while (true) {
            preco = Entrada.lerDouble(scanner, "Preço: ");
            try {
                validarPreco(preco);
                break;
            } catch (ProdutoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        int quantidade;
        while (true) {
            quantidade = Entrada.lerInteiro(scanner, "Quantidade: ", 0, Integer.MAX_VALUE);
            try {
                validarQuantidade(quantidade);
                break;
            } catch (ProdutoInvalidoException e) {

                System.out.println(e.getMessage());
            }
        }

        Produto produto = new Produto(id, nome, preco, quantidade);
        produtos[quantidadeProdutos] = produto;
        quantidadeProdutos++;
        System.out.println("Produto cadastrado com sucesso!");
        System.out.println("Quantidade de produtos: " + quantidadeProdutos);
    }


    public void listarProdutos() {
        if (quantidadeProdutos == 0 ){
            System.out.println("Nenhum Produto Cadastrado");
            return;
        }
        System.out.println("\n=== Lista de Produtos ===");
        System.out.println("TOTAL DE PRODUTOS CADASTRADOS= " + quantidadeProdutos);

        for (int i = 0; i < quantidadeProdutos; i++) {
            Produto produto = produtos[i];
            System.out.println("ID: " + produto.getId());
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço:R$  " + produto.getPreco());
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
        int id = Entrada.lerInteiro(scanner, "Digite o ID do produto: ", 1, Integer.MAX_VALUE);
        Produto produto = buscarPorId(id);

        String nome;
        while (true) {
            nome = Entrada.lerString(scanner, "Novo Nome: ");
            try {
                validarNome(nome);
                break;
            } catch (ProdutoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        double preco;
        while (true) {
            preco = Entrada.lerDouble(scanner, "Novo Preço:");
            try {
                validarPreco(preco);
                break;
            } catch (ProdutoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        int quantidade;
        while (true) {
            quantidade = Entrada.lerInteiro(scanner, "Nova quantidade: ", 0, Integer.MAX_VALUE);
            try {
                validarQuantidade(quantidade);
                break;
            } catch (ProdutoInvalidoException e) {
                System.out.println(e.getMessage());
            }
        }

        produto.setNome(nome);
        produto.setPreco(preco);
        produto.setQuantidade(quantidade);
        System.out.println("\nProduto atualizado com sucesso!");
    }

    public void excluirProduto(int id) {
        for (int i = 0; i < quantidadeProdutos; i++) {
            if (produtos[i].getId() == id) {
                for (int j = i; j < quantidadeProdutos - 1; j++) {
                    produtos[j] = produtos[j + 1];
                }

                produtos[quantidadeProdutos - 1] = null;
                quantidadeProdutos--;

                System.out.println("Produto removido com sucesso!");
                return;
            }
        }
        throw new ProdutoNaoEncontradoException("Produto com ID " + id + " não encontrado.");
    }
}