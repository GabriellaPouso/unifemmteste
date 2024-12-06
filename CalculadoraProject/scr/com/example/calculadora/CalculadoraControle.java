package CalculadoraProject.scr.com.example.calculadora;

import java.util.Scanner;

public class CalculadoraControle {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String opcao;

            do {
                System.out.println("Escolha a operação (ou digite 'finalizar' para sair):");
                System.out.println("1 - Soma");
                System.out.println("2 - Subtração");
                System.out.println("3 - Multiplicação");
                System.out.println("4 - Divisão");
                opcao = scanner.nextLine();

                if (opcao.equalsIgnoreCase("finalizar")) {
                    break;
                }

                try {
                    int escolha = Integer.parseInt(opcao);
                    System.out.print("Digite o primeiro número: ");
                    double num1 = scanner.nextDouble();
                    System.out.print("Digite o segundo número: ");
                    double num2 = scanner.nextDouble();

                    Calculadora calculadora;
                    switch (escolha) {
                        case 1 -> calculadora = new Soma();
                        case 2 -> calculadora = new Subtracao();
                        case 3 -> calculadora = new Multiplicacao();
                        case 4 -> calculadora = new Divisao();
                        default -> {
                            System.out.println("Opção inválida.");
                            continue;
                        }
                    }

                    double resultado = calculadora.calcular(num1, num2);
                    System.out.println("Resultado: " + resultado);
                } catch (NumberFormatException e) {
                    System.out.println("Entrada inválida. Por favor, digite um número ou 'finalizar'.");
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            } while (true);
        }
        System.out.println("Calculadora encerrada.");
    }
}