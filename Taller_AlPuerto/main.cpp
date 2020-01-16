/* 
 * File:   main.cpp
 * Author: Juan Pablo Martinez Romero
 */
#include <cstdlib>
#include "Barco.h"
#include "Estandar.h"
#include "Grua.h"
#include "ListaGruas.h"
#include "ListaOperarios.h"
#include "Mega.h"
#include "NodoGrua.h"
#include "Operario.h"
#include <iostream>
#include <string>
#include <fstream>
#include "ListaBarcos.h"
#include <sstream>
using namespace std;

void leerArchivoBarcos(ListaBarcos *lb) {
    ifstream archivo("ArchivoBarcos.txt");
    if (archivo) {
        if (archivo.is_open()) {
            string cant;
            string nombreBarco;
            string nombrePiloto;
            string tipoBarco;
            string paisOrigen;
            string carga;
            string cantContainer;
            string cantCarga;
            string horaLlegada;
            string cantTrabajadores;
            string ciudadOrigen;
            getline(archivo, cant);
            for (int i = 0; i < atoi(cant.c_str()); i++) {
                getline(archivo, nombreBarco, ',');
                getline(archivo, nombrePiloto, ',');
                getline(archivo, tipoBarco, ',');
                if (tipoBarco == "estandar") {
                    getline(archivo, paisOrigen, ',');
                    getline(archivo, carga, ',');
                    getline(archivo, cantContainer, ',');
                    getline(archivo, cantCarga, ',');
                    getline(archivo, horaLlegada, '\n');
                    Barco *B = new Estandar(nombreBarco, nombrePiloto, tipoBarco, paisOrigen, carga, atoi(cantContainer.c_str()), atoi(cantCarga.c_str()), horaLlegada);
                    lb->ingresarBarco(B);
                } else {
                    getline(archivo, cantTrabajadores, ',');
                    getline(archivo, ciudadOrigen, ',');
                    getline(archivo, paisOrigen, ',');
                    getline(archivo, carga, ',');
                    getline(archivo, cantContainer, ',');
                    getline(archivo, cantCarga, ',');
                    getline(archivo, horaLlegada, '\n');
                    Barco *B = new Mega(nombreBarco, nombrePiloto, tipoBarco, paisOrigen, carga, atoi(cantContainer.c_str()), atoi(cantCarga.c_str()), horaLlegada, atoi(cantTrabajadores.c_str()), ciudadOrigen);
                    lb->ingresarBarco(B);
                }

            }
        }
        archivo.close();
    } else {
        cout << "archivo no existe" << endl;
    }
}

void leerArchivoOperarios(ListaOperarios *lo) {
    ifstream archivo("ArchivoOperarios.txt");
    if (archivo) {
        if (archivo.is_open()) {
            string cant;
            string nombre;
            string cedulaIdentidad;
            string horasTrabajadas;
            string estado;
            getline(archivo, cant);
            for (int i = 0; i < atoi(cant.c_str()); i++) {
                getline(archivo, nombre, ',');
                getline(archivo, cedulaIdentidad, ',');
                getline(archivo, horasTrabajadas, ',');
                getline(archivo, estado, '\n');
                Operario *O = new Operario(nombre, cedulaIdentidad, atoi(horasTrabajadas.c_str()), atoi(estado.c_str()));
                lo->ingresarOperario(O);
            }
        }
        archivo.close();
    } else {
        cout << "archivo no existe" << endl;
    }
}

void leerArchivoGruas(ListaGruas *lg, ListaOperarios *lo, ListaBarcos *lb) {
    ifstream archivo("ArchivoGruas.txt");
    if (archivo) {
        if (archivo.is_open()) {
            string cant;
            string codigo;
            string pesoTransportado;
            string estado;
            string horaInicio;
            string horaFin;
            string nombreOperario;
            string nombreBarco;
            getline(archivo, cant);
            for (int i = 0; i < atoi(cant.c_str()); i++) {
                getline(archivo, codigo, ',');
                getline(archivo, pesoTransportado, ',');
                getline(archivo, estado, ',');
                getline(archivo, nombreOperario, ',');
                getline(archivo, nombreBarco, ',');
                getline(archivo, horaInicio, ',');
                getline(archivo, horaFin, '\n');
                Grua *G = new Grua(codigo, atoi(pesoTransportado.c_str()), atoi(estado.c_str()), horaInicio, horaFin);
                Operario *O = lo->buscarOperario(nombreOperario);
                G->setOpeario(O);
                Barco *B = lb->buscarBarco(nombreBarco);
                G->setBarco(B);
                lg->ingresarGrua(G);
            }
        }
        archivo.close();
    } else {
        cout << "archivo no existe" << endl;
    }
}

