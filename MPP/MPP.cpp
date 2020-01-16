/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   MPP.cpp
 * Author: Usuario
 * 
 * Created on 17 de mayo de 2017, 16:33
 */

#include "MPP.h"
#include <cstddef>
#include <iostream>
#include <fstream> 
using namespace std;

MPP::MPP(int i, int j) {
    this->cabezalColumna = NULL;
    this->cabezalFila = NULL;
    this->i = i;
    this->j = j;
    this->cantDatos = 0;
}

Nodo* MPP::getCabezalColumna() {
    return this->cabezalColumna;
}

Nodo* MPP::getCabezalFila() {
    return this->cabezalFila;
}

int MPP::getCantcolumnas() {
    return this->j;
}

int MPP::getCantfilas() {
    return this->j;
}

void MPP::setCabezalColumna(Nodo *cabezalColuma) {
    this->cabezalColumna = cabezalColumna;
}

void MPP::setCabezalFila(Nodo *cabezalFila) {
    this->cabezalFila = cabezalFila;
}

int MPP::getColorFondo() {
    return this->colorFondo;
}

void MPP::setColorFondo(int colorFondo) {
    this->colorFondo = colorFondo;
}

void MPP::crearCabezales() {
    Nodo *cabezalColumna1 = new Nodo(-1, -1, 1);
    this->cabezalColumna = cabezalColumna1;
    cabezalColumna1 = this->cabezalColumna;
    int contColumnas = 2;
    while (contColumnas <= j) {
        Nodo *columnaCurrent = new Nodo(-1, -1, contColumnas);
        cabezalColumna1->setNext(columnaCurrent);
        cabezalColumna1 = columnaCurrent;
        contColumnas++;
    }
    cabezalColumna1->setNext(this->cabezalColumna);

    Nodo *cabezalFila1 = new Nodo(-1, 1, -1);
    this->cabezalFila = cabezalFila1;
    cabezalFila1 = this->cabezalFila;
    int contFilas = 2;
    while (contFilas <= i) {
        Nodo *filaCurrent = new Nodo(-1, contFilas, -1);
        cabezalFila1->setDown(filaCurrent);
        cabezalFila1 = filaCurrent;
        contFilas++;
    }
    cabezalFila1->setDown(this->cabezalFila);
}

void MPP::ingresarColor(int i, int j, int dato) {
    if (i>this->i || j>this->j) {
        cout << "No se puede ingresar el dato (excede limite de la matriz)" << endl;
    } else {
        Nodo *filaCurrent = this->cabezalFila;
        while (filaCurrent->getFila() != i) {
            filaCurrent = filaCurrent->getDown();
        }
        Nodo *columnaCurrent = this->cabezalColumna;
        while (columnaCurrent->getColuma() != j) {
            columnaCurrent = columnaCurrent->getNext();
        }

        Nodo *nuevo = new Nodo(dato, i, j);

        if (filaCurrent->getNext() == NULL) {
            filaCurrent->setNext(nuevo);
            nuevo->setNext(filaCurrent);
        } else {
            Nodo *actual = filaCurrent;
            while (actual->getNext()->getColuma() < j && actual->getNext()->getColuma() != -1) {
                actual = actual->getNext();
            }
            if (actual->getNext()->getColuma() == j) {
                actual->getNext()->setDato(dato);
            } else {
                nuevo->setNext(actual->getNext());
                actual->setNext(nuevo);
            }
        }

        if (columnaCurrent->getDown() == NULL) {
            columnaCurrent->setDown(nuevo);
            nuevo->setDown(columnaCurrent);

        } else {
            Nodo *actual = columnaCurrent;
            while (actual->getDown()->getFila() < i && actual->getDown()->getFila() != -1) {
                actual = actual->getDown();
            }
            if (actual->getDown()->getFila() == i) {
                actual->getDown()->setDato(dato);

            } else {
                nuevo->setDown(actual->getDown());
                actual->setDown(nuevo);

            }
        }
    }
}

bool MPP::elimarColor(int i, int j) {
    if (i>this->i || j>this->j) {
        return false;
    } else {
        Nodo *filaCurrent = this->cabezalFila;
        while (filaCurrent->getFila() != i) {
            filaCurrent = filaCurrent->getDown();
        }
        Nodo *columnaCurrent = this->cabezalColumna;
        while (columnaCurrent->getColuma() != j) {
            columnaCurrent = columnaCurrent->getNext();
        }
        if (filaCurrent->getNext() == NULL) {
            return false;
        } else {
            Nodo *actual = filaCurrent;
            while (actual->getNext()->getColuma() != j && actual->getNext()->getColuma() != -1) {
                actual = actual->getNext();
            }
            if (actual->getNext()->getColuma() == j) {
                actual->setNext(actual->getNext()->getNext());
            } else {
                return false;
            }

        }
        if (columnaCurrent->getDown() == NULL) {
            return false;
        } else {
            Nodo *actual = columnaCurrent;
            while (actual->getDown()->getFila() != i && actual->getDown()->getFila() != -1) {
                actual = actual->getDown();
            }
            if (actual->getDown()->getFila() == i) {
                Nodo* auxiliar = actual->getDown();
                actual->setDown(actual->getDown()->getDown());
                delete auxiliar;
                return true;
            } else {
                return false;
            }

        }
    }
}

