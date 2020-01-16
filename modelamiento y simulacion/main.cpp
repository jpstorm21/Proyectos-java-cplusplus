/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Juan Pablo Martinez
 *
 * Created on 3 de septiembre de 2018, 22:53
 */

#include <cstdlib>
#include <iostream>
#include <math.h>
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    int a;
    cout << "ingrese demanda anual(a): ";
    cin >>a;
    int k;
    cout << "ingrese costo a emitir orden de compra(k): ";
    cin>>k;
    cout << "que desea ingresa h[1] o (tasa de interes(i) y costo unitario(c))[2]: ";
    int opcion;
    cin>>opcion;
    while (opcion != 1 && opcion != 2) {
        cout << "ingrese opcion valida" << endl;
        cout << "que desea ingresa h[1] o (tasa de interes(i) y costo unitario(c))[2]: ";
        cin>>opcion;
    }
    double Q;
    if (opcion == 1) {
        int h;
        cout << "ingrese costo de mantener inventario(h): ";
        cin>>h;   
        Q = sqrt((2 * a * k) / h);
    } else {
        int i;
        double c;
        cout <<"ingrese tasa de interes(i): ";
        cin>>i;
        cout <<"ingrese costo unitario(c): ";
        cin>>c;
        Q = sqrt((2 * a * k) / (c*i));
    }
    cout << "--------------------------------------" << endl;
    cout << " el valor de Q* es: " << Q << endl;
    cout << "--------------------------------------" << endl;
    system("pause");
    return 0;
}