void estadoGruas(ListaGruas *lg) {
    string ocupadas[10]; //1
    string vacias[10]; //2
    string mantencion[10]; //3
    int k = 0;
    int j = 0;
    int i = 0;
    NodoGrua *actual = lg->getFirst();
    if (actual != NULL) {
        while (actual != NULL) {
            Grua *G = actual->getGrua();
            if (G->getEstado() == 1) {
                ocupadas[i] = G->getCodigo();
                i++;
            } else if (G->getEstado() == 2) {
                vacias[j] = G->getCodigo();
                j++;
            } else {
                mantencion[k] = G->getCodigo();
                k++;
            }
            actual = actual->getNext();
        }
        cout << "ocupadas : ";
        for (int inicio = 0; inicio < i; inicio++) {
            if ((inicio + 1) == i) {
                cout << ocupadas[inicio];
            } else {
                cout << ocupadas[inicio] << "-";
            }
        }
        cout << endl;
        cout << "vacias : ";
        for (int inicio = 0; inicio < j; inicio++) {
            if ((inicio + 1) == j) {
                cout << vacias[inicio];
            } else {
                cout << vacias[inicio] << "-";
            }
        }
        cout << endl;
        cout << "mantencion : ";
        for (int inicio = 0; inicio < k; inicio++) {
            if ((inicio + 1) == k) {
                cout << mantencion[inicio];
            } else {
                cout << mantencion[inicio] << "-";
            }
        }
        cout << endl;
    } else {
        cout << "ocupadas : " << endl;
        cout << "vacias : " << endl;
        cout << "mantencion : " << endl;
    }
}
void opcion_1(ListaGruas *lg);
void opcion_2(ListaBarcos *lb, ListaGruas *lg);
void opcion_3(ListaGruas *lg);
void opcion_4(ListaGruas *lg);
void opcion_5(ListaOperarios *lo);
void opcion_6(ListaBarcos *lb);
void opcion_7(ListaBarcos *lb, ListaOperarios *lo, ListaGruas *lg);

void menu(ListaGruas *lg, ListaOperarios *lo, ListaBarcos *lb) {
    int opcion = 0;
    while (opcion != 7) {
        estadoGruas(lg);
        cout << "----------------------------------------------------------" << endl;
        cout << "\t[MENU]" << endl;
        cout << "[1] Cambiar estado de las grúas." << endl;
        cout << "[2] Ingresar nueva embarcación." << endl;
        cout << "[3] Desplegar información detallada de las grúas." << endl;
        cout << "[4] Desplegar información de un barco en particular." << endl;
        cout << "[5] Desplegar información de trabajadores." << endl;
        cout << "[6] Desplegar estadística de barcos." << endl;
        cout << "[7] salir." << endl;
        cout << " > ";
        cin>> opcion;
        switch (opcion) {
            case 1:
                cout << "----------------------------------------------------------" << endl;
                opcion_1(lg);
                cout << "----------------------------------------------------------" << endl;
                break;
            case 2:
                cout << "----------------------------------------------------------" << endl;
                opcion_2(lb,lg);
                cout << "----------------------------------------------------------" << endl;
                break;
            case 3:
                cout << "----------------------------------------------------------" << endl;
                opcion_3(lg);
                cout << "----------------------------------------------------------" << endl;
                break;
            case 4:
                cout << "----------------------------------------------------------" << endl;
                opcion_4(lg);
                cout << "----------------------------------------------------------" << endl;
                break;
            case 5:
                cout << "----------------------------------------------------------" << endl;
                opcion_5(lo);
                cout << "----------------------------------------------------------" << endl;
                break;
            case 6:
                cout << "----------------------------------------------------------" << endl;
                opcion_6(lb);
                cout << "----------------------------------------------------------" << endl;
                break;
            default:
                opcion_7(lb, lo, lg);
                opcion = 7;

        }
    }
}

