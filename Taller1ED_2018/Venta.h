/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Venta.h
 * Author: Casa
 *
 * Created on 27 de abril de 2018, 12:33
 */

#ifndef VENTA_H
#define VENTA_H
#include <string.h>
#include <iostream>
#include "Cliente.h"
#include "NodoCliente.h"
#include "ListaClientes.h"
#include "ListaJuegos.h"
using namespace std;

class Venta {
public:
    Venta(string metodoPago);
    string getMetodoPago();
    void setMetodoPago(string metodoPago);
    Cliente *getCliente();
    void setCliente(Cliente *cliente);
    ListaJuegos *getLj();
    void setLj(ListaJuegos *lj);
    virtual ~Venta();
private:
    Cliente *cliente;
    ListaJuegos *lj;
    string metodoPago;

};

#endif /* VENTA_H */

