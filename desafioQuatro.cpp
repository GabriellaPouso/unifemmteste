#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    const int NUM_OPCOES = 6;
    int votos[NUM_OPCOES + 1] = {0}; // índice 0 será para votos inválidos
    int totalVotos = 0;
    int voto;

    cout << "Enquete: Qual o melhor sistema operacional para uso em servidores?" << endl;
    cout << "1 - Windows Server" << endl;
    cout << "2 - Unix" << endl;
    cout << "3 - Linux" << endl;
    cout << "4 - Netware" << endl;
    cout << "5 - Mac OS" << endl;
    cout << "6 - Outro" << endl;
    cout << "0 - Encerrar" << endl;

    // Coleta de votos
    while (true) {
        cout << "Digite sua resposta (0 a 6): ";
        cin >> voto;

        if (voto == 0) {
            break; // Encerra a entrada de dados
        } else if (voto >= 1 && voto <= NUM_OPCOES) {
            votos[voto]++; // Registra o voto
            totalVotos++;  // Incrementa o total de votos
        } else {
            cout << "Voto inválido. Tente novamente." << endl;
        }
    }

    // Exibição dos resultados
    cout << fixed << setprecision(2); // Configura a precisão para 2 casas decimais
    cout << "\nResultados da Enquete:" << endl;

    for (int i = 1; i <= NUM_OPCOES; i++) {
        double percentual = (totalVotos > 0) ? (static_cast<double>(votos[i]) / totalVotos) * 100 : 0;
        cout << "Opção " << i << ": " << votos[i] << " voto(s) (" << percentual << "%)" << endl;
    }

    return 0;
}
