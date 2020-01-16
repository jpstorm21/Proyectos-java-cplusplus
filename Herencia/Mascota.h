/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Mascota.h
 * Author: Usuario
 *
 * Created on 4 de octubre de 2017, 23:18
 */

#ifndef MASCOTA_H
#define MASCOTA_H
#include <string>
#include <iostream>
#include <cstdlib>
using namespace std;
class Mascota {
public:
    Mascota();
    Mascota(string nombre);
    string getNombre();

    void setNombre(string);

    virtual ~Mascota();
protected:
    string nombre;

};

#endif /* MASCOTA_H */

