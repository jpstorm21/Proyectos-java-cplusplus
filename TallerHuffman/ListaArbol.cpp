

#include "ListaArbol.h"
#include <cstdlib>

ListaArbol::ListaArbol() {
    this->inicio = NULL;
}

NodoListaArbol* ListaArbol::getInicio() {
    return this->inicio;
}

void ListaArbol::setInicio(NodoListaArbol* inicio) {
    this->inicio = inicio;
}

void ListaArbol::agregarOrdenados(Arbol* arbol) {
    NodoListaArbol *nuevo = new NodoListaArbol(arbol);
    if (inicio == NULL)
        inicio = nuevo;
    else {
        NodoListaArbol *aux = inicio;
        NodoListaArbol *aux2 = NULL;
        while (aux != NULL && (aux->getArbol()->getRaiz()->getFrecuencia() < nuevo->getArbol()->getRaiz()->getFrecuencia())) {
            aux2 = aux;
            aux = aux->getSiguiente();
        }
        if (aux2 == NULL) {
            nuevo->setSeguiente(inicio);
            inicio = nuevo;
        } else
            if (aux == NULL)
            aux2->setSeguiente(nuevo);
        else {
            aux2->setSeguiente(nuevo);
            nuevo->setSeguiente(aux);
        }
    }
}

bool ListaArbol::buscar(string palabra) {
    NodoListaArbol *actual = inicio;
    bool esta = false;
    while (actual != NULL) {
        if (actual->getArbol()->getRaiz()->getPalabra() == palabra) {
            esta = true;
            break;
        }
        actual = actual->getSiguiente();
    }
    return esta;
}

void ListaArbol::armarLista(Lista* l) {
    Nodo *actual = l->getInicio();
    while (actual != NULL) {
        string palabra = actual->getPalabra();
        int frecuencia = l->contarIguales(palabra);
        bool agregar = buscar(palabra);
        if (!agregar) {
            agregarOrdenados(new Arbol(palabra, frecuencia));
        }
        actual = actual->getSiguiente();
        palabra = "";
        frecuencia = 0;
    }
}

NodoArbol *ListaArbol::sacarInicio() {
    if (this->inicio == NULL) {
        return NULL;
    }
    NodoListaArbol *aux = inicio;
    inicio = aux->getSiguiente();
    aux->setSeguiente(NULL);
    return aux->getArbol()->getRaiz();
}

void ListaArbol::obtenerArbol() {
    NodoArbol *uno = NULL;
    NodoArbol *dos = NULL;
    while (this->inicio->getSiguiente() != NULL) {
        uno = this->sacarInicio();
        dos = this->sacarInicio();
        Arbol *nuevo = new Arbol("", uno->getFrecuencia() + dos->getFrecuencia());
        nuevo->agregarHojas(uno, dos);
        this->agregarOrdenados(nuevo);
    }
}

ListaTabla* ListaArbol::obtenerHojas(string ubicacion, ListaTabla *tabla, NodoArbol* raiz) {
    string s =raiz->getPalabra();
    if (s.empty()) {
        tabla = obtenerHojas(ubicacion + "0", tabla, raiz->getIzquierdo());
        tabla = obtenerHojas(ubicacion + "1", tabla, raiz->getDerecho());
    } else{
        tabla->agregar(raiz->getPalabra(), ubicacion);
    }
    return tabla;
}

ListaArbol::~ListaArbol() {
}

