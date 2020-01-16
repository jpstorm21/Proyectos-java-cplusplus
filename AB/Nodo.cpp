#include "Nodo.h"
#include <cstdlib>
Nodo::Nodo() {
}

Nodo::Nodo(int dato) {
    this->dato=dato;
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
    this->dato=dato;
}

void Nodo::setHijoDerech(Nodo *hijoDerech ) {
    this->hijoDerech=hijoDerech;
}

void Nodo::setHijoIzqui(Nodo *hijoIzqu) {
    this->hijoIzqu=hijoIzqu;
}

Nodo::~Nodo() {
}

