/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   gato.cpp
 * Author: Usuario
 * 
 * Created on 4 de octubre de 2017, 23:26
 */

#include "gato.h"

gato::gato() {
}

gato::gato(string raza,string nombre) {
    this->raza=raza;
    
}

string gato::getRaza() {
    return this->raza;
}

void gato::setRaza(string raza) {
    this->raza=raza;
}



gato::~gato() {
}

