/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Usuario
 *
 * Created on 2 de junio de 2017, 0:10
 */

#ifndef NODO_H
#define NODO_H

class Nodo {
public:
    Nodo();
    Nodo(int dato);
    Nodo *getHijoIzqui();
    Nodo *getHijoDerech();
    int getDato();
    void setHijoIzqui(Nodo *);
    void setHijoDerech(Nodo *);
    void setDato(int dato);
    virtual ~Nodo();
private:
    Nodo *hijoIzqu;
    Nodo *hijoDerech;
    int dato;

};

#endif /* NODO_H */

