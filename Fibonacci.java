public class Fibonacci {
    public static void main(String[] args) {
        // Define o número de elementos desejados na sequência
        int n = 50;

        // Array para armazenar os primeiros 50 números da sequência de Fibonacci
        long[] fibonacci = new long[n];

        // Inicializa os dois primeiros números da sequência
        fibonacci[0] = 0;
        fibonacci[1] = 1;

        // Gera os demais números usando um laço de repetição
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        // Exibe os números da sequência de Fibonacci
        System.out.println("Os primeiros 50 números da sequência de Fibonacci são:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci[i] + " ");
        }
    }
}
