package GerencClienteProduto.src;

public class Main {
    public static void main(String[] args) {
        // Criar objeto Cliente
        Cliente cliente = new Cliente();
        cliente.setCPF("12345678901");
        cliente.setNome("João Silva");
        cliente.setEmail("joao@email.com");
        cliente.setEndereco("Rua A, 123");
        System.out.println("Informações do cliente: " + cliente.toString());

        // Criar objeto Produto
        Produto produto = new Produto();
        produto.setCodigo(123);
        produto.setNome("Camiseta");
        produto.setPreco(49.99);
        System.out.println("Informações do produto: " + produto.toString());

        // Calcular preço com desconto
        double desconto = 0.2; // 20% de desconto
        double precoComDesconto = produto.getPrecoComDesconto(desconto);
        System.out.println("Preço com desconto de " + (desconto * 100) + "%: R$" + String.format("%.2f", precoComDesconto));
    }
}