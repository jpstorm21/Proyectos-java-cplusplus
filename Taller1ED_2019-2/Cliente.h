/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Cliente.h
 * Author: Juan Pablo Martinez
 *
 * Created on 18 de septiembre de 2019, 16:47
 */

#ifndef CLIENTE_H
#define CLIENTE_H

#include <string>
#include <iostream>

using namespace std;

class Cliente {
    
    public:
        Cliente(string nombre, int fondo);
        string getNombre();
        int getFondos();
        void setNombre(string nombre);
        void setFondo(int fondos);
        virtual ~Cliente();
    private:
        string nombre;
        int fondos;
        
};

#endif /* CLIENTE_H */

