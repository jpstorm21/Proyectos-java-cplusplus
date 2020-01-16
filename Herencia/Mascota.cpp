/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Mascota.cpp
 * Author: Usuario
 * 
 * Created on 4 de octubre de 2017, 23:18
 */

#include "Mascota.h"
#include <string>
#include <iostream>
#include <cstdlib>
using namespace std;
Mascota::Mascota() {
}

Mascota::Mascota(string nombre) {

    this->nombre= nombre;
}



string Mascota::getNombre() {
    return this->nombre;
}


void Mascota::setNombre(string nombre) {
    this->nombre=nombre;
}





Mascota::~Mascota() {
}

