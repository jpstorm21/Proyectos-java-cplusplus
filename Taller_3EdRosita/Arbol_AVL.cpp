/* 
 * File:   Arbol_AVL.cpp
 * 
 * Implementacion de la clase Arbol_AVL.
 */

#include "Arbol_AVL.h"

/**
 * Constructor, siempre inicia vacio.
 */
template <class T>
Arbol_AVL<T>::Arbol_AVL(){
    raizArbol = NULL;
}

/**
 * Destructor de la clase.
 */
template <class T>
Arbol_AVL<T>::~Arbol_AVL(){
    if(raizArbol!=NULL){
        raizArbol->~Nodo();
    }
}

/**
 * Retorna raiz del arbol.
 */
template <class T>
Nodo<T>* Arbol_AVL<T>::getRaiz(){
    return raizArbol;
}

/**
 * Retorna altura del arbol.
 * @return Entero que muestra la altura del arbol.
 */
template <class T>
int Arbol_AVL<T>::altura(){
    return alturaRecursivo(raizArbol);
}

/**
 * Imprime el arbol de diferentes formas, el tipo de impresion se espesifica con un entero,
 * 0.- mostrar: imprime los datos en forma jerarquica cada una da sus ramas.
 * 1.- inorden: imprime los datos en inorden.
 * 2.- preorden: imprime los datos en preorden.
 * 3.- postorden: imprime los datos en postorden.
 * @param tipo Entero que entrega el tipo de impresion a realizar.
 */
template <class T>
void Arbol_AVL<T>::imprimir(int tipo){
    switch(tipo){
        case 0:
            mostrar(raizArbol,1);
            break;
        case 1:
            inOrden(raizArbol);
            break;
        case 2:
            preOrden(raizArbol);
            break;
        case 3:
            postOrden(raizArbol);
            break;
    }
}

/**
 * Entrega la altura de un arbol o subarbol entregando su raiz.
 * @param raiz Puntero a nodo raiz del subarbol.
 * @return Entero que muestra la altura del subarbol.
 */
template <class T>
int Arbol_AVL<T>::alturaRecursivo(Nodo<T>* raiz){
    int h = 0;
    if (raiz != NULL){
        int altura_IZQ = alturaRecursivo (raiz->getIzquierda());
        int altura_DER = alturaRecursivo (raiz->getDerecha());
        if(altura_IZQ>altura_DER){h=altura_IZQ+1;}
        else{h=altura_DER+1;}
    }
    return h;
}

/**
 * Imprime el Arbol o subarbol, entragando la raiz y el nivel en que esta.
 * @param raiz Puntero a nodo raiz del subarbol.
 * @param nivel Entero que muestra  el nivel en que se encuentra la raiz.
 */
template <class T>
void Arbol_AVL<T>::mostrar(Nodo<T>* raiz, int nivel){
    int i;
    if (raiz!=NULL){
        mostrar(raiz->getDerecha(), nivel + 1);
        std::cout<<"\n";
        if (raiz == this->raizArbol)
        std::cout<<"raiz -> ";
        for (i = 0; i < nivel && raiz != this->raizArbol; i++)
            std::cout<<"        ";
        std::cout<<raiz->getDato();
        mostrar(raiz->getIzquierda(), nivel + 1);
    }
}

/**
 * Imprime datos en inorden.
 * inorden: subarbol izquierda - raiz - subarbol derecho.
 * @param raiz raiz del subarbol o arbol a imprimir.
 */
template <class T>
void Arbol_AVL<T>::inOrden(Nodo<T>* raiz){
    if (raiz == NULL)
        return;
    inOrden (raiz->getIzquierda());
    std::cout<<raiz->getDato()<<"  ";
    inOrden (raiz->getDerecha());
}

/**
 * Imprime datos en preorden.
 * preorden: raiz - subarbol izquierda - subarbol derecho.
 * @param raiz raiz del subarbol o arbol a imprimir.
 */
template <class T>
void Arbol_AVL<T>::preOrden(Nodo<T>* raiz){
    if (raiz == NULL)
        return;
    std::cout<<raiz->getDato()<<"  ";
    preOrden (raiz->getIzquierda());
    preOrden (raiz->getDerecha());
}

/**
 * Imprime datos en postorden.
 * postorden: subarbol izquierda - subarbol derecho - raiz.
 * @param raiz raiz del subarbol o arbol a imprimir.
 */
template <class T>
void Arbol_AVL<T>::postOrden(Nodo<T>* raiz){
    if (raiz == NULL)
        return;
    postOrden ( raiz ->getIzquierda() );
    postOrden ( raiz ->getDerecha() );
    std::cout<<raiz->getDato()<<"  ";
}

/**
 * Inserta el dato en el arbol.
 * @param dato Tipo por definir que se almacenará.
 */
