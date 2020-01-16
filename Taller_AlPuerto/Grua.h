/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Grua.h
 * Author: ASUS
 *
 * Created on 13 de febrero de 2018, 16:43
 */

#ifndef GRUA_H
#define GRUA_H
#include <string>
#include "Barco.h"
#include "Operario.h"
using namespace std;
class Grua {
public:
    Grua(string codigo, int pesoTransportadoAcumulado, int estado, string horaInicio, string horaFin);
    Grua(const Grua& orig);
    string getCodigo();
    void setCodigo(string codigo);
    int getPesoTransportadoAcumulado();
    void setPesoTransportadoAcumulado(int pesoTransportadoAcumulado);
    int getEstado();
    void setEstado(int estado);
    Operario* getOperario();
    void setOpeario(Operario *operario);
    Barco* getBarco();
    void setBarco(Barco* barco);
    string getHoraInicio();
    void setHoraInicio(string horaInicio);
    string getHoraFin();
    void setHoraFIn(string horaFin);
    virtual ~Grua();
private:
    string codigo;
    float pesoTransportadoAcumulado;
    int estado;
    Operario* operario;
    Barco* barco;
    string horaInicio;
    string horaFin;

};

#endif /* GRUA_H */

