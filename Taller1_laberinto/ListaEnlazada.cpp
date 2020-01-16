/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaEnlazada.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 17 de abril de 2019, 0:26
 */

#include "ListaEnlazada.h"
#include <iostream>

using namespace std;

ListaEnlazada::ListaEnlazada(){
    this->primero = nullptr;
    this->ultimo = nullptr;
}

Nodo *ListaEnlazada::getPrimero(){
    return primero;
}
Nodo *ListaEnlazada::getUltimo(){
    return this->ultimo;
}

void ListaEnlazada::setPrimero(Nodo* primero){
    this->primero = primero;
}

void ListaEnlazada::setUltimo(Nodo* ultimo){
    this->ultimo = ultimo;
}

void ListaEnlazada::insertarNodo(int posX, int posY){
    Nodo* nuevo = new Nodo(posX, posY);
    if(primero == nullptr){
        primero = nuevo;
        ultimo = nuevo;
    }else{
        nuevo->setPrevio(ultimo);
        ultimo->setSiguiente(nuevo);
        ultimo = nuevo;
    }
}

Nodo* ListaEnlazada::buscarNodo(int posX, int posY){
    Nodo* actual = primero;
    while(actual != nullptr && actual->getPosX() != posX && actual->getPosY() != posY){
        actual = actual->getSiguiente();
    }

    if(actual != nullptr){
        return actual;
    }else{
        return nullptr;
    }
}

void ListaEnlazada::imprimir(){
    Nodo* actual = primero;
    if(actual != nullptr){
        while(actual != nullptr){
            cout<< actual->getPosX() <<"-"<< actual->getPosY()<<endl;
            actual = actual->getSiguiente();
        }
    }else{
        cout<<"La lista se encuentra vacía";
    }
}


ListaEnlazada::~ListaEnlazada() {
}

