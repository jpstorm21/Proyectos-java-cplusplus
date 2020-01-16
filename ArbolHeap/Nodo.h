#ifndef NODO_H
#define NODO_H

#include <cstdlib>

class Nodo {
private:
    int dato;
    Nodo* izquierdo;
    Nodo* derecho;
public:

    Nodo(int info) {
        dato = info;
        izquierdo = NULL;
        derecho = NULL;
    }

    void setIzquierdo(Nodo* nodo) {
        izquierdo = nodo;
    }

    void setDerecho(Nodo* nodo) {
        derecho = nodo;
    }

    void setDato(int value) {
        dato = value;
    }

    int getDato() {
        return dato;
    }

    Nodo* getIzquierdo() {
        return izquierdo;
    }

    Nodo* getDerecho() {
        return derecho;
    }
};

#endif /* NODO_H */