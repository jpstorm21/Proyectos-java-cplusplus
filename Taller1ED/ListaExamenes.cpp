#include "ListaExamenes.h"
#include <cstddef>
#include <iostream>
ListaExamenes::ListaExamenes(){
	contador=0;
	lastExamen = NULL;
}
NodoExamen *ListaExamenes::getLastExamen(){
	return lastExamen;
}
void ListaExamenes::setLastExamen(NodoExamen *lastExamen){
	this->lastExamen=lastExamen;
}
int ListaExamenes::getContador(){
	return contador;
}
void ListaExamenes::ingresarExamen(Examen *E){
	NodoExamen *nuevo = new NodoExamen(E);
	if(lastExamen == NULL){
	    lastExamen = nuevo;
            contador++;
	}else{
		nuevo->setPrevExamen(lastExamen);
		lastExamen = nuevo;
		contador++;
		
	}
}
Examen *ListaExamenes::buscarExamen(int codigo){
	NodoExamen *actual = lastExamen;
	while(actual !=NULL && actual->getExamen()->getCodigo() != codigo){
		actual = actual->getPrevExamen();
	}
	if(actual != NULL){
		return actual->getExamen();
	}else{
		return NULL;
	}
	
}
