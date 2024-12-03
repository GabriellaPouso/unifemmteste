public class LivroFisico extends Livro {
    private double custoEnvio;

    public LivroFisico(String titulo, String autor, double preco, double custoEnvio) {
        super(titulo, autor, preco);
        this.custoEnvio = custoEnvio;
    }

    @Override
    public double calcularPrecoComDesconto() {
        return preco + custoEnvio - (preco * 0.10); // 10% de desconto
    }

    public double getCustoEnvio() {
        return custoEnvio;
    }

    public void setCustoEnvio(double custoEnvio) {
        this.custoEnvio = custoEnvio;
    }
}