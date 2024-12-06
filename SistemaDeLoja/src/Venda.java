package SistemaDeLoja.src;

public class Venda {
    private Comprador comprador;
    private Vendedor vendedor;
    private Produto produto;

    public Venda(Comprador comprador, Vendedor vendedor, Produto produto) {
        this.comprador = comprador;
        this.vendedor = vendedor;
        this.produto = produto;
    }

    // Getters e Setters
    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    // Métodos de negócio
    public void finalizarVenda() {
        if (comprador != null && produto != null) {
            double valorTotal = calcularValorTotal();
            if (valorTotal > 0 && produto.vender()) {
                System.out.println("Venda finalizada com sucesso!");
                System.out.println("Produto: " + produto.getNome() + " | Valor: R$" + produto.getPreco());
                System.out.println("Comprador: " + comprador.getNome() + " | Saldo restante: R$" + comprador.getRecurso());
                if (vendedor != null) {
                    double comissao = vendedor.calcularComissao(produto.getPreco());
                    System.out.println("Comissão do vendedor " + vendedor.getNome() + ": R$" + String.format("%.2f", comissao));
                }
            } else {
                System.out.println("Venda não pôde ser concluída. Verifique estoque ou saldo.");
            }
        } else {
            System.out.println("Dados da venda incompletos. Verifique comprador e produto.");
        }
    }

    public void cancelarVenda() {
        if (produto != null) {
            produto.cancelar();
            System.out.println("Venda cancelada. Estoque atualizado para o produto: " + produto.getNome());
        } else {
            System.out.println("Não foi possível cancelar a venda. Produto inválido.");
        }
    }

    public double calcularValorTotal() {
        if (comprador != null && produto != null) {
            if (comprador.pagar(produto.getPreco())) {
                return produto.getPreco();
            } else {
                System.out.println("Comprador " + comprador.getNome() + " não possui saldo suficiente.");
            }
        } else {
            System.out.println("Erro ao calcular valor: Comprador ou produto inválido.");
        }
        return 0.0;
    }
}
