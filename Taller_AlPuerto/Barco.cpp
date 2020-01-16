/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Barco.cpp
 * Author: Juan Pablo martinez romero
 * 
 */

#include "Barco.h"

Barco::Barco(string nombreBarco, string nombrePiloto, string tipoBarco, string paisOrigen,
        string carga, int cantidadContainers, int cantidadCarga, string horaLlegada) {
    this->nombreBarco = nombreBarco;
    this->nombrePiloto = nombrePiloto;
    this->tipoBarco = tipoBarco;
    this->paisOrigen = paisOrigen;
    this->carga = carga;
    this->cantidadCarga = cantidadCarga;
    this->cantidadContainers = cantidadContainers;
    this->horaLlegada = horaLlegada;
}

Barco::Barco(const Barco& orig) {
}

string Barco::getNombreBarco(){
    return nombreBarco;
}

void Barco::setNombreBarco(string nombreBarco){
    this->nombreBarco = nombreBarco;
}

string Barco::getNombrePiloto(){
    return nombrePiloto;
}

void Barco::setNombrePiloto(string nombrePiloto){
    this->nombrePiloto = nombrePiloto;
}

string Barco::getTipoBarco(){
    return tipoBarco;
}

void Barco::setTipoBarco(string tipoBarco){
    this->tipoBarco = tipoBarco;
}

string Barco::getPaisOrigen(){
    return paisOrigen;
}

void Barco::setPaisOrigen(string paisOrigen){
    this->paisOrigen = paisOrigen;
}

string Barco::getCarga(){
    return carga;
}

void Barco::setCarga(string carga){
    this->carga = carga;
}

int Barco::getCantidadContainers(){
    return cantidadContainers;
}

void Barco::setCantidadContainers(int cantidadContainers){
    this->cantidadContainers = cantidadContainers;
}

int Barco::getCantidadCarga(){
    return cantidadCarga;
}

void Barco::setCantidadCarga(float cantidadCarga){
    this->cantidadCarga = cantidadCarga;
}

string Barco::getHoraLlegada() {
    return horaLlegada;
}


Barco::~Barco() {
}

