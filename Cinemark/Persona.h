/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Persona.h
 * Author: ASUS
 *
 * Created on 4 de febrero de 2018, 19:25
 */

#ifndef PERSONA_H
#define PERSONA_H

#include <string>
using namespace std;
class Persona {
public:
    Persona(string nombre, int rut);
    Persona(const Persona& orig);
    string getNombre();
    void setNombre(string nombre);
    int getRut();
    void setRut(int rut);
    virtual ~Persona();
private:
    string nombre;
    int rut;

};

#endif /* PERSONA_H */