void opcion_1(ListaGruas *lg) {
    NodoGrua *actual = lg->getFirst();
    while (actual != NULL) {
        Grua *G = actual->getGrua();
        float cargaAcumulada = G->getPesoTransportadoAcumulado() / 1000;
        if (cargaAcumulada <= 5.775 && cargaAcumulada >= 5.225) {
            G->setEstado(3);
            G->getOperario()->setEstado(2);
        }
        actual = actual->getNext();
    }
    int respuesta;
    cout << "¿Desea cambiar algún estado de alguna grúa?(1->si/2->no): " << endl;
    cin>>respuesta;
    if (respuesta == 1) {
        string codigo;
        cout << "Ingrese el codigo de la grúa: " << endl;
        cin>>codigo;
        Grua *G = lg->buscarGrua(codigo);
        if (G != NULL) {
            if (G->getEstado() == 1 || G->getEstado() == 3) {
                int estado;
                cout << "Ingrese el nuevo estado: " << endl;
                cin>>estado;
                if (estado == 2) {
                    G->setEstado(estado);
                    cout << "Estado cambiado" << endl;
                } else {
                    cout << "Solo se puede cambiar a estado vacía" << endl;
                }
            } else {
                cout << "El estado de la grúa ya es vacía" << endl;
            }
        } else {
            cout << "La grúa no existe" << endl;
        }
    }
}

void opcion_2(ListaBarcos *lb, ListaGruas *lg) {
    string nombreBarco;
    cout << "Ingrese nombre de la embarcación: " << endl;
    cin>>nombreBarco;
    string nombrePiloto;
    cout << "Ingrese nombre del piloto: " << endl;
    cin>> nombrePiloto;
    string tipoBarco;
    cout << "Ingrese tipo de barco: " << endl;
    string paisOrigen;
    string carga;
    int cantidadContainers;
    float cantidadCarga;
    string horaLlegada;
    if (tipoBarco == "mega") {
        int cantidadTrabajadores;
        cout << "Ingrese cantidad de trabajadores: " << endl;
        cin>>cantidadTrabajadores;
        string ciudadOrigen;
        cout << "Ingrese ciudad origen: " << endl;
        cin>>ciudadOrigen;
        cout << "Ingrese pais orgien: " << endl;
        cin>>paisOrigen;
        cout << "Ingrese tipo de carga: " << endl;
        cin>>carga;
        cout << "Ingrese cantidad de carga: " << endl;
        cin>>cantidadCarga;
        string horaLlegada;
        cout << "Ingrese hora de llegada: " << endl;
        cin>>horaLlegada;
        Barco *B = new Mega(nombreBarco, nombrePiloto, tipoBarco, paisOrigen, carga, cantidadContainers, cantidadCarga, horaLlegada, cantidadTrabajadores, ciudadOrigen);
        NodoGrua *G = lg->getFirst();
        while (G->getGrua()->getEstado() != 2) {
            G = G->getNext();
        }
        if (G->getGrua()->getEstado() == 2) {
            G->getGrua()->setBarco(B);
            bool ingreso = lb->ingresarBarco(B);
            if (!ingreso) {
                cout << "No se puedo ingresar el barco, no hay espacio suficiente." << endl;
            } else {
                cout << "Barco ingresado con exito, asignado a la grúa con el código" << G->getGrua()->getCodigo() << endl;
            }
        } else {
            cout << "No hay grúa disponible para este barco." << endl;
        }

    } else {
        cout << "Ingrese pais orgien: " << endl;
        cin>>paisOrigen;
        cout << "Ingrese tipo de carga: " << endl;
        cin>>carga;
        cout << "Ingrese cantidad de carga: " << endl;
        cin>>cantidadCarga;
        string horaLlegada;
        cout << "Ingrese hora de llegada: " << endl;
        cin>>horaLlegada;
        Barco *B = new Estandar(nombreBarco, nombrePiloto, tipoBarco, paisOrigen, carga, cantidadContainers, cantidadCarga, horaLlegada);
        NodoGrua *G = lg->getFirst();
        while (G->getGrua()->getEstado() != 2) {
            G = G->getNext();
        }

        if (G->getGrua()->getEstado() == 2) {
            G->getGrua()->setBarco(B);
            bool ingreso = lb->ingresarBarco(B);
            if (!ingreso) {
                cout << "No se puedo ingresar el barco, no hay espacio suficiente." << endl;
            } else {
                cout << "Barco ingresado con exito, asignado a la grúa con el código" << G->getGrua()->getCodigo() << endl;
            }
        } else {
            cout << "No hay grúa disponible para este barco." << endl;
        }
    }

}

