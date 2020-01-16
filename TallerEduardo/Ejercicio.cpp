#include "Ejercicio.h"

Ejercicio::Ejercicio() {
    identificador = 0;
    this->nota = 1;
}

double Ejercicio::getNota() {
    return nota;
}

void Ejercicio::setNota(double n) {
    nota = n;
}

int Ejercicio::getIdentificador() {
    return identificador;
}

void Ejercicio::setIdentificador(int i) {
    identificador = i;
}

Ejercicio::~Ejercicio() {

}
