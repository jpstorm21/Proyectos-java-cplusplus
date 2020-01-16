/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoMatriz.h
 * Author: Usuario
 *
 * Created on 8 de mayo de 2017, 21:00
 */

#ifndef NODOMATRIZ_H
#define NODOMATRIZ_H

class NodoMatriz {
public:
    NodoMatriz();
    NodoMatriz(int dato, int fila, int columna);
    NodoMatriz *getNodoAbajo();
    NodoMatriz *getNodoDerecho();
    int getDato();
    int getFila();
    int getColumna();
    void setNodoAbajo(NodoMatriz *nodoAbajo);
    void setNodoDerecho(NodoMatriz *nodoDerecho);
    void setDato(int dato);
    void setFila(int fila);
    void setColumna(int columna);
    virtual ~NodoMatriz();
private:
    NodoMatriz *nodoAbajo;
    NodoMatriz *nodoDerecho;
    int dato;
    int fila;
    int columna;    
};

#endif /* NODOMATRIZ_H */

