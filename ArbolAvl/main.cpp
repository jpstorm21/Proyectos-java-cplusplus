/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Usuario
 *
 * Created on 27 de noviembre de 2017, 1:34
 */

#include <cstdlib>
#include <iostream>
#include "Arbol_AVL.h"
#include "Nodo.h"
using namespace std;

void menu(Arbol_AVL<int> *Avl) {
    int opcion = 0;
    while (opcion != 4) {
        cout << "----------------------------------------------------------" << endl;
        cout << "\t[MENU]" << endl;
        cout << "[1] Ingresar" << endl;;
        cout << "[2] Eliminar" << endl;
        cout << "[3] imprimir" << endl;
        cout << "[4] salir" << endl;
        cout << " > ";
        cin>> opcion;

        switch (opcion) {
            case 1:
                cout << "----------------------------------------------------------" << endl;
                int dato;
                cout<<"ingrese dato: ";
                cin>>dato;
                Avl->agregar(dato);
                cout<<"dato ingresado"<<endl;
                break;
            case 2:
                cout << "----------------------------------------------------------" << endl;
                int dato2;
                cout<<"ingrese dato: ";
                cin>>dato2;
                Avl->eliminar(dato2);             
                break;
            case 3:
                cout << "----------------------------------------------------------" << endl;
                cout << "------Arbol------" << endl;
                Avl->imprimir(0);
                cout<<endl;
                break;
            default:
                system("pause");
        }
    }
}
int main() {
    Arbol_AVL<int> *Avl = new Arbol_AVL<int>();
    menu(Avl);
    return 0;
}

