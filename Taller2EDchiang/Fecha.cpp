/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Fecha.cpp
 * Author: Usuario
 * 
 * Created on 17 de noviembre de 2017, 0:13
 */

#include "Fecha.h"

Fecha::Fecha() {
}

Fecha::Fecha(int hora,int minutos) {
    this->hora=hora;
    this->minutos=minutos;

}

int Fecha::getHora() {
    return this->hora;
}

int Fecha::getMinutos() {
    return this->minutos;
}

void Fecha::setHora(int hora) {
    this->hora=hora;
}

void Fecha::setMin(int minutos) {
    this->minutos=minutos;
}







Fecha::~Fecha() {
}

