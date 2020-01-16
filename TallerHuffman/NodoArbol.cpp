
#include "NodoArbol.h"
#include <cstdlib>

NodoArbol::NodoArbol(string palabra) {
    this->palabra = palabra;
    this->frecuencia = 1;
    this->izquierdo = NULL;
    this->derecho = NULL;
    this->direccion=0;
}

NodoArbol::NodoArbol(string palabra, int frecuencia) {
    this->palabra = palabra;
    this->frecuencia = frecuencia;
    this->izquierdo = NULL;
    this->derecho = NULL;
    this->direccion=0;
}

int NodoArbol::getDireccion() {
    return this->direccion;
}

void NodoArbol::setDireccion(int direccion) {
    this->direccion=direccion;
}

NodoArbol* NodoArbol::getDerecho() {
    return this->derecho;
}

int NodoArbol::getFrecuencia() {
    return this->frecuencia;
}

NodoArbol* NodoArbol::getIzquierdo() {
    return this->izquierdo;
}

string NodoArbol::getPalabra() {
    return this->palabra;
}

void NodoArbol::setDerecho(NodoArbol* derecho) {
    this->derecho=derecho;
}

void NodoArbol::setFrecuencia(int frecuencia) {
    this->frecuencia=frecuencia;
}

void NodoArbol::setIzquiero(NodoArbol* izquierdo) {
    this->izquierdo=izquierdo;
}

void NodoArbol::setPalabra(string palabra) {
    this->palabra=palabra;
}

NodoArbol::~NodoArbol() {
}

