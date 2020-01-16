/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Pila.cpp
 * Author: Usuario
 * 
 * Created on 10 de mayo de 2017, 21:41
 */

#include "Pila.h"
#include "Nodo.h"
#include <iostream>
#include <iosfwd>
using namespace std;

Pila::Pila() {
    this->inicio = NULL;
    this->cola = NULL;
}

void Pila::push(int dato) {
    Nodo *nuevo = new Nodo(dato);
    if (inicio == NULL) {
        inicio = nuevo;
        cola = nuevo;
    } else {
        cola->setNext(nuevo);
        cola = nuevo;
    }
}

bool Pila::pilaVacia() {
    if (this->inicio == NULL) {
        return true;
    } else {
        return false;
    }
}

int Pila::pop() {
    if (inicio == NULL) { // cero elementos
        cout << "pila vacia" << endl;
    } else if (inicio == cola) { // 1 elemento
        inicio = NULL;
        cola = NULL;
    } else { // 2 o mas elementos
        Nodo *prev = inicio;
        Nodo *actual = inicio;
        while (actual != cola) {
            prev = actual;
            actual = actual->getNext();
        }
        prev->setNext(NULL);
        delete actual;
        cola = prev;
    }
}

int Pila::size() {
    int cant = 0;
    Nodo* actual = inicio;
    while (actual != NULL) {
        cant++;
        actual = actual->getNext();
    }
    return cant;
}

void Pila::destructor() {
    Nodo* actual = inicio;
    while (actual != NULL) {
        Nodo *aux = actual;
        inicio = inicio->getNext();
        actual = actual->getNext();
        delete aux;
    }
}

void Pila::imprimir() {
    Nodo *actual = inicio;
    int i = 1;
    if (actual != NULL) {
        while (actual != cola) {
            cout << i << "-" << actual->getDato() << endl;
            i++;
            actual = actual->getNext();
        }
        cout << i << "-" << actual->getDato() << endl;
    } else {
        cout << "pila vacia" << endl;
    }
}

Pila::~Pila() {
}

