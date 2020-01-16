/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   LinkedList.h
 * Author: Victor Huerta
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
    void setFirst(Nodo*first);
    Nodo *getLast();
    void setLast(Nodo*last);
    void ingresarDato(int dato);
    int buscarDato(int dato);
    bool eliminarDato(int dato);
    void imprimir();

    virtual ~LinkedList();
private:
    Nodo *first;
    Nodo *last;

};

#endif /* LINKEDLIST_H */

