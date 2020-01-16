#include "Contribuyente.h"

Contribuyente::Contribuyente() {
}

Contribuyente::Contribuyente(int rut, int numeroAtencion, bool atendido) {
    this->rut=rut;
    this->numeroAtencion=numeroAtencion;
    this->atendido=false;
}

int Contribuyente::getRut() {
    return this->rut;
}

int Contribuyente::getNumeroAtencion() {
    return this->numeroAtencion;
}

Fecha *Contribuyente::getTiempoInicial() {
    return this->tiempoInicial;
}

Fecha *Contribuyente::getTiempoFinal() {
    return this->tiempoFinal;
}

bool Contribuyente::getAtendido() {
    return this->atendido;
}

void Contribuyente::setRut(int rut) {
    this->rut=rut;
}

void Contribuyente::setNumeroAtencion(int numeroAtencion) {
    this->numeroAtencion=numeroAtencion;
}

void Contribuyente::setTiempoInicial(Fecha *tiempoInicial) {
    this->tiempoInicial=tiempoInicial;
}

void Contribuyente::setTiempoFinal(Fecha *tiempoFinal) {
    this->tiempoFinal=tiempoFinal;
}

void Contribuyente::setAtendido(bool atendido) {
    this->atendido=atendido;
}
Contribuyente::~Contribuyente() {
}

