#include <stdio.h>
int main(){
    int numero,contador,resultado;
    printf("Qual a tabuada de multiplicar você precisa? ");
    scanf("%d",&numero);
    contador=0;
    while(contador<11){
        resultado=numero*contador;
        printf("%d x %d: %d\n",numero,contador,resultado);
        contador=contador+1;
    }
}