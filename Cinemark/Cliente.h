/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Cliente.h
 * Author: ASUS
 *
 * Created on 4 de febrero de 2018, 19:30
 */

#ifndef CLIENTE_H
#define CLIENTE_H

class Cliente : public Persona{
public:
    Cliente();
    Cliente(const Cliente& orig);
    virtual ~Cliente();
private:

};

#endif /* CLIENTE_H */

