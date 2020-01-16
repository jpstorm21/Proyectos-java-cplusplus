#include "Cola.h"
#include <cstdlib>
#include <iostream>
using namespace std;

Cola::Cola() {
    this->first = NULL;
    this->last = NULL;
}

Nodo* Cola::getFirst() {
    return this->first;
}

Nodo* Cola::getLast() {
    return this->last;
}

void Cola::setFirst(Nodo *first) {
    this->first = first;
}

void Cola::setLast(Nodo *last) {
    this->last = last;
}

void Cola::ingresar(int dato, int prioridad) {
    Nodo *nuevo = new Nodo(dato, prioridad);
    if (first == NULL) {
        first = nuevo;
        last = nuevo;
    } else {
        if (first == last) {
            if (last->getPrioridad() < prioridad) {
                last->setNext(nuevo);
                nuevo->setPrev(last);
                first = nuevo;
            } else {
                last->setPrev(nuevo);
                nuevo->setNext(last);
                last = nuevo;
            }
        } else {
            Nodo *actual = last;
            while (actual != NULL && actual->getPrioridad() < prioridad) {
                actual = actual->getNext();
            }
            if (actual != NULL) {
                Nodo *aux = actual->getPrev();
                actual->getPrev()->setNext(nuevo);
                nuevo->setPrev(aux);
                nuevo->setNext(actual);
                actual->setPrev(nuevo);
            } else {
                first->setNext(nuevo);
                nuevo->setPrev(first);
                first = nuevo;
            }
        }
    }
}

bool Cola::eliminar() {
    if (first == NULL) {
        return false;
    } else {
        if (first == last) {
            first = NULL;
            last = NULL;
        } else {
            Nodo *aux = first->getPrev();
            first->getPrev()->setNext(NULL);
            delete first;
            first = aux;
        }
        return true;
    }
}

void Cola::imprimir() {
    Nodo *actual = last;
    if (actual == NULL) {
        cout << "no hay datos" << endl;
    } else {
        while (actual != NULL) {
            cout << actual->getDato() << endl;
            actual = actual->getNext();
        }
    }
}
