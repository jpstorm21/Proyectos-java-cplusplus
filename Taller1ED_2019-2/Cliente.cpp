/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Cliente.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 18 de septiembre de 2019, 16:47
 */

#include "Cliente.h"

Cliente::Cliente(string nombre, int fondo) {
    this->nombre=nombre;
    this->fondos=fondo;
}

int Cliente::getFondos() {
    return this->fondos;
}

string Cliente::getNombre() {
    return this->nombre;
}

void Cliente::setFondo(int fondos) {
    this->fondos=fondos;
}

void Cliente::setNombre(string nombre) {
    this->nombre=nombre;
}

Cliente::~Cliente() {
}

