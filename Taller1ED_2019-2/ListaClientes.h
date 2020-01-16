/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaClientes.h
 * Author: Juan Pablo Martinez
 *
 * Created on 18 de septiembre de 2019, 17:58
 */

#ifndef LISTACLIENTES_H
#define LISTACLIENTES_H
#include "NodoCliente.h"
class ListaClientes {
public:
    ListaClientes();
    NodoCliente *getFirst();
    NodoCliente *getLast();
    void setFirst(NodoCliente *first);
    void setLast(NodoCliente *last);
    void ingresarCliente(Cliente *c);
    Cliente *buscarCliente(string nombre);
    bool eliminarCliente(string nombre);
    virtual ~ListaClientes();
private:
    NodoCliente *first;
    NodoCliente *last;
};

#endif /* LISTACLIENTES_H */

