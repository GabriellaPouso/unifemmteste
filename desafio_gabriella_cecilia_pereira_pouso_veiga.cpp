#include <iostream>
#include <iomanip>
//Desafio Prático
//Disciplina: Algorítmo e Programação II (2024/10EAD)
//Aluna: Gabriella Cecília Pereira Pouso Veiga
using namespace std;

int main() {
    double a1, b1, c1, a2, b2, c2, x, y;
        //Variáveis: Mistura 1 => "café Tipo 1": a1; "café Tipo 2": b1; preço pago: c1.
        //          Mistura 2 => "café Tipo 1": a2; "café Tipo 2": b2; preço pago: c2.
        // Entrada de dados:
    cout << "Digite a quantidade de café tipo 1 na mistura 1: ";
    cin >> a1;
    cout << "Digite a quantidade de café tipo 2 na mistura 1: ";
    cin >> b1;
    cout << "Digite o preço da mistura 1 por kg: ";
    cin >> c1;
    cout << "Digite a quantidade de café tipo 1 na mistura 2: ";
    cin >> a2;
    cout << "Digite a quantidade de café tipo 2 na mistura 2: ";
    cin >> b2;
    cout << "Digite o preço da mistura 2 por kg: ";
    cin >> c2;

    // Resposta a erros:
    if (a1 <= 0 || b1 <= 0 || c1 <= 0 || a2 <= 0 || b2 <= 0 || c2 <= 0 || a1 == b1) {
        cout << "Valores inválidos. As quantidades devem ser positivas e diferentes." << endl;
        return 1;
    }

    // Equações para encontrar x e y:
    double det = a1 * b2 - a2 * b1;
    x = ((c1*(a1+b1)) * b2 - (c2*(a2+b2)) * b1) / det;
    y = (a1 * (c2*(a2+b2)) - a2 * (c1*(a1+b1))) / det;

    // Área de impressão:
    cout << fixed << setprecision(2);
    cout << "\nMistura 1:" << endl;
    cout << "Quantidade de Café do Tipo 1 (kg): " << a1 << endl;
    cout << "Quantidade de Café do Tipo 2 (kg): " << b1 << endl;
    cout << "Valor da Mistura 1 (Kg): " << c1 << endl;
    cout << "Preço do Café do Tipo 1: R$" << x << endl;
    cout << "Preço do Café do Tipo 2: R$" << y << endl;

    cout << "\nMistura 2:" << endl;
    cout << "Quantidade de Café do Tipo 1 (kg): " << a2 << endl;
    cout << "Quantidade de Café do Tipo 2 (kg): " << b2 << endl;
    cout << "Valor da Mistura 2 (Kg): " << c2 << endl;
    cout << "Preço do Café do Tipo 1: R$" << x << endl;
    cout << "Preço do Café do Tipo 2: R$" << y << endl;

    return 0;
}
