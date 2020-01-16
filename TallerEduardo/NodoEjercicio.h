#ifndef NODOEJERCICIO_H
#define NODOEJERCICIO_H
#include "Ejercicio.h"

class NodoEjercicio {
public:
    NodoEjercicio(Ejercicio *ej);
    Ejercicio *getEjercicio();
    NodoEjercicio *getPrevEj();
    void setPrevEj(NodoEjercicio *);
    ~NodoEjercicio();
private:
    NodoEjercicio *prevEj;
    Ejercicio *ej;
};

#endif
