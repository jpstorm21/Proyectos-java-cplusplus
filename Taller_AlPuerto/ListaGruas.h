/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ListaGruas.h
 * Author: ASUS
 *
 * Created on 13 de febrero de 2018, 16:52
 */

#ifndef LISTAGRUAS_H
#define LISTAGRUAS_H
#include "Grua.h"
#include "NodoGrua.h"
#include <string>
using namespace std;
class ListaGruas {
public:
    ListaGruas();
    ListaGruas(const ListaGruas& orig);
    NodoGrua *getFirst();
    NodoGrua *getLast();
    void setFirst(NodoGrua *);
    void setLast(NodoGrua *);
    void ingresarGrua(Grua *grua);
    Grua *buscarGrua(string codigo);
    bool eliminarGrua(string codigo);
    virtual ~ListaGruas();
private:
    NodoGrua *first;
    NodoGrua *last;

};

#endif /* LISTAGRUAS_H */

