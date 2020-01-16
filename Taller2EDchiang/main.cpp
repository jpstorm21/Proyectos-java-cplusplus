#include <cstdlib>
#include <iostream>
#include <string>
#include "Contribuyente.h"
#include "ABB.h"
#include "NodoABB.h"
#include "Fecha.h"
#include <ctime>
#include <fstream> 
#include <stdio.h>
#include <stdlib.h>
using namespace std;
void IngrearPersona(ABB *arbol);
void IniciarAtencion(ABB *arbol);
void personasPorAtender(ABB *arbol);
void InformeDeAtencion(ABB *arbol);

void menu(ABB *arbol) {

    // MENU PRINCIPAL
    int opcion = 0;
    while (opcion != 5) {
        cout << "----------------------------------------------------------" << endl;
        cout << "\t[MENU]" << endl;
        cout << "[1] Registrar Persona" << endl;
        cout << "[2] Iniciar atencion de la persona" << endl;
        cout << "[3] Cantidad de personas que faltan por atender" << endl;
        cout << "[4] Generar informe de atencion" << endl;
        cout << "[5] Salir" << endl;
        cout << " > ";
        cin>> opcion;

        switch (opcion) {
            case 1:
                cout << "----------------------------------------------------------" << endl;
                IngrearPersona(arbol);
                break;
            case 2:
                cout << "----------------------------------------------------------" << endl;
                IniciarAtencion(arbol);
                break;
            case 3:
                cout << "----------------------------------------------------------" << endl;
                personasPorAtender(arbol);
                break;
            case 4:
                cout << "----------------------------------------------------------" << endl;
                InformeDeAtencion(arbol);
                break;
            default:
                opcion = 5;
        }
    }
}

void IngrearPersona(ABB *arbol) {
    int rut;
    cout << "ingrese rut de la persona a registrar: ";
    cin>>rut;
    time_t now = time(0);
    tm *ltm = localtime(&now);
    int hora = ltm->tm_hour;
    int min = ltm->tm_min;
    Fecha *Finicial = new Fecha(hora, min);
    Fecha *Ffinal = new Fecha(0, 0);
    int numeroAtencion = arbol->getCantPersonas() + 1;
    Contribuyente *C = new Contribuyente(rut, numeroAtencion, false);
    C->setTiempoInicial(Finicial);
    C->setTiempoFinal(Ffinal);
    arbol->insertar(C);
    cout << "persona ingresada exitosamente su numero de atencion es: " << C->getNumeroAtencion() << " espere tranquilamente" << endl;
}

void IniciarAtencion(ABB *arbol) {
    int rut;
    cout << "ingrese rut de la persona: ";
    cin>>rut;
    Contribuyente *C = arbol->buscar(rut, arbol->getRaiz());
    if (C != NULL) {
        C->setAtendido(true);
        time_t now = time(0);
        tm *ltm = localtime(&now);
        int hora = ltm->tm_hour;
        int min = ltm->tm_min;
        Fecha *F = C->getTiempoFinal();
        F->setHora(hora);
        F->setMin(min);
        cout << "persona fue atendida" << endl;
    } else {
        cout << "persona no existe" << endl;
    }
}

void personasPorAtender(ABB *arbol) {
    int cant = arbol->PreOrden();
    cout << "la cantidad de personas por atender es : " << cant << endl;
}

int Recorrer(NodoABB *nodo, Contribuyente *vector[], int pos) {
    if (nodo != NULL) {
        if (nodo->getContribuyente()->getAtendido()) {
            vector [pos] = nodo->getContribuyente();
            pos++;
        }
        Recorrer(nodo->getHijoIzq(), vector, pos);
        Recorrer(nodo->getHijoDer(), vector, pos);
    } else {
        return pos;
    }

}

void ordenar(Contribuyente *arreglo[], int pos) {
    for (int i = 0; i < pos - 1; i++) {
        for (int j = 0; j < pos - 1; j++) {
            Fecha *f1 = arreglo[j]->getTiempoFinal();
            Fecha *f11 = arreglo[j]->getTiempoInicial();
            Fecha *f2 = arreglo[j + 1]->getTiempoFinal();
            Fecha *f22 = arreglo[j + 1]->getTiempoInicial();
            int cant = (f1->getHora()* 60 + f1->getMinutos())-(f11->getHora()*60 + f11->getMinutos());
            int cant2 = (f2->getHora()*60 + f2->getMinutos())-(f22->getHora()*60 + f22->getMinutos());
            if (cant < cant2) {
                Contribuyente *tmp = arreglo[j + 1];
                arreglo[j + 1] = arreglo[j];
                arreglo[j] = tmp;
            }
        }
    }
}

void InformeDeAtencion(ABB *arbol) {
    Contribuyente * vector[arbol->getCantPersonas() - arbol->PreOrden()];
    int pos = Recorrer(arbol->getRaiz(), vector, 0);
    ordenar(vector, pos);
    cout << "-----------------------------------------------------------------------------------------------" << endl;
    for (int i = 0; i < pos; i++) {
        cout << "rut: " << vector[i]->getRut() << endl;
        cout << "numero de atencion: " << vector[i]->getNumeroAtencion() << endl;
        Fecha *f1 = vector[i]->getTiempoInicial();
        Fecha *f2 = vector[i]->getTiempoFinal();
        int cant = f1->getHora()* 60 + f1->getMinutos();
        int cant2 = f2->getHora()*60 + f2->getMinutos();
        cout << "tiempo que tardo: " << cant2 - cant << " minutos" << endl;
        cout << "-----------------------------------------------------------------------------------------------" << endl;
    }
}

int main() {
    ABB *arbol = new ABB();
    menu(arbol);
    string nombre = "informe.txt";
    ofstream archivo;
    archivo.open(nombre.c_str(), ios::out);
    arbol->imprimir(arbol->getRaiz(),1,archivo);
    archivo<<endl;
    archivo<<endl;
    cout<<"informe generado"<<endl;
    return 0;
}

