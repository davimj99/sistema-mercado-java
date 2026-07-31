package br.com.davi.mercado.service;

import br.com.davi.mercado.dominio.Produto;

import java.util.Scanner;

public class ProdutoService {
    private Produto[] produtos = new Produto[100];
    private int quantidadeProdutos = 0;
    private Scanner scanner = new Scanner(System.in);


    public void cadastrarProduto(){
        System.out.println("Cadastrando produto...");
        int id;
        while (true) {
            System.out.println("ID: ");
            id = scanner.nextInt();
            scanner.nextLine();

            if(buscarPorId(id) == null){
                break;
            }
            System.out.println("Erro: ID " + id + " já cadastrado. \n Tente outro ID.");
        }

        String nome;
        while (true){
            System.out.println("Nome: ");
            nome = scanner.nextLine();

            if(nome.isBlank()){
                System.out.println("Erro: O nome do produto não pode estar vazio.");
            }else{
                break;
            }
        }

        double preco;
        while (true){
            System.out.print("Preço: ");
            preco = scanner.nextDouble();

            if(preco > 0){
                break;

            }else {
                System.out.println("Preço inválido! Digite um valor maior que zero. ");
            }
        }

        int quantidade;
        while (true){
            System.out.println("Quantidade: ");
            quantidade = scanner.nextInt();
            scanner.nextLine();

            if(quantidade > 0){
            break;

            }else{
                System.out.println("Quantidade inválida! Digite um valor maior que zero.");
            }
        }

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
            scanner.nextLine();

            System.out.print("Novo preço: ");
            double preco = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Nova quantidade: ");
            int quantidade = scanner.nextInt();
            scanner.nextLine();

            produto.setNome(nome);
            produto.setPreco(preco);
            produto.setQuantidade(quantidade);
            System.out.println("\nProduto atualizado com sucesso!");

        } else {
            System.out.println("\nProduto não encontrado.");
        }
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

        System.out.println("Produto não encontrado.");
    }
}
