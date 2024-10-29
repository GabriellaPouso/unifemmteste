#include <iostream>
#include <cstdlib>
#include <ctime>

using namespace std;

void mostrarOpcoes() {
    cout << "Escolha uma opção:\n";
    cout << "0 - Pedra\n";
    cout << "1 - Papel\n";
    cout << "2 - Tesoura\n";
}

int main() {
    srand(static_cast<unsigned int>(time(0)));
    
    int escolhaUsuario;
    int escolhaComputador;

    mostrarOpcoes();
    
    cout << "Digite sua escolha (0, 1 ou 2): ";
    cin >> escolhaUsuario;

    if (escolhaUsuario < 0 || escolhaUsuario > 2) {
        cout << "Escolha inválida! Tente novamente.\n";
        return 1;
    }

    escolhaComputador = rand() % 3;

    cout << "Você escolheu: ";
    switch (escolhaUsuario) {
        case 0: cout << "Pedra\n"; break;
        case 1: cout << "Papel\n"; break;
        case 2: cout << "Tesoura\n"; break;
    }

    cout << "O computador escolheu: ";
    switch (escolhaComputador) {
        case 0: cout << "Pedra\n"; break;
        case 1: cout << "Papel\n"; break;
        case 2: cout << "Tesoura\n"; break;
    }

    if (escolhaUsuario == escolhaComputador) {
        cout << "Empate!\n";
    } else if ((escolhaUsuario == 0 && escolhaComputador == 2) || 
               (escolhaUsuario == 1 && escolhaComputador == 0) || 
               (escolhaUsuario == 2 && escolhaComputador == 1)) {
        cout << "Você ganhou!\n";
    } else {
        cout << "Você perdeu!\n";
    }

    return 0;
}
