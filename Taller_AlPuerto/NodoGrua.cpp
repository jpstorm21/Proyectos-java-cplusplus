/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoGrua.cpp
 * Author: ASUS
 * 
 * Created on 13 de febrero de 2018, 16:46
 */

#include "NodoGrua.h"
#include <cstdlib>
NodoGrua::NodoGrua(Grua *grua) {
    this->grua = grua;
    this->next = NULL;
    this->previo = NULL;
}

NodoGrua::NodoGrua(const NodoGrua& orig) {
}

Grua* NodoGrua::getGrua() {
    return this->grua;
}

NodoGrua* NodoGrua::getNext() {
    return this->next;
}

NodoGrua* NodoGrua::getPrev() {
    return this->previo;
}

void NodoGrua::setGrua(Grua* grua) {
    this->grua = grua;
}

void NodoGrua::setNext(NodoGrua* next) {
    this->next = next;
}

void NodoGrua::setPrev(NodoGrua* previo) {
    this->previo= previo;
}

NodoGrua::~NodoGrua() {
}

