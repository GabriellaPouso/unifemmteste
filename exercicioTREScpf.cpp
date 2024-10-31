#include <iostream>
#include <string>

using namespace std;

// Função para calcular o dígito verificador
int calcularDigitoVerificador(const string& cpf, int pesoInicial) {
    int soma = 0;
    for (int i = 0; i < pesoInicial - 1; i++) {
        soma += (cpf[i] - '0') * (pesoInicial - i);
    }
    int digito = 11 - (soma % 11);
    return (digito >= 10) ? 0 : digito;
}

// Função para validar o CPF
bool validarCPF(const string& cpf) {
    if (cpf.length() != 11) {
        return false; // CPF deve ter 11 dígitos
    }

    // Verifica se todos os caracteres são dígitos
    for (char c : cpf) {
        if (!isdigit(c)) {
            return false;
        }
    }

    // Calcula o primeiro dígito verificador
    int primeiroDigito = calcularDigitoVerificador(cpf, 10);
    if (primeiroDigito != (cpf[9] - '0')) {
        return false;
    }

    // Calcula o segundo dígito verificador
    int segundoDigito = calcularDigitoVerificador(cpf, 11);
    if (segundoDigito != (cpf[10] - '0')) {
        return false;
    }

    return true; // CPF válido
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