template <class T>
void Arbol_AVL<T>::agregar(T dato){
    raizArbol = agregarRecursivo(raizArbol, new Nodo<T>(dato));
}

/**
 * Recorre el arbol por recursion en buqueda de el lugar donde agregar el nuevo 
 * dato y luego balancea.
 * @param actual Posicion en que se encuentra el metodo en el arbol.
 * @param nuevo Puntero a nodo que contiene el dato que se almacenará.
 * @return la rama modificada del arbol con el dato agregado.
 */
template <class T>
Nodo<T>* Arbol_AVL<T>::agregarRecursivo(Nodo<T>* actual, Nodo<T>* nuevo){
    if (actual == NULL){// Si se llega al final se enlaza el nuevo nodo.
        return nuevo;
    }
    else if (nuevo->getDato() < actual->getDato()){// Si el dato es menor que el actual se busca agrega a la izquierda.
        actual->setIzquierda(agregarRecursivo(actual->getIzquierda(), nuevo));
        return balanceo(actual);
    }
    else if (nuevo->getDato() >= actual->getDato()){// Si el dato es mayor o igual que el actual se busca agrega a la derecha.
        actual->setDerecha(agregarRecursivo(actual->getDerecha(), nuevo));
        return balanceo(actual);
    }
    return actual;
}

/**
 * Ordena el arbol por medio de rotaciones, de forma que mantiene una diferencia 
 * de altura entre subarbol derecho e izquierdo de maximo 1.
 * @param raiz Raiz del arbol o subarbol que se balanceará.
 * @return Retorna la raiz balanceada.
 */
template <class T>
Nodo<T>* Arbol_AVL<T>::balanceo(Nodo<T>* raiz){
    int factorDeBalance = desbalance (raiz);
    Nodo<T>* cambio = raiz;
    if (factorDeBalance > 1){// Si el factor de balance es mayor que 1 el arbol esta desbalanceado a la izquierda.
        if (desbalance (raiz->getIzquierda()) > 0)// Si el de la izquierda en mayor que 1 hay un desbalance a la izquierda.
            cambio = rotacion_DER (raiz);// Se realiza rotacion a la izquierda.
        else // Si el desbalance esta a la derecha.
            cambio = rotacion_IZQ_DER (raiz); // Se realiza rotacion a la izquierda y luego a la derecha.
    }
    else if (factorDeBalance < -1){// Si el factor de balance es menor que -1 el arbol esta desbalanceado a la derecha.
        if (desbalance (raiz->getDerecha()) < 0)// Si el de la izquierda en menor que 0 hay un desbalance a la derecha.
            cambio = rotacion_IZQ (raiz);// Se realiza rotacion a la derecha.
        else // Si el desbalance esta a la izquierda.
            cambio = rotacion_DER_IZQ (raiz);// Se realiza rotacion a la derecha y luego a la izquierda.
    }
    return cambio;
}

/**
 * calcula el desbalance de un arbol o subarbol, es decir, la diferencia entre 
 * la altura del subarbol derecho e izquierdo.
 * @param raiz Arbol o subarbol que se balanceará.
 * @return Entero que muestra el desbalance en el arbol o subarbol.
 */
template <class T>
int Arbol_AVL<T>::desbalance(Nodo<T>* arbol){
    int alturaIZQ = alturaRecursivo (arbol->getIzquierda());//Altura subarbol izquierdo.
    int alturaDER = alturaRecursivo (arbol->getDerecha());//Altura subarbol derecho.
    int desbalance = alturaIZQ - alturaDER;//Desbalance, diferencia entre altura izquierda y derecha.
    return desbalance;
}

/**
 * Rotacion derecha, realiza un cambio entre el mayor dato del subarbol 
 * izquierdo y la raiz, manteniendo el orden de los datos.
 * @param raiz Raiz de el arbol o subarbol que se rotara.
 * @return Raiz del arbol o subarbol rotado.
 */
template <class T>
Nodo<T>* Arbol_AVL<T>::rotacion_DER(Nodo<T>* raiz){
    Nodo<T>* temp;
    temp = raiz->getIzquierda();//Guarda arbol derecho.
    raiz->setIzquierda(temp->getDerecha());//quita enlace con subarbol guardado.
    temp->setDerecha(raiz);//Subarbol izquierdo se hace raiz, y raiz se vuelve subarbol derecho.
    return temp;
}

/**
 * Rotacion izquierda, realiza un cambio entre el menor dato del subarbol 
 * derecho y la raiz, manteniendo el orden de los datos.
 * @param raiz Raiz de el arbol o subarbol que se rotará.
 * @return Raiz del arbol o subarbol rotado.
 */
template <class T>
Nodo<T>* Arbol_AVL<T>::rotacion_IZQ(Nodo<T>* raiz){
    Nodo<T>* temp;
    temp = raiz->getDerecha();
    raiz->setDerecha(temp->getIzquierda());
    temp->setIzquierda(raiz);
    return temp;
}

