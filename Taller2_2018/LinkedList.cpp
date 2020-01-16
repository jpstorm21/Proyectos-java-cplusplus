/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   LinkedList.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 5 de junio de 2018, 19:14
 */

#include "LinkedList.h"
#include <cstdlib>
#include <iostream>

using namespace std;

LinkedList::LinkedList() {
    this->first = NULL;
    this->last = NULL;
}

NodoLinked* LinkedList::getFirst() {
    return first;
}

NodoLinked* LinkedList::getLast() {
    return last;
}

void LinkedList::setFirst(NodoLinked *first) {
    this->first = first;
}

void LinkedList::setLast(NodoLinked *last) {
    this->last = last;
}

void LinkedList::ingresar(int dato) {
    NodoLinked *nuevo = new NodoLinked(dato);
    if (first == NULL) {
        first = nuevo;
        last = nuevo;
    } else {
        nuevo->setNext(first);
        first->setPrev(nuevo);
        nuevo->setPrev(NULL);
        first = nuevo;
    }
}

int LinkedList::buscar(int dato) {
    NodoLinked *actual = first;
    while (actual != NULL && actual->getDato() != dato) {
        actual = actual->getNext();
    }
    if (actual != NULL) {
        return actual->getDato();
    } else {
        return NULL;
    }
}

void LinkedList::imprimir() {
    NodoLinked *actual = first;
    if (actual != NULL) {
        while (actual != NULL) {
            cout << "dato: " << actual->getDato() << endl;
            actual = actual->getNext();
        }
    } else {
        cout<<"linkedList sin datos"<<endl;
    }

}

void LinkedList::allDelete() {
    first = NULL;
    last = NULL;
}

LinkedList::~LinkedList() {
}

