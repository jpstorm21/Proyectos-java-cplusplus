/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaClientes.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 18 de septiembre de 2019, 17:58
 */

#include "ListaClientes.h"

ListaClientes::ListaClientes() {
    this->first = nullptr;
    this->last = nullptr;
}

NodoCliente* ListaClientes::getFirst() {
    return this->first;
}

NodoCliente* ListaClientes::getLast() {
    return this->last;
}

void ListaClientes::setFirst(NodoCliente* first) {
    this->first = first;
}

void ListaClientes::setLast(NodoCliente* last) {
    this->last = last;
}

void ListaClientes::ingresarCliente(Cliente* c) {
    NodoCliente *nuevo = new NodoCliente(c);
    if (first == nullptr) {
        first = nuevo;
        last = nuevo;
    } else {
        nuevo->setNext(first);
        first->setPrev(nuevo);
        first = nuevo;
    }
}

Cliente* ListaClientes::buscarCliente(string nombre) {
    NodoCliente *actual = first;
    Cliente *buscado = nullptr;
    while(actual != nullptr){
        if(actual->getCliente()->getNombre() == nombre){
            buscado= actual->getCliente();
            break;
        }
        actual=actual->getNext();
    }
    return buscado;
}

bool ListaClientes::eliminarCliente(string nombre) {
    NodoCliente *actual = first;
    while(actual != nullptr && actual->getCliente()->getNombre() != nombre){
        actual = actual->getNext();
    }
    NodoCliente *aux = nullptr;
    if(actual != nullptr){
        if(actual == first){
            aux = first;
            first = first->getNext();
        }else if(actual == last){
            aux = last;
            last = last->getPrev();
        }else{
            aux = actual;
            actual->getNext()->setPrev(actual->getPrev());
            actual->getPrev()->setNext(actual->getNext());
        }
        delete aux;
        return true;
    }else{
        return false;
    }
}


ListaClientes::~ListaClientes() {
}

