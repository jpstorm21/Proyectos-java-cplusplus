/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoVenta.cpp
 * Author: Casa
 * 
 * Created on 27 de abril de 2018, 13:40
 */

#include "NodoVenta.h"
#include <cstdlib>
#include <string.h>
#include <iostream>
using namespace std;
NodoVenta::NodoVenta(Venta *venta) {
    this->venta=venta;
    this->next=NULL;
}

NodoVenta* NodoVenta::getNext() {
    return next;
}

Venta* NodoVenta::getVenta() {
    return venta;
}

NodoVenta* NodoVenta::getPrev() {
    return prev;
}

void NodoVenta::setPrev(NodoVenta* prev) {
    this->prev=prev;
}

void NodoVenta::setVenta(Venta*) {
    this->venta=venta;
}

void NodoVenta::setNext(NodoVenta* next) {
    this->next=next;
}


NodoVenta::~NodoVenta() {
}

