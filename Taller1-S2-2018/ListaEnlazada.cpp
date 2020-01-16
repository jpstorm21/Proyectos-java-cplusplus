

#include "ListaEnlazada.h"
#include  <cstdlib>

ListaEnlazada::ListaEnlazada() {
    this->last=NULL;
}
Nodo* ListaEnlazada::getLast() {
    return this->last;
}
void ListaEnlazada::setLast(Nodo* last) {
    this->last=last;
}
void ListaEnlazada::ingresar(int i,int j,int vecinos,int estadoActual, string nombreRegla) {
    Nodo *nuevo = new Nodo(i,j,vecinos,estadoActual,nombreRegla);
    if(last == NULL){ //vacio
        last = nuevo;
    }else { 
        nuevo->setNext(last);
        last = nuevo;   
    }
}

bool ListaEnlazada::eliminar() {
    if(last == NULL){
        return false;
    }else{

        last = last->getNext();

    }
}

ListaEnlazada::~ListaEnlazada() {
}

