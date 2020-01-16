/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Usuario
 *
 * Created on 27 de noviembre de 2017, 1:35
 */
#ifndef NODO_H
#define NODO_H

template <class T> class Nodo {
public:
    // Métodos públicos:
    Nodo(T dato); // Constructor.
    virtual ~Nodo(); // Destructor.
    // Setters:
    void setDerecha(Nodo* derecha);
    void setIzquierda(Nodo* izquierda);
    void setDato(T dato);
    
    // Getters:
    Nodo* getDerecha();
    Nodo* getIzquierda();
    T getDato();
private:
    // Parámetros, son todos privados:
    T dato; // Dato almacenado.
    Nodo* derecha; // Nodo hijo derecho.
    Nodo* izquierda; // Nodo hijo izquierdo.
};

#endif
