/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   MPP.h
 * Author: Usuario
 *
 * Created on 17 de mayo de 2017, 16:33
 */

#ifndef MPP_H
#define MPP_H
#include "Nodo.h"
class MPP {
public:
    MPP(int i,int j);
    Nodo *getCabezalFila();
    Nodo *getCabezalColumna();
    int getCantfilas();
    int getCantcolumnas();
    void setCabezalFila(Nodo *);
    void setCabezalColumna(Nodo *);
    void crearCabezales();
    void ingresarColor(int i, int j, int dato);
    bool elimarColor(int i,int j);
    void cambiarColorReg(int i1, int j1, int i2,int j2, int dato);
    bool eliminarColorReg(int i1,int j1, int i2, int j2);
    void imprimir();
    Nodo *buscarNodo(int i,int j);
    int getColorFondo();
    void setColorFondo(int);
    void agregarDinamico(int i,int j,int dato);
    virtual ~MPP();
private:
    Nodo *cabezalFila;
    Nodo *cabezalColumna;
    int i;
    int j;
    int colorFondo;
    int cantDatos;
};

#endif /* MPP_H */

