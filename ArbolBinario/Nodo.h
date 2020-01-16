/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Usuario
 *
 * Created on 24 de septiembre de 2017, 17:53
 */

#ifndef NODO_H
#define NODO_H

class Nodo {
public:
    Nodo();
    Nodo(int dato);
    int getDato();
    Nodo *getDer();
    Nodo *getIzq();
    void setDer(Nodo *);
    void setIzq(Nodo *);
    virtual ~Nodo();
private:
    Nodo *izq;
    Nodo *der;
    int dato;

};

#endif /* NODO_H */

