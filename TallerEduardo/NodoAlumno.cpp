#include "NodoAlumno.h"

NodoAlumno::NodoAlumno(Alumno *alumno) {


    this->al = alumno;


}

Alumno *NodoAlumno::getAlumno() {

    return al;
}

NodoAlumno *NodoAlumno::getNextAl() {
    return nextAl;
}

NodoAlumno *NodoAlumno::getPrevAl() {
    return prevAl;
}

void NodoAlumno::setNextAl(NodoAlumno * na) {
    nextAl = na;
}

void NodoAlumno::setPrevAl(NodoAlumno *na) {
    prevAl = na;
}

NodoAlumno::~NodoAlumno() {

}
