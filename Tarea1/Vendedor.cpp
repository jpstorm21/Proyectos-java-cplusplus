/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Vendedor.cpp
 * Author: Usuario
 * 
 * Created on 8 de septiembre de 2017, 22:42
 */

#include "Vendedor.h"

Vendedor::Vendedor() {
}

Vendedor::Vendedor(string nombre,int ventas) {
    this->nombre = nombre;
    this->ventas=ventas;
}

string Vendedor::getNombre() {
    return nombre;
}

int Vendedor::getVentas() {
    return ventas;
}

void Vendedor::setNombre(string nombre) {
    this->nombre=nombre;
}

void Vendedor::setVentas(int ventas) {
    this->ventas=ventas;
}





Vendedor::~Vendedor() {
}

