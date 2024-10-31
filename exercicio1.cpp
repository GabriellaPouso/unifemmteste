#include <iostream>
#include <cmath>

using namespace std;

int main(){
    //Declaração de variáveis
    double angulo_graus, angulo_radianos,velocidade_inicial, alcance, g = 10;
    //Entrada de dados
    cout << "Digite a velocidade inicial (m/s): ";
    cin >> velocidade_inicial;
    cout<<"Digite o ângulo em graus: ";
    cin>>angulo_graus;
    //Conversão do ângulo em graus para radianos
    angulo_radianos=angulo_graus*M_PI/180;
     // Cálculo do alcance
    alcance = (pow(velocidade_inicial, 2) * sin(2 * angulo_radianos))/g;
    // Saída do resultado
    cout << "O alcance máximo da bala é: " << alcance << " metros." << endl;
    return 0;
}