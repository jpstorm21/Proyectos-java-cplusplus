#ifndef LISTAEXAMENES_H
#define LISTAEXAMENES_H
#include "NodoExamen.h"
#include "Examen.h"
class ListaExamenes
{
	public:
		ListaExamenes();
		NodoExamen *getLastExamen();
		void setLastExamen(NodoExamen*);
		int getContador();
		void ingresarExamen(Examen*);
		Examen *buscarExamen(int codigo);
	private:
		NodoExamen *lastExamen;
		int contador;
};

#endif