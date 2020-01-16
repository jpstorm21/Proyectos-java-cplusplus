/* 
 * File:   ArbolHeap.cpp
 * 
 * A continuación se implementan las funciones de la clase ArbolHeap.
 */
#include <cstdlib>
#include "ArbolHeap.h"

/**
 * Constructor de la clase. Inicializa el objeto con la raíz vacía y cero datos
 * almacenados.
 */
template <class T>
ArbolHeap<T>::ArbolHeap() {
    this->raiz = NULL;
    this->cantNodos = 0;
    this->niveles = 0;
}

/**
 * Destructor de la clase.
 * Elimina sus componentes, si estas no son vacías (nulas).
 */
template <class T>
ArbolHeap<T>::~ArbolHeap() {
    if (this->raiz != NULL) {
        raiz->~Nodo();
    }
}

template <class T>
int ArbolHeap<T>::getCantDatos() {
    return this->cantNodos;
}

/**
 * Se calcula la altura del árbol, es decir, la cantidad de niveles máxima que tiene.
 * @return Altura máxima del árbol.
 */
template <class T>
int ArbolHeap<T>::getAltura() {
    int altura = 0;
    Nodo<T>* current = raiz;
    while (current != NULL) {
        altura++;
        current = current->getIzquierda();
    }
    return altura;
}

/**
 * Agrega un nuevo dato al árbol, analizando los dos posibles casos.
 * @param dato
 */
template <class T>
void ArbolHeap<T>::agregar(T dato) {
    if (raiz == NULL) { // Caso 1: Árbol vacío.
        raiz = new Nodo<T>(dato);
        this->cantNodos = 1;
        this->niveles = 1;
    } else { // Caso 2: árbol con al menos un dato.
        agregarRecursivo(raiz, 1, dato);
        corregirNiveles();
    }
}

/**
 * Método recursivo que recorre el árbol y agrega el dato en la posición
 * correspondiente, sin embargo, no corrobora que los datos estén ordenados como
 * un montículo.
 * @param current nodo actual que se está analizando.
 * @param nivel nivel del árbol en el que se encuentra current.
 * @param dato dato que se desea agregar.
 * @return true si se logró agregar el dato por el camino que se está
 * recorriendo, false si no se agregó en dicho camino, por lo que se deberá
 * recorrer otro camino (backtracking)
 */
template <class T>
bool ArbolHeap<T>::agregarRecursivo(Nodo<T>* current, int nivel, T dato) {

    if (nivel == this->niveles) { // Evalúa condición de término: Si se llegó al nivel en el que se deben agregar los datos.
        if (current->getIzquierda() == NULL) { // Primero corroborar la izquierda.
            current->setIzquierda(new Nodo<T>(dato));
            this->cantNodos++;
            intercambioDatos(current, current->getIzquierda());
            return true;
        } else if (current->getDerecha() == NULL) { // Luego corroborar la derecha.
            current->setDerecha(new Nodo<T>(dato));
            this->cantNodos++;
            intercambioDatos(current, current->getDerecha());
            return true;
        } else { // Si no se pudo agregar en izquierda ni en derecha.
            return false;
        }
    } else { // Aún no se llega al nivel en el que se agregará el nodo, por lo tanto se debe seguir recorriendo el árbol.
        bool correcto = agregarRecursivo(current->getIzquierda(), nivel + 1, dato); // Primero se intenta por la izquierda.
        if (correcto) { // Si se agregó.
            intercambioDatos(current, current->getIzquierda()); // Reordenar datos.
            return true;
        } else { // Se intenta por la derecha.
            correcto = agregarRecursivo(current->getDerecha(), nivel + 1, dato);
            if (correcto) { // Si se agregó.
                intercambioDatos(current, current->getDerecha()); // Reordenar datos.
                return true;
            }
            return false; // No se agregó el dato en este camino.
        }
    }
}

/**
 * Se intercambian los datos de un nodo con uno de sus hijos, solo si el nodo
 * superior tiene un dato menor al nodo inferior.
 * @param superior Nodo padre, debe quedar con el dato mayor.
 * @param inferior Nodo hijo, debe quedar con el dato menor.
 */
