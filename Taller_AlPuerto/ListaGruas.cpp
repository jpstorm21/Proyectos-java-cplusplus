/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaGruas.cpp
 * Author: ASUS
 * 
 * Created on 13 de febrero de 2018, 16:52
 */

#include "ListaGruas.h"
#include <cstdlib>
ListaGruas::ListaGruas() {
    this->first = NULL;
    this->last = NULL;
}

ListaGruas::ListaGruas(const ListaGruas& orig) {
}

NodoGrua* ListaGruas::getFirst() {
    return this->first;
}

NodoGrua* ListaGruas::getLast() {
    return this->last;
}

void ListaGruas::setFirst(NodoGrua* first) {
    this->first=first;
}

void ListaGruas::setLast(NodoGrua*) {
    this->last=last;
}

void ListaGruas::ingresarGrua(Grua* grua) {
    NodoGrua *nuevo =  new NodoGrua(grua);
    if(first == NULL){
        first = nuevo;
        last = nuevo;
    }else{
        first->setPrev(nuevo);
        nuevo->setNext(first);
        first = nuevo;
    }
}

Grua* ListaGruas::buscarGrua(string codigo) {
    NodoGrua *actual = first;
    while(actual != NULL && actual->getGrua()->getCodigo() != codigo){
        actual = actual->getNext();
    }
    if(actual != NULL){
        return actual->getGrua();
    }else{
        return NULL;
    }
}

bool ListaGruas::eliminarGrua(string codigo) {
    NodoGrua *actual = first;
    while(actual != NULL && actual->getGrua()->getCodigo() != codigo){
        actual = actual->getNext();
    }
    if(actual != NULL){
        if(actual == first){
            first = first->getNext();
        }else{
            actual->getPrev()->setNext(actual->getNext());
        }
        if(actual == last){
            last= last->getPrev();
        }else{
            actual->getNext()->setPrev(actual->getPrev());
        }
        delete actual;
        return true;
    }else{
        return false;
    }
}


ListaGruas::~ListaGruas() {
}

