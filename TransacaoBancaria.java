public class TransacaoBancaria {
    private double saldo;
    private double limiteChequeEspecial;

    // Construtor
    public TransacaoBancaria(double saldoInicial, double limiteChequeEspecial) {
        this.saldo = saldoInicial;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    // Método para realizar saque
    public String realizarSaque(double valorSaque) {
        if (valorSaque <= saldo) {
            saldo -= valorSaque;
            return "Saque realizado com sucesso. Saldo atual: R$ " + saldo;
        } else if (valorSaque <= (saldo + limiteChequeEspecial)) {
            double diferenca = valorSaque - saldo;
            saldo = 0;
            limiteChequeEspecial -= diferenca;
            return "Saque realizado utilizando cheque especial. Saldo: R$ 0, Limite do cheque especial restante: R$ " + limiteChequeEspecial;
        } else {
            return "Saque negado. Valor excede o saldo e o limite do cheque especial.";
        }
    }

    // Método para consultar o saldo
    public String consultarSaldo() {
        return "Saldo atual: R$ " + saldo + ", Limite do cheque especial: R$ " + limiteChequeEspecial;
    }

    // Main para teste
    public static void main(String[] args) {
        // Criando uma conta com saldo inicial de R$ 1000 e limite de cheque especial de R$ 500
        TransacaoBancaria conta = new TransacaoBancaria(1000.0, 500.0);

        // Testando saques
        System.out.println(conta.realizarSaque(800)); // Saque dentro do saldo
        System.out.println(conta.consultarSaldo());
        System.out.println(conta.realizarSaque(900)); // Saque utilizando cheque especial
        System.out.println(conta.consultarSaldo());
        System.out.println(conta.realizarSaque(100)); // Saque negado
    }
}
