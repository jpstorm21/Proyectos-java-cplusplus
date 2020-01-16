/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoMatriz.cpp
 * Author: Usuario
 * 
 * Created on 8 de mayo de 2017, 21:00
 */

#include "NodoMatriz.h"
#include <cstddef>
NodoMatriz::NodoMatriz() {
}

NodoMatriz::NodoMatriz(int dato, int fila, int columna) {
    this->dato= dato;
    this->fila=fila;
    this->columna=columna;
}

int NodoMatriz::getDato() {
    return this->dato;
}

int NodoMatriz::getColumna() {
    return this->columna;
}

int NodoMatriz::getFila() {
    return this->fila;
}

NodoMatriz* NodoMatriz::getNodoAbajo() {
    return this->nodoAbajo;
}

NodoMatriz* NodoMatriz::getNodoDerecho() {
    return this->nodoDerecho;
}

void NodoMatriz::setColumna(int columna) {
    this->columna = columna;
}

void NodoMatriz::setDato(int dato) {
    this->dato =dato;
}

void NodoMatriz::setFila(int fila) {
    this->fila=fila;
}

void NodoMatriz::setNodoAbajo(NodoMatriz *nodoAbajo) {
    this->nodoAbajo= nodoAbajo;
}

void NodoMatriz::setNodoDerecho(NodoMatriz *nodoDerecho) {
    this->nodoDerecho= nodoDerecho;
}











NodoMatriz::~NodoMatriz() {
}

