/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Usuario
 *
 * Created on 17 de mayo de 2017, 16:25
 */

#ifndef NODO_H
#define NODO_H

class Nodo {
public:
    
    Nodo(int dato, int fila,int columna);
    int getDato();
    int getFila();
    int getColuma();
    Nodo *getNext();
    Nodo *getDown();
    void setDato(int dato);
    void setNext(Nodo *);
    void setDown(Nodo *);
    virtual ~Nodo();
private:
    int dato;
    Nodo *next;
    Nodo *down;
    int fila;
    int columna;

};

#endif /* NODO_H */

