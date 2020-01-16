#include "ABB.h"
#include <cstdlib>
#include <iostream>
using namespace std;

ABB::ABB() {
    this->raiz = NULL;
}

Nodo* ABB::getRaiz() {
    return this->raiz;
}

void ABB::insertar(int dato) {//insertar iterativo
    Nodo *nuevo = new Nodo(dato);
    if (this->raiz == NULL) {
        this->raiz = nuevo;
    } else {
        Nodo *actual = this->raiz;
        Nodo *padre;
        while (true) {
            padre = actual;
            if (dato < actual->getDato()) {//insertar hacia la izquierda
                if (actual->getHijoIzqui() == NULL) {
                    padre->setHijoIzqui(nuevo);
                    return;
                }
            } else {//insertar hacia la derecha
                if (actual->getHijoDerech() == NULL) {
                    padre->setHijoDerech(nuevo);
                    return;
                }
            }
        }
    }
}

void ABB::insertarRecursivo(int dato) {
    if (this->raiz == NULL) {
        this->raiz = new Nodo(dato);
    } else {
        inserccion(dato, this->raiz);
    }


}

bool ABB::inserccion(int dato, Nodo*raiz) {
    if (dato < raiz->getDato()) {
        if (raiz->getHijoIzqui() == NULL) {
            raiz->setHijoIzqui(new Nodo(dato));
            return true;
        } else {
            inserccion(dato, raiz->getHijoIzqui());
        }
    } else if (dato > raiz->getDato()) {
        if (raiz->getHijoDerech() == NULL) {
            raiz->setHijoDerech(new Nodo(dato));
            return true;
        } else {
            inserccion(dato, raiz->getHijoDerech());
        }
    } else {
        return false;
    }
}

bool ABB::degenerado() {
    if (this->raiz == NULL) {
        return false;
    } else {
        bool d = degeneradoRecursivo(raiz);
        if (d) {
            return true;
        } else {
            false;
        }
    }
}

bool ABB::degeneradoRecursivo(Nodo* nodo) {
    if (nodo->getHijoDerech() == NULL) {
        if (nodo->getHijoIzqui() != NULL && nodo->getHijoIzqui()->getDato() < nodo->getDato()) {
            degeneradoRecursivo(nodo->getHijoIzqui());
            return true;
        } else {
            return false;
        }
    } else {
        return false;
    }

}

int ABB::alturaRecursivo(Nodo* raiz) {
    int h = 0;
    if (raiz != NULL) {
        int altura_IZQ = alturaRecursivo(raiz->getHijoIzqui());
        int altura_DER = alturaRecursivo(raiz->getHijoDerech());
        if (altura_IZQ > altura_DER) {
            h = altura_IZQ + 1;
        } else {
            h = altura_DER + 1;
        }
    }
    return h;
}

int ABB::desbalance(Nodo* arbol) {
    int alturaIZQ = alturaRecursivo(arbol->getHijoIzqui());
    int alturaDER = alturaRecursivo(arbol->getHijoDerech());
    int desbalance = alturaIZQ - alturaDER;
    return desbalance;
}

bool ABB::arbolCompleto(Nodo *nodo) {
    if (nodo == NULL) {
        return true;
    } else {
        if (alturaRecursivo(nodo->getHijoIzqui()) != alturaRecursivo(nodo->getHijoDerech())) {
            return false;
        }
        return arbolCompleto(nodo->getHijoIzqui()) && arbolCompleto(nodo->getHijoDerech());
    }
}

bool ABB::esABB() {
    if (this->raiz == NULL) {
        return false;
    } else {
        return esABBrec(raiz);
    }
}

bool ABB::esABBrec(Nodo* nodo) {
    if (nodo != NULL && nodo->getHijoIzqui() != NULL && nodo->getHijoDerech() != NULL) {
        if (nodo->getDato() > nodo->getHijoIzqui()->getDato()) {
            esABBrec(nodo->getHijoIzqui());
        } else {
            return false;
        }
        if (nodo->getDato() < nodo->getHijoDerech()->getDato()) {
            esABBrec(nodo->getHijoDerech());
        } else {
            return false;
        }
    }
    return true;

}

