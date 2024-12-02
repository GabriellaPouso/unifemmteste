package com.example.calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            try {
                System.out.println("Bem-vindo à Calculadora!");
                System.out.println("Escolha a operação (1-Soma, 2-Subtração, 3-Multiplicação, 4-Divisão, 5-Sair):");
                int opcao = scanner.nextInt();

                if (opcao == 5) {
                    System.out.println("Encerrando a calculadora...");
                    continuar = false;
                    break;
                }

                System.out.print("Digite o primeiro número: ");
                double num1 = scanner.nextDouble();

                System.print("Digite o segundo número: ");
                double num2 = scanner.nextDouble();

                double resultado = 0;
                Calculadora calculadora;

                switch (opcao) {
                    case 1:
                        calculadora = new Soma();
                        resultado = calculadora.calcular(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 2:
                        calculadora = new Subtracao();
                        resultado = calculadora.calcular(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 3:
                        calculadora = new Multiplicacao();
                        resultado = calculadora.calcular(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    case 4:
                        calculadora = new Divisao();
                        resultado = calculadora.calcular(num1, num2);
                        System.out.println("Resultado: " + resultado);
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Tente novamente.");
                scanner.nextLine(); // Limpar o buffer do scanner
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}