void opcion_3(ListaGruas *lg) {
    string codigo;
    cout << "Ingrese el código de la grúa" << endl;
    cin>>codigo;
    Grua *G = lg->buscarGrua(codigo);
    if (G != NULL) {
        cout << "Código d ela grua: " << G->getCodigo() << endl;
        cout << "Peso transportado: " << G->getPesoTransportadoAcumulado() << endl;
        int estado = G->getEstado();
        switch (estado) {
            case 1:
                cout << "Estado: Ocupada" << endl;
                cout << "Nombre Operario: " << G->getOperario()->getNombre() << endl;
                cout << "Nombre Barco: " << G->getBarco()->getNombreBarco() << endl;
                break;
            case 2:
                cout << "Estado: Vacía" << endl;
                break;
            case 3:
                cout << "Estado: Mantención" << endl;
                break;
        }
    } else {
        cout << "La grúa no se encuentra registrada." << endl;
    }

}

void opcion_4(ListaGruas *lg) {
    string codigo;
    cout << "Ingrese el código de la grúa: " << endl;
    cin>>codigo;
    Grua *G = lg->buscarGrua(codigo);
    if (G != NULL && G->getEstado() == 1) {
        Barco *barco = G->getBarco();
        if (barco != NULL) {
            cout << "Nombre del barco: " << barco->getNombreBarco() << endl << endl;
            cout << "Nombre del piloto: " << barco->getNombrePiloto() << endl << endl;
            cout << "Tipo de barco: " << barco->getTipoBarco() << endl;
            cout << "Pais de origen: " << barco->getPaisOrigen() << endl;
            cout << "Tipo de carga: " << barco->getCarga() << endl;
            cout << "Cantidad de containers: " << barco->getCantidadContainers() << endl;
            cout << "Cantidad de carga: " << barco->getCantidadCarga() << " kgs" << endl;
            cout << "Hora de llegada: " << barco->getHoraLlegada() << endl;
            if (barco->getTipoBarco() == "Mega") {
                Mega *M = dynamic_cast<Mega *> (barco);
                cout << "Cantidad de trabajadores: " << M->getCantidaTrabajadores() << endl;
                cout << "Ciudad de origen: " << M->getCiudadOrigen();
            }
        } else {
            cout << "grua no tiene barcos asociados" << endl;
        }
    } else {
        cout << "La grúa se encuentra desocupada o en mantención, por lo que no tiene un barco asignado" << endl;
    }
}

void opcion_5(ListaOperarios *lo) {
    int cantidad = lo->getCant();
    for (int i = 0; i < cantidad; i++) {
        Operario *O = lo->getOperario(i);
        cout << "Nombre: " << O->getNombre() << endl;
        cout << "Cedula de identidad: " << O->getCedulaIdentidad() << endl;
        cout << "Horas trabajadas: " << O->getHorasTrabajadas() << endl;
        int estado = O->getEstado();
        switch (estado) {
            case 1:
                cout << "Estado: Trabajando" << endl;
                break;
            case 2:
                cout << "Estado: Desocupado" << endl;
                break;
            case 3:
                cout << "Estado: Licencia" << endl;
                break;
            case 4:
                cout << "Estado: Vacaciones" << endl;
                break;
        }
    }
}

