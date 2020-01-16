#include <iostream>
#include "Alumno.h"
#include "ListaAlumno.h"
#include "NodoAlumno.h"
#include "NodoEjercicio.h"
#include "ListaEjercicio.h"
#include "Ejercicio.h"

using namespace std; // std para imprimir

void menuApp(ListaEjercicio *le, ListaAlumno *la);

void ingresarAlumno(ListaAlumno *la) {
    int rut;
    int nota;
    cout << "Ingrese rut del alumno: " << endl;
    cin >> rut;
    Alumno *A = new Alumno(rut);
    la->ingresarAlumno(A);

}

void ingresarEjercicio(ListaEjercicio *le, ListaAlumno *la) {
    int numeroEjercicio;
    int rut;
    cout << "Elija el rut del alumno para ingresar ejercicio: " << endl;
    NodoAlumno *curr = la->getFirstAl();
    while (curr != NULL) {
        cout << "-" << curr->getAlumno()->getRut() << endl;
        curr = curr->getNextAl();
    }
    cin >> rut;
    Alumno *A = la->buscarAlumno(rut);
    while (A == NULL) {
        cout << "No se encontro ningun alumno con el rut ingresado" << endl;
        cout << "Elija el rut del alumno para ingresar ejercicio: " << endl;
        cin >> rut;
        A = la->buscarAlumno(rut);
    }
    cout << "Ingrese el numero del ejercicio a ingresar: (1-500): " << endl;
    cin >> numeroEjercicio;

    while (numeroEjercicio < 1 || numeroEjercicio > 500) {
        cout << "Se ingeso un numero fuera del rango , ingrese nuevamente: " << endl;
        cin >> numeroEjercicio;
    }

    Ejercicio *E = new Ejercicio(); //ctor por defecto , nota = 1
    E->setIdentificador(numeroEjercicio);

    A->getListaEjercicio()->ingresarEjercicio(E);

}

void revisarEjercicio(ListaEjercicio *le, ListaAlumno *la) {
    Alumno *A;
    int rut;
    double nota;
    cout << "Elija el rut del alumno para corregir ejercicio: " << endl;
    NodoAlumno *curr = la->getFirstAl();
    while (curr != NULL) {
        cout << "-" << curr->getAlumno()->getRut() << endl;
        curr = curr->getNextAl();
    }
    cin >> rut;
    A = la->buscarAlumno(rut);
    while (A == NULL) {
        cout << "No se encontro ningun alumno con el rut ingresado" << endl;
        cout << "Elija el rut del alumno para ingresar ejercicio: " << endl;
        cin >> rut;
        A = la->buscarAlumno(rut);
    }
    Ejercicio *E = A->getListaEjercicio()->getLastEj()->getEjercicio(); // tomo el ultimo ejercicio del alumno
    cout << "Ingrese nota del ejercicio numero" << "[ " << E->getIdentificador() << " ] : " << endl;
    cin >> nota;

    E->setNota(nota);
}

void alumnosPresentes(ListaAlumno *la) {
    int cantAlumnos = la->getContador();
    cout << "La cantidad de alumnos presentes son: " << cantAlumnos << endl;
}

void promedioDeTodoElCurso(ListaAlumno *la, ListaEjercicio *le) {
    double sumador = 0;
    double promTodoElCurso = 0, promDeCadaAlumno = 0;
    NodoAlumno *curr = la->getFirstAl();
    while (curr != NULL) {
        Alumno *A = curr->getAlumno();
        promDeCadaAlumno = A->getListaEjercicio()->calcularPromedioEjercicio();
        sumador = sumador + promDeCadaAlumno;
        curr = curr->getNextAl();
    }
    promTodoElCurso = sumador / la->getContador();
    cout << "El promedio del curso es: " << promTodoElCurso << endl;
}

void ejerciciosAlumnoEspecifico(ListaEjercicio *le, ListaAlumno *la) {
    int rut;

    cout << "Elija el rut del alumno a buscar: " << endl;
    NodoAlumno *curr = la->getFirstAl();
    while (curr != NULL) {
        cout << "-" << curr->getAlumno()->getRut() << endl;
        curr = curr->getNextAl();
    }
    cin >> rut;
    Alumno *A = la->buscarAlumno(rut);
    while (A == NULL) {
        cout << "No se encontro ningun alumno con el rut ingresado" << endl;
        cout << "Elija el rut del alumno para ingresar ejercicio: " << endl;
        cin >> rut;
        A = la->buscarAlumno(rut);
    }
    int cantEjRealizados = A->getListaEjercicio()->getContador();
    NodoEjercicio *NE = A->getListaEjercicio()->getLastEj();
    cout << "Los numeros de los ejercicios que hizo el alumno fueron los siguientes: " << endl;
    while (NE != NULL) {
        cout << "Ejercicio numero: " << NE->getEjercicio()->getIdentificador() << " , ";
        NE = NE->getPrevEj();
    }
    cout << "En total el alumno realizo " << cantEjRealizados << " ejercicios." << endl;

}

