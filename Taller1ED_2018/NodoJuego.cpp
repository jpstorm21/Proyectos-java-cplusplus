/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoJuego.cpp
 * Author: Casa
 * 
 * Created on 27 de abril de 2018, 12:40
 */

#include "NodoJuego.h"
#include <cstdlib>
#include <string.h>
#include <iostream>
using namespace std;

NodoJuego::NodoJuego(Juego *juego) {
    this->juego=juego;
    this->next=NULL;
    this->prev=NULL;
}

Juego* NodoJuego::getJuego() {
    return juego;
}

NodoJuego* NodoJuego::getNext() {
    return next;
}

NodoJuego* NodoJuego::getPrev() {
    return prev;
}

void NodoJuego::setPrev(NodoJuego* prev) {
    this->prev=prev;
}

void NodoJuego::setJuego(Juego *juego) {
    this->juego=juego;
}

void NodoJuego::setNext(NodoJuego *next) {
    this->next=next;
}


NodoJuego::~NodoJuego() {
}

