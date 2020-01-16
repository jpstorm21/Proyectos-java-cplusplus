#ifndef NODOABB_H
#define NODOABB_H
#include "Contribuyente.h"

class NodoABB {
public:
    NodoABB();
    NodoABB(Contribuyente *c);
    NodoABB *getHijoIzq();
    NodoABB *getHijoDer();
    Contribuyente *getContribuyente();
    void setHijoIzq(NodoABB* hijoIzq);
    void setHijoDer(NodoABB* hijoDer);
    void setContribuyente(Contribuyente* c);
    virtual ~NodoABB();
private:
    NodoABB *hijoIzq;
    NodoABB *hijoDer;
    Contribuyente *c;

};

#endif /* NODOABB_H */

