#ifndef PACIENTE_H
#define PACIENTE_H
#include "ListaExamenes.h"
class Paciente {
public:
    Paciente();
    Paciente(int rut);
    void setRut(int rut);
    int getRut();
    ListaExamenes *getListaExamenes();
  
    virtual ~Paciente();
private:
    int rut;
    ListaExamenes *le;

};

#endif /* PACIENTE_H */

