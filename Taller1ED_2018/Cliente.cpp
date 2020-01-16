

#include "Cliente.h"
#include <string.h>
#include "Venta.h"
#include "NodoVenta.h"
#include "ListaVentas.h"
#include <iostream>
using namespace std;
Cliente::Cliente(string rut, string nombre, string direccion, string correo) {
    this->rut=rut;
    this->nombre=nombre;
    this->direccion=direccion;
    this->correo=correo;
    
}

string Cliente::getRut() {
    return rut;
}

string Cliente::getNombre() {
    return nombre;
}

string Cliente::getDireccion() {
    return direccion;
}

string Cliente::getCorreo() {
    return correo;
}

void Cliente::setRut(string rut) {
    this->rut=rut;
}

void Cliente::setNombre(string nombre) {
    this->nombre=nombre;
}

void Cliente::setDireccion(string direccion) {
    this->direccion=direccion;
}

void Cliente::setCorreo(string correo) {
    this->correo=correo;
}


Cliente::~Cliente() {
}

