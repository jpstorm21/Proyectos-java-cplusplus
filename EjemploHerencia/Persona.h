/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Persona.h
 * Author: Juan Pablo Martinez
 *
 * Created on 8 de marzo de 2018, 1:36
 */

#ifndef PERSONA_H
#define PERSONA_H
#include <string.h>
#include <iostream>
using namespace std;
class Persona {
public:
    Persona(string nombre,int edad);
    Persona(const Persona& orig);
    int getEdad();
    string getNombre();
    void setEdad(int edad);
    void setNombre(string nombre);
    virtual ~Persona();
private:
    string nombre;
    int edad;

};

#endif /* PERSONA_H */

