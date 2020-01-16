
#ifndef LISTA_H
#define LISTA_H
#include "Nodo.h"
#include <string>
#include <iostream>
using namespace std;
class Lista {
public:
    Lista();
    void agrear(string palabra);
    Nodo *getInicio();
    int contarIguales(string palabra);
    void setInicio(Nodo *inicio);
    bool eliminar(string palabra);
    virtual ~Lista();
private:
    Nodo *inicio;
};

#endif /* LISTA_H */

