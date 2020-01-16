#include <cstddef>
#include "ListaPacientes.h"
#include "NodoPaciente.h"
#include "Paciente.h"
#include <iostream>

ListaPacientes::ListaPacientes() {
    this->firstPaciente = NULL;
    this->lastPaciente = NULL;
    contador = 0;
}

NodoPaciente *ListaPacientes::getFirstPaciente() {
    return this->firstPaciente;
}

NodoPaciente *ListaPacientes::getPrevPaciente() {
    return this->lastPaciente;
}

void ListaPacientes::setFirstPaciente(NodoPaciente *firstPaciente) {
    this->firstPaciente = firstPaciente;
}

void ListaPacientes::setPrevPaciente(NodoPaciente *lastPaciente) {
    this->lastPaciente = lastPaciente;
}

int ListaPacientes::getContador() {
    return contador;
}

void ListaPacientes::ingresarPaciente(Paciente *P) {
    NodoPaciente *actual = firstPaciente;
    while (actual != NULL && actual->getPaciente()->getRut() != P->getRut()) {
        actual = actual->getNextPaciente();
    }
    if (actual != NULL) {
        cout << "El paciente ya fue ingresado anteriormente!!" << endl;
    } else {
        NodoPaciente *nuevo = new NodoPaciente(P);
        NodoPaciente *prev = NULL;
        NodoPaciente *aux = firstPaciente;

        while (aux != NULL && P->getRut() > aux->getPaciente()->getRut()) { //itera mientras el rut del alumno sea mayor que el que hay en la lista
            prev = aux;
            aux = aux->getNextPaciente();
        }

        if (prev == NULL) { //si está vacía, el alumno es el primero
            firstPaciente = nuevo;

        } else { //sino 
            prev->setNextPaciente(nuevo); //alumno sgte del anterior
            nuevo->setPrevPaciente(prev); //anterior anterior del alumno
        }
        nuevo->setNextPaciente(aux); //el sgte del alumno es el aux

        if (aux != NULL) {
            aux->setPrevPaciente(nuevo); //alumno anterior a aux
        } else {
            lastPaciente = nuevo;
        }

        contador++;
        cout << "Paciente ingresado con exito!" << endl;
    }
}

Paciente *ListaPacientes::buscarPaciente(int rut) {
    NodoPaciente *actual = firstPaciente;
    while (actual != NULL && actual->getPaciente()->getRut() != rut) {
        actual = actual->getNextPaciente();
    }
    if (actual != NULL) {
        return actual->getPaciente();
    } else {
        return NULL;
    }
}

ListaPacientes::~ListaPacientes() {
}
