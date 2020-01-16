/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 17 de abril de 2019, 0:10
 */

#include "Nodo.h"

Nodo::Nodo(int posX, int posY){
    this->posX = posX;
    this->posY = posY;
    this->siguiente = nullptr;
    this->previo = nullptr;
}

int Nodo::getPosX(){
    return posX;
}

void Nodo::setPosX(int posX){
    this->posX=posX;
}

int Nodo::getPosY(){
    return posY;
}

void Nodo::setPosY(int posY){
    this->posY=posY;
}

Nodo* Nodo::getSiguiente(){
    return siguiente;
}

void Nodo::setSiguiente(Nodo* siguiente){
    this->siguiente = siguiente;
}

Nodo* Nodo::getPrevio(){
    return previo;
}

void Nodo::setPrevio(Nodo* previo){
    this->previo = previo;
}




Nodo::~Nodo() {
}

