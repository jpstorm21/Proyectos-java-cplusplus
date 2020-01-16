/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Vendedor.h
 * Author: Usuario
 *
 * Created on 8 de septiembre de 2017, 22:42
 */
#ifndef VENDEDOR_H
#define VENDEDOR_H
#include <string>
#include <iostream>
using namespace std;

class Vendedor {
public:
    Vendedor();
    Vendedor(string nombre,int ventas);
    string getNombre();
    int getVentas();
    void setNombre(string nombre);
    void setVentas(int ventas);
    virtual ~Vendedor();
private:
    string nombre;
    int ventas;

};

#endif /* VENDEDOR_H */