template <class T>
void ArbolHeap<T>::intercambioDatos(Nodo<T>* superior, Nodo<T>* inferior) {
    if (superior->getDato() < inferior->getDato()) {
        int temp = superior->getDato();
        superior->setDato(inferior->getDato());
        inferior->setDato(temp);
    }
}

/**
 * Se saca el dato mayor del árbol y se elimina. Luego, se reordenan los valores
 * del árbol. Es equivalente al método "pop" de una cola.
 * @return Dato mayor del árbol.
 */
template <class T>
T ArbolHeap<T>::sacar() {
    if (raiz == NULL) { // Caso 1: no hay datos en el árbol.
        return 0;
    } else if (raiz -> getDerecha() == NULL && raiz->getIzquierda() == NULL) { // Caso 2: Existe solo un dato en el árbol.
        int valor = raiz->getDato();
        raiz = NULL;
        return valor;
    }
    int valor = raiz->getDato(); // Valor que se debe retornar.
    if (!sacarIterativo()) {// Caso 3: Caso especial, la altura del subárbol
        //derecho es igual a la altura del subárbol izquierdo.
        sacarRecursivo(raiz, 1); // Caso 4: Caso más común. Se coloca el
        //valor del último dato agregado en la raíz, luego se elimina el
        //nodo que contenía el último dato agregado.
    }
    corregirNiveles(); // Se corrige el número de niveles del árbol.
    reordenar(raiz); // Se reordenan los datos del árbol.
    return valor;
}

/**
 * Se evalúa si el subárbol izquierdo tiene la misma altura que el subárbol
 * derecho, si es así, se realiza el intercambio de datos entre la raíz y el
 * nodo que se encuentra más a la derecha y abajo, luego dicho nodo se elimina.
 * @return true si se hizo el intercambio de datos, false en caso contrario.
 */
template <class T>
bool ArbolHeap<T>::sacarIterativo() {
    Nodo<T>* currentDerecha = raiz;
    Nodo<T>* anteriorDerecha = NULL;
    int nivelesDerecha = 0;
    while (currentDerecha->getDerecha() != NULL) { // Se cuentan los niveles del subárbol derecho.
        nivelesDerecha++;
        anteriorDerecha = currentDerecha;
        currentDerecha = currentDerecha->getDerecha();
    }

    Nodo<T>* currentIzquierda = raiz;
    int nivelesIzquierda = 0;
    while (currentIzquierda->getIzquierda() != NULL) { // Se cuentan los niveles del subárbol izquierdo.
        /*if (nivelesDerecha < nivelesIzquierda) {
            return false;
        }*/
        nivelesIzquierda++;
        currentIzquierda = currentIzquierda->getIzquierda();
    }
    if (nivelesDerecha == nivelesIzquierda) { // Si ambos subárboles tienen la misma altura.
        raiz->setDato(currentDerecha->getDato()); // Se asigna a la raíz el valor del úlimo nodo derecho.
        currentDerecha = NULL;
        anteriorDerecha->setDerecha(NULL); // Se elimina el último nodo derecho.
        this->cantNodos--; // Disminuye la cantidad de nodos del árbol en uno.
        return true;
    }
    return false;
}

/**
 * Método recursivo que sirve para colocar el dato del último nodo ingresado en
 * la raíz, para luego eliminar dicho nodo.
 * @param current nodo actual que se está analizando.
 * @param nivel nivel del árbol en el que se encuentra current.
 * @return true si se logró eliminar un nodo por el camino que se está
 * recorriendo, false si no se eliminó el nodo en dicho camino, por lo que se
 * deberá recorrer otro camino (backtracking)
 */
