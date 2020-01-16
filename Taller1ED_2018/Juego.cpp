

#include "Juego.h"
#include <string.h>
#include <iostream>
using namespace std;
Juego::Juego(string codigo, string nombre, string desarrollador, string plataforma, string fecha, int stockInicial, int stockActual, int precio) {
    this->codigo=codigo;
    this->nombre=nombre;
    this->desarrollador=desarrollador;
    this->plataforma=plataforma;
    this->fecha=fecha;
    this->stockInicial=stockInicial;
    this->stockActual=stockActual;
    this->precio=precio;

}

string Juego::getCodigo() {
    return codigo;
}

string Juego::getNombre() {
    return nombre;
}

string Juego::getDesarrollador() {
    return desarrollador;
}

string Juego::getPlataforma() {
    return plataforma;
}

string Juego::getFecha() {
    return fecha;
}

int Juego::getStockInicial() {
    return stockInicial;
}

int Juego::getStockActual() {
    return stockActual;
}

int Juego::getPrecio() {
    return precio;
}

void Juego::setCodigo(string codigo) {
    this->codigo=codigo;
}

void Juego::setNombre(string nombre) {
    this->nombre=nombre;
}

void Juego::setDesarrollador(string desarrollador) {
    this->desarrollador=desarrollador;
}

void Juego::setPlataforma(string plataforma) {
    this->plataforma=plataforma;
}

void Juego::setFecha(string fecha) {
    this->fecha=fecha;
}

void Juego::setStockInicial(int stockInicial) {
    this->stockInicial=stockInicial;
}

void Juego::setStockActual(int stockActual) {
    this->stockActual=stockActual;
}

void Juego::setPrecio(int precio) {
    this->precio=precio;
}


Juego::~Juego() {
}

