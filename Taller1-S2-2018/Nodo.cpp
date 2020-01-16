

#include "Nodo.h"
#include <cstdlib>

Nodo::Nodo(int i, int j, int vecinos, int estadoActual, string nombreRegla) {
    this->c = new Celula(i, j, estadoActual, 0);
    this->next = NULL;
    this->vecinos = vecinos;
    this->name = nombreRegla;
}

Nodo* Nodo::getNext() {
    return this->next;
}

void Nodo::setNext(Nodo* next) {
    this->next = next;
}

Celula* Nodo::getCelula() {
    return this->c;
}

string Nodo::getName() {
    return name;
}

void Nodo::setVecinos(int vecinos) {
    this->vecinos = vecinos;
}

int Nodo::aplicarRule(int ciclos, int estado) {
    if (name == "sobrepoblacion") {
        if (estado != 0) {
            if (vecinos > 3) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 0;
        }
    } else if (name == "soledad") {
        if (vecinos <= 2) {
            return 0;
        } else {
            return 1;
        }
    } else if (name == "revivir") {
        if (vecinos == 3) {
            return 1;
        } else {
            return 0;
        }
    } else if (name == "vejez") {
        if (c->getCiclos() > 25) {
            return 0;
        } else {
            return 1;
        }
    } else if (name == "barrio_historico") {
        if (vecinos > 4) {
            if (ciclos > 25) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    } else if (name == "salto_en_el_tiempo") {
        if (c->getCiclos() >= 10) {
            if (vecinos >= 3) {
                if (ciclos <= 10) {
                    c->setCiclos(c->getCiclos() + 5);
                    return 1;
                } else {
                    return 1;
                }
            }
        } else {
            return 1;
        }
    }
}

Nodo::~Nodo() {
}

