/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ABB.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 5 de junio de 2018, 20:05
 */

#include "ABB.h"
#include <cstdlib>
#include <iostream>

using namespace std;

ABB::ABB() {
    this->raiz = NULL;
}

NodoArbol* ABB::getRaiz() {
    return raiz;
}

void ABB::ingresar(int dato) {
    if (raiz == NULL) {
        raiz = new NodoArbol(dato);
    } else {
        ingresarREC(raiz, dato);
    }
}

void ABB::ingresarREC(NodoArbol *actual, int dato) {
    if (dato < actual->getDato()) {
        if (actual->getIzquierdo() == NULL) {
            actual->setIzquierdo(new NodoArbol(dato));
        } else {
            ingresarREC(actual->getIzquierdo(), dato);
        }
    } else if (dato > actual->getDato()) {
        if (actual->getDerecho() == NULL) {
            actual->setDerecho(new NodoArbol(dato));
        } else {
            ingresarREC(actual->getDerecho(), dato);
        }
    }
}

int ABB::buscar(NodoArbol *actual, int dato) {
    if (actual != NULL) {
        if (actual->getDato() == dato) {
            return dato;
        } else if (dato < actual->getDato()) {
            buscar(actual->getIzquierdo(), dato);
        } else {
            buscar(actual->getDerecho(), dato);
        }
    } else {
        return -1;
    }
}

void ABB::imprimirPreOrden(NodoArbol *actual, int nivel) {
    int i;
    if (this->raiz != NULL) {
        if (actual != NULL) {
            imprimirPreOrden(actual->getDerecho(), nivel + 1);
            std::cout << "\n";
            if (actual == this->raiz)
                std::cout << "raiz -> ";
            for (i = 0; i < nivel && actual != this->raiz; i++)
                std::cout << "        ";
            std::cout << actual->getDato();
            imprimirPreOrden(actual->getIzquierdo(), nivel + 1);
        }
    } else {
        cout << "ABB vacio" << endl;
    }
}

void ABB::allDelete() {
    this->raiz = NULL;
}

ABB::~ABB() {
}

