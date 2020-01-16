/* 
 * Ejemplo de clase template con TDA cola que acepta integer y float
 * La cola se implementar? con una lista con punteros, usando template
 * tanto para el elemento de la lista como para el TDA cola
 * Author: Carlos
 * Created on 1 de octubre de 2016, 08:32 PM
 */

#include<iostream>
#include <cstdlib>
#include "Elemento.h"
#include "Cola.h"

using namespace std;


int main(int argc, char** argv) {

    //Creaci?n de objetos con la misma clase pero de distintos tipos de
    //objetos a almecenar, enteros y float respectivamente. Se esta usando 
    //una cola declarada template
    Cola<int> colaint;
    Cola<float> colafloat;
    
    int   x = 10;
    float y = 14.6;
    
    //Ingresa datos a cola de enteros
    colaint.ingresaCola(x);
    x = 11;
    colaint.ingresaCola(x);
    x = 12;
    colaint.ingresaCola(x);
    x = 13;
    colaint.ingresaCola(x);
    
    //Ingresa dato a cola de float
    colafloat.ingresaCola(y);
    
    //obtiene y saca objtos de la cola de enteros
    cout << colaint.muestraCola()<< endl;
    colaint.sacaCola();
    cout << colaint.muestraCola()<< endl;
    colaint.sacaCola();
    cout << colaint.muestraCola()<< endl;
    colaint.sacaCola();
    
    //Usa m?todo isEmpty para verificar si quedan objetos en cola enteros
    if (!colaint.isEmpty()){
            cout << colaint.muestraCola()<< endl;
            colaint.sacaCola();
    }
    
    if (!colaint.isEmpty()){
            cout << colaint.muestraCola()<< endl;
            colaint.sacaCola();
    }
    else cout<<"Cola Vacia"<< endl;
    
    //Usa m?todo isEmpty para verificar si quedan objetos en cola float
    if (!colafloat.isEmpty()){
            cout << colafloat.muestraCola()<< endl;
            colafloat.sacaCola();
    }
    else cout<<"Cola Vacia"<< endl;
    
    return 0;
}