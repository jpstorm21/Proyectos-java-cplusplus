/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Juan Pablo Martinez
 *
 * Created on 17 de abril de 2019, 0:10
 */

#ifndef NODO_H
#define NODO_H

class Nodo {
public:
    Nodo(int posX, int posY); 
        int getPosX();
        int getPosY();
        void setPosX(int posX);
        void setPosY(int posY);
        Nodo* getSiguiente();
        Nodo* getPrevio();      
        void setSiguiente(Nodo* siguiente);
        void setPrevio(Nodo* previo);
        virtual ~Nodo();
private:
     Nodo *siguiente;
        Nodo *previo;
        int posX;
        int posY;

};

#endif /* NODO_H */

