/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Juan Pablo Martinez
 *
 * Created on 28 de mayo de 2018, 19:43
 */

#include <cstdlib>
#include "Cola.h"
#include <iostream>
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    Cola *c =  new Cola();
    c->ingresar(5,3);
    c->ingresar(6,1);
    c->ingresar(7,2);
    c->imprimir();
    c->eliminar();
    cout<<"-----------------"<<endl;
    c->imprimir();
    return 0;
}

