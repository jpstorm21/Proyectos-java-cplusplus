/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Amigo.h
 * Author: Usuario
 *
 * Created on 9 de septiembre de 2017, 20:18
 */

#ifndef AMIGO_H
#define AMIGO_H
#include <string>
#include <iostream>
using namespace std;
class Amigo {
public:
    Amigo();
    Amigo(string nombre);
    string getNombre();
    void setNombre(string nombre);
    virtual ~Amigo();
private:
    string nombre;
};

#endif /* AMIGO_H */

