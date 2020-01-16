#ifndef NODOPACIENTE_H
#define NODOPACIENTE_H
#include "Paciente.h"
class NodoPaciente {
public:
    NodoPaciente();
    NodoPaciente(Paciente *P);
    NodoPaciente *getNextPaciente();
    NodoPaciente *getPrevPaciente();
    Paciente *getPaciente();
    void setNextPaciente(NodoPaciente *);
    void setPrevPaciente(NodoPaciente *);
    
    virtual ~NodoPaciente();
private:
    Paciente *paciente;
    NodoPaciente *nextPaciente;
    NodoPaciente *prevPaciente;

};

#endif /* NODOPACIENTE_H */

