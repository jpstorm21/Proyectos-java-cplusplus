#include <cstdlib>
#include "Examen.h"
#include "Paciente.h"
#include "ListaExamenes.h"
#include "ListaPacientes.h"
#include "NodoExamen.h"
#include "NodoPaciente.h"
#include <iostream>
#include <string>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// integrantes: Juan Martinez, Michael Bravo, Leonel Villagra
using namespace std;

void menu(ListaExamenes *le, ListaPacientes *lp);
void menuEstadisticas(ListaExamenes *le, ListaPacientes *lp);

void registrarPaciente(ListaPacientes *lp, ListaExamenes *le) {
// registra un paciente 
    int rut;
    cout << "----------- Ingreso de paciente: -----------" << endl;
    cout << "Rut de paciente: ";
    cin>>rut;
    Paciente *p = new Paciente(rut);
    
    lp->ingresarPaciente(p);
    
    // registra un examen automaticamente para no de jar un paciente sin exámen
    int codigo;
    string tipo;
    cout << "ingrese codigo del examen a registrar : ";
    cin>>codigo;
    cout << "ingrese tipo de examen [sanguineo],[respiratorio]o[muscular] : ";
    cin>>tipo;
    while (tipo != "sanguineo" && tipo != "respiratorio" && tipo != "muscular") {
    	cout<<"tipo ingresado no valido ingrese nuevamente "<<endl;
        cout << "ingrese tipo de examen [sanguineo],[respiratorio]o[muscular] : ";
        cin>>tipo;
    }
    Examen *E = new Examen(codigo, tipo);
        E->setRealizado(false);
        le->ingresarExamen(E);
        p->getListaExamenes()->ingresarExamen(E);
        cout << "Examen registrado exitosamente! " << endl;
}

void registrarExamen(ListaExamenes *le, ListaPacientes *lp) {
    // registra un examen 
    int codigo;
    string tipo;
    int rut;
    cout << "ingrese codigo del examen a registrar : ";
    cin>>codigo;
    cout << "ingrese tipo de examen [sanguineo],[respiratorio]o[muscular] : ";
    cin>>tipo;
    
    // el tipo de examen puede ser sanguineo, respiratorio o muscular
    while (tipo != "sanguineo" && tipo != "respiratorio" && tipo != "muscular") {
    	cout<<"tipo ingresado no valido ingrese nuevamente "<<endl;
        cout << "ingrese tipo de examen [sanguineo],[respiratorio]o[muscular] : ";
        cin>>tipo;
    }
    cout << "ingrese rut del paciente al cual se lo registrara: ";
    cin>>rut;
    Paciente *P = lp->buscarPaciente(rut);
    if (P != NULL) {
        Examen *E = new Examen(codigo, tipo);
        E->setRealizado(false);
        le->ingresarExamen(E);
        P->getListaExamenes()->ingresarExamen(E);
        cout << "Examen registrado exitosamente! " << endl;
    } else {
        // si el paciente buscado no existe, manda un mensaje correspondiente
        cout << "Paciente no encontrado!" << endl;
    }

}

void consultarExamenes(ListaPacientes *lp) {
    //muestra los examenes de un paciente a buscar
    int rut;
    int numero = 1;
    cout << "Ingrese rut de paciente a buscar: ";
    cin>>rut;
    Paciente *P = lp->buscarPaciente(rut);
    if (P != NULL) {
        NodoExamen *actual = P->getListaExamenes()->getLastExamen();
        if (actual == NULL) {
            cout << "El paciente no tiene asignado examenes" << endl;
        } else {
            while (actual != NULL) {
                Examen *e = actual->getExamen();
                int realizado;
                // en esta parte de el codigo, se puede dejar como realizado o no realizado un examen X del paciente
                cout << "El examen " << numero << " fue realizado? (SI=1 , NO=2) :";
                cin>>realizado;
                while (realizado != 1 && realizado != 2) {
                    cout << "El examen " << numero << " fue realizado? (Intente nuevamente! SI=1 , NO=2) :";
                    cin>>realizado;
                }
                if (realizado == 1) {
                    e->setRealizado(true);
                    cout << "Examen " << numero << " registrado como realizado!" << endl;
                } else {
                    cout << "Examen " << numero << " registrado como no realizado!" << endl;
                }
                numero++;
                actual = actual->getPrevExamen();
            }
        }
    } else {
        // SI EL PACIENTE NO FUE ENCONTRADO, MUESTRA EL ERROR CORRESPONDIENTE
        cout << "Paciente no encontrado!" << endl;
    }
}

