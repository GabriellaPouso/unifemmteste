package CalculadoraProject.scr.com.example.calculadora;

public class Soma implements Calculadora {
    @Override
    public double calcular(double a, double b) {
        return a + b;
    }
}