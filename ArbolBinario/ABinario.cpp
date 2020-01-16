
#include "ABinario.h"
#include <iosfwd>
#include "Nodo.h" 
#include <iostream>
using namespace std;

ABinario::ABinario() {
    this->raiz = NULL;
}

void ABinario::ingresarIterativo(int dato) {
    if (this->raiz == NULL) {
        raiz = new Nodo(dato);
    } else {
        Nodo *actual = this->raiz;
        while (true) {
            if (actual->getDato() > dato) {//se insertara a la izquierda
                if (actual->getIzq() == NULL) {
                    actual->setIzq(new Nodo(dato));
                } else {
                    actual = actual->getIzq();
                }
            } else if (actual->getDato() < dato) {
                if (actual->getDer() == NULL) {
                    actual->setDer(new Nodo(dato));
                } else {
                    actual = actual->getDer();
                }
            } else {//dato ya existe
                break;
            }
        }
    }
}

void ABinario::ingresarR(int dato) {
    if (this->raiz == NULL) {
        this->raiz = new Nodo(dato);
    } else {
        ingresarRecursivo(dato, this->raiz);
    }
}

void ABinario::ingresarRecursivo(int dato, Nodo* raiz) {
    if (raiz->getDato() < dato) {
        if (raiz->getDer() == NULL) {
            raiz->setDer(new Nodo(dato));
        } else {
            ingresarRecursivo(dato, raiz->getDer());
        }
    } else if (raiz->getDato() > dato) {
        if (raiz->getIzq() == NULL) {
            raiz->setIzq(new Nodo(dato));
        } else {
            ingresarRecursivo(dato, raiz->getIzq());
        }
    }
}

void ABinario::buscar(int dato) {
    if (this->raiz == NULL) {
        cout << "no se encuentra dato" << endl;
    } else if (this->raiz->getDato() == dato) {
        cout << "dato encontrado" << endl;
    } else {
        Nodo *actual = this->raiz;
        while (true) {
            if (actual->getDato() > dato) {
                if (actual->getIzq()->getDato() == dato) {
                    cout << "dato encontrado" << endl;
                    break;
                } else {
                    actual = actual->getIzq();
                }
            } else {
                if (actual->getDato() < dato) {
                    if (actual->getDer()->getDato() == dato) {
                        cout << "dato encontrado" << endl;
                        break;
                    } else {
                        actual = actual->getDer();
                    }
                }
            }
        }
    }
}

ABinario::~ABinario() {
}

