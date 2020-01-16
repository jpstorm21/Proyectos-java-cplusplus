/* 
 * File:   Cola.h
 * Declaraci?n de clase template cola, TDA que usa una lista de nodos de
 * tipo clase Elemento, para administrar una lista con punteros
 * Author: Carlos
 * Created on 1 de octubre de 2016, 09:52 PM
 */

#ifndef COLA_H
#define	COLA_H

#include "Elemento.h"
#include <iostream>
using namespace std;

template <class Tipo> class Cola {
public:
    Cola();
    void ingresaCola(Tipo dato);
    void sacaCola();
    Tipo muestraCola();
    bool isEmpty();
private:
    Elemento<Tipo> *frente;
    Elemento<Tipo> *posterior;

};

#endif	/* COLA_H */
