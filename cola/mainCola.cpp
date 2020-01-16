#include <cstdlib>
#include "Cola.h"
#include "Nodo.h"
#include <iostream>
using namespace std;
/*
 * 
 */
void menu(Cola *col) {
    int opcion = 0;
    while (opcion != 7) {
        cout << "----------------------------------------------------------" << endl;
        cout << "\t[MENU]" << endl;
        cout << "[1] push" << endl;
        cout << "[2] pop" << endl;
        cout << "[3] cola vacia" << endl;
        cout << "[4] imprimir" << endl;
        cout << "[5] tamaño" << endl;
        cout << "[6] destruir " << endl;
        cout << "[7] salir" << endl;
        cout << " > ";
        cin>> opcion;
        switch (opcion) {
            case 1:
                cout << "----------------------------------------------------------" << endl;
                int dato;
                cout<<"ingrese dato: ";
                cin>>dato;
                col->push(dato);
                cout<<"dato ingresado"<<endl;
                break;
            case 2:
                cout << "----------------------------------------------------------" << endl;
                col->pop();
                break;
            case 3:
                cout << "----------------------------------------------------------" << endl;
                bool vacia;
                vacia = col->isEmpty();
                if(vacia){
                    cout<<"cola vacia"<<endl;
                }else{
                    cout<<"cola tiene datos"<<endl;
                }
                break;
            case 4:
                cout << "----------------------------------------------------------" << endl;
                cout << "------datos------" << endl;
                col->imprimir();
                break;
            case 5:
                cout << "----------------------------------------------------------" << endl;              
                int cant;
                cant = col->size();
                cout<<"la cantidad de elementos es: "<< cant <<endl;
                break;
            case 6:
                cout << "----------------------------------------------------------" << endl;
                col->~Cola();
                cout<<"cola destruida"<<endl;
                break;
            default:
                opcion = 7;
        }
    }
}
int main() {
    Cola *col = new Cola();
    menu(col);
    system("pause");
    return 0;
}

