/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Usuario
 *
 * Created on 10 de mayo de 2017, 21:37
 */

#include <cstdlib>
#include <iostream>
#include "Pila.h"
#include "Nodo.h"
using namespace std;

void menu(Pila *p) {
    int opcion = 0;
    while (opcion != 7) {
        cout << "----------------------------------------------------------" << endl;
        cout << "\t[MENU]" << endl;
        cout << "[1] push" << endl;
        cout << "[2] pop" << endl;
        cout << "[3] pila vacia" << endl;
        cout << "[4] imprimir" << endl;
        cout << "[5] tamaño" << endl;
        cout << "[6] destruir " << endl;
        cout << "[7] salir" << endl;
        cout << " > ";
        cin>> opcion;

        switch (opcion) {
            case 1:
                cout << "----------------------------------------------------------" << endl;
                int dato;
                cout<<"ingrese dato: ";
                cin>>dato;
                p->push(dato);
                cout<<"dato ingresado"<<endl;
                break;
            case 2:
                cout << "----------------------------------------------------------" << endl;
                p->pop();
                break;
            case 3:
                cout << "----------------------------------------------------------" << endl;
                bool vacia;
                vacia = p->pilaVacia();
                if(vacia){
                    cout<<"pila vacia"<<endl;
                }else{
                    cout<<"pila tiene datos"<<endl;
                }
                break;
            case 4:
                cout << "----------------------------------------------------------" << endl;
                cout << "------datos------" << endl;
                p->imprimir();
                break;
            case 5:
                cout << "----------------------------------------------------------" << endl;              
                int cant;
                cant = p->size();
                cout<<"la cantidad de elementos es: "<< cant <<endl;
                break;
            case 6:
                cout << "----------------------------------------------------------" << endl;
                p->destructor();
                cout<<"pila destruida"<<endl;
                break;
            default:
                opcion = 7;
        }
    }
}

int main(int argc, char** argv) {
    Pila *p = new Pila();
    menu(p);
    //system("pause");
    return 0;
}

