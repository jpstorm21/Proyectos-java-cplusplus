#include <cstdlib>
#include "Nodo.h"
#include <iostream>
#include <fstream>
#include "MPP.h"

using namespace std;

void leerFotos(MPP *matriz1, MPP *matriz2);
void cambiarColorPixel(MPP *matriz1, MPP *matriz2);
void eliminarColorPixel(MPP *matriz1, MPP *matriz2);
void imprimir(MPP *matriz1, MPP *matriz2);
void cambiarColorXregion(MPP *matriz1, MPP *matriz2);
void eliminarColorXregion(MPP *matriz1, MPP *matriz2);
void compararFotos(MPP *matriz1, MPP *matriz2);
void superPonerFoto(MPP *matriz1, MPP *matriz2);

void menu(MPP *matriz1, MPP *matriz2) {
    int opcion = 0;
    while (opcion != 9) {
        cout << "\t[MENU]" << endl;
        cout << "[1] Ingresar Foto" << endl;
        cout << "[2] Imprimir Foto" << endl;
        cout << "[3] Cambiar color a un pixel" << endl;
        cout << "[4] Eliminar color de un pixel" << endl;
        cout << "[5] Cambiar color de una region " << endl;
        cout << "[6] Eliminar color de una region" << endl;
        cout << "[7] Comparar si dos fotos son iguales " << endl;
        cout << "[8] Superponer dos fotos" << endl;
        cout << "[9] Salir" << endl;
        cout << ">";
        cin >> opcion;
        switch (opcion) {
            case 1:
                leerFotos(matriz1, matriz2);
                cout << "-----------------------" << endl;
                break;
            case 2:
                imprimir(matriz1, matriz2);
                cout << "-----------------------" << endl;
                break;
            case 3:
                cambiarColorPixel(matriz1, matriz2);
                cout << "-----------------------" << endl;
                break;
            case 4:
                eliminarColorPixel(matriz1, matriz2);
                cout << "-----------------------" << endl;
                break;
            case 5:
                cambiarColorXregion(matriz1, matriz2);
                cout << "-----------------------" << endl;
                break;
            case 6:
                eliminarColorXregion(matriz1, matriz2);
                cout << "-----------------------" << endl;
                break;
            case 7:
                compararFotos(matriz1, matriz2);
                break;
            case 8:
                superPonerFoto(matriz1, matriz2);
                cout << "-----------------------" << endl;
                break;
            default:
                opcion = 9;

        }
    }
}

void leerFotos(MPP *matriz1, MPP *matriz2) {
    int color, fondo, fila, columna;
    ifstream foto1("foto1.txt");
    foto1>>fondo;
    while (!foto1.eof()) {
        foto1>>fila;
        foto1>>columna;
        foto1>>color;
        if (color != fondo) {
            matriz1->ingresarColor(fila, columna, color);
            //matriz1->agregarDinamico(fila,columna,color);
        }
    }
    matriz1->setColorFondo(fondo);
    foto1.close();
    cout << "foto1 cargada" << endl;

    ifstream foto2("foto2.txt");
    foto2>>fondo;
    while (!foto2.eof()) {
        foto2>>fila;
        foto2>>columna;
        foto2>>color;
        if (color != fondo) {
            matriz2->ingresarColor(fila, columna, color);
            //matriz1->agregarDinamico(fila,columna,color);
        }
    }
    matriz2->setColorFondo(fondo);
    foto2.close();
    cout << "foto2 cargada" << endl;
}

void cambiarColorPixel(MPP *matriz1, MPP *matriz2) {
    int i, j, color, eleccion;
    cout << "ingrese fila del pixel a cambiar: ";
    cin>>i;
    cout << "ingrese columa del pixel a cambiar: ";
    cin>>j;
    cout << "ingrese el nuevo color: ";
    cin>>color;
    cout << "ingrese [1] si desea cambiarlo en la foto1 o [2] si en la foto2: ";
    cin>>eleccion;
    if (eleccion == 1) {
        matriz1->ingresarColor(i, j, color);
        cout << "color cambiado  exitosamente " << endl;
    } else {
        matriz2->ingresarColor(i, j, color);
        cout << "color cambiado  exitosamente " << endl;
    }


}

void eliminarColorPixel(MPP *matriz1, MPP *matriz2) {
    int i, j, eleccion;
    bool eliminado;
    cout << "ingrese fila del pixel a eliminar: ";
    cin>>i;
    cout << "ingrese columa del pixel a eliminar: ";
    cin>>j;
    cout << "ingrese [1] si desea eliminarlo en la foto1 o [2] si en la foto2: ";
    cin>>eleccion;
    if (eleccion == 1) {
        eliminado = matriz1->elimarColor(i, j);
    } else {
        eliminado = matriz2->elimarColor(i, j);
    }
    if (eliminado) {
        cout << "color eliminado" << endl;
    } else {
        cout << "no se pudo elimiar color" << endl;
    }
}

void imprimir(MPP *matriz1, MPP *matriz2) {
    int eleccion;
    cout << "ingrese [1] si desea imprimir la foto1 o [2] si la foto2: ";
    cin>>eleccion;
    if (eleccion == 1) {
        matriz1->imprimir();
    } else {
        matriz2->imprimir();
    }
}