template <class T>
bool ArbolHeap<T>::sacarRecursivo(Nodo<T>* current, int nivel) {
    /*if (current == NULL) {
        return false;
    }*/
    if (nivel == this->niveles) { // Evalúa condición de término: Si se llegó al nivel en el que se deben eliminar los datos.
        if (current->getDerecha() != NULL) { // Primero intenta por la derecha.
            raiz->setDato(current->getDerecha()->getDato());
            delete current->getDerecha();
            current->setDerecha(NULL);
            this->cantNodos--;
            return true;
        } else if (current->getIzquierda() != NULL) { // Luego por la izquierda.
            raiz->setDato(current->getIzquierda()->getDato());
            delete current->getIzquierda();
            current->setIzquierda(NULL);
            this->cantNodos--;
            return true;
        } else { // No habían nodos que se podían eliminar.
            return false;
        }
    } else { // Se debe seguir recorriendo el árbol.
        if (sacarRecursivo(current->getDerecha(), nivel + 1)) { // Primero se intenta por la derecha.
            return true;
        } else { // Luego se intenta por la izquierda.
            return sacarRecursivo(current->getIzquierda(), nivel + 1);
        }
    }
}

/**
 * Se reordena el árbol, colocando los datos mayores arriba y los menores abajo.
 * @param current nodo actual que se está analizando si está bien ordenado
 * respecto de sus hijos.
 */
template <class T>
void ArbolHeap<T>::reordenar(Nodo<T>* current) {

    if (current->getDerecha() != NULL && current->getIzquierda() != NULL) { // Si tiene ambos hijos, izquierdo y derecho.

        // Si hijo derecho es mayor a hijo izquierdo, se evalúa primero hijo derecho y luego hijo izquierdo.
        if ((current->getDerecha()->getDato() > current->getIzquierda()->getDato())) {
            //if (current->getDato() < current->getDerecha()->getDato()) { // Si hijo derecho es mayor que current.
            this->intercambioDatos(current, current->getDerecha());
            //    reordenar(current->getDerecha());
            //} else if (current->getDato() < current->getIzquierda()->getDato()) { // Si hijo izquierda es mayor que current.
            this->intercambioDatos(current, current->getIzquierda());
            reordenar(current->getIzquierda());
            reordenar(current->getDerecha());
            //}

            // Si hijo izquierdo es mayor a hijo derecho, se evalúa primero hijo izquierdo y luego hijo derecho.
        } else {
            //if (current->getDato() < current->getIzquierda()->getDato()) { // Si hijo izquierda es mayor que current.
            this->intercambioDatos(current, current->getIzquierda());
            //  reordenar(current->getIzquierda());
            //} else if (current->getDato() < current->getDerecha()->getDato()) { // Si hijo derecho es mayor que current.
            this->intercambioDatos(current, current->getDerecha());
            reordenar(current->getIzquierda());
            reordenar(current->getDerecha());
            //}
        }
    } else { // Si al menos uno de los hijos es nulo.

        // Primero se compara con hijo derecho, si existe.
        if (current->getDerecha() != NULL /*&& (current->getDato() < current->getDerecha()->getDato())*/) {
            this->intercambioDatos(current, current->getDerecha());
            reordenar(current->getDerecha());

            // Luego se compara con hijo izquierdo, si existe.
        } else if (current->getIzquierda() != NULL /*&& (current->getDato() < current->getIzquierda()->getDato())*/) {
            this->intercambioDatos(current, current->getIzquierda());
            reordenar(current->getIzquierda());
        }

    }
}

/**
 * Asigna la cantidad de niveles del árbol según corresponda, luego de haber
 * agregado o eliminado un dato.
 */
template <class T>
void ArbolHeap<T>::corregirNiveles() {
    if (raiz == NULL) { // Si el árbol está vacío.
        niveles = 0;
    } else {
        int potenciaDos = 1;
        int auxCantNodos = this->cantNodos - 1;
        for (int i = 1; i <= niveles + 1; i++) {
            potenciaDos = potenciaDos * 2;
            auxCantNodos = auxCantNodos - potenciaDos;
            if (auxCantNodos == 0) { // El árbol tiene todos los subárboles con balance cero.
                niveles = i + 1;
                return;
            } else if (auxCantNodos < 0) { // El balance del árbol no es perfecto.
                niveles = i;
                return;
            }
        }
    }
}


template class ArbolHeap<int>;