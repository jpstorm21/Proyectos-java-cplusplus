
#include "Lista.h"
#include <cstdlib>

Lista::Lista() {
    this->inicio = NULL;
}

Nodo* Lista::getInicio() {
    return this->inicio;
}

void Lista::setInicio(Nodo* inicio) {
    this->inicio = inicio;
}

void Lista::agrear(string palabra) {
    Nodo *nuevo = new Nodo(palabra);
    if (this->inicio == NULL)
        this->setInicio(nuevo);
    else {
        nuevo->setSiguiente(inicio);
        inicio = nuevo;
    }
}


bool Lista::eliminar(string palabra) {
    Nodo* actual = inicio;
    Nodo* previo = inicio;
    while (actual != NULL && actual->getPalabra() != palabra) {
        previo = actual;
        actual = actual->getSiguiente();
    }
    if (actual != NULL) {
        if (actual == inicio) {
            inicio = inicio->getSiguiente();
        } else {
            previo->setSiguiente(actual->getSiguiente());
        }
        return true;
    } else {
        return false;
    }
}

int Lista::contarIguales(string palabra) {
    Nodo *aux = inicio;
    int contador = 0;
    while (aux != NULL) {
        if (aux->getPalabra() == palabra) {
            contador++;
            aux = aux->getSiguiente();
        } else {
            aux = aux->getSiguiente();
        }
    }
    return contador;
}

Lista::~Lista() {
}

