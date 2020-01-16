#include "NodoEjercicio.h"
#include <cstddef>

NodoEjercicio::NodoEjercicio(Ejercicio *ej) {
    this->ej = ej;
    prevEj = NULL;

}

NodoEjercicio *NodoEjercicio::getPrevEj() {
    return prevEj;
}

Ejercicio *NodoEjercicio::getEjercicio() {
    return ej;
}

void NodoEjercicio::setPrevEj(NodoEjercicio *ne) {
    prevEj = ne;
}

NodoEjercicio::~NodoEjercicio() {

}
