/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Fecha.h
 * Author: Usuario
 *
 * Created on 17 de noviembre de 2017, 0:13
 */

#ifndef FECHA_H
#define FECHA_H

class Fecha {
public:
    Fecha();
    Fecha(int hors,int minutos);
    int getHora();
    int getMinutos();
    void setHora(int hora);
    void setMin(int minutos);
    virtual ~Fecha();
private:
    int hora;
    int minutos;


};

#endif /* FECHA_H */

