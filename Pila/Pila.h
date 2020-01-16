/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Pila.h
 * Author: Usuario
 *
 * Created on 10 de mayo de 2017, 21:41
 */

#ifndef PILA_H
#define PILA_H
#include "Nodo.h"
class Pila {
public:
    Pila();
    void push(int);
    int pop();
    void imprimir();
    bool pilaVacia();
    int size();
    void destructor();
    virtual ~Pila();
private:
    Nodo *inicio;
    Nodo *cola;
};

#endif /* PILA_H */