void ABB::eliminarDato(int dato) {
    raiz = eliminarDato(dato, raiz);
}

Nodo *ABB::eliminarDato(int dato, Nodo *nodo) {
    if (nodo == NULL) {
        cout << "No se encontro el dato" << endl;
    } else if (dato < nodo->getDato()) {
        Nodo *izq = eliminarDato(dato, nodo->getHijoIzqui());
        nodo->setHijoIzqui(izq);
    } else if (dato > nodo->getDato()) {
        Nodo *der = eliminarDato(dato, nodo->getHijoDerech());
        nodo->setHijoDerech(der);
    } else {
        Nodo *paraEliminar = nodo;
        if (paraEliminar->getHijoIzqui() == NULL) { // solo tiene hijo der
            nodo = paraEliminar->getHijoDerech();
        } else if (paraEliminar->getHijoDerech() == NULL) { // solo tiene hijo izq
            nodo = paraEliminar->getHijoIzqui();
        } else { // tiene dos hijos
            paraEliminar = reemplazar(paraEliminar);
        }
        paraEliminar = NULL;
    }
    return nodo;
}

Nodo *ABB::reemplazar(Nodo *actual) {
    Nodo *a, *p;
    p = actual;
    a = actual->getHijoIzqui();
    while (a->getHijoDerech() != NULL) {
        p = a;
        a = a->getHijoDerech();
    }
    actual->setDato(a->getDato());
    if (p == actual) { // a es el hijo izq de actual
        p->setHijoIzqui(a->getHijoIzqui()); // by pass
    } else {
        p->setHijoDerech(a->getHijoDerech()); // bypass
    }
    return a;

}

void ABB::Rotacion(Nodo* raiz) {
    int factorDeBalance = desbalance(raiz);
    if (factorDeBalance > 1) {
        if (desbalance(raiz->getHijoIzqui()) > 0) {
            cout << "rotacion derecha" << endl;
        } else {
            cout << "rotacion izquierda derecha" << endl;
        }
    } else if (factorDeBalance < -1) {
        if (desbalance(raiz->getHijoDerech()) < 0) {
            cout << "rotacion izquierda" << endl;
        } else {
            cout << "rotacion derecha izquierda" << endl;
        }
    } else {
        cout << "no necesita rotacion esta balanceado" << endl;
    }
}

int ABB::ValorMin() {
    Nodo *actual = this->raiz;
    int menor = 9999;
    while (actual != NULL) {
        if (actual->getDato() < menor) {
            menor = actual->getDato();
        }
        actual = actual->getHijoIzqui();
    }
    return menor;

}

int ABB::ValorMax() {
    Nodo *actual = this->raiz;
    int mayor = -99999;
    while (actual != NULL) {
        if (actual->getDato() > mayor) {
            mayor = actual->getDato();
        }
        actual = actual->getHijoDerech();
    }
    return mayor;
}

bool ABB::buscar(int dato, Nodo *actual) {
    if (actual == NULL) {
        return false;
    }
    if (actual->getDato() == dato) {
        return true;
    } else if (actual->getDato() > dato) {
        buscar(dato, actual->getHijoIzqui());
    } else {
        buscar(dato, actual->getHijoDerech());
    }
}

int ABB::cantVeces(int cant, Nodo* actual,int dato) {
    if (actual == NULL) {
        return cant;
    }
    if (actual->getDato() > dato) {
        if(actual->getDato() == dato){
            cant++;
        }
        cantVeces(cant, actual->getHijoIzqui(),dato);
    } else {
        if(actual->getDato() == dato){
            cant++;
        }
        cantVeces(cant, actual->getHijoDerech(),dato);
    }
}

int ABB::numeroNodo(Nodo * nodo) {
    int cant= 0;
    if(nodo ==NULL){
        return 0;
    }else{
        cant = numeroNodo(nodo->getHijoIzqui()) + numeroNodo(nodo->getHijoDerech());
        return cant + 1;//se le suma 1 por la raiz
    }
}


ABB::~ABB() {
}

