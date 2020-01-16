#include "Alumno.h"

Alumno::Alumno(int r) {
    this->le = new ListaEjercicio();
    rut = r;
}

int Alumno::getRut() {
    return rut;
}

ListaEjercicio *Alumno::getListaEjercicio() {
    return le;
}

void Alumno::setRut(int r) {
    rut = r;
}

Alumno::~Alumno() {

}
