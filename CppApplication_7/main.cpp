/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Usuario
 *
 * Created on 12 de abril de 2017, 21:43
 */

#include <iostream>
#include <string>
#include "Persona.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    int edad;
    string nombre;
    cout<<"ingrese edad: " ;
    cin>>edad;
    cout<<"ingrese nombre: ";
    cin>>nombre;
    Persona p = Persona(edad,nombre);
    cout<<"su edad es: " << p.getEdad() <<endl ;
    cout<<"su nombre es : " << p.getNombre() << endl;
    string nombre2;
    cout<<"ingrese su segundo nombre : ";
    cin>>nombre2;
    p.setNombre(nombre2);
    cout<<"su nuevo nombre es : " << p.getNombre() << endl;
    return 0;
}

