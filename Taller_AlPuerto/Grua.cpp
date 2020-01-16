/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Grua.cpp
 * Author: ASUS
 * 
 * Created on 13 de febrero de 2018, 16:43
 */

#include "Grua.h"

Grua::Grua(string codigo, int pesoTransportadoAcumulado, int estado, string horaInicio, string horaFin) {
    this->codigo = codigo;
    this->pesoTransportadoAcumulado = pesoTransportadoAcumulado;
    this->estado = estado;
    this->horaInicio = horaInicio;
    this->horaFin = horaFin;
}

Grua::Grua(const Grua& orig) {
}

string Grua::getCodigo(){
    return codigo;
}

void Grua::setCodigo(string codigo){
    this->codigo = codigo;
}

int Grua::getPesoTransportadoAcumulado(){
    return pesoTransportadoAcumulado;    
}

void Grua::setPesoTransportadoAcumulado(int pesoTransportadoAcumulado){
    this->pesoTransportadoAcumulado = pesoTransportadoAcumulado;
}

int Grua::getEstado(){
    return estado;
}

void Grua::setEstado(int estado){
    this->estado = estado;
}

Operario *Grua::getOperario(){
    return operario;
}

void Grua::setOpeario(Operario* operario){
    this->operario = operario;
}

Barco *Grua::getBarco(){
    return barco;
}

void Grua::setBarco(Barco* barco){
    this->barco = barco;
}

string Grua::getHoraInicio(){
    return horaInicio;
}

void Grua::setHoraInicio(string horaInicio){
    this->horaInicio = horaInicio;
}

string Grua::getHoraFin(){
    return horaFin;
}

void Grua::setHoraFIn(string horaFin){
    this->horaFin = horaFin;
}

Grua::~Grua() {
}

