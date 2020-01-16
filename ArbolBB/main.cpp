
#include <cstdlib>
#include "Nodo.h"
#include "ABB.h"
#include <iostream>
using namespace std;

void PreOrden(Nodo *nodo){
    if (nodo != NULL) {
            cout<<nodo->getDato();
            cout<<" ";
            PreOrden(nodo->getHijoIzqui());
            PreOrden(nodo->getHijoDerech());   
        }
}
int main(int argc, char** argv) {
    ABB *arbol = new ABB();
    arbol->insertarRecursivo(5);
    arbol->insertarRecursivo(3);
    arbol->insertarRecursivo(1);
    bool esDege = arbol->degenerado();
    if(esDege){
        cout<<"es degenerado"<<endl;
    }else{
        cout<<"no es degenerado"<<endl;
    }
    int b = arbol->desbalance(arbol->getRaiz());
    cout<<"factor de balance: "<<b<<endl;
    bool completo = arbol->arbolCompleto(arbol->getRaiz());
    if(completo){
        cout<<"arbol completo"<<endl;
    }else{
        cout<<"arbol no esta completo"<<endl;
    }
    bool esABB = arbol->esABB();
    if(esABB){
        cout<<"es abb"<<endl;
    }else{
        cout<<"no es abb"<<endl;
    }
    arbol->Rotacion(arbol->getRaiz());
    arbol->eliminarDato(6);
    cout<<"impresion en preorden "<<endl;
    PreOrden(arbol->getRaiz());
    cout<<endl;
    int minimo = arbol->ValorMin();
    cout<<"el valor minimo del arbol es: "<<minimo<<endl;
    int mayor= arbol->ValorMax();
    cout<<"el valor maximo del arbol es: "<<mayor<<endl;
    bool buscado = arbol->buscar(9,arbol->getRaiz());
    if(buscado){
        cout<<"valor encontrado"<<endl;
    }else{
        cout<<"valor no encontrado"<<endl;
    }
    int cantNodos = arbol->numeroNodo(arbol->getRaiz());
    cout<<"la cantidad de nodos en el arbol son : "<<cantNodos<<endl; 
    int cantveces=0;
    int cant = arbol->cantVeces(cantveces,arbol->getRaiz(),7);
    cout<<cant<<endl;
}

