
#ifndef LISTAARBOL_H
#define LISTAARBOL_H
#include "NodoListaArbol.h"
#include "Arbol.h"
#include "Lista.h"
#include "Nodo.h"
#include "ListaTabla.h"
class ListaArbol {
public:
    ListaArbol();
    NodoListaArbol *getInicio();
    void setInicio(NodoListaArbol *inicio);
    void agregarOrdenados(Arbol *arbol);
    void armarLista(Lista *l);
    bool buscar(string palabra);
    NodoArbol *sacarInicio();
    void obtenerArbol();
    ListaTabla *obtenerHojas(string ubicacion,ListaTabla *tabla,NodoArbol *raiz);
    virtual ~ListaArbol();
private:
    NodoListaArbol *inicio;
};

#endif /* LISTAARBOL_H */

