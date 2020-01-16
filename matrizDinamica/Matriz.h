/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Matriz.h
 * Author: Nicolas
 *
 * Created on 11 de mayo de 2017, 18:41
 */

#ifndef MATRIZ_H
#define MATRIZ_H
#include "Matriz.h"
#include "Nodo.h"
#include <cstdlib>
using namespace std;
class Matriz {
public:
    Matriz();
    virtual ~Matriz();
    void insertar(int dato,int fila,int columna);
    int obtenerDato(int fila,int columna);
    
    Nodo *getFilaH();
    Nodo *getColumnaH();
    void print();
    int getMaxcolumna();
    int getMaxfila();
private:
    Nodo* filaH;
    Nodo* columnaH;
    int cant;
    int maxcolumna;
    int maxfila;
    Nodo *buscarCabezalFila(int fila);
    Nodo *buscarCabezalColumna(int columna);
    Nodo *buscarDato(int fila,int columna);
    void insertarNodoCabezalFila(Nodo* n);
    void insertarNodoCabezalColumna(Nodo* n);
    void insertarNodoEnFila(Nodo* n,Nodo* cabezalF);
    void insertarNodoEnColumna(Nodo* n,Nodo* cabezalC);
    
    

};

#endif /* MATRIZ_H */

