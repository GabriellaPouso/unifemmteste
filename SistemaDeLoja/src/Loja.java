package SistemaDeLoja.src;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Venda> vendas = new ArrayList<>();

    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
        System.out.println("Venda adicionada com sucesso!");
    }

    public List<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }
}