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
}