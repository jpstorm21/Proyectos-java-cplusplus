#include "Examen.h"
#include <string>
using namespace std;

Examen::Examen (int codigo, string tipo){
	this->codigo=codigo;
	this->tipo=tipo;
        this->realizado=false;
}

int Examen::getCodigo(){
	return this->codigo;
}

void Examen::setCodigo(int codigo){
	this->codigo=codigo;
}

string Examen::getTipo(){
	return this->tipo=tipo;
}

void Examen::setTipo(string tipo){
	this->tipo=tipo;
}

void Examen::setRealizado(bool realizado){
    this->realizado= realizado;
}
bool Examen::getRealizado(){
    return this->realizado;
}