/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   LinkedList.cpp
 * Author: Victor Huerta
 * 
 * Created on 25 de septiembre de 2018, 19:41
 */

#include "LinkedList.h"
#include <cstdlib>
#include <iostream>

using namespace std;

LinkedList::LinkedList() {
    this->first= NULL;
    this->last = NULL;
}

Nodo* LinkedList::getFirst() {
    return first;

}

void LinkedList::setFirst(Nodo* first) {
    this->first=first;

}

Nodo* LinkedList::getLast() {
    return last;

}

void LinkedList::setLast(Nodo* last) {
    this->last=last;

}

void LinkedList::ingresarDato(int dato) {
    Nodo *nuevo = new Nodo(dato);
    if(first==NULL){
        first = nuevo;
        last = nuevo;
    }else{
        nuevo->setNext(first);
        first->setPrev(nuevo);
        first = nuevo;
    }

}

int LinkedList::buscarDato(int dato) {
    Nodo *current = first;
    while(current != NULL && current->getdato() != dato){
        current = current->getNext();
    }
    if(current != NULL) {
        return current->getdato();
    }else{
        return NULL;
    }

}

bool LinkedList::eliminarDato(int dato) {
    Nodo *actual = first;
    Nodo *aux = NULL;
    while (actual != NULL && actual->getdato() != dato) {
        actual = actual->getNext();
    }
    if (actual != NULL) {
        if(actual == first){
            aux = first;
            first = first->getNext();
        }else{
            aux = actual;
            actual->getNext()->setPrev(actual->getPrev());
        }
        if(actual == last){
            aux = last;
            last =last->getPrev();
        }else{
            actual->getPrev()->setNext(actual->getNext());
        }
        delete aux;
        return true;
    }else{
        return false;
    }
}
void LinkedList::imprimir() {
    Nodo *current = first;
    while(current != NULL){
        if(current == first){
            cout<<current->getdato();
        }else{
             cout<<"="<<current->getdato();
        }
        current = current->getNext();
    }
    cout<<endl;

}

LinkedList::~LinkedList() {
}

