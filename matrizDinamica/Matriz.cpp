/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Matriz.cpp
 * Author: Nicolas
 * 
 * Created on 11 de mayo de 2017, 18:41
 */

#include "Matriz.h"
#include <iostream>
#include <cstring>
using namespace std;

Matriz::Matriz() {
    this->filaH = NULL;
    this->columnaH = NULL;
    cant = 0;
    maxcolumna = -1;
    maxfila = -1;
}

Matriz::~Matriz() {
}

Nodo* Matriz::getFilaH() {
    return this->filaH;
}

Nodo* Matriz::getColumnaH() {
    return this->columnaH;
}

int Matriz::getMaxcolumna(){
    return maxcolumna;
}

int Matriz::getMaxfila(){
    return maxfila;
}
void Matriz::insertar(int dato, int fila, int columna) {
    Nodo* nuevo = new Nodo(dato, fila, columna);
    if (cant == 0) {
        filaH = new Nodo(fila, 0);
        columnaH = new Nodo(0, columna);
        filaH->setNext(nuevo);
        nuevo->setNext(filaH);
        columnaH->setAbajo(nuevo);
        nuevo->setAbajo(columnaH);
        if (columna > maxcolumna) {
           maxcolumna=columna;
        }
        if (fila > maxfila) {
            maxfila = fila;
        }
        cant++;
    } else {
        Nodo* Hfila = buscarCabezalFila(fila);
        Nodo* Hcolumna = buscarCabezalColumna(columna);
        
            insertarNodoEnFila(nuevo, Hfila);
            insertarNodoEnColumna(nuevo, Hcolumna);
            if (columna > maxcolumna) {
                maxcolumna = columna;
            }
            if (fila > maxfila) {
                maxfila = fila;
            }
            cant++;
        
    }
    this->print();
    cout<<endl;
    cout<<endl;
}

Nodo* Matriz::buscarCabezalFila(int fila) {
    Nodo* nfila = NULL;
    Nodo* current = filaH;
    do {
        if (current->getFila() == fila) {
            nfila = current;
            break;
        }
        current = current->getAbajo();
    } while (current != filaH);
    if (nfila == NULL) {
        nfila = new Nodo(fila, 0);
        insertarNodoCabezalFila(nfila);
    }
    return nfila;
}

Nodo* Matriz::buscarCabezalColumna(int columna) {
    Nodo* ncolumna = NULL;
    Nodo* current = columnaH;
    do {
        if (current->getColumna() == columna) {
            ncolumna = current;
            break;
        }
        current = current->getNext();
    } while (current != columnaH);
    if (ncolumna == NULL) {
        ncolumna = new Nodo(0, columna);
        insertarNodoCabezalColumna(ncolumna);
    }
    return ncolumna;
}

void Matriz::insertarNodoCabezalFila(Nodo* n) {
    int fila = n->getFila();
    Nodo* current = filaH;
    Nodo* last = NULL;
    while (current->getAbajo() != filaH) {
        current = current->getAbajo();
    }
    if (current == filaH) {
        last = filaH;
    } else {
        last = current;
    }
    current = filaH;
    if (filaH == last) {
        if (fila < filaH->getFila()) {
            filaH->setAbajo(n);
            n->setAbajo(filaH);
            filaH = n;
        } else {
            n->setAbajo(filaH);
            filaH->setAbajo(n);
        }
    } else {
        if (fila < filaH->getFila()) {
            last->setAbajo(n);
            n->setAbajo(filaH);
            filaH = n;
        } else {
            Nodo* anterior = filaH;
            while (current != last && fila > current->getFila()) {
                anterior = current;
                current = current->getAbajo();
            }
            if (current == last) {
                if (fila < last->getFila()) {
                    n->setAbajo(anterior->getAbajo());
                    anterior->setAbajo(n);
                } else {
                    n->setAbajo(last->getAbajo());
                    last->setAbajo(n);
                }
            } else {
                n->setAbajo(anterior->getAbajo());
                anterior->setAbajo(n);
            }
        }
    }
}

