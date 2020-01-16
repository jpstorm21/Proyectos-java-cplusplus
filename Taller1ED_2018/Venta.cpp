/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Venta.cpp
 * Author: Casa
 * 
 * Created on 27 de abril de 2018, 12:33
 */

#include "Venta.h"
#include <string.h>
#include "Cliente.h"
#include "ListaJuegos.h"
#include "NodoCliente.h"
#include "ListaClientes.h"
#include <iostream>
using namespace std;
Venta::Venta(string metodoPago) {
    this->metodoPago=metodoPago;
    this->lj = new ListaJuegos();
}

string Venta::getMetodoPago() {
    return metodoPago;
}

Cliente* Venta::getCliente() {
    return cliente;
}

void Venta::setMetodoPago(string metodoPago) {
    this->metodoPago=metodoPago;
}

void Venta::setCliente(Cliente* cliente) {
    this->cliente=cliente;
}

ListaJuegos* Venta::getLj() {
    return this->lj;
}

void Venta::setLj(ListaJuegos* lj) {
    this->lj=lj;
}


Venta::~Venta() {
}

