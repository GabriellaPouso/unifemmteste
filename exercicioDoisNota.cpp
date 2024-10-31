
#include <iostream>
#include <stdio.h>
//Função: Verificar se é triângulo e qual o tipo de Triângulo
//Autor: Gabriella Cecília Pereira Pouso Veiga
//Data: 30/10/2024
int main(){
    int ladoA,ladoB,ladoC;
    printf("Qual a medida do lado A? \n");
    scanf("%d",&ladoA);
    printf("Qual a medida do lado B? \n");
    scanf("%d",&ladoB);
    printf("Qual a medida do lado C? \n");
    scanf("%d",&ladoC);

    if ((ladoA + ladoB > ladoC) && (ladoA + ladoC > ladoB) && (ladoB + ladoC > ladoA)) {
        printf("É triângulo\n");

        if (ladoA == ladoB && ladoB == ladoC) {
            printf("Triângulo EQUILÁTERO\n");
        } else if (ladoA == ladoB || ladoA == ladoC || ladoB == ladoC) {
            printf("Triângulo ISÓSCELES\n");
        } else {
            printf("Triângulo ESCALENO\n");
        }
    } else {
        printf("Não é Triângulo!\n");
    }

    return 0;
}