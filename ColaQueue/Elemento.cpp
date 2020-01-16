/* 
 * File:   Elemento.cpp
 * Implementaci?n de la interface de la clase elemento
 * Author: Carlos
 * Created on 1 de octubre de 2016, 08:45 PM
 */

#include "Elemento.h"

template <class Tipo> Elemento<Tipo>::Elemento() {
}

template <class Tipo> void Elemento<Tipo>::setDato(Tipo dato){
    
    //Agregar un dato al elemento de la lista
    this->dato= dato;

}

template <class Tipo> Tipo Elemento<Tipo>::getDato(){
    
    //Recuperaci?n de un dato de la lista
    return dato;
}
    
template <class Tipo> void Elemento<Tipo>::setSiguiente(Elemento<Tipo> *elemento){
    
    //Agregar una direcci?n para el puntero siguiente
    this->siguiente = elemento;
    
}

template <class Tipo> Elemento<Tipo>* Elemento<Tipo>::getSiguiente(){
    
    //Recuperaci?n del puntero del elemento siguiente
    return siguiente;
}

//Importante: indica a compilador con que tipo de datos se usar? la clase
template class Elemento<int>;
template class Elemento<float>;