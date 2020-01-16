/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.cpp
 * Author: Nicolas
 * 
 * Created on 11 de mayo de 2017, 18:26
 */

#include "Nodo.h"

Nodo::Nodo(int dato,int fila,int columna) {
    this->dato=dato;
    this->fila=fila;
    this->columna=columna;
    this->next=this;
    this->abajo=this;
}
Nodo::Nodo(int fila,int columna){
    this->fila=fila;
    this->columna=columna;
    this->next=this;
    this->abajo=this;
}

Nodo::~Nodo() {
}

Nodo* Nodo::getNext(){
    return this->next;
}
Nodo* Nodo::getAbajo(){
    return this->abajo;
}
int Nodo::getDato(){
    return this->dato;
}
int Nodo::getFila(){
    return this->fila;
}
int Nodo::getColumna(){
    return this->columna;
}

void Nodo::setNext(Nodo* n){
    this->next=n;
}
void Nodo::setAbajo(Nodo* n){
    this->abajo=n;
}
void Nodo::setDato(int d){
    this->dato=d;
}
void Nodo::setFila(int f){
    this->fila=f;
}
void Nodo::setColumna(int c){
    this->columna=c;
}