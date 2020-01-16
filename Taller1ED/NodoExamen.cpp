#include "NodoExamen.h"
#include "Examen.h"
#include <cstddef>
NodoExamen::NodoExamen(Examen *examen){
	this->examen= examen;
	this->prevExamen=NULL;
}

NodoExamen *NodoExamen::getPrevExamen(){
	return this->prevExamen;
}
void NodoExamen::setPrevExamen(NodoExamen *prevExamen){
	this->prevExamen= prevExamen;
}
Examen *NodoExamen::getExamen(){
	return this->examen;
}