void registrarRecepcion(ListaPacientes * lp) {
    // MUESTRA LA LISTA DE EXAMEN DE UN PACIENTE Y SUS ESTADOS CORRESPONDIENTES
    int contador = 1;
    int rut;
    cout << "ingrese rut del paciente a buscar : ";
    cin>>rut;
    Paciente *paciente = lp->buscarPaciente(rut);
    if (paciente != NULL) {
        NodoExamen *actual2 = paciente->getListaExamenes()->getLastExamen();
        int contador2 = 0;
        while (actual2 != NULL) {
            Examen *examen = actual2->getExamen();
            if (examen->getRealizado() == true) {
                cout << "examen " << contador << " realizado" << endl;
                contador2++;
                contador++;
            } else {
                cout << "examen " << contador << " no realizado" << endl;
                contador++;
            }
            actual2 = actual2->getPrevExamen();
        }
        
        // SI UN PACIENTE COMPLETO TODOS SUS EXAMENES PUEDE TOMAR HORA
        if (paciente->getListaExamenes()->getContador() == contador2) {
            cout << "el paciente a completado sus examenes !!Puedes tomar hora!! " << endl;
        }else{
            // SI UN PACIENTE NO COMPLETO TODOS SUS EXAMENES NO PUEDE TOMAR HORA
            cout<<"no puedes tomar hora, aun no has completado tus examenes "<<endl;
        }
    } else {
        // SI EL PACIENTE NO FUE ENCONTRADO, MUESTRA EL ERROR CORRESPONDIENTE
        cout << "paciente no existe " << endl;
    }

}
void registroAtencionPaciente(ListaPacientes *lp){
    // MUESTRA LA LISTA DE TODOS LOS PACIENTES QUE COMPLETARON TODOS SUS EXAMENES
    cout<<"Listado de pacientes que pueden tomar hora "<<endl;
    NodoPaciente *actual = lp->getFirstPaciente();
    while (actual != NULL) {
        Paciente *paciente = actual->getPaciente();
        NodoExamen *actual2 = paciente->getListaExamenes()->getLastExamen();
        int contador2 = 0;
        while (actual2 != NULL) {
            Examen *examen = actual2->getExamen();
            if (examen->getRealizado() == true) {
                contador2++;
            } else {
                break;
            }
            actual2 = actual2->getPrevExamen();
        }
        if (paciente->getListaExamenes()->getContador() == contador2) {
            cout<<"Paciente : " <<paciente->getRut()<<endl;
        }

        actual = actual->getNextPaciente();
    }
    
    // MUESTRA LA LISTA DE TODOS LOS PACIENTES QUE NO COMPLETARON TODOS SUS EXAMENES
    cout<<"Listado de pacientes que no pueden tomar hora "<<endl;
    NodoPaciente *actual3 = lp->getFirstPaciente();
    while (actual3 != NULL) {
        Paciente *paciente = actual3->getPaciente();
        NodoExamen *actual4 = paciente->getListaExamenes()->getLastExamen();
        int contador3 = 0;
        while (actual4 != NULL) {
            Examen *examen = actual4->getExamen();
            if (examen->getRealizado() == true) {
                contador3++;
            } else {
                break;
            }
            actual4 = actual4->getPrevExamen();
        }
        if (paciente->getListaExamenes()->getContador() != contador3) {
            cout<<"Paciente : " <<paciente->getRut()<<endl;
        }
        actual3 = actual3->getNextPaciente();
    }
 
}

