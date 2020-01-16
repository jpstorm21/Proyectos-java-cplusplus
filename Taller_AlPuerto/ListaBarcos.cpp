/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaBarcos.cpp
 * Author: ASUS
 * 
 * Created on 14 de febrero de 2018, 0:51
 */

#include "ListaBarcos.h"
#include <cstdlib>
ListaBarcos::ListaBarcos(int max) {
    this->lb = new Barco *[max];
    this->cant = 0;
    this->max = max;
}

ListaBarcos::ListaBarcos(const ListaBarcos& orig) {
}

Barco* ListaBarcos::getBarco(int i) {
    return this->lb[i];

}

int ListaBarcos::getCant() {
    return this->cant;
}

bool ListaBarcos::ingresarBarco(Barco* B) {
    if(cant>= max){
        return false;
    }else{
        this->lb[cant] = B;
        this->cant++;
        return true;
    }
}

Barco* ListaBarcos::buscarBarco(string nombre) {
    int i;
    for(i =0;i<cant;i++){
        if(this->lb[i]->getNombreBarco() == nombre){
            break;
        }
    }
    if(i == cant){
        return NULL;
    }else{
        return this->lb[i];
    }
}



ListaBarcos::~ListaBarcos() {
}

