/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Laberinto.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 27 de abril de 2019, 14:35
 */

#include "Laberinto.h"
#include <iostream>
#include <string>
#include <cstdio>
using namespace std;

Laberinto::Laberinto() {//Constructor del laberinto
    this->solucion = new Nodo*[100];
    this->soluciones = new ListaEnlazada*[100];
    this->cant = 0;
    this->tamFila = 10;
    this->tamCol = 10;
    this->cantSoluciones = 0;
}

bool Laberinto::isTheEnd(int x, int y) {//Función para comprobar si se llegó al termino
    if (x == this->termino->getPosX() && y == this->termino->getPosY()) {
        return true;
    } else {
        return false;
    }
}

bool Laberinto::isWall(int x, int y) {//Función para ver si es una muralla la posición x,y
    return this->tablero[x][y] == 1 ? true : false;
}

bool Laberinto::wasVisited(int x, int y) {
    bool visited = false;
    if (this->tablero[x][y] == 3) {
        visited = true;
    }
    return visited;
}

bool Laberinto::flagVisit(int x, int y) {//Función para marcar como vistada la casilla
    this->tablero[x][y] = 3;
    Nodo *n = new Nodo(x, y);
    this->solucion[cant] = n;
    cant++;
    return true;
}

bool Laberinto::rango(int x, int y) {//Rango que tendrá el laberinto
    if (x < 0 || x >= this->tamFila) {
        return false;
    }
    if (y < 0 || y >= this->tamCol) {
        return false;
    }
    return true;
}

void Laberinto::imprimirSolucion() {//Se imprime las soluciones encontradas por el backtracking
    int menor = 999;
    int posMenor = 0;
    int cant = 0;
    for (int i = 0; i < cantSoluciones; i++) {
        ListaEnlazada *l = soluciones[i];
        Nodo *actual = l->getPrimero();
        if (i == 0) {
            cout << "-------------------------------------------------------------------------------------------------" << endl;
        }
        cout << "solucion " << (i + 1) << " :" << endl;
        while (actual != nullptr) {
            cant++;
            if (actual->getSiguiente() == nullptr) {
                cout << "(" << actual->getPosX() << "," << actual->getPosY() << ")" << endl;
            } else {
                cout << "(" << actual->getPosX() << "," << actual->getPosY() << ")->";
            }
            actual = actual->getSiguiente();
        }
        if (cant < menor) {
            menor = cant;
            posMenor = i;
        }
        cant = 0;
        cout << "-------------------------------------------------------------------------------------------------" << endl;
    }

    cout << "la solucion con menores pasos es: " << endl;
    ListaEnlazada *l2 = soluciones[posMenor];
    Nodo *actual2 = l2->getPrimero();
    while (actual2 != nullptr) {
        if (actual2->getSiguiente() == nullptr) {
            cout << "(" << actual2->getPosX() << "," << actual2->getPosY() << ")" << endl;
        } else {
            cout << "(" << actual2->getPosX() << "," << actual2->getPosY() << ")->";
        }
        cant++;
        actual2 = actual2->getSiguiente();
    }
}

void Laberinto::guardarSolucion() {
    ListaEnlazada *l = new ListaEnlazada();
    for (int i = 0; i < cant; i++) {
        l->insertarNodo(this->solucion[i]->getPosX(), this->solucion[i]->getPosY());
    }
    this->soluciones[cantSoluciones] = l;
    cantSoluciones++;
    this->solucion = new Nodo*[100];
    this->cant = 0;
}

bool Laberinto::isPortal(int x, int y) {
    bool portal = false;
    if (this->tablero[x][y] > 100) {
        portal = true;
    }
    return portal;
}

int Laberinto::resolve(int x, int y) {//Función para el Backtracking
    //imprimir();
    if (isTheEnd(x, y)) {
        this->tablero[termino->getPosX()][termino->getPosY()] = -2;
        cout << "-----------------------------------------------------" << endl;
        cout << "Resuelto desde la posicion de inicio: " << inicio->getPosX() << "," << inicio->getPosY() << endl;
        cout << "-----------------------------------------------------" << endl;
        this->tablero[inicio->getPosX()][inicio->getPosY()] = 3;
        guardarSolucion();
        if (seguirBuscando()) {
            imprimir();
            return resolve(this->inicio->getPosX(), this->inicio->getPosY());
        } else {
            return 1;
        }
    } else {
        for (int k = 0; k < 4; k++) {
            int movF = x + this->movFila[k];
            int movC = y + this->movCol[k];
            if (!isWall(movF, movC)) {
                if (!wasVisited(movF, movC)) {
                    if (rango(movF, movC)) {
                        if (isPortal(movF, movC)) {
                            int y = tablero[movF][movC] % 10;
                            int x = (tablero[movF][movC] / 10) % 10;
                            flagVisit(movF, movC);
                            movF = x;
                            movC = y;
                            flagVisit(movF, movC);
                        } else {
                            flagVisit(movF, movC);
                        }
                        int estado = resolve(movF, movC); //Llamada a la función que resuelve el laberinto
                        switch (estado) {
                            case (0):
                                this->tablero[movF][movC] = 0;
                                break;
                            case (-1):
                                this->tablero[movF][movC] = 3;
                                break;
                            default:
                                return 1;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

bool Laberinto::seguirBuscando() {
    bool sepuede = false;
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (this->tablero[i][j] == 0) {
                sepuede = true;
                this->tablero[termino->getPosX()][termino->getPosY()] = -2;
                this->inicio->setPosX(i);
                this->inicio->setPosY(j);
                break;
            }
        }
        if (sepuede) {
            break;
        }
    }
    return sepuede;
}

void Laberinto::setTablero(int tablero[10][10]) {
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (tablero[i][j] == -1) {
                inicio = new Nodo(i, j);
            } else if (tablero[i][j] == -2) {
                termino = new Nodo(i, j);
            }
            this->tablero[i][j] = tablero[i][j];
        }
    }
}

void Laberinto::imprimir() {//Función para imprimir el laberinto
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            cout << tablero[i][j] << "\t";
        }
        cout << endl;
    }
}

Nodo *Laberinto::getInicio() {//Se obtiene el inicio del laberinto
    return this->inicio;
}

Nodo *Laberinto::getTermino() {//Se obtiene el termino del laberinto
    return this->termino;
}

Laberinto::~Laberinto() {//Destructor de la clase laberinto
}

