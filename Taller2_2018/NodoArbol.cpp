/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoArbol.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 5 de junio de 2018, 20:01
 */

#include "NodoArbol.h"
#include <cstdlib>
NodoArbol::NodoArbol(int dato) {
    this->dato=dato;
    this->der =NULL;
    this->izq =NULL;
}

int NodoArbol::getDato() {
    return dato;
}

NodoArbol* NodoArbol::getDerecho() {
    return der;
}

NodoArbol* NodoArbol::getIzquierdo() {
    return izq;
}

void NodoArbol::setDato(int dato) {
    this->dato=dato;
}

void NodoArbol::setDerecho(NodoArbol *der) {
    this->der=der;
}

void NodoArbol::setIzquierdo(NodoArbol *izq) {
    this->izq=izq;
}



NodoArbol::~NodoArbol() {
}

