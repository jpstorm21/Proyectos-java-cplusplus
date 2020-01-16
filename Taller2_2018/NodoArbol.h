/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoArbol.h
 * Author: Juan Pablo Martinez
 *
 * Created on 5 de junio de 2018, 20:01
 */

#ifndef NODOARBOL_H
#define NODOARBOL_H

class NodoArbol {
public:
    NodoArbol(int dato);
    NodoArbol *getDerecho();
    NodoArbol *getIzquierdo();
    int getDato();
    void setDato(int dato);
    void setDerecho(NodoArbol *);
    void setIzquierdo(NodoArbol *);
    virtual ~NodoArbol();
private:
    int dato;
    NodoArbol *izq;
    NodoArbol *der;
};

#endif /* NODOARBOL_H */

