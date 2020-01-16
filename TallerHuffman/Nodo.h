
#ifndef NODO_H
#define NODO_H
#include <string>
#include <iostream>
using namespace std;

class Nodo {
public:
    Nodo(string palabra);
    string getPalabra();
    void setPalabra(string palabra);
    Nodo *getSiguiente();
    void setSiguiente(Nodo *siguiente);
    virtual ~Nodo();
private:
    string palabra;
    Nodo *siguiente;
};

#endif /* NODO_H */

