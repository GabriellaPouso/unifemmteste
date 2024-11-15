import java.util.Scanner;

public class testeValidadorCPF {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Digite o CPF a ser validado: ");
    String cpfInput = scanner.nextLine();

    ValidadorCPF validador = new ValidadorCPF(cpfInput);
    if (validador.isValid()) {
        System.out.println("CPF válido!");
    } else {
        System.out.println("CPF inválido.");
    }
    }
}