/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Grua.h
 * Author: Usuario
 *
 * Created on 5 de octubre de 2017, 0:14
 */

#ifndef GRUA_H
#define GRUA_H
#include <string>
#include <iostream>
using namespace std;
class Grua {
public:
    Grua();
    Grua(string codigo ,int pesoTransAcumulado,string estado,int inicio,int fin);
    virtual ~Grua();
private:
    string codigo;
    int pesoTransAcumulado;
    string estado;
    ListaOperadores lp;
    Barco barco;
    int inicio;
    int fin;
    
};

#endif /* GRUA_H */

