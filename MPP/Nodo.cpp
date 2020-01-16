/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.cpp
 * Author: Usuario
 * 
 * Created on 17 de mayo de 2017, 16:25
 */

#include "Nodo.h"
#include <cstddef>

Nodo::Nodo(int dato,int fila,int columna) {
    this->fila = fila;
    this->columna = columna;
    this->dato =dato;
    next = NULL;
    down = NULL;
}

int Nodo::getColuma() {
    return this->columna;
}

int Nodo::getDato() {
    return this->dato;
}

Nodo* Nodo::getDown() {
    return this->down;
}

int Nodo::getFila() {
    return this->fila;
}

Nodo* Nodo::getNext() {
    return this->next;
}

void Nodo::setDown(Nodo *down) {
    this->down = down;
}

void Nodo::setNext(Nodo *next) {
    this->next = next;
}
void Nodo::setDato(int dato){
    this->dato=dato;
}
Nodo::~Nodo() {
}

