/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Persona.h
 * Author: Usuario
 *
 * Created on 12 de abril de 2017, 22:00
 */
#include <string>
using namespace std;
#ifndef PERSONA_H
#define PERSONA_H



class Persona {
private:
    string nombre;
    int edad;
public:
    Persona();
    Persona(int edad,string nombre);
    virtual ~Persona();
    int getEdad();
    void setEdad(int edad);
    string getNombre();
    void setNombre(string nombre);

    

};

#endif /* PERSONA_H */

