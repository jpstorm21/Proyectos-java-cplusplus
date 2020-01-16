/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   LinkedList.h
 * Author: Juan Pablo Martinez
 *
 * Created on 5 de junio de 2018, 19:14
 */

#ifndef LINKEDLIST_H
#define LINKEDLIST_H

#include "NodoLinked.h"


class LinkedList {
public:
    LinkedList();
    NodoLinked *getFirst();
    NodoLinked *getLast();
    void setFirst(NodoLinked*);
    void setLast(NodoLinked*);
    void ingresar(int dato);
    int buscar(int dato);
    void imprimir();
    void allDelete();
    virtual ~LinkedList();
private:
    NodoLinked *first;
    NodoLinked *last;
};

#endif /* LINKEDLIST_H */

