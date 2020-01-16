/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoCliente.h
 * Author: Casa
 *
 * Created on 27 de abril de 2018, 13:34
 */

#ifndef NODOCLIENTE_H
#define NODOCLIENTE_H
#include "Cliente.h"
#include <string.h>
#include <iostream>
using namespace std;
class NodoCliente {
public:
    NodoCliente();
    NodoCliente(Cliente *cliente);
    Cliente *getCliente();
    NodoCliente *getNext();
    NodoCliente *getPrev();
    void setCliente(Cliente *);
    void setNext(NodoCliente *);
    void setPrev(NodoCliente *);
    virtual ~NodoCliente();
private:
    Cliente *cliente;
    NodoCliente *next;
    NodoCliente *prev;

};

#endif /* NODOCLIENTE_H */

