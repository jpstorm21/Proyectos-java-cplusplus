

#include <cstdlib>
#include <iostream>
#include <string>
#include "Vendedor.h"

using namespace std;

int leerDatos(){
    string eleccion = "si";
    int suma = 0;
    while(eleccion != "no"){
        string nombre;
        int ventas;
        cout<<"ingrese nombre: ";
        cin>>nombre;
        cout<<"ingrese ventas: ";
        cin>>ventas;
        Vendedor *V =  new Vendedor(nombre,ventas);//no era necesario un objeto pero el enunciado salio POO
        suma = suma + V->getVentas();
        cout<<"desea ingresar mas vendedores si o no: ";
        cin>>eleccion;
    }
    return suma;
   
}
int main(int argc, char** argv) {
    int ventas = leerDatos();
    cout<<"las ventas totales son : "<< ventas <<endl;
    return 0;
}

