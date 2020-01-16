/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaBarcos.h
 * Author: ASUS
 *
 * Created on 14 de febrero de 2018, 0:51
 */

#ifndef LISTABARCOS_H
#define LISTABARCOS_H
#include "Barco.h"
#include <string>
using namespace std;
class ListaBarcos {
public:
    ListaBarcos(int max);
    ListaBarcos(const ListaBarcos& orig);
    int getCant();
    Barco *getBarco(int i);
    bool ingresarBarco(Barco *B);
    Barco *buscarBarco(string nombre);
    virtual ~ListaBarcos();
private:
    int cant;
    int max;
    Barco **lb;

};

#endif /* LISTABARCOS_H */

