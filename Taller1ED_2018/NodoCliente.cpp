/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoCliente.cpp
 * Author: Casa
 * 
 * Created on 27 de abril de 2018, 13:34
 */

#include "NodoCliente.h"
#include <cstdlib>
#include <string.h>
#include <iostream>
using namespace std;
NodoCliente::NodoCliente(Cliente *cliente) {
    this->cliente=cliente;
    this->next=NULL;
    this->prev=NULL;
}

Cliente* NodoCliente::getCliente() {
    return cliente;
}

NodoCliente* NodoCliente::getNext() {
    return next;
}

NodoCliente* NodoCliente::getPrev() {
    return prev;
}

void NodoCliente::setPrev(NodoCliente* prev) {
    this->prev=prev;
}


void NodoCliente::setCliente(Cliente *cliente) {
    this->cliente=cliente;
}

void NodoCliente::setNext(NodoCliente *next) {
    this->next=next;
}


NodoCliente::~NodoCliente() {
}

