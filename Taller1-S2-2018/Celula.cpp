

#include "Celula.h"

Celula::Celula(int i,int j,int estadoActual,int ciclos){
    this->i=i;
    this->j=j;
    this->estadoActual=estadoActual;
    this->ciclos=ciclos;
}

int Celula::getCiclos() {
    return ciclos;
}

int Celula::getColumna() {
    return j;
}

int Celula::getFila() {
    return i;
}

int Celula::getEstadoActual() {
    return estadoActual;
}

void Celula::setCiclos(int ciclos) {
    this->ciclos=ciclos;
}

void Celula::setColumna(int j) {
    this->j=j;
}

void Celula::setEstado(int estadoActual) {
    this->estadoActual=estadoActual;
}

void Celula::setFila(int i) {
    this->i=i;
}


Celula::~Celula() {
}

