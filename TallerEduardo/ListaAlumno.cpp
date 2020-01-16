#include "ListaAlumno.h"
#include <iostream>
#include "NodoAlumno.h"
#include <cstddef>

ListaAlumno::ListaAlumno() {
    firstAl = NULL;
    lastAl = NULL;
    contador = 0;


}

NodoAlumno *ListaAlumno::getFirstAl() {
    return firstAl;
}

int ListaAlumno::getContador() {
    return contador;
}

NodoAlumno *ListaAlumno::getLastAl() {
    return lastAl;
}

void ListaAlumno::setFirstAl(NodoAlumno *na) {
    firstAl = na;
}

void ListaAlumno::setLastAl(NodoAlumno *na) {
    lastAl = na;
}

void ListaAlumno::ingresarAlumno(Alumno *a) { // aqui hay error.
    NodoAlumno *na = new NodoAlumno(a); //nodo con el alumno
    NodoAlumno *prev = NULL; //anterior al que recorre
    NodoAlumno *aux = firstAl; //nodo que recorre

    while (aux != NULL && a->getRut() > aux->getAlumno()->getRut()) { //itera mientras el rut del alumno sea mayor que el que hay en la lista
        prev = aux;
        aux = aux->getNextAl();
    }

    if (prev == NULL) { //si está vacía, el alumno es el primero
        firstAl = na;

    } else { //sino 
        prev->setNextAl(na); //alumno sgte del anterior
        na->setPrevAl(prev); //anterior anterior del alumno
    }
    na->setNextAl(aux); //el sgte del alumno es el aux

    if (aux != NULL) {
        aux->setPrevAl(na); //alumno anterior a aux
    } else {
        lastAl = na;
    }

    contador++;

}

Alumno *ListaAlumno::buscarAlumno(int rut) {
    NodoAlumno *curr = firstAl;

    while (curr != NULL && curr->getAlumno()->getRut() != rut) {
        curr = curr->getNextAl();
    }
    if (curr != NULL) {
        return curr->getAlumno();
    } else {
        return NULL;
    }
}

ListaAlumno::~ListaAlumno() {

}