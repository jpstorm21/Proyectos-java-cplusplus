/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * File:   ArrayList.cpp
 * Author: Juan Pablo Martinez
 *
 * Created on 5 de junio de 2018, 19:33
 */

#include "ArrayList.h"
#include <cstdlib>
#include "dato.h"
#include <iostream>
#include <ctime>
#include <time.h>
#include <windows.h>
#include <stdio.h>

using namespace std;

ArrayList::ArrayList(int max) {
    this->max = max;
    this->cant = 0;
    this->lista = new dato*[max];
}

int ArrayList::getCant() {
    return cant;
}

int ArrayList::getDato(int i) {
    return this->lista[i]->getNumero();
}

int ArrayList::getMax() {
    return max;
}

bool ArrayList::ingresar(int numero) {
    dato *d = new dato(numero);
    if (cant >= max) {
        return false;
    } else {
        lista[cant] = d;
        cant++;
        return true;
    }
}

int ArrayList::buscar(int dato) {
    int i;
    for (i = 0; i < cant; i++) {
        if (this->lista[i]->getNumero() == dato) {
            break;
        }
    }
    if (i == cant) {
        return -1;
    } else {
        return lista[i]->getNumero();
    }
}

void ArrayList::imprimir() {
    if (this->lista[0] != NULL) {
        for (int i = 0; i < cant; i++) {
            cout << "dato: " << lista[i]->getNumero() << endl;
        }
    } else {
        cout << " ArrayList vacio" << endl;
    }
}

double ArrayList::megersort(int posInicio, int posFinal) {
    LARGE_INTEGER t_ini, t_fin;
    double secs;
    QueryPerformanceCounter(&t_ini);
    if (posFinal > posInicio) {
        int posMedio = (posInicio + posFinal) / 2;
        megersort(posInicio, posMedio);
        megersort(posMedio + 1, posFinal);
        megersortREC(posInicio, posMedio, posFinal);
    }
    QueryPerformanceCounter(&t_fin);
    secs = performancecounter_diff(&t_fin, &t_ini);
    return secs * 1000.0;

}

void ArrayList::megersortREC(int posInicio, int mitad, int posFinal) {
    int n1 = mitad - posInicio + 1;
    int n2 = posFinal - mitad;
    int L[n1 + 1];
    int R[n2 + 1];
    for (int i = 0; i < n1; i++) L[i] = lista[posInicio + i]->getNumero();
    for (int j = 0; j < n2; j++) R[j] = lista[mitad + 1 + j]->getNumero();
    int i = 0;
    int j = 0;
    int n = 0;
    while (i != n1 && j != n2) {
        if (L[i] > R[j]) {
            dato *aux1 = new dato(R[j]);
            lista[posInicio + n] = aux1;
            j++;
        } else {
            dato *aux1 = new dato(L[i]);
            lista[posInicio + n] = aux1;
            i++;
        }
        n++;
    }
    while (j != n2) {
        dato *aux1 = new dato(R[j]);
        lista[posInicio + n] = aux1;
        j++;
        n++;
    }
    while (i != n1) {
        dato *aux1 = new dato(L[i]);
        lista[ posInicio + n] = aux1;
        i++;
        n++;
    }
}

double ArrayList::performancecounter_diff(LARGE_INTEGER *a, LARGE_INTEGER *b) {
    LARGE_INTEGER freq;
    QueryPerformanceFrequency(&freq);
    return (double) (a->QuadPart - b->QuadPart) / (double) freq.QuadPart;
}

double ArrayList::burbujaSort() {
    LARGE_INTEGER t_ini, t_fin;
    double secs;
    QueryPerformanceCounter(&t_ini);
    for (int i = 0; i < cant - 1; i++) {
        for (int j = 0; j < cant - 1; j++) {
            if (lista[j]->getNumero() > lista[j + 1]->getNumero()) {
                int tmp = lista[j + 1]->getNumero();
                dato *aux = new dato(lista[j]->getNumero());
                lista[j + 1] = aux;
                dato *aux2 = new dato(tmp);
                lista[j] = aux2;
            }
        }
    }
    QueryPerformanceCounter(&t_fin);
    secs = performancecounter_diff(&t_fin, &t_ini);
    return secs * 1000.0;
}

void ArrayList::allDelete() {
    for (int i = 0; i < cant; i++) {
        lista[i] = NULL;
    }
    this->cant = 0;
}

bool ArrayList::isVacia() {
    if (this->lista[0] == NULL) {
        return true;
    } else {
        return false;
    }
}

ArrayList::~ArrayList() {

}

