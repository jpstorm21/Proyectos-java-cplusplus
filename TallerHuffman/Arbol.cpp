
#include "Arbol.h"
#include <cstdlib>
#include <cstring>

Arbol::Arbol(string s, int suma) {
    this->raiz = new NodoArbol(s, suma);
}

Arbol::Arbol() {
    this->raiz = NULL;
}

NodoArbol* Arbol::getRaiz() {
    return this->raiz;
}

void Arbol::setRaiz(NodoArbol* raiz) {
    this->raiz = raiz;
}

void Arbol::agregarHojas(NodoArbol* izquierdo, NodoArbol *derecho) {
    izquierdo->setDireccion(0);
    derecho->setDireccion(1);
    this->raiz->setIzquiero(izquierdo);
    this->raiz->setDerecho(derecho);
}

string Arbol::buscarrec(string palabra, NodoArbol *actual) {
    string resultado = "";
    string palabrar = "";
    return resultado = buscar(palabra, actual, palabrar);
}

string Arbol::buscar(string palabra, NodoArbol* actual, string palabrar) {
    int pos = 0;
    while (actual != NULL) {
        if (palabra[pos] == '0') {
            if (pos == palabra.length() - 1) {
                palabrar = palabrar + actual->getIzquierdo()->getPalabra();
            } else {
                actual = actual->getIzquierdo();
            }
            pos++;
        } else {
            if (pos == palabra.length() - 1) {
                palabrar = palabrar  + actual->getDerecho()->getPalabra();
            } else {
                actual = actual->getDerecho();
            }
            pos++;
        }
    }
    return palabrar;
}

void Arbol::imprimir(NodoArbol *nodo, int nivel) {
    int i;
    if (nodo != NULL) {
        imprimir(nodo->getDerecho(), nivel + 1);
        std::cout << "\n";
        if (nodo == this->raiz)
            std::cout << "raiz -> ";
        for (i = 0; i < nivel && nodo != this->raiz; i++)
            std::cout << "        ";
        std::cout << nodo->getPalabra() << " " << nodo->getFrecuencia();
        //std::cout << "( f: "<<nodo->getFrecuencia()<<" - p: "<<nodo->getPalabra()<<" )";
        imprimir(nodo->getIzquierdo(), nivel + 1);
    }
}

void Arbol::imprimirTXT(NodoArbol* nodo, int nivel, ofstream& archivo) {
    int i;
    if (nodo != NULL) {
        imprimirTXT(nodo->getDerecho(), nivel + 1,archivo);
        archivo << endl;
        if (nodo == this->raiz)
            archivo << "raiz -> ";
        for (i = 0; i < nivel && nodo != this->raiz; i++)
            archivo << "        ";
        archivo << nodo->getPalabra() << " " << nodo->getFrecuencia();
        imprimirTXT(nodo->getIzquierdo(), nivel + 1,archivo);
    }
}

Arbol::~Arbol() {
}

