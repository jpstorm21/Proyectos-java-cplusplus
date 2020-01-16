#include <cstdlib>
#include "Arbol.h"
#include "Lista.h"
#include "ListaArbol.h"
#include "Nodo.h"
#include "NodoArbol.h"
#include "NodoListaArbol.h"
#include "ListaTabla.h"
#include "NodoTabla.h"
#include <string>
#include <iostream>
#include <cstdlib>
#include <fstream>

using namespace std;

bool validarPalabra(char palabra) {
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

void descomprimir(Lista * l, ListaArbol *la, ListaTabla *tabla);

void comprimir(Lista * l, ListaArbol *la, ListaTabla *tabla) {
    ifstream archivo("texto.txt");
    ofstream salida("salidaComprimida.txt.edz");
    string r = "";
    while (!archivo.eof()) {
        string s = "";
        getline(archivo, s);
        r = r + s;
    }
    string subpalabra = "";
    for (int i = 0; i < r.length(); i++) {
        bool validacion = validarPalabra(r[i]);
        if (validacion) {
            if (i == r.length() - 1) {
                subpalabra = subpalabra + r[i];
                l->agrear(subpalabra);
                subpalabra = "";
            } else {
                subpalabra = subpalabra + r[i];
            }

        } else {
            if (r[i] == ' ') {
                if (subpalabra == "") {
                    l->agrear("()");
                } else {
                    l->agrear(subpalabra);
                    l->agrear("()");
                }
                subpalabra = "";
            } else if (i == r.length() - 1) {
                subpalabra = subpalabra + r[i];
                l->agrear(subpalabra);
                subpalabra = "";
            } else {
                l->agrear(subpalabra);
                subpalabra = "";
                subpalabra = subpalabra + r[i];
                l->agrear(subpalabra);
                subpalabra = "";
            }
        }
    }


    la->armarLista(l);
    la->obtenerArbol();
    /*la->getInicio()->getArbol()->imprimir(la->getInicio()->getArbol()->getRaiz(), 1);
    cout << endl;*/
    tabla = la->obtenerHojas("", tabla, la->getInicio()->getArbol()->getRaiz());
    string direccion = tabla->unirTodo(r);
    //cout << "direcciones: " << direccion << endl;
    salida << direccion;
    la->getInicio()->getArbol()->imprimirTXT(la->getInicio()->getArbol()->getRaiz(), 1, salida);
    /*string palabraR = tabla->descomprimir(direccion, la->getInicio()->getArbol());
    cout << "palabra: " << palabraR << endl;
    cout << endl;*/
    cout << "palabra comprimida archivo generado" << endl;
    descomprimir(l, la, tabla);
}

/*void comprimir(Lista * l, ListaArbol *la, ListaTabla *tabla) {
    ifstream archivo("texto.txt");
    ofstream salida("salidaComprimida.txt.edz");
    string r = "";
    while (!archivo.eof()) {
        string s = "";
        getline(archivo, s);
        r = r + s;
    }
    string subpalabra = "";
    for (int i = 0; i < r.length(); i++) {
        if (r[i] == ' ') {
            l->agrear(subpalabra);
            subpalabra = "";
        } else if (i == r.length() - 1) {
            subpalabra = subpalabra + r[i];
            l->agrear(subpalabra);
            subpalabra = "";
        } else {
            subpalabra = subpalabra + r[i];
        }
    }
    la->armarLista(l);
    la->obtenerArbol();
    /*la->getInicio()->getArbol()->imprimir(la->getInicio()->getArbol()->getRaiz(), 1);
    cout << endl;
    tabla = la->obtenerHojas("", tabla, la->getInicio()->getArbol()->getRaiz());
    string direccion = tabla->unirTodo(r);
    //cout << "direcciones: " << direccion << endl;
    salida << direccion;
    la->getInicio()->getArbol()->imprimirTXT(la->getInicio()->getArbol()->getRaiz(), 1, salida);
    /*string palabraR = tabla->descomprimir(direccion, la->getInicio()->getArbol());
    cout << "palabra: " << palabraR << endl;
    cout << endl;
    cout << "palabra comprimida archivo generado" << endl;
    descomprimir(l,la,tabla);
}*/

void descomprimir(Lista * l, ListaArbol *la, ListaTabla *tabla) {
    ifstream archivo("salidaComprimida.txt.edz");
    ofstream salida("salidaDescomprimido.txt.edz");
    string r = "";
    string s = "";
    getline(archivo, s);
    r = r + s;
    salida << tabla->descomprimir(r, la->getInicio()->getArbol());
    cout << "palabra descomprimida a traves del archivo comprimido archivo generado" << endl;
}

int main() {
    Lista * l = new Lista();
    ListaArbol *la = new ListaArbol();
    ListaTabla *tabla = new ListaTabla();
    comprimir(l, la, tabla);
}

