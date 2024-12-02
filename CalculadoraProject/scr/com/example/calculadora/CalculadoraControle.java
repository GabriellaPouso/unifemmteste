package CalculadoraProject.scr.com.example.calculadora;

public class CalculadoraControle {
    public static void main(String[] args) {
        Calculadora soma = new Soma();
        Calculadora subtracao = new Subtracao();
        Calculadora multiplicacao = new Multiplicacao();
        Calculadora divisao = new Divisao();

        System.out.println("Soma: " + soma.calcular(5, 3));
        System.out.println("Subtração: " + subtracao.calcular(10, 4));
        System.out.println("Multiplicação: " + multiplicacao.calcular(2, 7));
        System.out.println("Divisão: " + divisao.calcular(15, 3));
    }
}