/**
 * Doble rotacion izquierda derecha, realiza dos rotaciones una rotacion a la 
 * izquierda sucedida de una rotacion derecha.
 * @param raiz Raiz de el arbol o subarbol que se rotará.
 * @return Raiz del arbol o subarbol rotado. 
 */
template <class T>
Nodo<T>* Arbol_AVL<T>::rotacion_IZQ_DER(Nodo<T>* raiz){
    Nodo<T>* temp;
    temp = raiz->getIzquierda();//Guarda subarbol izquierdo.
    raiz->setIzquierda(rotacion_IZQ (temp));//se realiza una rotacion a la izquierda al subarbol guardado y se setea a la izquierda.
    return rotacion_DER (raiz);//realiza una rotacion a la derecha en la raiz entregada.
}

/**
 * Doble rotacion derecha izquierda, realiza dos rotaciones una rotacion a la 
 * derecha sucedida de una rotacion izquierda.
 * @param raiz Raiz de el arbol o subarbol que se rotará.
 * @return Raiz del arbol o subarbol rotado. 
 */
template <class T>
Nodo<T>* Arbol_AVL<T>::rotacion_DER_IZQ(Nodo<T>* raiz){
    Nodo<T>* temp;
    temp = raiz->getDerecha();
    raiz->setDerecha(rotacion_DER (temp));
    return rotacion_IZQ (raiz);
}

/**
 * Elimina un dato amacenado.
 * @param dato Valor del dato que se eliminará.
 */
template <class T>
void Arbol_AVL<T>::eliminar(T dato){
    raizArbol = eliminarRecursivo(raizArbol, dato);
}

/**
 * Recorre el arbol por recursion en buqueda de el Dato que se eliminará, 
 * manteniendo el balance del arbol.
 * @param actual Posicion en que se encuentra el metodo en el arbol.
 * @param dato Tipo por definir que se desea eliminar del arbol.
 * @return la rama modificada del arbol con el dato eliminado.
 */
template <class T>
Nodo<T>* Arbol_AVL<T>::eliminarRecursivo(Nodo<T>* actual, T dato){
    if(actual==NULL){//Si llega al final no existe el dato.
        return NULL;
    }else if(dato == actual->getDato()){//Si encuentra el dato.
        if(actual->getIzquierda()==NULL){//Si la izquierda no existe se setea la derecha.
            return actual->getDerecha();
        }else{//Si existe la izquierda.
            Nodo<T>* mayorIZQ = removerDatoMayor(actual->getIzquierda());// Busca y guarda dato mayor del subarbol izquierdo, removiendolo.
            if(mayorIZQ==actual->getIzquierda()){//Si el dato mayor es el de la izquierda de actual.
                mayorIZQ->setDerecha(actual->getDerecha());//Se vuelve raiz y se setea derecha.
            }else{//Si el dato mayor es distinto al subarbol izquierdo del actual.
                mayorIZQ->setDerecha(actual->getDerecha());//Al mayor del suarbol izquierdo, setea a la derecha lo que tenia la raiz.
                agregarRecursivo(mayorIZQ,actual->getIzquierda());//Agrega lo que la raiz tenia a la izquierda al mayor del subarbol izquierdo, combiertiendose en la nueva raiz.
                delete actual;//Elimina actual.
            }
            return mayorIZQ;//Pasa a ser nueva subraiz.
        }
    }else if(dato < actual->getDato()){//Si el dato es menor al del actual se busca por la izquierda.
        actual->setIzquierda(eliminarRecursivo(actual->getIzquierda(),dato));
    }else{//Si el dato es mayor al actual se busca por la derecha.
        actual->setDerecha(eliminarRecursivo(actual->getDerecha(),dato));
    }
    return actual;
}

/**
 * Remuevo el dato mayor de un arbol o subarbol.
 * @param raiz Raiz del arbol o subarbol.
 * @return Nodo con valor mayor, removido del arbol.
 */
template <class T>
Nodo<T>* Arbol_AVL<T>::removerDatoMayor(Nodo<T>* raiz){
    Nodo<T>* mayor=NULL;
    if(raiz==NULL){
    }else if(raiz->getDerecha()==NULL){//Si es el ultimo de la derecha, es el mayor.
        mayor = raiz;//Guarda el mayor.
    }else {//Si no es el ultimo de la derecha, busco en el subarbol derecho.
        mayor = removerDatoMayor(raiz->getDerecha());//Busca por la derecha.
        if(raiz->getDerecha()==mayor){//Si encuentro el mayor rompo el enlace con él.
            raiz->setDerecha(NULL);
        }
    }
    return mayor;
}

template class Arbol_AVL <int>;