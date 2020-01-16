/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Victor Huerta
 *
 * Created on 25 de septiembre de 2018, 19:29
 */

#include <cstdlib>
#include "LinkedList.h"

using namespace std;

int main() {
    LinkedList *lk = new LinkedList();
    lk->ingresarDato(5);
    lk->ingresarDato(9);
    lk->ingresarDato(2);
    lk->ingresarDato(7);
    lk->ingresarDato(3);
    lk->eliminarDato(7);
    lk->imprimir();

    return 0;
}

