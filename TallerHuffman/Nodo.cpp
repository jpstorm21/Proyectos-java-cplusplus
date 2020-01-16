

#include "Nodo.h"
#include <cstdlib>
Nodo::Nodo(string palabra) {
    this->palabra=palabra;
    this->siguiente=NULL;
}


string Nodo::getPalabra() {
    return this->palabra;
}

Nodo* Nodo::getSiguiente() {
    return this->siguiente;
}

void Nodo::setPalabra(string palabra) {
    this->palabra=palabra;
}

void Nodo::setSiguiente(Nodo* siguiente) {
    this->siguiente=siguiente;
}


Nodo::~Nodo() {
}