void cambiarColorXregion(MPP *matriz1, MPP *matriz2) {
    int fila1, col1, fila2, col2, color, eleccion;
    cout << "ingrese fila del inicio de la primer region :";
    cin>>fila1;
    cout << "ingrese columna del inicio de la primera region :";
    cin>>col1;
    cout << "ingrese fila del inicio de la segunda region :";
    cin>>fila2;
    cout << "ingrese columna del inicio de la segunda region :";
    cin>>col2;
    cout << "ingrese el color; ";
    cin>>color;
    cout << "ingrese [1] si desea imprimir la foto1 o [2] si la foto2: ";
    cin>>eleccion;
    if (eleccion == 1) {
        matriz1->cambiarColorReg(fila1, col1, fila2, col2, color);
    } else {
        matriz2->cambiarColorReg(fila1, col1, fila2, col2, color);
    }
    cout << "region cambiada" << endl;
}

void eliminarColorXregion(MPP *matriz1, MPP *matriz2) {
    int fila1, col1, fila2, col2, eleccion;
    bool eliminado;
    cout << "ingrese fila del inicio de la primer region :";
    cin>>fila1;
    cout << "ingrese columna del inicio de la primera region :";
    cin>>col1;
    cout << "ingrese fila del inicio de la segunda region :";
    cin>>fila2;
    cout << "ingrese columna del inicio de la segunda region :";
    cin>>col2;
    cout << "ingrese [1] si desea imprimir la foto1 o [2] si la foto2: ";
    cin>>eleccion;
    if (eleccion == 1) {
        matriz1->eliminarColorReg(fila1, col1, fila2, col2);
    } else {
        matriz2->eliminarColorReg(fila1, col1, fila2, col2);
    }
    if (eliminado) {
        cout << "region eliminada" << endl;
    } else {
        cout << "no se pudo elimiar region" << endl;
    }
}

void compararFotos(MPP *matriz1, MPP *matriz2) {
    if (matriz1->getCantfilas() == matriz2->getCantfilas() && matriz2->getCantcolumnas() == matriz1->getCantcolumnas()) {
        Nodo *actualFila = matriz1->getCabezalFila();
        Nodo *actualfila2 = matriz2->getCabezalFila();
        while (actualFila->getDown() != matriz1->getCabezalFila()) {
            Nodo *actual = actualFila;
            Nodo *actual2 = actualfila2;
            while (actual->getNext()->getColuma() != -1) {
                if (actual->getNext()->getDato() == actual2->getNext()->getDato()) {
                } else {
                    cout << "fotos no son iguales" << endl;
                    return;
                }
                actual = actual->getNext();
                actual2 = actual2->getNext();
            }
            if (actual->getNext()->getDato() == actual2->getNext()->getDato()) {
            } else {
                cout << "fotos no son iguales" << endl;
                return;
            }
            actualFila = actualFila->getDown();
            actualfila2 = actualfila2->getDown();
        }
        Nodo *actual = actualFila;
        Nodo *actual2 = actualfila2;
        while (actual->getNext()->getColuma() != -1) {
            if (actual->getNext()->getDato() == actual2->getNext()->getDato()) {
            } else {
                cout << "fotos no son iguales" << endl;
                return;
            }
            actual = actual->getNext();
            actual2 = actual2->getNext();
        }
        if (actual->getNext()->getDato() == actual2->getNext()->getDato()) {
        } else {
            cout << "fotos no son iguales" << endl;
            return;
        }
    } else {
        cout << "fotos no son iguales" << endl;
        return;
    }
    cout << "fotos son iguales" << endl;
}

void superPonerFoto(MPP *matriz1, MPP *matriz2) {
    Nodo *filaCurrent = matriz1->getCabezalFila();
    while (filaCurrent->getDown() != matriz1->getCabezalFila()) {
        Nodo *actual = filaCurrent;
        while (actual->getNext() != filaCurrent) {
            Nodo *aux = matriz2->buscarNodo(actual->getNext()->getFila(), actual->getNext()->getColuma());
            if (aux == NULL) {
                matriz2->ingresarColor(actual->getNext()->getFila(), actual->getNext()->getColuma(), actual->getNext()->getDato());
            }
                actual = actual->getNext();
            }
            filaCurrent = filaCurrent->getDown();
        }
        Nodo *actual = filaCurrent;
        while (actual->getNext() != filaCurrent) {
            Nodo *aux = matriz2->buscarNodo(actual->getNext()->getFila(), actual->getNext()->getColuma());
            if (aux == NULL) {
                matriz2->ingresarColor(actual->getNext()->getFila(), actual->getNext()->getColuma(), actual->getNext()->getDato());
            }
            actual = actual->getNext();
        }
  
        cout << "foto1 superPonida en la foto 2" << endl;
        matriz2->imprimir();
    }

    int main(int argc, char** argv) {
        MPP *matriz1 = new MPP(3,3);
        matriz1->crearCabezales();
        MPP *matriz2 = new MPP(3,3);
        matriz2->crearCabezales();
        menu(matriz1, matriz2);
        return 0;
    }

