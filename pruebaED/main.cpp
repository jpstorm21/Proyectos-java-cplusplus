
#include <iostream>
#include <cstdlib>

using namespace std;

void pregunta1A(int m [4][4]) {


    for (int i = 0; i < 2; i++) {
        for (int j = 0; j < 4; j++) {
            int aux = m[j][i];
            m[j][i] = m[j][4 - i];
            m[j][4 - i] = aux;
        }
    }
}

void rellenarmatriz(int m [4][4]) {
    int n;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cout << "ingrese dato : ";
            cin>>n;
            m[j][i] = n;
        }
    }
}

void imprimir(int m [4][4]) {
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            cout << m[i][j] << " ";

        }
        cout << endl;
    }

}

void sumarDiagonal(int m[4][4]) {
    int suma = 0;
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < i + 1; j++) {
            suma = suma + m[i][j];
        }

    }
    cout << suma << endl;
}

int main(int argc, char** argv) {
    int m [4][4];
    rellenarmatriz(m);
    imprimir(m);
    cout << "---------------------" << endl;
    //pregunta1A(m);
    imprimir(m);
    cout << "suma : ";
    sumarDiagonal(m);
    return 0;
}

