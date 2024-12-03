public class Revista implements Produto {
    private String titulo;
    private String editora;
    private double preco;

    public Revista(String titulo, String editora, double preco) {
        this.titulo = titulo;
        this.editora = editora;
        this.preco = preco;
    }

    @Override
    public double calcularPrecoComDesconto() {
        return preco - (preco * 0.05); // 5% de desconto
    }

    public void exibirDetalhes() {
        System.out.println("Título: " + titulo);
        System.out.println("Editora: " + editora);
        System.out.println("Preço: " + preco);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}