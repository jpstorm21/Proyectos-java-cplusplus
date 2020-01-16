/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaJuegos.cpp
 * Author: Casa
 * 
 * Created on 27 de abril de 2018, 13:52
 */

#include "ListaJuegos.h"
#include <cstdlib>
#include <string.h>
#include <iostream>
using namespace std;

ListaJuegos::ListaJuegos() {
    this->first=NULL;
    this->last=NULL;
}

NodoJuego* ListaJuegos::getFirst() {
    return first;
}

NodoJuego* ListaJuegos::getLast() {
    return last;
}

void ListaJuegos::setFirst(NodoJuego*first) {
    this->first=first;
}

void ListaJuegos::setLast(NodoJuego*last) {
    this->last=last;
}

void ListaJuegos::ingresarJuego(Juego* J) {
    NodoJuego *nuevo = new NodoJuego(J);
    if(first==NULL) {
        first=nuevo;
        last=nuevo;
    }else{
        nuevo->setNext(first);
        first->setPrev(nuevo);
        nuevo->setPrev(NULL);
        first=nuevo;
    }

}

Juego* ListaJuegos::buscarJuego(string codigo) {
    NodoJuego *current = first;
    while(current != NULL && current->getJuego()->getCodigo()!= codigo){
        current = current->getNext();
    }   
    if(current != NULL) {
        return current->getJuego();
    }else{
        return NULL;
    }

}

bool ListaJuegos::eliminarJuego(string codigo) {
    NodoJuego *current = first;
    while(current!= NULL && current->getJuego()->getCodigo() != codigo) {
        current = current->getPrev();
    }
    if(current != NULL){
        if(current == first) {
            NodoJuego *eliminado = first;
            first = first->getNext();
            delete eliminado;
        }else{
            current->getPrev()->setNext(current->getNext());
        }
        if(current == last) {
            NodoJuego *eliminado = last;
            last = last->getPrev();
            delete eliminado;
        }else{
            current->getNext()->setPrev(current->getPrev());
        }
        return true;
    }else{
        return false;
    }
}



ListaJuegos::~ListaJuegos() {
}

