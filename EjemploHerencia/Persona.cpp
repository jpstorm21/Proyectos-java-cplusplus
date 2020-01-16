/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Persona.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 8 de marzo de 2018, 1:36
 */

#include "Persona.h"
#include <string.h>

Persona::Persona(string nombre,int edad) {
    this->edad =edad;
    this->nombre=nombre;
}

Persona::Persona(const Persona& orig) {
}

int Persona::getEdad() {
    return this->edad;
}

string Persona::getNombre() {
    return this->nombre;
}

void Persona::setEdad(int edad) {
    this->edad = edad;
}

void Persona::setNombre(string nombre) {
    this->nombre =nombre;
}

Persona::~Persona() {
}

