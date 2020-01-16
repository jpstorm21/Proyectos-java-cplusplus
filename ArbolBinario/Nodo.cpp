/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.cpp
 * Author: Usuario
 * 
 * Created on 24 de septiembre de 2017, 17:53
 */

#include "Nodo.h"
#include <iosfwd>

Nodo::Nodo() {
}

Nodo::Nodo(int dato) {
    this->dato = dato;
    this->der = NULL;
    this->izq = NULL;
}

int Nodo::getDato() {
    return dato;
}

Nodo* Nodo::getDer() {
    return der;
}

Nodo* Nodo::getIzq() {
    return izq;
}

void Nodo::setDer(Nodo *der) {
    this->der = der;
}

void Nodo::setIzq(Nodo *izq) {
    this->izq = izq;
}

Nodo::~Nodo() {
}

