
#ifndef LISTAPACIENTES_H
#define LISTAPACIENTES_H
#include "NodoPaciente.h"
#include "Paciente.h"
class ListaPacientes {
public:
    ListaPacientes();

    NodoPaciente *getFirstPaciente();
    NodoPaciente *getPrevPaciente();
    void setFirstPaciente(NodoPaciente *);
    void setPrevPaciente(NodoPaciente *);
    int getContador();
    void ingresarPaciente(Paciente *P);
    Paciente *buscarPaciente(int rut);
    virtual ~ListaPacientes();
private:
    NodoPaciente *firstPaciente;
    NodoPaciente *lastPaciente;
    int contador;

};

#endif /* LISTAPACIENTES_H */

