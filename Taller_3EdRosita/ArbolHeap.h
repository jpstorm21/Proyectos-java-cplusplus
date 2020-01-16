/* 
 * File:   ArbolHeap.h
 *
 * Clase que define un arbol binario que se mantiene ordenado con la técnica
 * "heap sort". Funciona como un montículo, y por la forma en la que se obtienen
 * los datos, puede ser usado como una cola con prioridad. El tipo de datos que
 * almacena, al ser organizados por el nodo genérico para árboles, debe cumplir
 * con los mismos requicitos que los datos que se almacenan en la clase Nodo.
 */

#ifndef ARBOLHEAP_H
#define ARBOLHEAP_H

#include "Nodo.h"

template <class T> class ArbolHeap {
public:
    // Métodos públicos:
    ArbolHeap(); // Constructor.
    virtual ~ArbolHeap(); // Destructor.
    void agregar(T dato); // Agregar un dato al árbol.
    T sacar(); // Obtiene el dato con mayor valor del árbol, el cual luego se elimina.
    int getCantDatos(); // Obtiene la cantidad de datos almacenados en el árbol.
    int getAltura(); // Obtiene el número de niveles del árbol, es decir, su altura.

private:
    // Métodos privados:
    bool agregarRecursivo(Nodo<T>* current, int nivel, T dato); // Auxiliar para el método agregar.
    void intercambioDatos(Nodo<T>* superior, Nodo<T>* inferior); // Intercambia los datos de dos nodos.
    bool sacarIterativo(); // Caso especial del método sacar, cuando el árbol tiene un balance de 0 para todos sus nodos.
    bool sacarRecursivo(Nodo<T>* current, int nivel); // Caso común del método sacar.
    void reordenar(Nodo<T>* current); // Reordena los valores del árbol para dejarlo nuevamente como una cola con prioridad (o montículo).
    void corregirNiveles(); // Reasigna el parámetro "nivels" después de haber agregado o sacado un dato.
    
    // Parámetros:
    Nodo<T>* raiz; // Nodo inicial del árbol, almacena siempre el mayor valor de todos.
    int cantNodos; // Cantidad de nodos, equivalente a la cantidad de datos
    int niveles; // Funciona como auxiliar de los métodos agregarRecursivo y eliminarRecursivo. No es un representante real de la altura del árbol.
};

#endif

