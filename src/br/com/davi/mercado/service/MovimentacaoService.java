package br.com.davi.mercado.service;

import br.com.davi.mercado.dominio.MovimentacaoEstoque;
import br.com.davi.mercado.dominio.Produto;
import br.com.davi.mercado.dominio.TipoMovimentacao;

import java.time.LocalDateTime;

public class MovimentacaoService {
    private MovimentacaoEstoque[] movimentacoes = new MovimentacaoEstoque[1000];

    private int quantidadeMovimentacoes;

    public void registrarMovimentacao(Produto produto, TipoMovimentacao tipo, int quantidade){
        MovimentacaoEstoque movimentacao = new MovimentacaoEstoque(produto.getId(), produto.getNome(), tipo, quantidade, LocalDateTime.now());

         movimentacoes[quantidadeMovimentacoes] = movimentacao;
         quantidadeMovimentacoes++;
    }
    public void listarMovimentacoes(){
        if (quantidadeMovimentacoes == 0 ){
            System.out.println("Nenhuma movimentação registrada ");
            return;
        }
        for (int i = 0; i < quantidadeMovimentacoes; i++){
            System.out.println(movimentacoes[i]);
        }
    }
}