void menu(ListaExamenes *le, ListaPacientes *lp) {

// MENU PRINCIPAL
    int opcion = 0;
    while (opcion != 7) {
        cout << "----------------------------------------------------------" << endl;
        cout << "\t[MENU]" << endl;
        cout << "[1] Registrar paciente" << endl;
        cout << "[2] Registrar un examen por realizarse" << endl;
        cout << "[3] Consultar si un paciente ha completado los examenes" << endl;
        cout << "[4] Registrar la recepción de resultados de exámenes" << endl;
        cout << "[5] Registro de Atención de paciente" << endl;
        cout << "[6] Menu de estadisticas" << endl;
        cout << "[7] Fin de sesión" << endl;
        cout << " > ";
        cin>> opcion;

        switch (opcion) {
            case 1:
                cout << "----------------------------------------------------------" << endl;
                registrarPaciente(lp, le);
                break;
            case 2:
                cout << "----------------------------------------------------------" << endl;
                registrarExamen(le, lp);
                break;
            case 3:
                cout << "----------------------------------------------------------" << endl;
                consultarExamenes(lp);
                break;
            case 4:
                cout << "----------------------------------------------------------" << endl;
                registrarRecepcion(lp);
                break;
            case 5:
                cout << "----------------------------------------------------------" << endl;
                registroAtencionPaciente(lp);
                break;
            case 6:
                menuEstadisticas(le, lp);
                cout << "----------------------------------------------------------" << endl;
                break;
            default:
                opcion = 7;

        }
    }
}

void numeroEnEspera(ListaPacientes *lp) {
    // CUENTA Y DESPLEGA LA CANTIDAD DE PACIENTES QUE COMPLETARON TODOS SUS EXAMENES
    int contador = 0;
    NodoPaciente *actual = lp->getFirstPaciente();
    while (actual != NULL) {
        Paciente *paciente = actual->getPaciente();
        NodoExamen *actual2 = paciente->getListaExamenes()->getLastExamen();

        int contador2 = 0;
        while (actual2 != NULL) {

            Examen *examen = actual2->getExamen();
            if (examen->getRealizado() == true) {
                contador2++;
            } else {
                break;
            }
            actual2 = actual2->getPrevExamen();
        }
        if (paciente->getListaExamenes()->getContador() == contador2) {
            contador++;
        }

        actual = actual->getNextPaciente();
    }
    cout << "La cantidad de pacientes en lista de espera es " << contador << endl;
}

void promedioExamamenesXpaciente(ListaPacientes *lp) {
    // CALCULA EL PROMEDIO DE CANTIDAD EXAMENES POR CADA PACIENTE
    int contPacientes = lp->getContador();
    int contExamenes = 0;

    NodoPaciente *actual = lp->getFirstPaciente();
    while (actual != NULL) {
        Paciente *p = actual->getPaciente();

        contExamenes = contExamenes + p->getListaExamenes()->getContador();
        actual = actual->getNextPaciente();
    }

    if (contPacientes == 0) {
        cout << "El promedio de examenes por paciente es igual a 0" << endl;
    } else {
        cout << "El promedio de examenes por paciente es igual a " << contExamenes / contPacientes << endl;
    }
}

void totalPacienteAtencion(ListaPacientes*lp) {
    // CUENTA Y DESPLEGA EL TOTAL DE PACIENTES QUE NO HAN REALIZADO TODOS SUS EXAMENES
    int contador = 0;
    NodoPaciente *actual = lp->getFirstPaciente();
    while (actual != NULL) {
        Paciente *paciente = actual->getPaciente();
        NodoExamen *actual2 = paciente->getListaExamenes()->getLastExamen();
        int contador2 = 0;
        while (actual2 != NULL) {
            Examen *examen = actual2->getExamen();
            if (examen->getRealizado() == true) {
                contador2++;
            } else {
                break;
            }
            actual2 = actual2->getPrevExamen();
        }
        if (paciente->getListaExamenes()->getContador() != contador2) {
            contador++;
        }
        actual = actual->getNextPaciente();
    }
    cout << "La cantidad de pacientes en lista de espera para sus examenes es " << contador << endl;
}

