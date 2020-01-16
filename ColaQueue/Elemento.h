/* 
 * File:   Elemento.h
 * Declaraci?n de clase template elemento, nodo de la lista con punteros
 * El elemento aceptar? datos de tipo enteros o float
 * Author: Carlos
 * Created on 1 de octubre de 2016, 08:45 PM
 */

#ifndef ELEMENTO_H
#define	ELEMENTO_H

template <class Tipo> class Elemento {
public:
    //Funciones de la API de la clase
    Elemento(); // Constructor
    void setDato(Tipo dato);
    Tipo getDato();
    void setSiguiente(Elemento *elemento);
    Elemento* getSiguiente();
private:
    //Datos privados de la clase
    Tipo dato;
    Elemento<Tipo>  *siguiente;
};

#endif	/* ELEMENTO_H */
