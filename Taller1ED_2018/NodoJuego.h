/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoJuego.h
 * Author: Casa
 *
 * Created on 27 de abril de 2018, 12:40
 */

#ifndef NODOJUEGO_H
#define NODOJUEGO_H
#include "Juego.h"
#include <string.h>
#include <iostream>
using namespace std;
class NodoJuego {
public:
    NodoJuego();
    NodoJuego(Juego *juego);
    Juego *getJuego();
    NodoJuego *getNext();
    NodoJuego *getPrev();
    void setJuego(Juego *);
    void setNext(NodoJuego *);
    void setPrev(NodoJuego *);
    virtual ~NodoJuego();
private:
    Juego *juego;
    NodoJuego *next;
    NodoJuego *prev;

};

#endif /* NODOJUEGO_H */

