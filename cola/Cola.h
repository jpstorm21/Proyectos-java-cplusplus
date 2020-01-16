/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Cola.h
 * Author: Usuario
 *
 * Created on 25 de julio de 2017, 13:03
 */

#ifndef COLA_H
#define COLA_H
#include "Nodo.h"
class Cola {
public:

    Cola();
    void push(int dato);
    void pop();
    bool isEmpty();
    void imprimir();
    void destructor();
    int size();
    virtual ~Cola();
private:
    Nodo *frent;
    Nodo *last;
};

#endif /* COLA_H */

