#include <iostream>

using namespace std;

int main() {
    // Coeficientes das equações
    double a1 = 2, b1 = 3, c1 = 4.8 * (2 + 3);
    double a2 = 3, b2 = 2, c2 = 5.2 * (3 + 2);
a1= t1_m1
b1= t2_m1
c1= p_m1*(t1_m1+t2_m1)
a2= t1_m2
b2= t2_m2
c2= p_m2*(t1_m2+t2_m2)

    // Cálculo do determinante
    double det = a1 * b2 - a2 * b1;

    // Verificando se o sistema tem solução única
    if (det == 0) {
        cout << "O sistema não tem solução única ou possui infinitas soluções." << endl;
        return 1;
    }

    // Calculando x e y
    double x = (c1 * b2 - c2 * b1) / det;
    double y = (a1 * c2 - a2 * c1) / det;

    // Imprimindo os resultados
    cout << "x = " << x << endl;
    cout << "y = " << y << endl;

    return 0;
}