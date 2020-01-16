#include <cstdlib>
#include "Cliente.h"
#include "Juego.h"
#include "ListaClientes.h"
#include "ListaJuegos.h"
#include "ListaVentas.h"
#include "NodoCliente.h"
#include "NodoJuego.h"
#include "NodoVenta.h"
#include "Venta.h"
#include <fstream>
using namespace std;

void lecturaDeJuegos(ListaJuegos *lj) {
    ifstream archivo("games.txt");
    if (archivo.is_open()) {
        string codigo;
        string nombre;
        string desarrollador;
        string plataforma;
        string fechaLanzamiento;
        string stockInicial;
        string stockActual;
        string precio;
        while (!archivo.eof()) {
            getline(archivo, codigo, ',');
            getline(archivo, nombre, ',');
            getline(archivo, desarrollador, ',');
            getline(archivo, plataforma, ',');
            getline(archivo, fechaLanzamiento, ',');
            getline(archivo, stockInicial, ',');
            getline(archivo, stockActual, ',');
            getline(archivo, precio, '\n');
            Juego *j = new Juego(codigo, nombre, desarrollador, plataforma, fechaLanzamiento, atoi(stockInicial.c_str()), atoi(stockActual.c_str()), atoi(precio.c_str()));
            lj->ingresarJuego(j);
        }
    }
    archivo.close();
}

int main(int argc, char** argv) {
    ListaJuegos *lj = new ListaJuegos();
    ListaClientes *lc = new ListaClientes();
    ListaVentas *lv = new ListaVentas();
    lecturaDeJuegos(lj);
    NodoJuego *actual = lj->getFirst();
    while(actual != NULL){
        cout<<actual->getJuego()->getNombre()<<endl;
        actual = actual->getNext();
    }

    return 0;
}

