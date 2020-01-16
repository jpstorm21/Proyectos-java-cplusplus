/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Nicolas
 *
 * Created on 11 de mayo de 2017, 18:26
 */

#ifndef NODO_H
#define NODO_H
class Nodo {
public:
    Nodo(int dato,int fila,int columna);
    Nodo(int fila,int columna);
    virtual ~Nodo();
    
    Nodo *getNext();
    Nodo *getAbajo();
    int getDato();
    int getFila();
    int getColumna();
    
    void setNext(Nodo* n);
    void setAbajo(Nodo* n);
    void setDato(int d);
    void setFila(int f);
    void setColumna(int c);
private:
    int dato;
    int fila;
    int columna;
    Nodo* next;
    Nodo* abajo;

};

#endif /* NODO_H */

