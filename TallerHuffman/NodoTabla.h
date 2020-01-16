
#ifndef NODOTABLA_H
#define NODOTABLA_H
#include <string>
#include <iostream>
using namespace std;

class NodoTabla {
public:
    NodoTabla(string valor,string ub);
    string getDato();
    string getUbicacion();
    NodoTabla *getSiguiente();
    void setDato(string dato);
    void setUbicacion(string ubicacion);
    void setSiguiente(NodoTabla *siguiente);
    virtual ~NodoTabla();
private:
    string Dato;
    string ubicacion;
    NodoTabla *siguiente;

};

#endif /* NODOTABLA_H */

