/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.cpp
 * Author: Usuario
 * 
 * Created on 2 de junio de 2017, 0:10
 */

#include "Nodo.h"
#include <cstdlib>

Nodo::Nodo() {
}

Nodo::Nodo(int dato) {
    this->dato = dato;
    this->hijoDerech = NULL;
    this->hijoIzqu = NULL;
}

int Nodo::getDato() {
    return this->dato;
}

Nodo* Nodo::getHijoDerech() {
    return this->hijoDerech;
}

Nodo* Nodo::getHijoIzqui() {
    return this->hijoIzqu;
}

void Nodo::setDato(int dato) {
    this->dato = dato;
}

void Nodo::setHijoDerech(Nodo *hijoDerech) {
    this->hijoDerech = hijoDerech;
}

void Nodo::setHijoIzqui(Nodo *hijoIzqu) {
    this->hijoIzqu = hijoIzqu;
}

Nodo::~Nodo() {
}

