/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Cola.cpp
 * Author: Usuario
 * 
 * Created on 25 de julio de 2017, 13:03
 */

#include "Cola.h"
#include "Nodo.h"
#include <iosfwd>
#include <iostream>
using namespace std;

Cola::Cola() {
    this->frent = NULL;
    this->last = NULL;
}

bool Cola::isEmpty() {
    if (frent == NULL && last == NULL) {
        return true;
    } else {
        return false;
    }
}

void Cola::push(int dato) {
    Nodo * nuevo = new Nodo(dato);
    if (frent == NULL) {
        frent = nuevo;
        last = nuevo;
    } else {
        last->setNext(nuevo);
        last = nuevo;
    }
}

void Cola::pop() {
    if (frent == NULL) {
        cout << "cola vacia" << endl;
    } else {
        if (frent->getDato() == last->getDato()) {
            frent = NULL;
            last = NULL;
        } else {
            Nodo *aux = frent;
            frent = frent->getNext();
            delete aux;
        }
    }
}

void Cola::destructor() {
    Nodo *actual = frent;
    while (actual != NULL) {
        Nodo *aux = actual;
        frent = frent->getNext();
        actual = actual->getNext();
        delete aux;
    }
}

int Cola::size() {
    int cant = 0;
    Nodo *actual = frent;
    while (actual != NULL) {
        cant++;
        actual = actual->getNext();
    }
    return cant;
}

void Cola::imprimir() {
    Nodo *actual = frent;
    int i = 1;
    if (actual != NULL) {
        while (actual != last) {
            cout << i << "-" << actual->getDato() << endl;
            actual = actual->getNext();
            i++;
        }
        cout << i << "-" << actual->getDato() << endl;
    } else {
        cout << "cola vacia" << endl;
    }
}

Cola::~Cola() {
    Nodo *actual = frent;
    while (actual != NULL) {
        Nodo *aux = actual;
        frent = frent->getNext();
        actual = actual->getNext();
        delete aux;
    }
}

