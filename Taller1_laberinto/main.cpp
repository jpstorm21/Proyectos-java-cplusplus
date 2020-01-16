/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Juan Pablo Martinez
 *
 * Created on 17 de abril de 2019, 0:10
 */

#include <cstdlib>
#include <iostream>
#include "ListaEnlazada.h"
#include "Laberinto.h"
#include <fstream>
#include<stdlib.h>
#include <string> 

using namespace std;

/*
 * 
 */
 int fila = 0;
 int col = 0;

void obtenerfilas(){
    ifstream matriz("laberinto.txt");
    int cant= 0;
    string c;
    while(!matriz.eof()){
        getline(matriz,c,'\n');
        cant++;
    }
    fila = cant;
    col = cant;
    matriz.close(); 
}

void cargarTablero(int tablero[10][10]){//Lectura de txt   
    ifstream matriz2("laberinto.txt");
    int valor;
    for(int i = 0; i < fila; i++){
        for(int j = 0; j < col; j++){
            matriz2>>valor;
            tablero[i][j] = valor;
        }
    }
    matriz2.close();
}

int main() {
    obtenerfilas();
    int tablero[10][10];

    cargarTablero(tablero);
    Laberinto *l = new Laberinto();
    l->setTablero(tablero);
    cout<<"Tablero Inicial: "<<endl;
    cout << "-----------------------------------------------------" << endl;
    l->imprimir();
    
    int resuelto  = l->resolve(l->getInicio()->getPosX(),l->getInicio()->getPosY());
    cout<<endl;
    //l->imprimir();
    l->imprimirSolucion();
    return 0;
}

