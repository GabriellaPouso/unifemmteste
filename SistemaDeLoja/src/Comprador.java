package SistemaDeLoja.src;

public class Comprador {
    private String nome;
    private int cpf;
    private double recurso;
    private int idade;

    public Comprador(String nome, int cpf, double recurso, int idade) {
        this.nome = nome;
        this.cpf = cpf;
        this.recurso = recurso;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public double getRecurso() {
        return recurso;
    }

    public boolean pagar(double valor) {
        if (recurso >= valor) {
            recurso -= valor;
            return true;
        }
        return false;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void setRecurso(double recurso) {
        this.recurso = recurso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
