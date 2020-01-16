/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   LinkedList.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 25 de septiembre de 2018, 19:41
 */

#include "LinkedList.h"
#include <cstdlib>
#include <iostream>

using namespace std;

LinkedList::LinkedList() {
    this->first = NULL;
    this->last = NULL;
}

Nodo* LinkedList::getFirst() {
    return first;
}

void LinkedList::setFirst(Nodo* first) {
    this->first = first;
}

Nodo* LinkedList::getLast() {
    return last;
}

void LinkedList::setLast(Nodo* last) {
    this->last = last;
}

void LinkedList::ingresar(int dato) {
    Nodo *nuevo = new Nodo(dato);
    if (first == NULL) {
        first = nuevo;
        last = nuevo;
    } else {
        nuevo->setNext(first);
        first->setPrev(nuevo);
        first = nuevo;
    }
}

int LinkedList::buscar(int dato) {
    Nodo *actual = first;
    while (actual != NULL && actual->getDato() != dato) {
        actual = actual->getNext();
    }
    if (actual != NULL) {
        return actual->getDato();
    } else {
        return NULL;
    }
}

bool LinkedList::eliminar(int dato) {
    Nodo *actual = first;
    Nodo *aux = NULL;
    while (actual != NULL && actual->getDato() != dato) {
        actual = actual->getNext();
    }
    if (actual != NULL) {
        if (actual == first) {
            aux = first;
            first = first->getNext();
            first->setPrev(NULL);
        } else if (actual == last) {
            aux = last;
            last = last->getPrev();
            last->setNext(NULL);
        } else {
            aux = actual;
            actual->getNext()->setPrev(actual->getPrev());
            actual->getPrev()->setNext(actual->getNext());
        }
        delete aux;
        return true;
    } else {
        return false;
    }
}

void LinkedList::imprimir() {
    Nodo *actual = first;
    while (actual != NULL) {
        if (actual == first) {
            cout << actual->getDato();
        } else {
            cout << "-" << actual->getDato();
        }
        actual = actual->getNext();
    }
    cout << endl;
}

LinkedList::~LinkedList() {
}

