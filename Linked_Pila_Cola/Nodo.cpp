/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 25 de septiembre de 2018, 19:27
 */

#include "Nodo.h"
#include <cstdlib>

Nodo::Nodo(int dato) {
    this->dato = dato;
    this->next = NULL;
    this->prev = NULL;
}

int Nodo::getDato() {
    return dato;
}

void Nodo::setDato(int dato) {
    this->dato=dato;
}

Nodo* Nodo::getNext() {
    return next;
}

void Nodo::setNext(Nodo* next) {
    this->next=next;
}

Nodo* Nodo::getPrev() {
    return prev;
}

void Nodo::setPrev(Nodo *prev) {
    this->prev=prev;
}

Nodo::~Nodo() {
}

