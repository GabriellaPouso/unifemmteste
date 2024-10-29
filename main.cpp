#include <iostream>

using namespace std;

// Função para solicitar um número ao usuário
int solicitarNumero() {
    int numero;
    cout << "Por favor, insira um número inteiro: ";
    cin >> numero;
    return numero;
}

// Função para calcular o antecessor e o sucessor
void calcularAntecessorSucessor(int numero, int &antecessor, int &sucessor) {
    antecessor = numero - 1;
    sucessor = numero + 1;
}

// Função para mostrar a tabuada de multiplicação
void mostrarTabuada(int numero) {
    cout << "\nTabuada de " << numero << ":\n";
    for (int i = 1; i <= 10; i++) {
        cout << numero << " x " << i << " = " << numero * i << endl;
    }
}

// Função para mostrar os próximos três números com contagem de dois em dois
void mostrarProximosNumeros(int numero) {
    cout << "\nPróximos três números com contagem de dois em dois:\n";
    for (int i = 1; i <= 3; i++) {
        cout << numero + i * 2 << endl;
    }
}

// Função principal
int main() {
    int numero, antecessor, sucessor;

    numero = solicitarNumero();
    calcularAntecessorSucessor(numero, antecessor, sucessor);
    
    cout << "Antecessor: " << antecessor << ", Sucessor: " << sucessor << endl;

    mostrarTabuada(numero);
    mostrarProximosNumeros(numero);

    return 0;
}
