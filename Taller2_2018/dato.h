/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   dato.h
 * Author: Juan Pablo Martinez
 *
 * Created on 5 de junio de 2018, 19:53
 */

#ifndef DATO_H
#define DATO_H

class dato {
public:
    dato(int numero);
    int getNumero();
    virtual ~dato();
private:
    int numero;
};

#endif /* DATO_H */

