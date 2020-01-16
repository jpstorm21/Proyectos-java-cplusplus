#include "ABB.h"
#include <cstdlib>
#include <iostream>
#include <fstream> 
using namespace std;


ABB::ABB() {
    this->raiz=NULL;
    this->cantPersonas=0;
}

NodoABB* ABB::getRaiz() {
    return this->raiz;
}

void ABB::insertar(Contribuyente* c) {
    if(this->raiz ==NULL){
        this->raiz = new NodoABB(c);
        this->cantPersonas++;
    }
    else{
        insertarNodo(c, this->raiz);
    }
}

void ABB::insertarNodo(Contribuyente *c, NodoABB* raiz) {
    if(c->getRut() < raiz->getContribuyente()->getRut()){
        if(raiz->getHijoIzq() ==NULL){
            raiz->setHijoIzq(new NodoABB(c));
            this->cantPersonas++;
        }
        else{
            insertarNodo(c, raiz->getHijoIzq());
        }
    }
    else{
        if(raiz->getHijoDer() == NULL){
            raiz->setHijoDer(new NodoABB(c));
            this->cantPersonas++;
        }
        else{
            insertarNodo(c, raiz->getHijoDer());
        }
    }
}

Contribuyente* ABB::buscar(int rut, NodoABB* raiz) {
    if(raiz == NULL){
        return NULL;
    }
    else if(raiz->getContribuyente()->getRut() == rut){
        return raiz->getContribuyente();
        
    }
    if(raiz->getContribuyente()->getRut() < rut){
        buscar(rut, raiz->getHijoDer());
    }
    else{
        buscar(rut, raiz->getHijoIzq());
    }
}

void ABB::eliminar(int rut) {
    raiz = eliminarDato(rut, raiz);
}

NodoABB* ABB::eliminarDato(int rut, NodoABB* raiz) {
    if (raiz == NULL) {
        cout << "No se encontro el dato" << endl;
    } else if (rut < raiz->getContribuyente()->getRut()) {
        NodoABB *izq = eliminarDato(rut, raiz->getHijoIzq());
        raiz->setHijoIzq(izq);
    } else if (rut > raiz->getContribuyente()->getRut()) {
        NodoABB *der = eliminarDato(rut, raiz->getHijoDer());
        raiz->setHijoDer(der);
    } else {
        NodoABB *paraEliminar = raiz;
        if (paraEliminar->getHijoIzq() == NULL) { // solo tiene hijo der
            raiz = paraEliminar->getHijoDer();
        } else if (paraEliminar->getHijoDer() == NULL) { // solo tiene hijo izq
            raiz = paraEliminar->getHijoIzq();
        } else { // tiene dos hijos
            paraEliminar = reemplazar(paraEliminar);
        }
        paraEliminar = NULL;
    }
    return raiz;
}

NodoABB* ABB::reemplazar(NodoABB* actual) {
    NodoABB *a, *p;
    p = actual;
    a = actual->getHijoIzq();
    while (a->getHijoDer() != NULL) {
        p = a;
        a = a->getHijoDer();
    }
    actual->setContribuyente(a->getContribuyente());
    if (p == actual) { // a es el hijo izq de actual
        p->setHijoIzq(a->getHijoIzq()); // by pass
    } else {
        p->setHijoDer(a->getHijoDer()); // bypass
    }
    return a;
}

int ABB::getCantPersonas() {
    return this->cantPersonas;
}

int ABB::PreOrden() {
    int cant = 0;
    return PreOrdenR(this->raiz,cant);
}

int ABB::PreOrdenR(NodoABB *nodo,int cant) {
    if(nodo != NULL){
        if(nodo->getContribuyente()->getAtendido() == false){
            cant++;
        }
        PreOrdenR(nodo->getHijoIzq(),cant);
        PreOrdenR(nodo->getHijoDer(),cant);
    }else{
        return cant;
    }

}

void ABB::imprimir(NodoABB *nodo,int nivel,ofstream &archivo) {
    int i;
    if (nodo!=NULL){
        imprimir(nodo->getHijoDer(), nivel + 1,archivo);
        archivo<<endl;
        if (nodo == this->raiz)
        archivo<<"raiz -> ";
        for (i = 0; i < nivel && nodo != this->raiz; i++)
            archivo<<"        ";
        archivo<<nodo->getContribuyente()->getNumeroAtencion();
        imprimir(nodo->getHijoIzq(), nivel + 1,archivo);
    }
}

ABB::~ABB() {
}

