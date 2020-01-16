/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoLinked.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 5 de junio de 2018, 19:05
 */

#include "NodoLinked.h"
#include <cstdlib>
NodoLinked::NodoLinked(int dato) {
   this->dato= dato;
   this->next =  NULL;
   this->prev = NULL;
}

NodoLinked* NodoLinked::getNext() {
    return this->next;
}

NodoLinked* NodoLinked::getPrev() {
    return this->prev;
}

void NodoLinked::setNext(NodoLinked *next) {
    this->next = next;
}

void NodoLinked::setPrev(NodoLinked *prev) {
    this->prev = prev;
}

int NodoLinked::getDato() {
    return this->dato;
}

void NodoLinked::setDato(int dato) {
    this->dato =dato;
}






NodoLinked::~NodoLinked() {
}

