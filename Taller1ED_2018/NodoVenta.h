/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoVenta.h
 * Author: Casa
 *
 * Created on 27 de abril de 2018, 13:40
 */

#ifndef NODOVENTA_H
#define NODOVENTA_H
#include "Venta.h"
#include <string.h>
#include <iostream>
using namespace std;

class NodoVenta {
public:
    NodoVenta();
    NodoVenta(Venta *venta);
    Venta *getVenta();
    NodoVenta *getNext();
    NodoVenta *getPrev();
    void setVenta(Venta *venta);
    void setNext(NodoVenta *);
    void setPrev(NodoVenta *);
    virtual ~NodoVenta();
private:
    Venta *venta;
    NodoVenta *next;
    NodoVenta *prev;
};

#endif /* NODOVENTA_H */

