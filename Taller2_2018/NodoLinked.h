/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoLinked.h
 * Author: Juan Pablo Martinez
 *
 * Created on 5 de junio de 2018, 19:05
 */

#ifndef NODOLINKED_H
#define NODOLINKED_H

class NodoLinked {
public:
    NodoLinked(int dato);
    NodoLinked *getNext();
    NodoLinked *getPrev();
    int getDato();
    void setNext(NodoLinked *);
    void setPrev(NodoLinked *);
    void setDato(int dato);
    virtual ~NodoLinked();
private:
    NodoLinked *next;
    NodoLinked *prev;
    int dato;
};

#endif /* NODOLINKED_H */

