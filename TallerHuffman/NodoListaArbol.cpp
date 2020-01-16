

#include "NodoListaArbol.h"
#include <cstdlib>
NodoListaArbol::NodoListaArbol(Arbol *valor) {
    this->setArbol(valor);
    this->setSeguiente(NULL);
}

Arbol* NodoListaArbol::getArbol() {
    return this->arbol;
}

void NodoListaArbol::setArbol(Arbol* arbol) {
    this->arbol=arbol;
}

NodoListaArbol* NodoListaArbol::getSiguiente() {
    return this->siguiente;
}

void NodoListaArbol::setSeguiente(NodoListaArbol* siguiente) {
    this->siguiente=siguiente;
}


NodoListaArbol::~NodoListaArbol() {
}

