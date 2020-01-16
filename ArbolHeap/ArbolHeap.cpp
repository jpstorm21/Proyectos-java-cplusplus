#include <iostream>
#include <math.h>
#include "ArbolHeap.h"
using namespace std;

ArbolHeap::ArbolHeap(){
	start = NULL;
	cantNodos = 0;
	contNivel=0;
}

void ArbolHeap::insertar(int value){
	if (start == NULL){
		start = new Nodo (value);
		cantNodos++;
		contNivel++;
	} else {
		insertarRecursivo(start, 1, value);
	}
}

bool ArbolHeap::insertarRecursivo(Nodo* cursor, int nivel, int value){
	if (nivel == contNivel){
		if (cursor->getIzquierdo() == NULL){
			cursor->setIzquierdo(new Nodo(value));
			cantNodos++;
			intercambiarValores(cursor, cursor->getIzquierdo());
			if(cantNodos+1==pow(2,contNivel+1)){
				contNivel++;
			}
			return true;
		} else if (cursor->getDerecho() == NULL){
			cursor->setDerecho(new Nodo(value));
			cantNodos++;
			intercambiarValores(cursor, cursor->getDerecho());
			if(cantNodos+1==pow(2,contNivel+1)){
				contNivel++;
			}
			return true;
		} else {
			return false;
		}
	} else {
		bool correcto = insertarRecursivo(cursor->getIzquierdo(), nivel+1, value);
		if (correcto){
			intercambiarValores(cursor, cursor->getIzquierdo());
			return true;
		} else {
			correcto = insertarRecursivo(cursor->getDerecho(), nivel+1, value);
			if (correcto){
				intercambiarValores(cursor, cursor->getDerecho());
				return true;
			}
			return false;
		}
		
		
	}
}

void ArbolHeap::intercambiarValores(Nodo* actual, Nodo* bajo){
	if (actual->getDato() < bajo->getDato()){
		int temp = actual->getDato();
		actual->setDato(bajo->getDato());
		bajo->setDato(temp);
	}
}

int ArbolHeap::eliminar(){
	int valor = start->getDato();
	eliminarNodoRecursivo(start, 1);
	ordenarArbol(start);
	return valor;
}

bool ArbolHeap::eliminarNodoRecursivo(Nodo* cursor, int nivel){
	if (nivel == contNivel){
		if (cursor->getDerecho() != NULL){
			start->setDato(cursor->getDerecho()->getDato());
			Nodo* eliminar = cursor->getDerecho();
			delete eliminar;
			cursor->setDerecho(NULL);
			cantNodos--;
			if(cantNodos+1==pow(2,contNivel)){
				contNivel--;
			}
			return true;
		} else if (cursor->getIzquierdo() != NULL){
			start->setDato(cursor->getIzquierdo()->getDato());
			Nodo* eliminar = cursor->getIzquierdo();
			delete eliminar;
			cursor->setIzquierdo(NULL);
			cantNodos--;
			if(cantNodos+1==pow(2,contNivel)){
				contNivel--;
			}
			return true;
		} else {
			return false;
		}
	} else {
		if (eliminarNodoRecursivo(cursor->getDerecho(), nivel+1)){
			return true;
		} else {
			return eliminarNodoRecursivo(cursor->getIzquierdo(), nivel+1);
		}
	}
}

void ArbolHeap::ordenarArbol(Nodo* cursor){
	if (cursor->getDerecho()->getDato() > cursor->getIzquierdo()->getDato() ){
		if (cursor->getDato() < cursor->getDerecho()->getDato()){
			intercambiarValores(cursor, cursor->getDerecho());
			ordenarArbol(cursor->getDerecho());
		} else if (cursor->getDato() < cursor->getIzquierdo()->getDato()){
			intercambiarValores(cursor, cursor->getIzquierdo());
			ordenarArbol(cursor->getIzquierdo());
		} else {
			return;
		}
	} else {
		if (cursor->getDato() < cursor->getIzquierdo()->getDato()){
			intercambiarValores(cursor, cursor->getIzquierdo());
			ordenarArbol(cursor->getIzquierdo());
		} else if (cursor->getDato() < cursor->getDerecho()->getDato()){
			intercambiarValores(cursor, cursor->getDerecho());
			ordenarArbol(cursor->getDerecho());
		} else {
			return;
		}
	}
}

void ArbolHeap::guardarEnArreglo(int* arreglo, Nodo* cursor, int posicion){
	arreglo[posicion] = cursor->getDato();
	if (cursor->getIzquierdo() != NULL){
		guardarEnArreglo(arreglo, cursor->getIzquierdo(), 2*posicion + 1);
	}
	if (cursor->getDerecho() != NULL){
		guardarEnArreglo(arreglo, cursor->getDerecho(), 2*posicion + 2);
	}
}


void ArbolHeap::imprimir(){
	int valores[cantNodos];
	guardarEnArreglo(valores, start, 0);
	for (int i=0;i<cantNodos;i++){
		cout << valores[i] << " ";
	}
	cout << endl;
}