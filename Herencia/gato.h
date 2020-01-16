/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   gato.h
 * Author: Usuario
 *
 * Created on 4 de octubre de 2017, 23:26
 */

#ifndef GATO_H
#define GATO_H
#include <string>
#include <iostream>
#include "Mascota.h"
using namespace std;
class gato : public Mascota {
public:
    gato();
    gato(string raza,string nombre);
    string getRaza();
    void setRaza(string);
    virtual ~gato();
private:
    string raza;

};

#endif /* GATO_H */

