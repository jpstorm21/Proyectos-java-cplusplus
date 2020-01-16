/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaVentas.h
 * Author: Casa
 *
 * Created on 27 de abril de 2018, 17:36
 */

#ifndef LISTAVENTAS_H
#define LISTAVENTAS_H
#include "NodoVenta.h"
#include "Venta.h"
#include <string.h>
#include <iostream>
using namespace std;
class ListaVentas {
public:
    ListaVentas();
    NodoVenta *getFirst();
    NodoVenta *getLast();
    void setFirst(NodoVenta*);
    void setLast(NodoVenta*);
    void ingresarVenta(Venta *V);
    virtual ~ListaVentas();
private:
    NodoVenta *first;
    NodoVenta *last;

};

#endif /* LISTAVENTAS_H */

