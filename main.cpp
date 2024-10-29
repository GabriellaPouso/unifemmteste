#include <iostream>

using namespace std;

int obterNumero() {
    int numero;
    cout << "Por favor, insira um número inteiro: ";
    cin >> numero;
    return numero;
}

void calcularAntecessorSucessor(int numero, int &antecessor, int &sucessor) {
    antecessor = numero - 1;
    sucessor = numero + 1;
}

void mostrarTabuada(int numero) {
    cout << "\nTabuada de " << numero << ":\n";
    for (int i = 1; i <= 10; i++) {
        cout << numero << " x " << i << " = " << numero * i << endl;
    }
}

void mostrarProximosNumeros(int numero) {
    cout << "\nPróximos três números com contagem de dois em dois:\n";
    for (int i = 1; i <= 3; i++) {
        cout << numero + i * 2 << endl;
    }
}

int main() {
    int numero, antecessor, sucessor;

    numero = obterNumero();
    calcularAntecessorSucessor(numero, antecessor, sucessor);
    
    cout << "Antecessor: " << antecessor << ", Sucessor: " << sucessor << endl;

    mostrarTabuada(numero);
    mostrarProximosNumeros(numero);

    return 0;
}
