/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Barco.h
 * Author: ASUS
 *
 * Created on 13 de febrero de 2018, 16:30
 */

#ifndef BARCO_H
#define BARCO_H
#include <string>
using namespace std;

class Barco {
public:
    Barco(string nombreBarco, string nombrePiloto, string tipoBarco, string paisOrigen,
            string carga, int cantidadContainers, int cantidadCarga, string horaLlegada);
    Barco(const Barco& orig);
    string getNombreBarco();
    void setNombreBarco(string nombreBarco);
    string getNombrePiloto();
    void setNombrePiloto(string nombrePiloto);
    string getTipoBarco();
    void setTipoBarco(string tipoBarco);
    string getPaisOrigen();
    void setPaisOrigen(string paisOrigen);
    string getCarga();
    void setCarga(string carga);
    int getCantidadContainers();
    void setCantidadContainers(int cantidadContainers);
    int getCantidadCarga();
    void setCantidadCarga(float cantidadCarga);
    string getHoraLlegada();
    void setHoraLlegada(string horaLlegada);
    virtual ~Barco();
private:
    string nombreBarco;
    string nombrePiloto;
    string tipoBarco;
    string paisOrigen;
    string carga;
    int cantidadContainers;
    int cantidadCarga;
    string horaLlegada;

};

#endif /* BARCO_H */

