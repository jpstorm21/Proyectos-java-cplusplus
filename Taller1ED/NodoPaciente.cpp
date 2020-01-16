#include "NodoPaciente.h"

#include "NodoPaciente.h"
#include "Paciente.h"
NodoPaciente::NodoPaciente() {
}

NodoPaciente::NodoPaciente(Paciente *P) {
    this->paciente = P;
   
}
Paciente *NodoPaciente::getPaciente(){
    return this->paciente;
}
NodoPaciente *NodoPaciente::getNextPaciente(){
    return this->nextPaciente;
}

NodoPaciente *NodoPaciente::getPrevPaciente(){
    return this->prevPaciente;
}
void NodoPaciente::setNextPaciente(NodoPaciente *nextPaciente){
    this->nextPaciente=nextPaciente;
}
void NodoPaciente::setPrevPaciente(NodoPaciente *prevPaciente){
    this->prevPaciente=prevPaciente;
}
NodoPaciente::~NodoPaciente() {
}

