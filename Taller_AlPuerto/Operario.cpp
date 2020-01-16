/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Operario.cpp
 * Author: Juan Pablo Martinez Romero
 * 
 * 
 */

#include "Operario.h"

Operario::Operario(string nombre, string cedulaIdentidad, int horasTrabajadas,int estado) {
    this->nombre = nombre;
    this->estado = estado;
    this->cedulaIdentidad = cedulaIdentidad;
    this->horasTrabajadas = horasTrabajadas;
}

Operario::Operario(const Operario& orig) {
}

string Operario::getCedulaIdentidad() {
    return this->cedulaIdentidad;
}

int Operario::getEstado() {
    return this->estado;
}

int Operario::getHorasTrabajadas() {
    return this->horasTrabajadas;
}

string Operario::getNombre() {
    return this->nombre;
}

void Operario::setCedulaIdentidad(string cedulaIdentidad) {
    this->cedulaIdentidad = cedulaIdentidad;
}

void Operario::setEstado(int estado) {
    this->estado = estado;
}

void Operario::setHorasTrabajadas(int horasTrabajadas) {
    this->horasTrabajadas =horasTrabajadas;
}

void Operario::setNombre(string nombre) {
    this->nombre = nombre;
            
}

Operario::~Operario() {
}

