/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Persona.cpp
 * Author: ASUS
 * 
 * Created on 4 de febrero de 2018, 19:25
 */

#include "Persona.h"

Persona::Persona(string nombre,int rut) {
    this->nombre = nombre;
    this->rut =  rut;
}

Persona::Persona(const Persona& orig) {
}

string Persona::getNombre() {
    return this->nombre;
}

void Persona::setNombre(string nombre) {
    this->nombre= nombre;
}

int Persona::getRut() {
    return this->rut;
}

void Persona::setRut(int rut) {
    this->rut=rut;
}




Persona::~Persona() {
}

