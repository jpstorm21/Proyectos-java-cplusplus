/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Amigo.cpp
 * Author: Usuario
 * 
 * Created on 9 de septiembre de 2017, 20:18
 */

#include "Amigo.h"

Amigo::Amigo() {
}

Amigo::Amigo(string nombre) {
    this->nombre=nombre;
}

string Amigo::getNombre() {
    return nombre;
}

void Amigo::setNombre(string nombre) {
    this->nombre=nombre;
}



Amigo::~Amigo() {
}

