
#ifndef CLIENTE_H
#define CLIENTE_H
#include <string.h>
#include <iostream>
#include "Venta.h"
#include "NodoVenta.h"
#include "ListaVentas.h"
using namespace std;

class Cliente {
public:
    Cliente(string rut, string nombre, string direccion, string correo);
    string getRut();
    string getNombre();
    string getDireccion();
    string getCorreo();
    void setRut(string rut);
    void setNombre(string nombre);
    void setDireccion(string direccion);
    void setCorreo(string correo);
    virtual ~Cliente();
private:
    string rut;
    string nombre;
    string direccion;
    string correo;
    ListaVentas *lv;
 
};

#endif /* CLIENTE_H */

