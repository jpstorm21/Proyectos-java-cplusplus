
#ifndef ARBOL_H
#define ARBOL_H
#include "NodoArbol.h"
#include <string>
#include <iostream>
#include <fstream>
using namespace std;

class Arbol {
public:
    Arbol(string s, int suma);
    Arbol();
    NodoArbol *getRaiz();
    void setRaiz(NodoArbol *raiz);
    void agregarHojas(NodoArbol *izquierdo,NodoArbol *derecho);
    void imprimir(NodoArbol *nodo, int nivel);
    string buscarrec(string palabra,NodoArbol *actual);
    void imprimirTXT(NodoArbol *nodo, int nivel,ofstream &archivo);
    virtual ~Arbol();
private:
    NodoArbol *raiz;
   string buscar(string palabra,NodoArbol *actual,string palabrar);
};

#endif /* ARBOL_H */

