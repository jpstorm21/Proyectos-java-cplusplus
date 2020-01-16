/* 
 * File:   Nodo.cpp
 * 
 * A continuación se implementan las funciones de la clase Nodo.
 */

#include <cstdlib>
#include "Nodo.h"

/**
 * Constructor por defecto, inicializa con un dato y con sus dos nodos hijos
 * apuntando a nulo.
 */
template <class T>
Nodo<T>::Nodo(T dato) {
    this->dato = dato;
    this->derecha = NULL;
    this->izquierda = NULL;
}

/**
 * Destructor de la clase. Elimina sus componentes, si no son nulas.
 */
template <class T>
Nodo<T>::~Nodo(){
    if(this->derecha != NULL){
        derecha->~Nodo();
    }
    if(this->izquierda != NULL){
        izquierda->~Nodo();
    }
}

/**
 * Asigna un nodo hijo a la derecha del nodo.
 * @param derecha Nodo que ocupará la posición de hijo derecho.
 */
template <class T>
void Nodo<T>::setDerecha(Nodo* derecha) {
    this->derecha = derecha;
}

/**
 * Asigna un nodo hijo a la izquierda del nodo.
 * @param derecha Nodo que ocupará la posición de hijo izquierdo.
 */
template <class T>
void Nodo<T>::setIzquierda(Nodo* izquierda) {
    this->izquierda = izquierda;
}

/**
 * Entrega el nodo hijo derecho.
 * @return hijo derecho del nodo, corresponde a un puntero a un nodo.
 */
template <class T>
Nodo<T>* Nodo<T>::getDerecha() {
    return this->derecha;
}

/**
 * Entrega el nodo hijo izquierdo.
 * @return hijo izquierdo del nodo, corresponde a un puntero a un nodo.
 */
template <class T>
Nodo<T>* Nodo<T>::getIzquierda() {
    return this->izquierda;
}

/**
 * Entrega el dato almacenado en el nodo.
 * @return dato del nodo.
 */
template <class T>
T Nodo<T>::getDato(){
    return this->dato;
}

/**
 * Se asigna un dato al nodo.
 * @param dato Objeto de clase genérica "T" que se almacenará en el nodo.
 */
template <class T>
void Nodo<T>::setDato(T dato){
    this->dato = dato;
}

template class Nodo<int>;