void promNotaCantEjerAlumno(ListaEjercicio *le, ListaAlumno *la) {
    int rut;
    cout << "Elija el rut del alumno a buscar: " << endl;
    NodoAlumno *curr = la->getFirstAl();
    while (curr != NULL) {
        cout << "-" << curr->getAlumno()->getRut() << endl;
        curr = curr->getNextAl();
    }
    cin >> rut;
    Alumno *A = la->buscarAlumno(rut);
    while (A == NULL) {
        cout << "No se encontro ningun alumno con el rut ingresado" << endl;
        cout << "Elija el rut del alumno para ingresar ejercicio: " << endl;
        cin >> rut;
        A = la->buscarAlumno(rut);
    }
    int numEjercicios = A->getListaEjercicio()->getContador();
    double promedio = A->getListaEjercicio()->calcularPromedioEjercicio();

    cout << "El promedio de notas fue: " << promedio << " y la cantidad de ejercicios que realizo fueron: " << numEjercicios << endl;
}

void listadoNotasFinales(ListaEjercicio *le, ListaAlumno *la) {
    cout << "LISTADO DE ALUMNOS Y SU NOTA FINAL" << endl;
    cout << "----------------------------------" << endl;
    cout << "RUT     NOTA" << endl;
    NodoAlumno *NA = la->getFirstAl();
    while (NA != NULL) {
        Alumno *A = NA->getAlumno();
        cout << A->getRut() << "  " << A->getListaEjercicio()->calcularPromedioEjercicio() << endl;
        NA = NA->getNextAl();
    }
}

void menuEstadisticas(ListaEjercicio *le, ListaAlumno *la) {

    int opcion = 0;
    while (opcion != 6) {
        cout << "\t[MENU ESTADISTICO]" << endl;
        cout << "[1] Numero de alumnos presentes" << endl;
        cout << "[2] Promedio general de los alumnos presentes" << endl;
        cout << "[3] Ejercicios ya realizados para un alumno en especifico" << endl;
        cout << "[4] Promedio de notas y cantidad de ejercicios de un alumno en especifico " << endl;
        cout << "[5] Listado de alumnos y su nota final" << endl;
        cout << "[6] Salir al menu principal" << endl;
        cin >> opcion;
        switch (opcion) {
            case 1:
                alumnosPresentes(la);
                cout << "----------------------------------" << endl;
                break;
            case 2:
                promedioDeTodoElCurso(la, le);
                cout << "----------------------------------" << endl;
                break;
            case 3:
                ejerciciosAlumnoEspecifico(le, la);
                cout << "----------------------------------" << endl;
                break;
            case 4:
                promNotaCantEjerAlumno(le, la);
                cout << "----------------------------------" << endl;
                break;
            case 5:
                listadoNotasFinales(le, la);
                cout << "----------------------------------" << endl;
                break;

            default:
                menuApp(le, la);

        }
    }
}

void menuApp(ListaEjercicio *le, ListaAlumno *la) {
    int opcion = 0;
    while (opcion != 5) {
        cout << "\t[MENU]" << endl;
        cout << "[1] Ingresar alumno" << endl;
        cout << "[2] Ingresar ejercicio" << endl;
        cout << "[3] Revisar ejercicio de algun alumno" << endl;
        cout << "[4] Ver estadisticas del curso " << endl;
        cout << "[5] Salir de la aplicacion" << endl;
        cin >> opcion;
        switch (opcion) {
            case 1:
                ingresarAlumno(la);
                cout << "Alumno ingresado con exito" << endl;
                cout << "----------------------------------" << endl;
                break;
            case 2:
                ingresarEjercicio(le, la);
                cout << "Ejercicio entregado al alumno" << endl;
                cout << "----------------------------------" << endl;
                break;
            case 3:
                revisarEjercicio(le, la);
                cout << "----------------------------------" << endl;
                break;
            case 4:
                menuEstadisticas(le, la);
                break;
            default:
                opcion = 5;

        }
    }
}

int main(int argc, char** argv) {
    ListaEjercicio le;
    ListaAlumno la;

    menuApp(&le, &la);

    return 0;
}
