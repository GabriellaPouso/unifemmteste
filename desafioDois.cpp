#include <stdio.h>

#define PRECO_INGRESSO 12.50

void mostrarOpcoesFilme() {
    printf("Escolha um filme:\n");
    printf("1. Vingadores 4 da Marvel\n");
    printf("2. Como Treinar o Seu Dragão 3\n");
    printf("3. Dumbo\n");
    printf("4. Shazam!\n");
}

double calcularValorTotal(int quantidade) {
    return quantidade * PRECO_INGRESSO;
}

int main() {
    int opcaoFilme, quantidadeIngressos;

    mostrarOpcoesFilme();

    printf("Digite o número do filme escolhido: ");
    scanf("%d", &opcaoFilme);

    if (opcaoFilme < 1 || opcaoFilme > 4) {
        printf("Opção inválida. Por favor, escolha um número entre 1 e 4.\n");
        return 1;
    }

    printf("Digite a quantidade de ingressos: ");
    scanf("%d", &quantidadeIngressos);

    double valorTotal = calcularValorTotal(quantidadeIngressos);

    printf("Filme escolhido: ");
    switch (opcaoFilme) {
        case 1:
            printf("Vingadores 4 da Marvel\n");
            break;
        case 2:
            printf("Como Treinar o Seu Dragão 3\n");
            break;
        case 3:
            printf("Dumbo\n");
            break;
        case 4:
            printf("Shazam!\n");
            break;
    }

    printf("Quantidade de ingressos: %d\n", quantidadeIngressos);
    printf("Valor total: R$ %.2f\n", valorTotal);

    return 0;
}
