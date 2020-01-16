/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Estandar.h
 * Author: ASUS
 *
 * Created on 13 de febrero de 2018, 16:34
 */

#ifndef ESTANDAR_H
#define ESTANDAR_H
#include <string>
#include "Barco.h"
using namespace std;
class Estandar:public Barco{
public:
    Estandar(string nombreBarco, string nombrePiloto, string tipoBarco, string paisOrigen,
        string carga, int cantidadContainers, int cantidadCarga, string horaLlegada);
    virtual ~Estandar();
private:

};

#endif /* ESTANDAR_H */

