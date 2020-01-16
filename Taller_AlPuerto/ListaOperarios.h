/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaOperarios.h
 * Author: Juan Pablo Martinez Romero
 *
 *
 */

#ifndef LISTAOPERARIOS_H
#define LISTAOPERARIOS_H
#include "Operario.h"
#include <iostream>
using namespace std;
class ListaOperarios {
public:
    ListaOperarios(int max);
    ListaOperarios(const ListaOperarios& orig);
    int getCant();
    bool ingresarOperario(Operario *);
    Operario *getOperario(int i);
    Operario *buscarOperario(string nombre);
    virtual ~ListaOperarios();
private:
    int max;
    int cant;
    Operario **lo;
};

#endif /* LISTAOPERARIOS_H */

