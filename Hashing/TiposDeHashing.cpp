#include <cstdlib>
#include <iostream>
using namespace std;

struct nodo {
    int dato;
    nodo *next = NULL;
};

void limpiarArray(nodo *datos[], int n) {
    for (int i = 0; i < n; i++) {
        datos[i] = NULL;
    }
}

void insertarEncadenamiento(nodo *datos[], int n, int dato) {
    int hashing = dato % n;
    if (datos[hashing] == NULL) {
        datos[hashing] = new nodo();
        datos[hashing]->dato = dato;
    } else {
        nodo *actual = datos[hashing];
        while (actual->next != NULL) {
            actual = actual->next;
        }
        actual->next = new nodo();
        actual->next->dato = dato;
    }
}

int buscar(nodo *datos[], int dato, int n) {
    int hashing = dato % n;
    while (datos[hashing] != NULL && datos[hashing]->dato != dato) {
        datos[hashing] = datos[hashing]->next;
    }
    if (datos[hashing] != NULL) {
        return datos[hashing]->dato;
    } else {
        return -1;
    }
}
bool eliminar(nodo *datos[],int n,int dato){
    int hashing = dato%n;
    nodo* actual = datos[hashing];
    nodo* previo = datos[hashing];
    while(actual != NULL && actual->dato !=  dato){
        previo = actual;
        actual = actual->next;
    }
    if(actual != NULL){
        if(actual->dato == datos[hashing]->dato){
            datos[hashing] = datos[hashing]->next;
        }else{
            previo->next = actual->next;
        }
        return true;
    }else{
        return false;
    }
}

void insertDobleHashing(int datoD [], int n, int dato) {
    int hashing = dato % n;
    int intento = 1;
    while (true) {
        if (datoD[hashing] == 0) {
            datoD[hashing] = dato;
            break;
        } else {
            hashing = (intento + dato % n) % n;
            intento++;
        }
    }
}

int buscarDobleHashing(int datosD[], int n, int dato) {// funcion tanto para doble hashing como para direccionamiento abierto
    int hash = dato % n;
    int intentos = 1;
    while (hash <= n) {
        if (hash == n) {
            hash = 0;
        } else if (datosD[hash] == 0) {
            cout << "no encontrado en  intentos!" << intentos << endl;
            return -1;
        } else if (datosD[hash] == dato) {
            cout << "encontrado en  intentos!" << intentos << endl;
            break;
        } else {
            hash++;
        }
        intentos++;
    }
    return hash;
}

void llenarOFceros(int datosD[], int n) {
    for (int i = 0; i < n; i++) {
        datosD[i] = 0;
    }
}

void insertarDirecAbierto(int datosDabiertos[], int dato, int tam) {
    int hashing = dato % tam;
    while (hashing <= tam) {
        if (hashing == tam) {
            hashing = 0;
        } else if (datosDabiertos[hashing] != 0) {
            hashing++;
        } else {
            datosDabiertos[hashing] = dato;
            break;
        }
    }
}

int main(int argc, char** argv) {
    nodo * datos [10];
    limpiarArray(datos, 10);
    int numeros[10] = {10, 45, 23, 18, 30, 98, 42, 19, 50, 123};
    for (int i = 0; i < 10; i++) {
        insertarEncadenamiento(datos, 10, numeros[i]);
    }
    cout << "impresion con metodo de encadenamiento" << endl;
    for (int i = 0; i < 10; i++) {
        nodo* actual = datos[i];
        cout << i;
        while (actual != NULL) {
            cout << "--> " << actual->dato;
            actual = actual->next;
        }
        cout << endl;
    }
    int dato;
    cout << "ingrese dato a buscar: ";
    cin>>dato;
    int elemento = buscar(datos, dato, 10);
    if (elemento != -1) {
        cout << "encontrado" << endl;
    } else {
        cout << "no encontrado" << endl;
    }
    bool elimina = eliminar(datos,10,123);
    cout << "nueva impresion con metodo de encadenamiento" << endl;
    for (int i = 0; i < 10; i++) {
        nodo* actual = datos[i];
        cout << i;
        while (actual != NULL) {
            cout << "--> " << actual->dato;
            actual = actual->next;
        }
        cout << endl;
    }




    cout << "-----------------------------------------------" << endl;
    cout << "metodo de doble hashing" << endl;
    int datosD[10];
    int numerosD[8] = {10, 45, 23, 18, 30, 98, 42, 19};
    llenarOFceros(datosD, 10);
    for (int i = 0; i < 8; i++) {
        insertDobleHashing(datosD, 10, numerosD[i]);

    }
    for (int j = 0; j < 10; j++) {
        cout << j << " : " << datosD[j] << endl;
    }
    int datoD;
    cout << "ingrese dato a buscar: ";
    cin>>datoD;
    buscarDobleHashing(datosD, 8, datoD);







    cout << "-----------------------------------------------" << endl;
    int datosDabiertos[20];
    int numerosAbiertos[10] = {10, 45, 23, 18, 30, 98, 42, 19, 50, 123};
    llenarOFceros(datosDabiertos, 20);
    cout << "metodo de direccionamiento abierto hashing" << endl;
    for (int i = 0; i < 10; i++) {
        insertarDirecAbierto(datosDabiertos, numerosAbiertos[i], 20);
    }
    for (int j = 0; j < 20; j++) {
        cout << j << " : " << datosDabiertos[j] << endl;
    }
    int datoA;
    cout << "ingrese dato a buscar: ";
    cin>>datoA;
    buscarDobleHashing(datosDabiertos, 20, datoA);
    system("pause");
    return 0;
}

