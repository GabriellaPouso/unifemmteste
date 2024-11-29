import java.util.Scanner;

public class testeValidadorCPF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Cria o Scanner para leitura do input
        try {
            System.out.print("Digite o CPF a ser validado: ");
            String cpfInput = scanner.nextLine(); // Lê a entrada do usuário

            // Cria uma instância do ValidadorCPF e valida o CPF
            ValidadorCPF validador = new ValidadorCPF(cpfInput);
            if (validador.isValid()) {
                System.out.println("CPF válido!");
            } else {
                System.out.println("CPF inválido.");
            }
        } finally {
            scanner.close(); // Garante o fechamento do Scanner
        }
    }
}
