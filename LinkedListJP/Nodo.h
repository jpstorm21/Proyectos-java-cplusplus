/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Victor Huerta
 *
 * Created on 25 de septiembre de 2018, 19:29
 */
// & devuelve direccion de memoria
// * apunta al valor que contiene una direccion de memoria
// 
#ifndef NODO_H
#define NODO_H

class Nodo {
    
public: //aca van los metodos
    Nodo(int dato);
    int getdato();
    void setDato(int dato);
    Nodo *getNext();
    Nodo *getPrev();
    void setNext(Nodo*);
    void setPrev(Nodo*);
    virtual ~Nodo();
private: //atributos
    int dato;
    Nodo *next;
    Nodo *prev;
    
};

#endif /* NODO_H */

