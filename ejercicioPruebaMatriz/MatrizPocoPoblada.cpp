/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   MatrizPocoPoblada.cpp
 * Author: Usuario
 * 
 * Created on 8 de mayo de 2017, 21:08
 */
#include <iostream>
#include "MatrizPocoPoblada.h"
#include "NodoMatriz.h"
#include <cstddef>
using namespace std;

MatrizPocoPoblada::MatrizPocoPoblada() {
    this->cantDatos =0;
}

NodoMatriz* MatrizPocoPoblada::getCabezalColumna() {
    return this->cabezalColumna;
}

NodoMatriz* MatrizPocoPoblada::getCabezalFila() {
    return this->cabezalFila;
}

void MatrizPocoPoblada::setCabezalColumna(NodoMatriz*) {
    this->cabezalColumna = cabezalColumna;
}

void MatrizPocoPoblada::setCabezalFila(NodoMatriz*) {
   this->cabezalFila = cabezalFila;
}

void MatrizPocoPoblada::crearCabezales() {
    NodoMatriz *cabezalFila1 = new NodoMatriz(-1, 0, -1);
    this->cabezalFila = cabezalFila1;
    NodoMatriz *cabezalColumna2 = new NodoMatriz(-1, -1, 0);
    this->cabezalColumna = cabezalColumna2;
    cabezalFila1 = this->cabezalFila;
    cabezalColumna2 = this->cabezalColumna;
    int i = 1;
    while (i < 4) {
        NodoMatriz *actualFila = new NodoMatriz(-1, i, -1);
        NodoMatriz *actualColumna = new NodoMatriz(-1, -1, i);
        cabezalFila1->setNodoAbajo(actualFila);
        cabezalColumna2->setNodoDerecho(actualColumna);
        cabezalFila1 = cabezalFila1->getNodoAbajo();
        cabezalColumna2 = cabezalColumna2->getNodoDerecho();
        i++;
    }
    cabezalFila1->setNodoAbajo(this->cabezalFila);
    cabezalColumna2->setNodoDerecho(this->cabezalColumna);
}

void MatrizPocoPoblada::rellenarDiagonal(int n) {

    NodoMatriz *currentFila = this->cabezalFila;
    NodoMatriz *currentColumna = this->cabezalColumna;
    while (currentColumna->getNodoDerecho() != this->cabezalColumna) {
        NodoMatriz *nuevo = new NodoMatriz(n, currentFila->getFila(), currentColumna->getColumna());
        currentFila->setNodoDerecho(nuevo);
        currentColumna->setNodoAbajo(nuevo);
        nuevo->setNodoAbajo(currentColumna);
        nuevo->setNodoDerecho(currentFila);
        currentFila = currentFila->getNodoAbajo();
        currentColumna = currentColumna->getNodoDerecho();
    }
    NodoMatriz *nuevo = new NodoMatriz(n, currentFila->getFila(), currentColumna->getColumna());
    currentFila->setNodoDerecho(nuevo);
    currentColumna->setNodoAbajo(nuevo);
    nuevo->setNodoAbajo(currentColumna);
    nuevo->setNodoDerecho(currentFila);
    currentFila = currentFila->getNodoAbajo();
    currentColumna = currentColumna->getNodoDerecho();
}

void MatrizPocoPoblada::imprimirDatos() {
    NodoMatriz* actual1 = this->cabezalFila;
    do{
        NodoMatriz *actual = actual1;
        do{
            if(actual->getNodoDerecho()->getColumna() != -1){
            cout<<"["<<actual->getNodoDerecho()->getFila()<<"]"<<"["<<actual->getNodoDerecho()->getColumna()<<"]="<<actual->getNodoDerecho()->getDato()<<endl;
            }
            actual = actual->getNodoDerecho();
        }while(actual != actual1);
        actual1 = actual1->getNodoAbajo();
    }while(actual1 != this->cabezalFila);
}


NodoMatriz *MatrizPocoPoblada::buscarCabezalFila(int fila) {
    NodoMatriz *actual = this->cabezalFila;
    while (actual->getNodoAbajo() != this->cabezalFila && actual->getFila() != fila) {
        actual = actual->getNodoAbajo();
    }
    if (actual->getFila() == fila) {
        return actual;
    } else {
        return NULL;
    }
}

NodoMatriz* MatrizPocoPoblada::buscarCabezalColumna(int columna) {
    NodoMatriz *actual = this->cabezalColumna;
    while (actual->getNodoAbajo() != this->cabezalColumna && actual->getColumna() != columna) {
        actual = actual->getNodoAbajo();
    }
    if (actual->getColumna() == columna) {
        return actual;
    } else {
        return NULL;
    }
    
}




MatrizPocoPoblada::~MatrizPocoPoblada() {
}

