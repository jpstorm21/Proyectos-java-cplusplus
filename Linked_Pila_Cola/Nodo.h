/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Juan Pablo Martinez
 *
 * Created on 25 de septiembre de 2018, 19:27
 */


// & direccion memoria
// * apunta al valor 

#ifndef NODO_H
#define NODO_H

class Nodo {
    
public:
    
    Nodo(int dato);//constructor
    
    int getDato();
    void setDato(int dato);
    Nodo *getNext();                    //get y set de la clase
    Nodo *getPrev();
    void setNext(Nodo *);
    void setPrev(Nodo *);
       
    virtual ~Nodo(); // destructor
    
private:
    int dato;
    Nodo *next;
    Nodo *prev;

};

#endif /* NODO_H */

