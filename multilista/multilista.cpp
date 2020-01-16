#include <cstdlib>
#include <iostream>

using namespace std;

class persona {
public:
    persona(string, string, string, persona*);
    string nombre;
    string pais;
    string rut;
    persona* next;
};

class pais {
public:
    pais(string, persona*);
    string nombre;
    persona* primeraP;
};
void agregar(pais* paises[], persona* personas[], persona* dato, int cant);
void buscarPersonaxPais(pais * paises[], string nombre, string nombrePersona);
bool eliminarPersona(pais * paises[], string nombre, string nombrePersona);
void desplegar_pais(pais* paises[], persona* personas[], string pais);

int main() {
    pais * paises[] = {new pais("chile", NULL), new pais("argentina", NULL), new pais("peru", NULL)};
    persona * personas [] = {NULL, NULL, NULL, NULL, NULL};
    persona* p1 = new persona("juan", "chile", "123", NULL);
    persona* p2 = new persona("pedro", "argentina", "1234", NULL);
    persona* p3 = new persona("diego", "peru", "12345", NULL);
    persona* p4 = new persona("jose", "chile", "12367", NULL);
    persona* p5 = new persona("oliver", "peru", "123666", NULL);
    agregar(paises, personas, p1, 3);
    agregar(paises, personas, p2, 3);
    agregar(paises, personas, p3, 3);
    agregar(paises, personas, p4, 3);
    agregar(paises, personas, p5, 3);
    desplegar_pais(paises,personas,"peru");
    buscarPersonaxPais(paises, "peru", "oliver");
    bool eliminado = eliminarPersona(paises, "peru", "diego");
    if (eliminado) {
        cout << "persona eliminada" << endl;
    } else {
        cout << "no se puedo eliminar" << endl;
    }
    desplegar_pais(paises,personas,"peru");
    system("pause");
    return 0;
}

void agregar(pais* paises [], persona* personas [], persona* dato, int cant) {
    int i = 0;
    while (personas[i] != NULL && i < 5) {
        i++;
    }
    personas [i] = dato;
    for (int j = 0; j < cant; j++) {
        if (paises[j]->nombre == dato->pais) {
            if (paises[j]->primeraP == NULL) {
                paises[j]->primeraP = dato;
            } else {
                persona* aux = paises[j]->primeraP;
                while (aux->next != NULL) {
                    aux = aux->next;
                }
                aux->next = dato;
            }
        }
    }
}

void buscarPersonaxPais(pais * paises[], string nombre, string nombrePersona) {
    int i = 0;
    while (paises[i] != NULL && paises[i]->nombre != nombre) {
        i++;
    }
    persona *actual = paises[i]->primeraP;
    while (actual != NULL && actual->nombre != nombrePersona) {
        actual = actual->next;
    }
    if (actual->nombre == nombrePersona) {
        cout << "encontrada: " << actual->nombre << endl;
    } else {
        cout << "no encontrada" << endl;
    }
}

bool eliminarPersona(pais * paises[], string nombre, string nombrePersona) {
    int i = 0;
    while (paises[i] != NULL && paises[i]->nombre != nombre) {
        i++;
    }
    persona *actual = paises[i]->primeraP;
    persona *prev = paises[i]->primeraP;
    while (actual != NULL && actual->nombre != nombrePersona) {
        prev = actual;
        actual = actual->next;
    }
    if (actual != NULL) {
        if (actual == paises[i]->primeraP) {
            paises[i]->primeraP = paises[i]->primeraP->next;
        } else {
            prev->next = actual->next;
        }
        return true;
    } else {
        return false;
    }
}

void desplegar_pais(pais* paises[], persona* personas[], string pais) {
    int i = 0;
    while (paises[i] != NULL && paises[i]->nombre != pais) {
        i++;
    }
    persona *actual = paises[i]->primeraP;
    while (actual != NULL) {
        cout << "Nombre: " << actual->nombre << " Rut: " << actual->rut << " - Pais: " << actual->pais << endl;
        actual = actual->next;
    }
}

persona::persona(string n, string p, string r, persona * np) {
    this->nombre = n;
    this->pais = p;
    this->rut = r;
    this->next = np;
}

pais::pais(string n, persona * p) {
    this->primeraP = p;
    this->nombre = n;
}