
#include <iostream>
#include <cstdlib>
#include <unistd.h>
#include <fstream>
#include "Nodo.h"
#include "Celula.h"
#include "ListaEnlazada.h"
#define N 30

using namespace std;
int vecinos = 0;
int tablero [30][30];

void ciclo(int matriz[N][N], ListaEnlazada *lista, int ciclo);
void dibujar(int matriz [N][N]);


void menu(ListaEnlazada *lista,int ciclos,int tablero[30][30]) {
    int opcion = 0;
    while (opcion != 10) {
        cout << "\t[MENU]" << endl;
        cout << "agrega tus reglas: " << endl;
        cout << "-------------------" << endl;
        cout << "\t[1] sobrepoblacion" << endl;
        cout << "\t[2] soledad" << endl;
        cout << "\t[3] revivir" << endl;
        cout << "\t[4] vejez" << endl;
        cout << "\t[5] barrio_historico" << endl;
        cout << "\t[6] salto_en_el_tiempo" << endl;
        cout << "\t[7] del_desarrollador" << endl;
        cout << "\t[8] iniciar" << endl;
        cout << "\t[9] eliminar regla" << endl;
        Nodo *actual = lista->getLast();
        string reglas = "[";
        while (actual != NULL) {
            reglas = reglas + actual->getName() + ",";
            actual = actual->getNext();
        }
        reglas = reglas + "]";
        cout << reglas << endl;
        cout << "[10] Salir" << endl;
        cout << ">";
        cin >> opcion;
        switch (opcion) {
            case 1:
                lista->ingresar(0, 0, 0, 0, "sobrepoblacion");
                break;
            case 2:
                lista->ingresar(0, 0, 0, 0, "soledad");
                cout << "-----------------------" << endl;
                break;
            case 3:
                lista->ingresar(0, 0, 0, 0, "revivir");
                cout << "-----------------------" << endl;
                break;
            case 4:
                lista->ingresar(0, 0, 0, 0, "vejez");
                cout << "-----------------------" << endl;
                break;
            case 5:
                lista->ingresar(0, 0, 0, 0, "barrio_historico");
                cout << "-----------------------" << endl;
                break;
            case 6:
                lista->ingresar(0, 0, 0, 0, "salto_en_el_tiempo");
                cout << "-----------------------" << endl;
                break;
            case 7:
                //lista->ingresar(0,0,0,0,'del_desarrollador');
                break;
            case 8:
                int i;
                i= 0;
                while (i < ciclos) {
                    dibujar(tablero);
                    ciclo(tablero,lista,i);
                    cout << "--------------------------" << endl;
                    i++;
                }
                break;
            case 9:
                lista->eliminar();
                break;
            default:
                opcion = 10;

        }
    }
}

int analizarVecinos(int posf, int posc, int mapa [N][N]) {
    vecinos = 0;
    if (posf - 1 >= 0 and posc - 1 >= 0)
        if (mapa[posf - 1][posc - 1] == 1) {
            vecinos++;
        }
    if (posf - 1 >= 0)
        if (mapa[posf - 1][posc] == 1) {
            vecinos++;
        }
    if (posf - 1 >= 0 and posc + 1 <= N - 1)
        if (mapa[posf - 1][posc + 1] == 1) {
            vecinos++;
        }
    if (posc - 1 >= 0)
        if (mapa[posf][posc - 1] == 1) {
            vecinos++;
        }
    if (posc + 1 <= N - 1)
        if (mapa[posf][posc + 1] == 1) {
            vecinos++;
        }
    if (posf + 1 <= N - 1 and posc - 1 >= 0)
        if (mapa[posf + 1][posc - 1] == 1) {
            vecinos++;
        }
    if (posf + 1 <= N - 1)
        if (mapa[posf + 1][posc] == 1) {
            vecinos++;
        }
    if (posf + 1 <= N - 1 and posc + 1 <= N - 1)
        if (mapa[posf + 1][posc + 1] == 1) {
            vecinos++;
        }
    return vecinos;
}

int regla(int i, int j, int vecinos, int estadoActual) {
    return vecinos;
}

void ciclo(int matriz[N][N], ListaEnlazada *lista, int ciclo) {
    int Nmatriz [N][N];
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            Nmatriz[i][j] = matriz[i][j];
        }
    }
    for (int f = 0; f < N; f++) {
        for (int c = 0; c < N; c++) {
            int v = analizarVecinos(f,c,matriz);
            Nodo *actual = lista->getLast();
            while (actual != NULL) {
                actual->setVecinos(v);
                Celula *celula = actual->getCelula();
                celula->setFila(f);
                celula->setColumna(c);
                int estado = matriz[f][c];
                celula->setEstado(estado);
                celula->setCiclos(ciclo);
                int valor = actual->aplicarRule(ciclo,estado);
                Nmatriz[f][c] = valor;
                actual = actual->getNext();
            }
           
        }
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            matriz[i][j] = Nmatriz[i][j];
        }
    }
}

void dibujar(int matriz [N][N]) { //listo
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if (matriz[i][j] == 1) {
                cout << "* ";
            } else {
                cout << ". ";
            }
        }
        cout << "\n";
    }
}

void cargarTalero(int tablero[N][N]) {
    int fila = 0;
    int columna = 0;
    int valor;
    ifstream matriz("matrix1.txt");
    for (int i = 0; i < 30; i++) {
        for (int j = 0; j < 30; j++) {
            matriz>>valor;
            tablero[i][j] = valor;
        }
    }
    cout << "matriz cargada" << endl;
    matriz.close();
}

int main() {
    ListaEnlazada *lista = new ListaEnlazada();
    cargarTalero(tablero);
    int ciclo;
    cout<<"ingrese cantidad de ciclos: ";
    cin>>ciclo;
    menu(lista,ciclo,tablero);

}