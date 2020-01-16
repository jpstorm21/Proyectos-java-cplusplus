/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaVentas.cpp
 * Author: Casa
 * 
 * Created on 27 de abril de 2018, 17:36
 */

#include "ListaVentas.h"
#include <cstdlib>
#include <string.h>
#include <iostream>
using namespace std;
ListaVentas::ListaVentas() {
    this->first=NULL;
    this->last=NULL;
}

NodoVenta* ListaVentas::getFirst() {
    return first;
}

NodoVenta* ListaVentas::getLast() {
    return last;
}

void ListaVentas::setFirst(NodoVenta*) {
    this->first=first;
}

void ListaVentas::setLast(NodoVenta*) {
    this->last=last;
}

void ListaVentas::ingresarVenta(Venta* V) {
    NodoVenta *nuevo = new NodoVenta(V);
    if(first==NULL) {
        first=nuevo;
        last=nuevo;
    }else{
        nuevo->setNext(first);
        first->setPrev(nuevo);
        nuevo->setPrev(NULL);
        first=nuevo;
    }
}

ListaVentas::~ListaVentas() {
}

