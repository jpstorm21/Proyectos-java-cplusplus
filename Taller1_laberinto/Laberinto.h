/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Laberinto.h
 * Author: Juan Pablo Martinez
 *
 * Created on 27 de abril de 2019, 14:35
 */

#ifndef LABERINTO_H
#define LABERINTO_H
#include "listaEnlazada.h"
#include "Nodo.h"

class Laberinto {
 private:
        ListaEnlazada **soluciones;
        int tablero[10][10];
        Nodo **solucion;
        int cant;
        Nodo *inicio;
        Nodo *termino;
        int movFila[4] = {-1,0,1,0};
        int movCol[4] = {0,1,0,-1};
        int tamFila;
        int tamCol;
        int cantSoluciones;
    public: 
        Laberinto();
        int resolve(int x,int y);
        bool isTheEnd(int x, int y);
        bool isWall(int x, int y);
        bool wasVisited(int x, int y);
        bool flagVisit(int x, int y);
        Nodo *getInicio();
        Nodo *getTermino();
        void setTablero(int tablero[10][10]);
        void imprimir();
        bool rango(int x , int y);
        void imprimirSolucion();
        bool seguirBuscando();
        void guardarSolucion();
        bool isPortal(int x,int y);
        virtual ~Laberinto();
};

#endif /* LABERINTO_H */

