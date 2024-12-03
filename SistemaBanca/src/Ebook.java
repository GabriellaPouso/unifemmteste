public class Ebook extends Livro {
    private double taxaLicenciamento;

    public double getTaxaLicenciamento() {
        return taxaLicenciamento;
    }

    public void setTaxaLicenciamento(double taxaLicenciamento) {
        this.taxaLicenciamento = taxaLicenciamento;
    }

    public Ebook(String titulo, String autor, double preco, double taxaLicenciamento) {
        super(titulo, autor, preco);
        this.taxaLicenciamento = taxaLicenciamento;
    }

    @Override
    public double calcularPrecoComDesconto() {
        return preco + taxaLicenciamento - (preco * 0.15); // 15% de desconto
    }
}