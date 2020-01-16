/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Arbol_AVL.h
 * Author: Juan Pablo Martinez
 *
 * Created on 5 de junio de 2018, 20:28
 */

#ifndef ARBOL_AVL_H
#define ARBOL_AVL_H

#include "Nodo.h"//Utilizacion para almacenamiento, define raiz, ramas(subarboles)y hojas.
#include <string>//Utilizacion de NULL.
#include <iostream>//Utilizacion de "cout" para impreciones.


template <class T> class Arbol_AVL {
public:
    Arbol_AVL();//Constructor.
    ~Arbol_AVL();//Destructor.
    Nodo<T>* getRaiz();//retorna raiz.
    int altura();//Entrega la altura total del arbol.
    void imprimir(int tipo);//imprime. tipo: 0 arbol completo, 1 inorden, 2 preorden, 3 postorden.
    void agregar(T dato);//Almacena un dato en la estructura.
    void eliminar(T dato);
private:
    Nodo<T>* removerDatoMayor(Nodo<T>* actual);
    Nodo<T>* agregarRecursivo(Nodo<T>* raiz,Nodo<T>* nuevo);//inserta en el arbol por recurcion.
    Nodo<T>* eliminarRecursivo(Nodo<T>* actual, T dato);
    int alturaRecursivo(Nodo<T>* raiz);//entrega la altura desde la raiz del arbol o del subarbol.
    void mostrar(Nodo<T>* raiz,int nivel);//Imprime un arbol o subarbol, espesificando el nivel en el que está. 
    void inOrden(Nodo<T>* raiz);//Imprime en inorden.
    void preOrden(Nodo<T>* raiz);//Imprime en preorden.
    void postOrden(Nodo<T>* raiz);//Imprime en postorden.
    Nodo<T>* balanceo(Nodo<T>* raiz);//Balancea el arbol en caso de desbalanceo.
    int desbalance(Nodo<T>* raiz);//Calcula el desbalance que tiene un arbol.
    Nodo<T>* rotacion_DER(Nodo<T>* raiz);//Rota a la derecha.
    Nodo<T>* rotacion_IZQ(Nodo<T>* raiz);//rota a la izquierda.
    Nodo<T>* rotacion_IZQ_DER(Nodo<T>* raiz);//Rota primero a la izquierda y luego a la derecha.
    Nodo<T>* rotacion_DER_IZQ(Nodo<T>* raiz);//Rota primero a la derecha y luego a la izquierda.

    Nodo<T>* raizArbol;//Raiz del arbol.
};

#endif /* ARBOL_AVL_H */

