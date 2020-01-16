/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Persona.cpp
 * Author: Usuario
 * 
 * Created on 12 de abril de 2017, 22:00
 */

#include "Persona.h"

Persona::Persona() {
}

Persona::Persona(int edad,string nombre) {
    this->edad= edad;
    this->nombre=nombre;
}
int Persona::getEdad(){
    return this->edad;
}
void Persona::setEdad(int edad){
    this->edad=edad;
}
string Persona::getNombre(){
    return this->nombre;
}
void Persona::setNombre(string nombre){
    this->nombre=nombre;
}

Persona::~Persona() {
}
