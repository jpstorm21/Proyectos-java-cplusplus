#ifndef ALUMNO_H
#define ALUMNO_H
#include "ListaEjercicio.h"

class Alumno {
public:
    Alumno(int);

    int getRut();
    void setRut(int);
    ListaEjercicio *getListaEjercicio();
    ~Alumno();
private:
    int rut;
    ListaEjercicio *le;
};

#endif
