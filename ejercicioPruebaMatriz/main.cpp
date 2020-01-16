

#include <cstdlib>
#include <iostream>
#include "MatrizPocoPoblada.h"
#include "NodoMatriz.h"
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    MatrizPocoPoblada *m =new  MatrizPocoPoblada();
    m->crearCabezales();
    m->rellenarDiagonal(100);
    /*m->agregarDato(20,2,3);
    m->agregarDato(20,2,2);
    m->agregarDato(20,2,4);*/
    m->imprimirDatos();
    NodoMatriz *actual = m->buscarCabezalFila(0);
    NodoMatriz *actual1 = m->buscarCabezalColumna(2);
    cout<<"la fila buscada tiene el dato: "<<actual->getDato()<<endl;
    return 0;
}

