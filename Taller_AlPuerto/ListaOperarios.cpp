/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaOperarios.cpp
 * Author: Juan Pablo Martinez Romero
 * 
 * 
 */

#include "ListaOperarios.h"
#include <cstdlib>
ListaOperarios::ListaOperarios(int max) {
    this->lo =  new Operario *[max];
    this->cant =0;
    this->max = max;
}

ListaOperarios::ListaOperarios(const ListaOperarios& orig) {
}

int ListaOperarios::getCant() {
    return this->cant;
}

Operario* ListaOperarios::getOperario(int i) {
    return this->lo[i];
}

bool ListaOperarios::ingresarOperario(Operario* O) {
    if(cant >= max){
        return false;
    }else{
        this->lo[cant] = O;
        this->cant++;
        return true;
    }
}

Operario* ListaOperarios::buscarOperario(string nombre) {
    int i;
    for(i = 0;i<cant;i++){
        if(this->lo[i]->getNombre() == nombre){
            break;
        }
    }
    if(i== cant){
        return NULL;
    }else{
        return this->lo[i];
    }
}



ListaOperarios::~ListaOperarios() {
}

