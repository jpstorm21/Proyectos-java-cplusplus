/*
 * Integrantes:     Rosita Hormann Lobos.
 *                  Matías Zárate Araya.
 * Carrera:         Ingeniería Civil en Computación e Informática.
 * Fecha:           22 noviembre, 2016.
 * IDE:             NetBeans 8.1
 * Compilador:      Cygwin version 2.876 (64 bit)
 */

/* 
 * File:   main.cpp
 *
 * Se implementan tres estructuras de datos que podrán ser usadas en futuros
 * programas. Las estructuras son una cola estática que funciona como cola
 * circular, una cola con prioridad implementda con un árbol heap, y un árbol
 * AVL. Todas estas estructuras puedes recibir cualquier tipo de dato, siempre
 * y cuando dichos datos incorporen los operadores de igualdad, desigualdad,
 * mayor a y menor a.
 */

#include <cstdlib>
#include <iostream>
#include "ColaCircular.h"
#include "ArbolHeap.h"
#include "Arbol_AVL.h"

void probandoColaCircular(); // Función para probar la cola circular.
void probandoArbolHeap(); // Función para probar la cola con prioridad, implementada como árbol heap.
void probandoArbolAVL(); // Funcion para probar el arbol binario AVL.
int Opciones();

using namespace std;

int main(int argc, char** argv) {
    //probandoColaCircular();
    //probandoArbolHeap();
    probandoArbolAVL();
    return 0;
}

/**
 * Función que puede ser usada por el programador para probar el funcionamiento
 * de la cola circular.
 */
void probandoColaCircular() {
    ColaCircular* c = new ColaCircular(10);
    //    cout << NULL << endl;
    cout << c->push(1) << endl;
    cout << c->push(2) << endl;
    cout << c->push(3) << endl;
    cout << c->push(4) << endl;
    cout << c->push(5) << endl;
    cout << c->push(6) << endl;
    cout << c->push(7) << endl;
    cout << c->push(8) << endl;
    cout << c->push(9) << endl;
    cout << c->push(10) << endl;
    cout << c->push(11) << endl;
    cout << c->push(12) << endl;
    cout << c->push(13) << endl;
    cout << c->push(14) << endl;

    cout << "-----------" << endl;

    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
    cout << c->pop() << endl;
}

/**
 * Función que puede ser usada por el programador para probar el funcionamiento
 * de la cola con prioridad, que está implementada con un árbol heap.
 */
void probandoArbolHeap() {
    ArbolHeap<int>* ah = new ArbolHeap<int>();

    ah->agregar(5);
    ah->agregar(1);
    ah->agregar(3);
    ah->agregar(8);
    ah->agregar(4);
    ah->agregar(9);
    ah->agregar(2);
    ah->agregar(10);
    ah->agregar(-1);

   
    cout << ah->sacar() << endl;
    cout << ah->sacar() << endl;
    cout << ah->sacar() << endl;
    cout << ah->sacar() << endl;
    cout << ah->sacar() << endl;
    cout << ah->sacar() << endl;
    cout << ah->sacar() << endl;
    cout << ah->sacar() << endl;
    cout << ah->sacar() << endl;
}

void probandoArbolAVL() {
    int numero;
    bool salir = false;
    Arbol_AVL<int>* avl = new Arbol_AVL<int>();
    cout << endl;
    while (!salir) {
        switch (Opciones()) {
            case 1:
                cout << "ingrese valor a insertar: ";
                cin>>numero;
                avl->agregar(numero);
                break;
            case 2:
                if (avl->getRaiz() == NULL) {
                    cout << "Arbol vacio." << endl;

                } else {
                    cout << "Arbol AVL balanceado: " << endl;
                    avl->imprimir(0);
                }
                break;
            case 3:
                cout << "Imprimiendo InOrden:" << endl;
                avl->imprimir(1);
                cout << endl;
                break;
            case 4:
                cout << "Imprimiendo Preorden: " << endl;
                avl->imprimir(2);
                cout << endl;
                break;
            case 5:
                cout << "Imprimiendo Postorden: " << endl;
                avl->imprimir(3);
                cout << endl;
                break;
            case 6:
                cout << "ingrese valor a eliminar: ";
                cin>>numero;
                avl->eliminar(numero);
                break;
            case 7:
                salir = false;
                break;
            default:
                cout << "Opcion no valida" << endl;
        }
    }

}

int Opciones() {
    int eleccion;
    cout << "\n---------------------" << endl;
    cout << "Opciones de prueba arbol AVL:" << endl;
    cout << "\n---------------------" << endl;
    cout << "1.Insertar" << endl;
    cout << "2.mostrar" << endl;
    cout << "3.InOrden" << endl;
    cout << "4.PreOrden" << endl;
    cout << "5.PostOrden" << endl;
    cout << "6.eliminar" << endl;
    cout << "7.salir" << endl;
    cout << "eleccion: ";
    cin>>eleccion;
    return eleccion;
}
