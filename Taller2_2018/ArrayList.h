/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ArrayList.h
 * Author: Juan Pablo Martinez
 *
 * Created on 5 de junio de 2018, 19:33
 */

#ifndef ARRAYLIST_H
#define ARRAYLIST_H
#include "dato.h"
#include <windows.h>
#include <stdio.h>
class ArrayList {
public:
    ArrayList(int max);
    int getCant();
    int getMax();
    int getDato(int i);
    bool ingresar(int dato);
    int buscar(int dato);
    void imprimir();
    double megersort(int posInicio,int posFinal);
    double burbujaSort();
    double performancecounter_diff(LARGE_INTEGER *a, LARGE_INTEGER *b);
    void allDelete();
    bool isVacia();
    virtual ~ArrayList();
private:
    int max;
    int cant;
    dato **lista;
    void megersortREC(int posInicio,int mitad,int posFinal);
};

#endif /* ARRAYLIST_H */

