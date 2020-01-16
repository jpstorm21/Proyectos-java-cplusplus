/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoCliente.h
 * Author: Juan Pablo Martinez
 *
 * Created on 18 de septiembre de 2019, 16:46
 */

#ifndef NODOCLIENTE_H
#define NODOCLIENTE_H
#include "Cliente.h"
class NodoCliente {
public:
    NodoCliente(Cliente *cliente);
    Cliente *getCliente();
    NodoCliente *getNext();
    NodoCliente *getPrev();
    void setCliente(Cliente *cliente);
    void setPrev (NodoCliente *prev);
    void setNext(NodoCliente *next);
    virtual ~NodoCliente();
private:
    Cliente *cliente;
    NodoCliente *next;
    NodoCliente *prev;
};

#endif /* NODOCLIENTE_H */

