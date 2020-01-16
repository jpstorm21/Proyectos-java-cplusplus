#ifndef NODOALUMNO_H
#define NODOALUMNO_H
#include "Alumno.h"

class NodoAlumno {
public:
    NodoAlumno(Alumno *alumno);

    Alumno *getAlumno();
    NodoAlumno *getPrevAl();
    NodoAlumno *getNextAl();
    void setPrevAl(NodoAlumno*);
    void setNextAl(NodoAlumno*);



    ~NodoAlumno();

private:
    Alumno *al;
    NodoAlumno *nextAl;
    NodoAlumno *prevAl;

};

#endif
