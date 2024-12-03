public class MiniLivro extends Livro {

    public MiniLivro(String titulo, String autor, double preco) {
        super(titulo, autor, preco);
    }

    @Override
    public double calcularPrecoComDesconto() {
        return preco - (preco * 0.20); // 20% de desconto
    }
}