/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Usuario.cpp
 * Author: Usuario
 * 
 * Created on 8 de septiembre de 2017, 23:00
 */

#include "Usuario.h"

Usuario::Usuario() {
}

Usuario::Usuario(string nombre,string profesion,int RecPositivas,int RecNegativas,string amigo) {
    this->RecNegativas=RecNegativas;
    this->RecPositivas=RecPositivas;
    this->nombre=nombre;
    this->profesion=profesion;
    this->amigo=amigo;
}

string Usuario::getNombre() {
    return nombre;
}
string Usuario::getAmigo() {
    return amigo;
}
string Usuario::getProfesion() {
    return profesion;
}

int Usuario::getRecNegativas() {
    return RecNegativas;
}

int Usuario::getRecPositivas() {
    return RecPositivas;
}

void Usuario::setNombre(string nombre) {
    this->nombre=nombre;
}

void Usuario::setProfesion(string profesion) {
    this->profesion=profesion;
}

void Usuario::setRecNegativas(int RecNegativas) {
    this->RecNegativas=RecNegativas;
}

void Usuario::setRecPositivas(int RecPositivas) {
    this->RecPositivas=RecPositivas;
}

void Usuario::setAmigo(string amigo) {
    this->amigo=amigo;
}

Usuario::~Usuario() {
}

