public class Main {
    public static void main(String[] args) {
        Produto livroFisico = new LivroFisico("Java para Iniciantes", "Autor A", 50.00, 10.00);
        Produto ebook = new Ebook("Aprendendo Java", "Autor B", 30.00, 5.00);
        Produto miniLivro = new MiniLivro("Java Básico", "Autor C", 20.00);
        Produto revista = new Revista("Tecnologia Hoje", "Editora X", 15.00);

        System.out.println("Livro Físico:");
        ((LivroFisico) livroFisico).exibirDetalhes();
        System.out.println("Preço com desconto + frete: " + livroFisico.calcularPrecoComDesconto());

        System.out.println("\nEbook:");
        ((Ebook) ebook).exibirDetalhes();
        System.out.println("Preço com desconto + taxa de licenciamento: " + ebook.calcularPrecoComDesconto());

        System.out.println("\nMiniLivro:");
        ((MiniLivro) miniLivro).exibirDetalhes();
        System.out.println("Preço com desconto: " + miniLivro.calcularPrecoComDesconto());

        System.out.println("\nRevista:");
        ((Revista) revista).exibirDetalhes();
        System.out.println("Preço com desconto: " + revista.calcularPrecoComDesconto());
    }
}