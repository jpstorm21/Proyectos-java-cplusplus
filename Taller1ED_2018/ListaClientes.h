

#ifndef LISTACLIENTES_H
#define LISTACLIENTES_H
#include "NodoCliente.h"
#include <string.h>
#include <iostream>
using namespace std;
class ListaClientes {
public:
    ListaClientes();
    NodoCliente *getFirst();
    NodoCliente *getLast();
    void setFirst(NodoCliente*);
    void setLast(NodoCliente*);
    void ingresarCliente(Cliente *C);
    Cliente* buscarCliente(string rut);
    bool eliminarCliente(string rut);
    virtual ~ListaClientes();
private:
    NodoCliente *first;
    NodoCliente *last;

};

#endif /* LISTACLIENTES_H */

