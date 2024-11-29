public class ContaBancaria {
    private double saldo;
    private final double limiteChequeEspecial;
    
    public ContaBancaria(double saldoInicial, double limiteChequeEspecial) {
        this.saldo = saldoInicial;
        this.limiteChequeEspecial = limiteChequeEspecial;
    }
    
    public boolean realizarSaque(double valorSaque) {
        // Verifica se o valor é válido
        if (valorSaque <= 0) {
            System.out.println("Valor de saque inválido");
            return false;
        }
        
        // Verifica se há saldo disponível (incluindo cheque especial)
        double saldoTotal = saldo + limiteChequeEspecial;
        
        if (valorSaque <= saldoTotal) {
            // Realiza o saque
            saldo -= valorSaque;
            System.out.println("Saque realizado com sucesso");
            System.out.println("Novo saldo: " + saldo);
            
            // Informa uso do cheque especial
            if (saldo < 0) {
                System.out.println("Utilizando cheque especial: " + (-saldo));
            }
            return true;
        } else {
            System.out.println("Saldo insuficiente (incluindo cheque especial)");
            return false;
        }
    }
    
    public double consultarSaldo() {
        return saldo;
    }
    
    public double consultarLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }
}