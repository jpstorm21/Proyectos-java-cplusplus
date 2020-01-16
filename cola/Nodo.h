/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Usuario
 *
 * Created on 25 de julio de 2017, 13:01
 */

#ifndef NODO_H
#define NODO_H

class Nodo {
public:
    Nodo();
    Nodo(int dato);
    Nodo *getNext();
    void setNext(Nodo *);
    int getDato();
    virtual ~Nodo();
private:
    int dato;
    Nodo *next;

};

#endif /* NODO_H */

