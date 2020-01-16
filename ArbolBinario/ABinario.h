/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ABinario.h
 * Author: Usuario
 *
 * Created on 24 de septiembre de 2017, 17:57
 */

#ifndef ABINARIO_H
#define ABINARIO_H
#include "Nodo.h"
class ABinario {
public:
    ABinario();
    void ingresarIterativo(int);
    void buscar(int);
    void ingresarR(int dato);
    virtual ~ABinario();
private:
    void ingresarRecursivo(int dato,Nodo *raiz);
    Nodo *raiz;

};

#endif /* ABINARIO_H */

