
#include "ColaCircular.h"

ColaCircular::ColaCircular(int size) {
    this->size = size;
    this->vector = new int[size];
    this->primero = 0;
    this->ultimo = 0;
    //Se llena el vector de 0, ya que dicho valor se considera "vacío".
    for (int i = 0; i < size; i++) {
        vector[i] = 0;
    }
}

ColaCircular::~ColaCircular() {
        delete vector;
}

bool ColaCircular::push(int dato) {
    if(dato == 0){ // No se pueden ingresar elementos nulos a la cola.
        return false;
    }
    if (primero == ultimo) {
        if (vector[ultimo] == 0) {
            vector[ultimo] = dato;
            return true;
        } else if (vector[ultimo + 1] != 0) {
            return false;
        }
    }
    int posAuxiliar = ultimo + 1;
    if (posAuxiliar == size) {
        posAuxiliar = 0;
    }
    if (posAuxiliar == primero) {
        return false;
    }
    vector[posAuxiliar] = dato;
    ultimo = posAuxiliar;
    return true;
}

int ColaCircular::pop() {
    if (primero == ultimo) {
        if (vector[primero] == 0) { //La cola está vacía
            return 0; // NULL
        } else {
            int porRetornar = vector[primero];
            vector[primero] = 0;
            return porRetornar;
        }
    }
    int porRetornar = vector[primero];
    int nuevaPosicion = primero + 1;
    if (nuevaPosicion == size) {
        nuevaPosicion = 0;
    }
    vector[primero] = 0; //NULL
    primero = nuevaPosicion;
    return porRetornar;

}

int ColaCircular::getSize(){
    return this->size;
}

