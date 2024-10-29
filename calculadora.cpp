#include <stdio.h>
int main(){

    int operador;
    float numero1,numero2,resultado;

    do{
        printf("---Menu---\n");
        printf("1 - Soma\n");
        printf("2 - Subtração\n");
        printf("3 - Multiplicação\n");
        printf("4 - Divisão\n");
        printf("5 - Encerrar\n");
        printf("Digite o número da operação escolhida: ");
        scanf("%d",&operador);

        
        switch(operador){
            case 1:
                printf("Digite o primeiro número: ");
                scanf("%f",&numero1);
                printf("Digite o segundo número: ");
                scanf("%f",&numero2);
                resultado=numero1+numero2;
                printf("Resultado da operação Soma entre %.2f e %.2f: %.2f\n",numero1,numero2,resultado);
                break;
            case 2:
                printf("Digite o primeiro número: ");
                scanf("%f",&numero1);
                printf("Digite o segundo número: ");
                scanf("%f",&numero2);
                resultado=numero1-numero2;
                printf("Resultado da operação Subtração entre %.2f e %.2f: %.2f\n",numero1,numero2,resultado);
                break;
            case 3:
                printf("Digite o primeiro número: ");
                scanf("%f",&numero1);
                printf("Digite o segundo número: ");
                scanf("%f",&numero2);
                resultado=numero1*numero2;
                printf("Resultado da operação Multiplicação entre %.2f e %.2f: %.2f\n",numero1,numero2,resultado);
                break;
            case 4:
                printf("Digite o primeiro número: ");
                scanf("%f",&numero1);
                printf("Digite o segundo número: ");
                scanf("%f",&numero2);
                resultado=numero1/numero2;
                printf("Resultado da operação Divisão entre %.2f e %.2f: %.2f\n",numero1,numero2,resultado);
                break;
            case 5:
                printf("Encerrando calculadora!!\n");
                break;
        }
    }
    while(operador!=5);
    return 0;
}