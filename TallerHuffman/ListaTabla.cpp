#include "ListaTabla.h"
#include <cstdlib>
#include <iostream>

ListaTabla::ListaTabla() {
    this->inicio = NULL;
}

NodoTabla* ListaTabla::getInicio() {
    return this->inicio;
}

void ListaTabla::setInicio(NodoTabla* inicio) {
    this->inicio = inicio;
}

void ListaTabla::agregar(string valor, string ubicacion) {
    NodoTabla *nuevo = new NodoTabla(valor, ubicacion);
    if (this->getInicio() == NULL) {
        this->setInicio(nuevo);
    } else {
        nuevo->setSiguiente(inicio);
        inicio = nuevo;
    }
}

void ListaTabla::imprimir() {
    if (this->getInicio() != NULL) {
        NodoTabla *aux = inicio;
        while (aux != NULL) {
            std::cout << aux->getDato() << ":" << aux->getUbicacion();
            aux = aux->getSiguiente();
        }
    }
}

string ListaTabla::ubicacionDe(string dato) {
    NodoTabla *aux = inicio;
    while (aux != NULL && !(aux->getDato() == dato)) {
        aux = aux->getSiguiente();
    }
    return aux->getUbicacion();
}

string ListaTabla::unirTodo(string palabra) {
    if (this->getInicio() == NULL) {
        string error = "lista vacia" ;
        return error;
    }
    string todo = "";
    string subpalabra ="";
    for (int i = 0; i < palabra.length(); i++) {
         if(palabra[i] == ' '){
             todo = todo +ubicacionDe(subpalabra) +" ";
            subpalabra ="";
        }else if(i == palabra.length()-1){
           subpalabra =subpalabra + palabra[i];
           todo = todo +ubicacionDe(subpalabra)+ " ";
            subpalabra ="";
        }else{
            subpalabra = subpalabra + palabra[i];
        }
    }
    return todo;
}

string ListaTabla::palabraDe(string ubicacion) {
    string letra = "";
    NodoTabla *aux = inicio;
    while (aux != NULL && !(aux->getUbicacion() == ubicacion)) {
        aux = aux->getSiguiente();
    }
    if (aux != NULL)
        letra = aux->getDato();
    return letra;
}

NodoTabla *ListaTabla::sacarInicio() {
    if (this->inicio == NULL) {
        return NULL;
    }
    NodoTabla *aux = inicio;
    inicio = aux->getSiguiente();
    aux->setSiguiente(NULL);
    return aux;
}

bool validarPalabraX(char palabra) {
    bool re = false;
    string abecedario = "AaBbCcDdEeFfGgHhIiJjKkLlMmNnÑñOoPpQqRrSsTtUuVvWwXxYyZz0123456789";
    for (int i = 0; i < abecedario.length(); i++) {
        if (palabra == abecedario[i]) {
            re = true;
            break;
        }
    }
    return re;
}

string ListaTabla::descomprimir(string direcciones,Arbol * nodo) {
    string subpalabra = "";
    string resultado = "";
    for(int i = 0; i<direcciones.length();i++){    
        if(direcciones[i] == ' '){
            resultado = resultado + " "+nodo->buscarrec(subpalabra,nodo->getRaiz());
            subpalabra ="";
        }else if(i == direcciones.length()-1){
            subpalabra =subpalabra + direcciones[i];
            resultado = resultado +" "+ nodo->buscarrec(subpalabra,nodo->getRaiz());
            subpalabra ="";
        }else{
            subpalabra =subpalabra + direcciones[i];
        }
    }
    return resultado;
}

ListaTabla::~ListaTabla() {
}

