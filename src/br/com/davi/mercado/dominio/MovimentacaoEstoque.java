package br.com.davi.mercado.dominio;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MovimentacaoEstoque {
    private int idProduto;
    private String nomeProduto;
    private TipoMovimentacao tipoMovimentacao;
    private int quantidade;
    private LocalDateTime dataHora;

    public MovimentacaoEstoque(int idProduto, String nomeProduto, TipoMovimentacao tipoMovimentacao, int quantidade, LocalDateTime dataHora) {
        this.idProduto = idProduto;
        this.nomeProduto = nomeProduto;
        this.tipoMovimentacao = tipoMovimentacao;
        this.quantidade = quantidade;
        this.dataHora = dataHora;
    }


    @Override
    public String toString() {
        return "MovimentacaoEstoque{" +
                "idProduto=" + idProduto +
                ", nomeProduto='" + nomeProduto + '\'' +
                ", tipo=" + tipoMovimentacao +
                ", quantidade=" + quantidade +
                ", dataHora=" + dataHora.format(FORMATTER) +
                '}';
    }
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public TipoMovimentacao getTipo() {
        return tipoMovimentacao;
    }

    public void setTipo(TipoMovimentacao tipo) {
        this.tipoMovimentacao = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
