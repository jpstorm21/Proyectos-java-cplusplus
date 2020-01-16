/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   dato.cpp
 * Author: Juan Pablo Martinez
 * 
 * Created on 5 de junio de 2018, 19:53
 */

#include "dato.h"

dato::dato(int numero) {
    this->numero =numero;
}

int dato::getNumero() {
    return numero;
}


dato::~dato() {
}

