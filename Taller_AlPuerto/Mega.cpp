/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Mega.cpp
 * Author: ASUS
 * 
 * Created on 13 de febrero de 2018, 16:39
 */

#include "Mega.h"

Mega::Mega(string nombreBarco, string nombrePiloto, string tipoBarco, string paisOrigen,
        string carga, int cantidadContainers, int cantidadCarga, string horaLlegada, int cantidadTrabajadores, string ciudadOrigen) : Barco(nombreBarco, nombrePiloto, tipoBarco, paisOrigen,
carga, cantidadContainers, cantidadCarga, horaLlegada) {
    this->cantidadTrabajadores = cantidadTrabajadores;
    this->ciudadOrigen = ciudadOrigen;
}

int Mega::getCantidaTrabajadores() {
    return this->cantidadTrabajadores;
}

void Mega::setCantidadTrabajadores(int cantidadTrabajadores) {
    this->cantidadTrabajadores = cantidadTrabajadores;
}

string Mega::getCiudadOrigen() {
    return this->ciudadOrigen;
}

void Mega::setCiudadOrigen(string ciudadOrigen) {
    this->ciudadOrigen = ciudadOrigen;
}

Mega::~Mega() {
}

