

#ifndef NODOLISTAARBOL_H
#define NODOLISTAARBOL_H
#include "Arbol.h"
class NodoListaArbol {
public:
    NodoListaArbol(Arbol *valor);
    Arbol *getArbol();
    void setArbol(Arbol *arbol);
    NodoListaArbol *getSiguiente();
    void setSeguiente(NodoListaArbol *siguiente);
    virtual ~NodoListaArbol();
private:
    Arbol *arbol;
    NodoListaArbol *siguiente;
};

#endif /* NODOLISTAARBOL_H */

