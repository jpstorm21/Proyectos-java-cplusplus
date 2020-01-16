/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Usuario
 *
 * Created on 24 de septiembre de 2017, 17:53
 */

#include <cstdlib>
#include <iostream>
#include "ABinario.h"

using namespace std;

void menu(ABinario *AB) {
    int opcion = 0;
    while (opcion != 3) {
        cout << "----------------------------------------------------------" << endl;
        cout << "\t[MENU]" << endl;
        cout << "[1] INGRESAR" << endl;
        cout << "[2] BUSCAR" << endl;
        cout << "[3] SALIR" << endl;
        cout << " > ";
        cin>> opcion;

        switch (opcion) {
            case 1:
                cout << "----------------------------------------------------------" << endl;
                int dato;
                cout<<"ingrese dato: ";
                cin>>dato;
                int eleccion;
                cout<<"ingrese [1] si desea ingresar iterativamente o [2] si desea recursivamente: ";
                cin>>eleccion;
                if(eleccion == 1){
                    AB->ingresarIterativo(dato);
                }else{
                    AB->ingresarR(dato);
                }
                cout<<"dato ingresado"<<endl;
                break;
            case 2:
                cout << "----------------------------------------------------------" << endl;
                int dato2;
                cout<<"ingrese dato a buscar : ";
                cin>>dato2;
                AB->buscar(dato2);
                break;
            default:
                system("pause");
        }
    }
}
int main(int argc, char** argv) {
    ABinario *AB = new ABinario();
    menu(AB);
    return 0;
}

