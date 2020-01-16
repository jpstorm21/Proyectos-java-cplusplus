#ifndef COLA_H
#define COLA_H
#include "Nodo.h"

class Cola
{
	public:
		Cola();
		Nodo *getFirst();
		Nodo *getLast();
		void setFirst(Nodo *);
		void setLast(Nodo *);
		void ingresar(int dato,int prioridad);
		bool eliminar();
                void imprimir();
	private:
		Nodo *first;
		Nodo *last;
};

#endif
