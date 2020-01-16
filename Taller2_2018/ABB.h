/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ABB.h
 * Author: Juan Pablo Martinez
 *
 * Created on 5 de junio de 2018, 20:05
 */

#ifndef ABB_H
#define ABB_H

#include "NodoArbol.h"


class ABB {
public:
    ABB();
    NodoArbol *getRaiz();
    void ingresar(int dato);
    int buscar(NodoArbol*,int dato);
    void imprimirPreOrden(NodoArbol *actual,int nivel);
    void allDelete();
    virtual ~ABB();
private:
    NodoArbol *raiz;
    void ingresarREC(NodoArbol*,int dato);
};

#endif /* ABB_H */

