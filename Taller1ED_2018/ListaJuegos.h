/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaJuegos.h
 * Author: Casa
 *
 * Created on 27 de abril de 2018, 13:52
 */

#ifndef LISTAJUEGOS_H
#define LISTAJUEGOS_H
#include "NodoJuego.h"
#include <string.h>
#include <iostream>
using namespace std;
class ListaJuegos {
public:
    ListaJuegos();
    NodoJuego *getFirst();
    NodoJuego *getLast();
    void setFirst(NodoJuego *);
    void setLast(NodoJuego *);
    void ingresarJuego(Juego *J);
    Juego *buscarJuego(string codigo);
    bool eliminarJuego(string codigo);
    virtual ~ListaJuegos();
private:
    NodoJuego *first;
    NodoJuego *last;
};

#endif /* LISTAJUEGOS_H */

