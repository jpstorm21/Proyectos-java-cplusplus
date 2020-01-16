#include "Paciente.h"

Paciente::Paciente() {
}

Paciente::Paciente(int rut) {
    this->rut=rut;
    this->le = new ListaExamenes();

}
int Paciente::getRut(){
    return this->rut;
}
void Paciente::setRut(int rut){
    this->rut=rut;
}

ListaExamenes *Paciente::getListaExamenes() {
    return this->le;
}

Paciente::~Paciente() {
}