void MPP::cambiarColorReg(int i1, int j1, int i2, int j2, int dato) {
    if (i1>this->i || j1>this->j || i2>this->i || j2>this->j) {
        cout << "excede limites de la matriz" << endl;
    } else {
        for (int w = i1; w <= i2; w++) {
            for (int z = j1; z <= j2; z++) {
                ingresarColor(w, z, dato);
            }
        }
    }
}

bool MPP::eliminarColorReg(int i1, int j1, int i2, int j2) {
    bool elimino;
    if (i1>this->i || j1>this->j || i2>this->i || j2>this->j) {
        cout << "excede limites de la matriz" << endl;
        return false;
    } else {
        for (int w = i1; w <= i2; w++) {
            for (int z = j1; z <= j2; z++) {
                elimino = elimarColor(w, z);
            }
        }
        return true;
    }

}

void MPP::imprimir() {
    string nombre;
    cout << "ingrese nombre de la foto finalize con .txt: ";
    cin>>nombre;
    std::ofstream ofFile;
    ofFile.open(nombre.c_str(), ios::out);
    int i = 1, j = 1;
    while (i <= this->i) {
        j = 1;
        while (j <= this->j) {
            Nodo *actual = buscarNodo(i, j);
            if (actual == NULL) {
                ofFile << colorFondo << " ";
            } else {
                ofFile << actual->getDato() << " ";
            }
            j++;
        }
        i++;
        ofFile << " \n";
    }
    cout << "foto imprimida exitosamente " << endl;

}

Nodo* MPP::buscarNodo(int i, int j) {
    Nodo *filaCurrent = this->cabezalFila;
    while (filaCurrent->getFila() != i && filaCurrent->getFila() != -1) {
        filaCurrent = filaCurrent->getDown();
    }
    if (filaCurrent->getNext() == NULL) {
        return NULL;
    } else {
        Nodo *actual = filaCurrent;
        while (actual->getNext()->getColuma() != j && actual->getNext()->getColuma() != -1) {
            actual = actual->getNext();
        }
        if (actual->getNext()->getColuma() == j) {
            return actual->getNext();
        } else {
            return NULL;
        }
    }

}

void MPP::agregarDinamico(int i, int j, int dato) {
    if (cantDatos == 0) {
        Nodo *cabezalFila1 = new Nodo(-1, i, -1);
        this->cabezalFila = cabezalFila1;
        Nodo *cabezalColumna1 = new Nodo(-1, -1, j);
        this->cabezalColumna = cabezalColumna1;
        Nodo *nuevo = new Nodo(dato, i, j);
        cabezalFila1->setDown(cabezalFila1);
        cabezalColumna1->setNext(cabezalColumna1);
        cabezalFila1->setNext(nuevo);
        nuevo->setNext(cabezalFila1);
        cabezalColumna1->setDown(nuevo);
        nuevo->setDown(cabezalColumna1);
        cantDatos++;
        //this->i++;
        //this->j++;
    } else {
        Nodo *nuevo = new Nodo(dato, i, j);
        Nodo *actualFila = this->cabezalFila;
        while (actualFila->getDown() != this->cabezalFila && actualFila->getFila() == i) {
            actualFila = actualFila->getDown();
        }
        if (actualFila->getDown() == this->cabezalFila) {
            Nodo *actual = new Nodo(-1, i, -1);
            if (actualFila->getFila() < i) {
                actualFila->setDown(actual);
                actual->setDown(actualFila);
                actualFila = this->cabezalFila;
            } else {
                actual->setDown(actualFila);
                actualFila->setDown(actual);
                actual = this->cabezalFila;
            }
            actual->setNext(nuevo);
            nuevo->setNext(actual);
            cantDatos++;
            //this->i++;
        } else {
            if (actualFila->getNext() == NULL) {
                actualFila->setNext(nuevo);
                nuevo->setNext(actualFila);
            } else {
                while (actualFila->getNext()->getColuma() < j && actualFila->getNext()->getColuma() != -1) {
                    actualFila = actualFila->getNext();
                }
                if (actualFila->getNext()->getColuma() == j) {
                    actualFila->getNext()->setDato(dato);
                } else {
                    nuevo->setNext(actualFila->getNext());
                    actualFila->setNext(nuevo);
                    cantDatos++;
                }
            }
        }
        Nodo *actualColumna = this->cabezalColumna;
        while (actualColumna->getNext() != this->cabezalColumna) {
            actualColumna = actualColumna->getNext();
        }
        if (actualColumna == this->cabezalColumna) {
            Nodo *actualCol = new Nodo(-1, -1, j);
            if (actualColumna->getColuma() < j) {
                actualColumna->setNext(actualCol);
                actualCol->setNext(actualColumna);
                actualColumna = this->cabezalColumna;
            } else {
                actualCol->setNext(actualColumna);
                actualColumna->setNext(actualCol);
                actualCol = this->cabezalColumna;
            }
            actualCol->setDown(nuevo);
            nuevo->setDown(actualCol);
            cantDatos++;
            //this->j++;
        } else {
            while (actualColumna->getDown()->getFila() < i && actualColumna->getDown()->getFila() != -1) {
                actualColumna = actualColumna->getDown();
            }
            if (actualColumna->getDown()->getFila() == i) {
                actualColumna->getDown()->setDato(dato);
            } else {
                nuevo->setDown(actualColumna->getDown());
                actualColumna->setDown(nuevo);
                cantDatos++;
            }
        }
    }
}

MPP::~MPP() {
}

