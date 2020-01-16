/* 
 * File:   Nodo.h
 *
 * Clase nodo necesaria en la implementacion de la clases que definen árboles
 * binarios, tales como el árbol AVL o el árbol heap. almacena un dato cuyo tipo
 * está por definir. Los datos que almacenan los nodos deben ser un tipo de dato
 * que tenga incorporados los operadores igual (=), menor (<) y mayor (>).
 */

#ifndef NODO_H
#define NODO_H

template <class T> class Nodo {
public:
    // Métodos públicos:
    Nodo(T dato); // Constructor.
    virtual ~Nodo(); // Destructor.
    // Setters:
    void setDerecha(Nodo* derecha);
    void setIzquierda(Nodo* izquierda);
    void setDato(T dato);
    
    // Getters:
    Nodo* getDerecha();
    Nodo* getIzquierda();
    T getDato();
private:
    // Parámetros, son todos privados:
    T dato; // Dato almacenado.
    Nodo* derecha; // Nodo hijo derecho.
    Nodo* izquierda; // Nodo hijo izquierdo.
};

#endif

