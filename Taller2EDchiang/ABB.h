#ifndef ABB_H
#define ABB_H
#include "NodoABB.h"
#include "Contribuyente.h"
#include <fstream> 
using namespace std;

class ABB {
public:
    ABB();
    NodoABB* getRaiz();
    void insertar(Contribuyente* c);
    Contribuyente* buscar(int rut, NodoABB* nodo);
    void eliminar(int rut);
    NodoABB *reemplazar(NodoABB *actual);
    int getCantPersonas();
    int PreOrden();
    void imprimir(NodoABB *nodo,int nivel,ofstream &archivo);
    virtual ~ABB();
private:
    NodoABB* raiz;
    void insertarNodo(Contribuyente *c, NodoABB* raiz);
    NodoABB *eliminarDato(int dato, NodoABB *nodo);
    int cantPersonas;
    int PreOrdenR(NodoABB *nodo,int cant);
};

#endif /* ABB_H */

