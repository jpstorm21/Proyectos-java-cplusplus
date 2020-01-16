/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

#include "NodoMatriz.h"


/* 
 * File:   MatrizPocoPoblada.h
 * Author: Usuario
 *
 * Created on 8 de mayo de 2017, 21:08
 */
#ifndef MATRIZPOCOPOBLADA_H
#define MATRIZPOCOPOBLADA_H

class MatrizPocoPoblada {
public:
   
    MatrizPocoPoblada();
    virtual ~MatrizPocoPoblada();
    NodoMatriz *getCabezalColumna();
    NodoMatriz *getCabezalFila();
    void setCabezalColumna(NodoMatriz *);
    void setCabezalFila(NodoMatriz *);
    void rellenarDiagonal(int n);
    void crearCabezales();
    void imprimirDatos();
    NodoMatriz *buscarCabezalFila(int fila);
    NodoMatriz *buscarCabezalColumna(int columna);
    void agregarDato(int dato,int fila,int columna);
private:
    NodoMatriz *cabezalColumna;
    NodoMatriz *cabezalFila;
    int cantDatos;
};

#endif /* MATRIZPOCOPOBLADA_H */

