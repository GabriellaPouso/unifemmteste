import java.util.Scanner;

public class Fibonacci
{
    public static void main(String[] args)
    {
        int tamanho = getTotalTermos();
        long[] numeros = new long[tamanho];

        numeros[0]=0;
        numeros[1]=1;

        System.out.print("0, 1");

        for(int i=2; i<numeros.length; i++)
        {
          numeros[i] = numeros[i-1] + numeros[i-2];  

          System.out.print(", " + numeros[i]);
        }

        System.out.println();
    }

    /**
     * @return
     */
    private static int getTotalTermos()
    {
        int total_termos = 0 = 0;
        try (Scanner input = new Scanner(System.in)) {
            try
            {
                System.out.print("Digite a quantidade de termos: " ); 
                total_termos = input.nextInt();

                if(total_termos<2)
                {
                     System.out.println("Por favor digite um número que seja maior do que 1" );
                     return getTotalTermos();
                } 
            }
            catch(Exception e)
            {
                System.out.println("Erro - Número inteiro inválido");
            }
        } 

        return total_termos;
    }
}