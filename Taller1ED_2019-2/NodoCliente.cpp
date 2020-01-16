/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoCliente.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 18 de septiembre de 2019, 16:46
 */

#include "NodoCliente.h"

NodoCliente::NodoCliente(Cliente *cliente) {
    this->cliente=cliente;
    this->next= nullptr;
    this->prev=nullptr;
}

Cliente* NodoCliente::getCliente() {
    return this->cliente;
}

NodoCliente* NodoCliente::getNext() {
    return this->next;
}

NodoCliente* NodoCliente::getPrev() {
    return this->prev;
}

void NodoCliente::setCliente(Cliente* cliente) {
    this->cliente=cliente;
}

void NodoCliente::setNext(NodoCliente* next) {
    this->next=next;
}

void NodoCliente::setPrev(NodoCliente* prev) {
    this->prev=prev;
}


NodoCliente::~NodoCliente() {
}

