/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoGrua.h
 * Author: ASUS
 *
 * Created on 13 de febrero de 2018, 16:46
 */

#ifndef NODOGRUA_H
#define NODOGRUA_H
#include "Grua.h"
using namespace std;
class NodoGrua {
public:
    NodoGrua(Grua *grua);
    NodoGrua(const NodoGrua& orig);
    NodoGrua *getNext();
    NodoGrua *getPrev();
    void setNext(NodoGrua *);
    void setPrev(NodoGrua *);
    Grua *getGrua();
    void setGrua(Grua *);
    virtual ~NodoGrua();
private:
    Grua *grua;
    NodoGrua *previo;
    NodoGrua *next;

};

#endif /* NODOGRUA_H */

