package SistemaDeLoja.src;

public class Main {
    public static void main(String[] args) {
        // Instância da loja
        Loja loja = new Loja();

        // Criando instâncias de Produto, Comprador e Vendedor
        Produto produto1 = new Produto(1, "Camiseta", 29.99, 10); // Produto com preço e estoque inicial
        Vendedor vendedor = new Vendedor("João", 0.1); // Vendedor com comissão de 10%
        Comprador comprador = new Comprador("Maria", 1234567, 250.00, 25); // Comprador com saldo de 250

        // Criando uma venda
        Venda venda1 = new Venda(comprador, vendedor, produto1);

        // Tentando finalizar a venda
        venda1.finalizarVenda();

        // Adicionando a venda à loja se concluída
        loja.adicionarVenda(venda1);

        // Calculando a comissão do vendedor
        double comissao = vendedor.calcularComissao(produto1.getPreco());

        // Imprimindo informações sobre o estado final
        System.out.println("=== Resumo da Venda ===");
        System.out.println("Comprador: " + comprador.getNome());
        System.out.println("Saldo restante do comprador: R$" + String.format("%.2f", comprador.getRecurso()));
        System.out.println("Produto vendido: " + produto1.getNome());
        System.out.println("Estoque restante: " + produto1.getEstoque());
        System.out.println("Comissão do vendedor " + vendedor.getNome() + ": R$" + String.format("%.2f", comissao));
    }
}
