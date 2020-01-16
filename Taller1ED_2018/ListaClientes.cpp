
#include "ListaClientes.h"
#include <cstdlib>
#include <string.h>
#include <iostream>
using namespace std;

ListaClientes::ListaClientes() {
    this->first=NULL;
    this->last=NULL;
}

NodoCliente* ListaClientes::getFirst() {
    return first;
}

NodoCliente* ListaClientes::getLast() {
    return last;
}

void ListaClientes::setFirst(NodoCliente*) {
    this->first=first;
}

void ListaClientes::setLast(NodoCliente*) {
    this->last=last;
}

void ListaClientes::ingresarCliente(Cliente* C) {
    NodoCliente *nuevo = new NodoCliente(C);
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

Cliente *ListaClientes::buscarCliente(string rut) {
    NodoCliente *current = first;
    while(current != NULL && current->getCliente()->getRut() != rut){
        current = current->getNext();
    }   
    if(current != NULL) {
        return current->getCliente();
    }else{
        return NULL;
    }

}

bool ListaClientes::eliminarCliente(string rut) {
    NodoCliente *current = first;
    while(current!= NULL && current->getCliente()->getRut() != rut) {
        current = current->getPrev();
    }
    if(current != NULL){
        if(current == first) {
            NodoCliente *eliminado = first;
            first = first->getNext();
            delete eliminado;
        }else{
            current->getPrev()->setNext(current->getNext());
        }
        if(current == last) {
            NodoCliente *eliminado = last;
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


ListaClientes::~ListaClientes() {
}

