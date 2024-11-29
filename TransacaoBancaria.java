import java.util.Scanner;

public class TransacaoBancaria {
    private double saldo;
    private double limiteChequeEspecial;
    private final double limiteInicialChequeEspecial; // Para restaurar o limite original

    // Construtor
    public TransacaoBancaria(double saldoInicial, double limiteChequeEspecial) {
        this.saldo = saldoInicial;
        this.limiteChequeEspecial = limiteChequeEspecial;
        this.limiteInicialChequeEspecial = limiteChequeEspecial; // Armazena o limite original
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

    // Método para realizar depósito com restauração do cheque especial
    public String realizarDeposito(double valorDeposito) {
        if (valorDeposito > 0) {
            saldo += valorDeposito;

            // Restaurar o limite do cheque especial, se necessário
            if (limiteChequeEspecial < limiteInicialChequeEspecial) {
                double restaurar = Math.min(valorDeposito, limiteInicialChequeEspecial - limiteChequeEspecial);
                limiteChequeEspecial += restaurar;
                saldo -= restaurar; // Deduz do saldo o valor usado para restaurar o limite
            }

            return "Depósito realizado com sucesso. Saldo atual: R$ " + saldo + ", Limite do cheque especial: R$ " + limiteChequeEspecial;
        } else {
            return "Valor de depósito inválido. Por favor, insira um valor maior que 0.";
        }
    }

    // Método para consultar o saldo
    public String consultarSaldo() {
        return "Saldo atual: R$ " + saldo + ", Limite do cheque especial: R$ " + limiteChequeEspecial;
    }

    // Main com entrada do usuário
    public static void main(String[] args) {
        // Solicitar o saldo inicial ao usuário
        try (Scanner scanner = new Scanner(System.in)) {
            // Solicitar o saldo inicial ao usuário
            System.out.print("Digite o saldo inicial da conta: R$ ");
            double saldoInicial = scanner.nextDouble();
            
            // Solicitar o limite do cheque especial ao usuário
            System.out.print("Digite o limite do cheque especial: R$ ");
            double limiteChequeEspecial = scanner.nextDouble();
            
            // Criar a conta com os valores fornecidos
            TransacaoBancaria conta = new TransacaoBancaria(saldoInicial, limiteChequeEspecial);
            
            OUTER:
            while (true) {
                System.out.println("\nEscolha uma operação:");
                System.out.println("1 - Realizar saque");
                System.out.println("2 - Realizar depósito");
                System.out.println("3 - Consultar saldo");
                System.out.println("4 - Sair");
                System.out.print("Opção: ");
                int opcao = scanner.nextInt();
                switch (opcao) {
                    case 1 -> {
                        // Realizar saque
                        System.out.print("Digite o valor do saque: R$ ");
                        double valorSaque = scanner.nextDouble();
                        System.out.println(conta.realizarSaque(valorSaque));
                    }
                    case 2 -> {
                        // Realizar depósito
                        System.out.print("Digite o valor do depósito: R$ ");
                        double valorDeposito = scanner.nextDouble();
                        System.out.println(conta.realizarDeposito(valorDeposito));
                    }
                    case 3 -> // Consultar saldo
                        System.out.println(conta.consultarSaldo());
                    case 4 -> {
                        // Sair do programa
                        System.out.println("Encerrando o programa. Obrigado!");
                        break OUTER;
                    }
                    default -> System.out.println("Opção inválida. Tente novamente.");
                }
            }
        }
    }
}