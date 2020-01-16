
#ifndef NODOARBOL_H
#define NODOARBOL_H
#include <string.h>
#include <iostream>

using namespace std;


class NodoArbol {
public:
    NodoArbol(string palabra);
    NodoArbol(string palabra,int frecuencia);
    string getPalabra();
    int getFrecuencia();
    NodoArbol *getIzquierdo();
    NodoArbol *getDerecho();
    int getDireccion();
    void setDireccion(int direccion);
    void setPalabra(string palabra);
    void setFrecuencia(int frecuencia);
    void setIzquiero(NodoArbol *izquierdo);
    void setDerecho(NodoArbol *derecho);
    virtual ~NodoArbol();
private:
    string palabra;
    int frecuencia;
    NodoArbol *izquierdo;
    NodoArbol *derecho;
    int direccion;
};

#endif /* NODOARBOL_H */

