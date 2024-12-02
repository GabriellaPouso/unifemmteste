package CalculadoraProject.scr.com.example.calculadora;

public class Divisao implements Calculadora {
    @Override
    public double calcular(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Não é possível dividir por zero.");
        }
        return a / b;
    }
}

