#ifndef LISTAALUMNO_H
#define LISTAALUMNO_H
#include "NodoAlumno.h"
#include "Alumno.h"
#include <cstddef>

class ListaAlumno {
public:
    ListaAlumno();
    NodoAlumno *getFirstAl();
    NodoAlumno *getLastAl();
    void setFirstAl(NodoAlumno*);
    void setLastAl(NodoAlumno*);
    int getContador();
    void ingresarAlumno(Alumno *);
    Alumno *buscarAlumno(int);

    bool estaVacio() {
        return firstAl == NULL;
    }

    ~ListaAlumno();
private:

    NodoAlumno *firstAl;
    NodoAlumno *lastAl;
    int contador;
};

#endif
