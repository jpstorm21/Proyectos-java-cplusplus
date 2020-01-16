/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Arbol.h
 * Author: Usuario
 *
 * Created on 8 de junio de 2017, 13:58
 */

#ifndef ARBOL_H
#define ARBOL_H

class Arbol {
public:
    Arbol();
    Nodo *getRaiz();
    void insertar();
    virtual ~Arbol();
private:
    Nodo *raiz;
    bool insertarR();

};

#endif /* ARBOL_H */

