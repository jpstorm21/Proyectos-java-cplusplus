/* 
 * File:   Cola.cpp
 * Implementaci?n de la interface de la clase cola
 * Author: Carlos
 * Created on 1 de octubre de 2016, 09:52 PM
 */

#include "Cola.h"
#include <iostream>
using namespace std;

template <class Tipo> Cola<Tipo>::Cola() {
    
    //Inicia a la lista con punteros vacia
    frente  = NULL;
    posterior = NULL;
}

template <class Tipo> void Cola<Tipo>::ingresaCola(Tipo dato){
    
    //Agrega un nuevo nodo a la lista con punteros
    Elemento<Tipo> *elemento = new Elemento<Tipo>();
    elemento->setDato(dato);
    elemento->setSiguiente(NULL);

    //Verifica si lista con punteros est? vacia, agregando primer nodo
    if (frente == NULL && posterior == NULL) {
         frente = elemento;
	 posterior = elemento;}
    else {
    //Agrega nodo para una lista ya con elementos
    posterior->setSiguiente(elemento); 
    posterior = elemento;}
   
}

template <class Tipo> void Cola<Tipo>::sacaCola(){

    //Verifica si la cola tiene elementos. si esta vacia, no hace nada
    //Si la cola tiene un elemento, lo saca y deja lista vacia
    if (frente != NULL){
        frente = frente->getSiguiente();
        if (frente == NULL) posterior = NULL;}

}


template <class Tipo> Tipo Cola<Tipo>::muestraCola(){
    
    //Retorna el dato en el frente de la lista
    return  frente->getDato();
    
}

template <class Tipo> bool Cola<Tipo>::isEmpty(){

    //Permite verificar si lista con punteros no tiene nodos
    if (frente == NULL)
        return true;
        else return false; 

}

//Importante: indica a compilador con que tipo de datos se usar? la clase
template class Cola<int>;
template class Cola<float>;
