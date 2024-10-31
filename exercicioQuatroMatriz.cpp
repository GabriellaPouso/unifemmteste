#include <iostream>
using namespace std;
int main() {
    int matrizA[3][2], matrizB[2][3], resultado[3][3];
    // matriz A
    cout << "Digite os elementos da matriz A (3x2):" << endl;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 2; j++) {
            cin >> matrizA[i][j];
        }
    }
    // matriz B
    cout << "Digite os elementos da matriz B (2x3):" << endl;
    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 3; j++) {
            cin >> matrizB[i][j];
        }
    }
    // Multiplicando as matrizes
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            resultado[i][j] = 0;
            for (int k = 0; k < 2; k++) {
                resultado[i][j] += matrizA[i][k] * matrizB[k][j];
            }
        }
    }
    // matriz resultante
    cout << "A matriz resultante da multiplicação é:" << endl;
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            cout << resultado[i][j] << " ";
        }
        cout << endl;
    }
    return 0;
}