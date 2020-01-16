/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Estandar.cpp
 * Author: ASUS
 * 
 * Created on 13 de febrero de 2018, 16:34
 */

#include "Estandar.h"

Estandar::Estandar(string nombreBarco, string nombrePiloto, string tipoBarco, string paisOrigen,
        string carga, int cantidadContainers, int cantidadCarga, string horaLlegada) : Barco(nombreBarco, nombrePiloto, tipoBarco, paisOrigen,
carga, cantidadContainers, cantidadCarga, horaLlegada) {
}

Estandar::~Estandar() {
}

