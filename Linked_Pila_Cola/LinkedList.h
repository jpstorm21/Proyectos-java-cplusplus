/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   LinkedList.h
 * Author: Juan Pablo Martinez
 *
 * Created on 25 de septiembre de 2018, 19:41
 */

#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include "Nodo.h"

class LinkedList {
public:
    LinkedList();
    Nodo *getFirst();
    Nodo *getLast();
    void setFirst(Nodo * first);
    void setLast(Nodo *last);
    void ingresar(int dato);
    int buscar(int dato);
    bool eliminar(int dato);
    void imprimir();
    virtual ~LinkedList();
private:
    Nodo *first;
    Nodo *last;
};

#endif /* LINKEDLIST_H */

