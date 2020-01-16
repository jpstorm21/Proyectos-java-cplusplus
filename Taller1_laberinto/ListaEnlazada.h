/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaEnlazada.h
 * Author: Juan Pablo Martinez
 *
 * Created on 17 de abril de 2019, 0:26
 */

#ifndef LISTAENLAZADA_H
#define LISTAENLAZADA_H
#include "Nodo.h"
class ListaEnlazada {
public:
     ListaEnlazada();
        Nodo* getPrimero();
        void setPrimero(Nodo* primero);
        Nodo* getUltimo();
        void setUltimo(Nodo*);
        void insertarNodo(int posX, int posY);
        Nodo* buscarNodo(int posX, int posY);
        void imprimir();
        virtual ~ListaEnlazada();
private:
     Nodo* primero;
     Nodo* ultimo;     
};

#endif /* LISTAENLAZADA_H */

