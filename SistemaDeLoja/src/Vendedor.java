package SistemaDeLoja.src;

public class Vendedor {
    private String nome;
    private double comissao; // Porcentagem como 0.1 para 10%

    public Vendedor(String nome, double comissao) {
        this.nome = nome;
        this.comissao = comissao;
    }

    public String getNome() {
        return nome;
    }

    public double calcularComissao(double valorVenda) {
        return valorVenda * comissao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }
}
