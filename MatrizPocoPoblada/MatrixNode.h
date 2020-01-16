#ifndef MATRIXNODE_H
#define MATRIXNODE_H

#include <cstdio>

class MatrixNode{
	public:
		int datoGuardado;	// Dato que almacena el nodo de la matriz
		
		int numColumna;		// Columna en la que el nodo se posiciona
		int numFila;		// Fila en la que el nodo se posiciona
	
		MatrixNode* nodoDerecha;	// puntero al nodo ubicado a la derecha
		MatrixNode* nodoAbajo;	// Puntero al nodo ubicado abajo
		
		/* Metodo constructor del nodo. Los punteros apuntan al mismo nodo*/
		MatrixNode(int dato, int fila, int columna) {
			this->datoGuardado = dato;
			this->numFila = fila;
			this->numColumna = columna;
			this->nodoAbajo = this;
			this->nodoDerecha = this;
		}
};

#endif /* MATRIXNODE_H */