#include "BTree.h"
#include "BTreeNode.h"
#include <iostream>
using namespace std;
void menu(BTree t);

void menu(BTree t) {

    // MENU PRINCIPAL
    int opcion = 0;
    while (opcion != 4) {
        cout << "----------------------------------------------------------" << endl;
        cout << "\t[MENU]" << endl;
        cout << "[1] Ingresar Dato" << endl;
        cout << "[2] Buscar Dato" << endl;
        cout << "[3] imprimir" << endl;
        cout << "[4] Salir" << endl;
        cout << " > ";
        cin>> opcion;
        switch (opcion) {
            case 1:
                cout << "----------------------------------------------------------" << endl;
                int dato;
                cout << "ingrese dato: ";
                cin>>dato;
                t.insert(dato);
                break;
            case 2:
                cout << "----------------------------------------------------------" << endl;
                int dat;
                cout << "ingrese dato: ";
                cin>>dat;             
                if (t.search(dat) != NULL) {
                    cout << "dato encontrado" << endl;
                } else {
                    cout << "dato no encontrado" << endl;
                }
                break;
            case 3:
                cout << "----------------------------------------------------------" << endl;
                t.traverse();
                break;
            default:
                opcion = 4;

        }
    }
}

int main() {
    BTree t(3);
    menu(t);

    return 0;
}