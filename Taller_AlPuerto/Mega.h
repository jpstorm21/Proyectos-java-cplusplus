/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Mega.h
 * Author: ASUS
 *
 * Created on 13 de febrero de 2018, 16:39
 */

#ifndef MEGA_H
#define MEGA_H
#include <string>
#include "Barco.h"
using namespace std;

class Mega : public Barco {
public:
    Mega(string nombreBarco, string nombrePiloto, string tipoBarco, string paisOrigen,
            string carga, int cantidadContainers, int cantidadCarga, string horaLlegada, int cantidadTrabajadores, string ciudadOrigen);
    int getCantidaTrabajadores();
    void setCantidadTrabajadores(int cantidadTrabajadores);
    string getCiudadOrigen();
    void setCiudadOrigen(string ciudadOrigen);
    virtual ~Mega();
private:
    int cantidadTrabajadores;
    string ciudadOrigen;

};

#endif /* MEGA_H */

