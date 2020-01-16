#ifndef CONTRIBUYENTE_H
#define CONTRIBUYENTE_H
#include <string>
#include <iostream>
#include "Fecha.h"

using namespace std;

class Contribuyente {
public:
    Contribuyente();
    Contribuyente(int rut, int numeroAtencion, bool atendido);
    int getRut();
    int getNumeroAtencion();
    Fecha *getTiempoInicial();
    Fecha *getTiempoFinal();
    bool getAtendido();
    void setRut(int rut);
    void setNumeroAtencion(int numeroAtencion);
    void setTiempoInicial(Fecha *tiempoInicial);
    void setTiempoFinal(Fecha *tiempoFinal);
    void setAtendido(bool atendido);
    virtual ~Contribuyente();
private:
    int rut;
    int numeroAtencion;
    Fecha *tiempoInicial;
    Fecha *tiempoFinal;
    bool atendido;

};

#endif /* CONTRIBUYENTE_H */

