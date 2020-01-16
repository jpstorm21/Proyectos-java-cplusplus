
#ifndef NODO_H
#define NODO_H
#include <string>
#include "Celula.h";
#include <iostream>
using namespace std;
class Nodo {
public:
    Nodo(int i,int j,int vecinos,int estadoActual,string nombreRegla);
    Nodo *getNext();
    int getRule();
    Celula *getCelula();
    string getName();
    void setVecinos(int vecinos);
    void setNext(Nodo *next);
    int aplicarRule(int,int);
    virtual ~Nodo();
private:
    Nodo *next;
    Celula *c;
    int vecinos;
    string name;
};

#endif /* NODO_H */

