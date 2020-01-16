#ifndef LISTAEJERCICIO_H
#define LISTAEJERCICIO_H
#include "NodoEjercicio.h"
#include "Ejercicio.h"

class ListaEjercicio {
public:
    ListaEjercicio();
    NodoEjercicio *getLastEj();
    void setLastEj(NodoEjercicio*);
    int getContador();
    double calcularPromedioEjercicio();
    void ingresarEjercicio(Ejercicio *);

    ~ListaEjercicio();
private:
    int contador;
    NodoEjercicio *lastEj;
};

#endif
