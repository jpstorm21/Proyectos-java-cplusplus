#include "NodoABB.h"
#include <cstdlib>

NodoABB::NodoABB() {
}

NodoABB::NodoABB(Contribuyente *c) {
    this->c=c;
    this->hijoIzq=NULL;
    this->hijoDer=NULL;
}

NodoABB* NodoABB::getHijoIzq() {
    return this->hijoIzq;
}

NodoABB* NodoABB::getHijoDer() {
    return this->hijoDer;
}

Contribuyente* NodoABB::getContribuyente() {
    return this->c;
}

void NodoABB::setHijoIzq(NodoABB* hijoIzq) {
    this->hijoIzq=hijoIzq;
}

void NodoABB::setHijoDer(NodoABB* hijoDer) {
    this->hijoDer=hijoDer;
}

void NodoABB::setContribuyente(Contribuyente* c) {
    this->c=c;
}

NodoABB::~NodoABB() {
}

