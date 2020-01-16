
#include "NodoTabla.h"
#include <cstdlib>
NodoTabla::NodoTabla(string valor, string ub) {
    this->setDato(valor);
    this->setSiguiente(NULL);
    this->setUbicacion(ub);
}

string NodoTabla::getDato() {
    return this->Dato;
}

NodoTabla* NodoTabla::getSiguiente() {
    return this->siguiente;
}

string NodoTabla::getUbicacion() {
    return this->ubicacion;
}

void NodoTabla::setDato(string dato) {
    this->Dato=dato;
}

void NodoTabla::setSiguiente(NodoTabla* siguiente) {
    this->siguiente=siguiente;
}

void NodoTabla::setUbicacion(string ubicacion) {
    this->ubicacion=ubicacion;
}

NodoTabla::~NodoTabla() {
}

