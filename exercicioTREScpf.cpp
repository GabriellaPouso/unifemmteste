#include <iostream>
#include <string>

using namespace std;

bool validarCPF(string cpf) {
    if (cpf.size() != 11) {
        return false;
    }

    int soma = 0;
    int peso = 10;
    for (int i = 0; i < 9; i++) {
        soma += (cpf[i] - '0') * peso;
        peso--;
    }

    int resto = soma % 11;
    if (resto < 2) {
        resto = 0;
    } else {
        resto = 11 - resto;
    }

    if (resto != (cpf[9] - '0')) {
        return false;
    }

    soma = 0;
    peso = 11;
    for (int i = 0; i < 10; i++) {
        soma += (cpf[i] - '0') * peso;
        peso--;
    }

    resto = soma % 11;
    if (resto < 2) {
        resto = 0;
    } else {
        resto = 11 - resto;
    }

    return resto == (cpf[10] - '0');
}

int main() {
    string cpf;

    cout << "Digite o CPF (somente números): ";
    cin >> cpf;

    if (validarCPF(cpf)) {
        cout << "CPF válido." << endl;
    } else {
        cout << "CPF inválido." << endl;
    }

    return 0;
}