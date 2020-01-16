
#ifndef LISTAENLAZADA_H
#define LISTAENLAZADA_H
#include  "Nodo.h"
#include <string>
#include <iostream>
using namespace std;
class ListaEnlazada {
public:
    ListaEnlazada();
    Nodo *getLast();
    void setLast(Nodo *last);
    void ingresar(int i,int j,int vecinos,int estadoActual, string nombreRegla);
    void buscar();
    bool eliminar();
    virtual ~ListaEnlazada();
private:
    Nodo *last;
};

#endif /* LISTAENLAZADA_H */

