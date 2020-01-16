#ifndef NODOEXAMEN_H
#define NODOEXAMEN_H
#include "Examen.h"
class NodoExamen
{
	public:
		NodoExamen(Examen *examen);
		NodoExamen *getPrevExamen();
		void setPrevExamen(NodoExamen *);
		Examen *getExamen();
		
	private:
		NodoExamen *prevExamen;
		Examen *examen;
};

#endif