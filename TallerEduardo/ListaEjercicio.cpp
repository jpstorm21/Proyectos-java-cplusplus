#include "ListaEjercicio.h"
#include <cstddef>
#include <iostream>

ListaEjercicio::ListaEjercicio() {
    contador = 0;
    lastEj = NULL;
}

NodoEjercicio *ListaEjercicio::getLastEj() {
    return lastEj;
}

void ListaEjercicio::setLastEj(NodoEjercicio *ne) {
    lastEj = ne;
}

int ListaEjercicio::getContador() {
    return contador;
}

void ListaEjercicio::ingresarEjercicio(Ejercicio *E) {
    if (contador < 500) {

        NodoEjercicio *curr = new NodoEjercicio(E);
        curr->setPrevEj(lastEj);
        lastEj = curr;
        contador++;
    } else {
        std::cout << "El alumno llego a su capacidad maxima de ejercicios" << std::endl;
    }


}

double ListaEjercicio::calcularPromedioEjercicio() {
    NodoEjercicio *curr;
    curr = lastEj;
    double sumador = 0;
    double promedio = 0;
    while (curr != NULL) {
        sumador += curr->getEjercicio()->getNota();
        curr = curr->getPrevEj();
    }
    promedio = sumador / contador;
    return promedio;

}

ListaEjercicio::~ListaEjercicio() // destructor
{

}
