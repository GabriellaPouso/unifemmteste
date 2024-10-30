#include <stdio.h>
int main(){
    double salarioAtual, salarioReajuste, reajuste,percentual;
    printf("Qual o salário atual?\n ");
    scanf("%lf",&salarioAtual);
    if(salarioAtual<=280){
        percentual=0.2;
    }
    else{
        if(salarioAtual<=700){
            percentual=0.15;
        }
        else{
            if(salarioAtual<=1500){
                percentual=0.1;
            }
            else{
                percentual=0.05;
            }
        }
    }
    reajuste=salarioAtual*percentual;
    salarioReajuste=salarioAtual+reajuste;
    printf("Salário Atual: R$ %.2lf\n",salarioAtual);
    printf("Percentual: %.2lf%%\n",percentual*100);
    printf("Reajuste: R$ %.2lf\n",reajuste);
    printf("Salário Reajustado: R$ %.2lf\n",salarioReajuste);
    return 0;
}