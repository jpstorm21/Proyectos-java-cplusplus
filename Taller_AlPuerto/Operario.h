/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Operario.h
 * Author: Juan Pablo Martinez Romero
 *
 * 
 */

#ifndef OPERARIO_H
#define OPERARIO_H
#include <string.h>
#include <iostream>
using namespace std;

class Operario {
public:
    Operario(string nombre, string cedulaIdentidad, int horasTrabajadas,int estado);
    Operario(const Operario& orig);
    string getNombre();
    string getCedulaIdentidad();
    int getHorasTrabajadas();
    int getEstado();
    void setNombre(string nombre);
    void setCedulaIdentidad(string cedulaIdentidad);
    void setEstado(int estado);
    void setHorasTrabajadas(int horasTrabajadas); 
    virtual ~Operario();
private:
    string nombre;
    string cedulaIdentidad;
    int horasTrabajadas;
    int estado;
};

#endif /* OPERARIO_H */