void opcion_6(ListaBarcos *lb) {
    int tipoMega = 0;
    int tipoEstandar = 0;
    float mayorCargaMega = 0;
    float mayorCargaEstand = 0;
    int cantidadBarcos = lb->getCant();
    Barco *mayorMega;
    Barco *mayorEstandar;
    for (int i = 0; i < cantidadBarcos; i++) {
        Barco *B = lb->getBarco(i);
        if (B->getTipoBarco() == "Mega") {
            tipoMega++;
            if (B->getCantidadCarga() > mayorCargaMega) {
                mayorCargaMega = B->getCantidadCarga();
                mayorMega = B;
            }
        } else {
            tipoEstandar++;
            if (B->getCantidadCarga() > mayorCargaEstand) {
                mayorCargaEstand = B->getCantidadCarga();
                mayorEstandar = B;
            }
        }
    }
    cout << "Cantidad de barcos tipo Mega: " << tipoMega << endl;
    cout << "Cantidad de barcos tipo Estandar: " << tipoEstandar << endl;
    cout << "Nombre barco tipo Mega con mayor carga: " << mayorMega->getNombreBarco() << " con " << mayorMega->getCantidadCarga() << "kgs" << endl;
    cout << "Nombre barco tipo Estandar con mayor carga: " << mayorEstandar->getNombreBarco() << " con " << mayorEstandar->getCantidadCarga() << " kgs" << endl;
}

void opcion_7(ListaBarcos *lb, ListaOperarios *lo, ListaGruas *lg) {
    ofstream gruas("ArchivoGruas.txt");
    ofstream operarios("ArchivoOperarios.txt");
    ofstream barcos("ArchivoBarcos.txt");
    NodoGrua *actual = lg->getFirst();
    int contador = 0;
    while (actual != NULL) {
        contador++;
        actual = actual->getNext();
    }
    gruas << contador << "\n";
    actual = lg->getFirst();
    while (actual != NULL) {
        Grua *G = actual->getGrua();
        gruas << G->getCodigo() << "," << G->getPesoTransportadoAcumulado() << "," << G->getEstado() << "," << G->getOperario()->getNombre() << "," << G->getBarco()->getNombreBarco() << "," << G->getHoraInicio() <<
                "," << G->getHoraFin() << "\n";
        actual = actual->getNext();
    }
    gruas.close();
    operarios << lo->getCant() << "\n";
    for (int i = 0; i < lo->getCant(); i++) {
        Operario *O = lo->getOperario(i);
        operarios << O->getNombre() << "," << O->getCedulaIdentidad() << "," << O->getHorasTrabajadas() << "," << O->getEstado() << "\n";
    }
    operarios.close();
    barcos << lb->getCant() << "\n";
    for (int j = 0; j < lb->getCant(); j++) {
        Barco *B = lb->getBarco(j);
        if (B->getTipoBarco() == "Mega") {
            Mega *M = dynamic_cast<Mega *> (B);
            barcos << M->getNombreBarco() << "," << M->getNombrePiloto() << "," << M->getTipoBarco() << "," << M->getCantidaTrabajadores() << "," << M->getCiudadOrigen() << "," << M->getPaisOrigen() << "," << M->getCarga() << "," << M->getCantidadContainers() << "," << M->getCantidadCarga() << "," << M->getHoraLlegada() << "\n";
        } else {
            Estandar *E = dynamic_cast<Estandar *> (B);
            barcos << E->getNombreBarco() << "," << E->getNombrePiloto() << "," << E->getTipoBarco() << "," << E->getPaisOrigen() << "," << E->getCarga() << "," << E->getCantidadContainers() << "," << E->getCantidadCarga() << "," << E->getHoraLlegada() << "\n";

        }
    }
    barcos.close();

}

int main(int argc, char** argv) {
    ListaGruas *lg = new ListaGruas();
    ListaOperarios *lo = new ListaOperarios(1000);
    ListaBarcos *lb = new ListaBarcos(1000);
    leerArchivoBarcos(lb);
    leerArchivoOperarios(lo);
    leerArchivoGruas(lg, lo, lb);
    cout << "----------------------------------------------------------" << endl;
    menu(lg, lo, lb);
    return 0;
}