void tipoExamenSolicitado(ListaExamenes *le) {
    // DESPLEGA EL TIPO DE EXAMEN QUE FUE MAS SOLICITADO
    int cont1 = 0;
    int cont2 = 0;
    int cont3 = 0;
    NodoExamen *actual = le->getLastExamen();
    while (actual != NULL) {
        Examen *E = actual->getExamen();
        if (E->getTipo() == "sanguineo") {
            cont1++;
        } else {
            if (E->getTipo() == "respiratorio") {
                cont2++;
            } else {
                cont3++;
            }

        }
        actual = actual->getPrevExamen();
    }
    int mayor = -1;
    if (cont1 > cont2 && cont1 > cont3) {
        mayor = cont1;
        cout << "el tipo de examen mas solicitado es : sanguineo" << endl;
    }
    if (cont2 > cont1 && cont2 > cont3) {
        mayor = cont2;
        cout << "el tipo de examen mas solicitado es : respiratorio" << endl;
    }
    if (cont3 > cont1 && cont3 > cont2) {
        mayor = cont3;
        cout << "el tipo de examen mas solicitado es : muscular" << endl;
    }

}

void ListadoExamenes(ListaPacientes * lp) {
    // MUESTRA LA LISTA DE EXAMENES DE UN PACIENTE BUSCADO, LOS DATOS Y SU ESTADO
    int rut;
    int numero = 1;
    cout << " ingrese rut del paciente : ";
    cin>>rut;
    Paciente *P = lp->buscarPaciente(rut);
    if (P != NULL) {
        NodoExamen *actual = P->getListaExamenes()->getLastExamen();
        cout << "Listado de examenes del paciente " << P->getRut() << endl;
        while (actual != NULL) {
            Examen *E = actual->getExamen();
            cout << "Examen N " << numero << endl;
            cout << "Datos: " << endl;
            cout << "Codigo : " << E->getCodigo() << endl;
            cout << "Tipo : " << E->getTipo() << endl;
            if (E->getRealizado() == true) {
                cout << "Estado : realizado" << endl;
            } else {
                cout << "Estado : no realizado" << endl;
            }
            numero++;
            actual = actual->getPrevExamen();
        }
    } else {
        cout << " paciente no existe " << endl;
    }
}

void menuEstadisticas(ListaExamenes *le, ListaPacientes * lp) {
    
    // MENU SECUNDARIO
    int opcion = 0;
    while (opcion != 6) {
        cout << "----------------------------------------------------------" << endl;
        cout << "\t[MENU ESTADISTICO]" << endl;
        cout << "[1] Número de pacientes en espera de atención" << endl;
        cout << "[2] Promedio de exámenes asignados a pacientes" << endl;
        cout << "[3] Tipo de examen más solicitado" << endl;
        cout << "[4] Total de pacientes en proceso de atención" << endl;
        cout << "[5] Listado de exámenes de un paciente en particular" << endl;
        cout << "[6] Regreso a menú principal" << endl;
        cin >> opcion;
        switch (opcion) {
            case 1:
                cout << "----------------------------------------------------------" << endl;
                numeroEnEspera(lp);
                break;
            case 2:

                cout << "----------------------------------------------------------" << endl;
                promedioExamamenesXpaciente(lp);
                break;
            case 3:

                cout << "----------------------------------------------------------" << endl;
                tipoExamenSolicitado(le);
                break;
            case 4:

                cout << "----------------------------------------------------------" << endl;
                totalPacienteAtencion(lp);
                break;
            case 5:

                cout << "----------------------------------------------------------" << endl;
                ListadoExamenes(lp);
                break;
                
            default:
                menu(le, lp);
        }
    }
}

int main(int argc, char** argv) {
    // LISTA DE PACIENTES GENERAL
    ListaPacientes *lp = new ListaPacientes();
    //LISTA DE EXAMENES GENERAL
    ListaExamenes * le = new ListaExamenes();
    menu(le, lp);
    return 0;
}