#ifndef HEAP_H
#define HEAP_H
#include "Nodo.h"

class ArbolHeap{
	private:
		Nodo* start;
		int cantNodos;
		int contNivel;
		bool insertarRecursivo(Nodo*, int nivel, int valor);
		void intercambiarValores(Nodo* actual, Nodo* bajo);
		bool eliminarNodoRecursivo(Nodo* cursor, int nivel);
		void ordenarArbol(Nodo* cursor);
		void guardarEnArreglo(int* arreglo, Nodo* cursor, int nivel);
	public:
		ArbolHeap();
		void insertar(int value);
		int eliminar();
		void imprimir();
};

#endif /* HEAP_H */