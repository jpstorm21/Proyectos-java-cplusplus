

#ifndef ABB_H
#define ABB_H
#include "Nodo.h"

class ABB {
public:
    ABB();
    Nodo *getRaiz();
    void insertar(int dato);
    bool buscar(int dato,Nodo *);
    void insertarRecursivo(int dato);
    bool degenerado();
    int desbalance(Nodo* arbol);
    bool arbolCompleto( Nodo *nodo);
    bool esABB();
    void eliminarDato(int dato);
    Nodo *reemplazar(Nodo *actual);
    void Rotacion(Nodo *actual);
    int ValorMin();
    int ValorMax();
    int numeroNodo(Nodo *);
    int cantVeces(int cant,Nodo *,int dato);
    virtual ~ABB();
private:
    Nodo *raiz;
    bool inserccion(int dato,Nodo *raiz);
    bool degeneradoRecursivo(Nodo * nodo);
    int alturaRecursivo(Nodo* raiz);
    bool esABBrec(Nodo *nodo);
    Nodo *eliminarDato(int dato, Nodo *nodo);

};

#endif /* ABB_H */