void Matriz::insertarNodoCabezalColumna(Nodo* n) {
    int columna = n->getColumna();
    Nodo* current = columnaH;
    Nodo* last = NULL;
    while (current->getNext() != columnaH) {
        current = current->getNext();
    }
    if (current == columnaH) {
        last = columnaH;
    } else {
        last = current;
    }
    current = columnaH;
    if (columnaH == last) {
        if (columna < columnaH->getColumna()) {
            columnaH->setNext(n);
            n->setNext(columnaH);
            columnaH = n;
        } else {
            columnaH->setNext(n);
            n->setNext(columnaH);
        }
    } else {
        if (columna < columnaH->getColumna()) {
            n->setNext(columnaH);
            last->setNext(n);
        } else {
            Nodo* anterior = columnaH;
            while (current != last && columna > current->getColumna()) {
                anterior = current;
                current = current->getNext();
            }
            if (current == last) {
                if (columna < last->getColumna()) {
                    n->setNext(anterior->getNext());
                    anterior->setNext(n);
                } else {
                    n->setNext(last->getNext());
                    last->setNext(n);
                    
                }
            } else {
                n->setNext(anterior->getNext());
                anterior->setNext(n);
            }
        }
    }
}

Nodo* Matriz::buscarDato(int fila, int columna) {
    Nodo* node = NULL;
    Nodo* cabezalF = buscarCabezalFila(fila);
    Nodo* cabezalC = buscarCabezalColumna(columna);
    if (cabezalF->getAbajo() == cabezalF && cabezalC->getNext() == cabezalC) {
        return node;
    } else {
        Nodo* current = filaH->getNext();
        do {
            if (current->getColumna() == columna) {
                node = current;
                break;
            }
            current = current->getNext();
        } while (current != filaH);
        return node;
    }
}

void Matriz::insertarNodoEnFila(Nodo* n, Nodo* cabezalF) {
    int columna = n->getColumna();
    Nodo* current = cabezalF;
    Nodo* last = NULL;
    if (current->getNext() == cabezalF) {
        cabezalF->setNext(n);
        n->setNext(cabezalF);
    } else {
        Nodo* first = current->getNext();
        current = first;
        while (current->getNext() != cabezalF) {
            current = current->getNext();
        }
        last = current;
        current = first;
        if (first == last) {
            if (columna < first->getColumna()) {
                cabezalF->setNext(n);
                n->setNext(first);
            } else {
                last->setNext(n);
                n->setNext(cabezalF);
            }
        } else {
            if (columna < first->getColumna()) {
                n->setNext(first);
                cabezalF->setNext(n);
            } else {
                Nodo* anterior = first;
                while (current != last && columna > current->getColumna()) {
                    anterior = current;
                    current = current->getNext();
                }
                if (current == last) {
                    if (columna < last->getColumna()) {
                        n->setNext(anterior->getNext());
                        anterior->setNext(n);
                    } else {
                        n->setNext(last->getNext());
                        last->setNext(n);
                    }
                } else {
                    n->setNext(anterior->getNext());
                    anterior->setNext(n);
                }
            }
        }
    }
}

void Matriz::insertarNodoEnColumna(Nodo* n, Nodo* cabezalC) {
    int fila = n->getFila();
    Nodo* current = cabezalC;
    Nodo* last = NULL;
    if (current->getAbajo() == cabezalC) {
        cabezalC->setAbajo(n);
        n->setAbajo(cabezalC);
    } else {
        Nodo* first = current->getAbajo();
        current = first;
        while (current->getAbajo() != cabezalC) {
            current = current->getAbajo();
        }
        last = current;
        current = first;
        if (first == last) {
            if (fila < first->getColumna()) {
                cabezalC->setAbajo(n);
                n->setAbajo(first);
            } else {
                last->setAbajo(n);
                n->setAbajo(cabezalC);
            }
        } else {
            if (fila < first->getColumna()) {
                n->setAbajo(first);
                cabezalC->setAbajo(n);
            } else {
                Nodo* anterior = first;
                while (current != last && fila > current->getColumna()) {
                    anterior = current;
                    current = current->getAbajo();
                }
                if (current == last) {
                    if (fila < last->getColumna()) {
                        n->setAbajo(anterior->getAbajo());
                        anterior->setAbajo(n);
                    } else {
                        n->setAbajo(last->getAbajo());
                        last->setAbajo(n);
                    }
                } else {
                    n->setAbajo(anterior->getAbajo());
                    anterior->setAbajo(n);
                }
            }
        }
    }
}

void Matriz::print() {
    Nodo* current = filaH;
    do{
        Nodo* current2=current->getNext();
        do {
            int dato=current2->getDato();
           
            cout << dato << " ";
            current2 = current2->getNext();
        } while (current2 != current);
        cout << endl;
        current=current->getAbajo();
    }while(current!=filaH);
  
}