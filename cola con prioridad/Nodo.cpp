#include "Nodo.h"
#include <cstdlib>

Nodo::Nodo(int dato,int prioridad){
	this->dato= dato;
	this->prioridad = prioridad;
	this->next = NULL;
	this->prev = NULL;
}

Nodo* Nodo::getNext(){
	return this->next;
}
Nodo *Nodo::getPrev(){
	return this->prev;
}
void Nodo::setNext(Nodo *next){
	this->next=next;
}
void Nodo::setPrev(Nodo *prev){
	this->prev=prev;
}
int Nodo::getDato(){
	return this->dato;
}
int Nodo::getPrioridad(){
	return this->prioridad;
}
