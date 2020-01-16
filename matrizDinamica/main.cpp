/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Nicolas
 *
 * Created on 11 de mayo de 2017, 18:18
 */

#include <cstdlib>
#include <iostream>
#include "Matriz.h"
using namespace std;

/*
 * 
 */
void ingresar(Matriz* m);

int main(int argc, char** argv) {

    Matriz* m = new Matriz();
    /*
     m->insertar(30, 0, 1);
    m->insertar(90, 0, 5);
    m->insertar(90, 3, 6);
    m->insertar(91, 3, 0);
    m->insertar(45, 1, 9);
    m->insertar(23, 3, 1);
    m->insertar(1, 0, 0);
    m->insertar(100, 0, 3);
    m->insertar(0, 1, 0);
     */
    ingresar(m);


    return 0;
}

void ingresar(Matriz* m) {
    int f;
    int c;
    int d;
    cout << "ingresa los datos, fila=-1 para terminar" << endl;
    cout << "ingresa fila: ";
    cin>>f;
    if (f != -1) {
        cout << "ingresa columna: ";
        cin>>c;
        cout << "ingresa el numero: ";
        cin>>d;
        cout << endl;
    }
    while (f != -1) {
        m->insertar(d, f, c);
        cout << "ingresa los datos, fila=-1 para terminar" << endl;
        cout << "ingresa fila: ";
        cin>>f;
        if (f != -1) {
            cout << endl;
            cout << "ingresa columna: ";
            cin>>c;
            cout << endl;
            cout << "ingresa el numero: ";
            cin>>d;
            cout << endl;
        }

    }
}