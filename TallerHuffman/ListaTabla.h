

#ifndef LISTATABLA_H
#define LISTATABLA_H
#include "NodoTabla.h"
#include <string>
#include "Arbol.h"
#include <iostream>
using namespace std;

class ListaTabla {
public:
    ListaTabla();
    NodoTabla *getInicio();
    void setInicio(NodoTabla *inicio);
    void agregar(string valor,string ubicacion);
    NodoTabla *sacarInicio();
    void imprimir();
    string unirTodo(string palabra);
    string ubicacionDe(string dato);
    string palabraDe(string ubicacion);
    string descomprimir(string direcciones,Arbol *nodo);
      bool validarPalabraX(char palabra);
    virtual ~ListaTabla();
private:
    NodoTabla *inicio;
};

#endif /* LISTATABLA_H */

