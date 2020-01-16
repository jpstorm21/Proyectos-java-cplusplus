package taller5_1;
//          AMANDA GALLARDO - MICHAEL BRAVO                   TALLER 5 - (ENTREGA I)
import ucn.*;

public class App {
    
    /**
     * Evalua si un string se puede transformar en un int
     * @param string: String a evaluar
     * @return : boolean si se puede o no transformar
     */
    public static boolean isInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    /**
     * Esta funcion lee el archivo txt y examina cada vector para luego ser ingresados en el sistema de arbol que dan en el
     * enunciado (para todo nodo actual ubicado en la posición “i” del arreglo tendrá a su hijo izquierdo en la posición 
     * 2*i + 1 del arreglo y a su hijo derecho en la posición 2*i + 2 del arreglo) y luego se ingresa en el otro sistema
     * de arbol que es el arbol binario de busqueda, para ser comparados y saber si es un abb o no.
     */
    public static void leerYValidar() {
        // SE LEEN LOS DATOS
        In datos = new In("abb.txt");
        while (!datos.isEmpty()) {
            boolean validar1= true;
            boolean validar2= true;
            boolean validar3= true;
            String tamaño = datos.readLine();
            validar1= isInt(tamaño);
            
            String linea = datos.readLine();
            String[] vec = linea.split(",");
            int[] vector = new int[vec.length];
            for (int i = 0; i < vec.length; i++) {
                if(!isInt(vec[i])){
                    validar2= false;
                    break;
                }
                vector[i] = Integer.parseInt(vec[i]);
            }
            
            if(validar1 && validar2 && Integer.parseInt(tamaño)== vector.length){
            //SE CREAN LOS DOS ARBOLES PARA LUEGO COMPARARLOS
            Arbol lista = new Arbol();
            Arbol listabinaria = new Arbol();
            //ARBOL DEL ENUNCIADO
            crearArbol(lista, vector, vector.length);
            //ARBOL BINARIO DE BUSQUEDA
            Arboldebusqueda(vector, listabinaria);
            
            //SE COMPARAN Y SE OBTIENE EL BOOLEANO PARA SABER SI IMPRIMIR O NO EL MIN Y EL MAX
            boolean abb = sonIguales(lista, listabinaria);

            for (int i = 0; i < vector.length; i++) {
                StdOut.print(vector[i] + " ");
            }
            
            StdOut.println();
            StdOut.println("     Es abb: " + abb);
            if (abb) {
                StdOut.println("     Mínimo: " + Min(vector));
                StdOut.println("     Máximo: " + Max(vector));
            }
            }else{
                //EN EL TXT SE INGRESO UN STRING LO QE GENERA ALGUN PROBLEMA
                StdOut.println("Problema con linea de txt (formato incorrecto!)");
            }
            StdOut.println();
        }
        datos.close();
    }
    
    /**
     * Llamada a la funcion que crea un arbol del tipo explicado en el enunciado
     * @param lista: es la lista que contendrá todo el arbol
     * @param vector: el vector que se transformara en arbol
     * @param tamaño: tamaño del vector
     */
    public static void crearArbol(Arbol lista, int[] vector, int tamaño) {
        crearArbol(lista.getRaiz(), vector, tamaño, 0);
    }
    
    /**
     * Metodo recursivo que transformara el vector en arbol de la forma que dice el enunciado
     * @param actual: sera el nodo actual del arbol
     * @param vector: vector que se transformara
     * @param tamaño: tamaño del vector
     * @param i: posicion del vector
     */
    private static void crearArbol(Nodo actual, int[] vector, int tamaño, int i) {
        if (i == 0) {
            actual.setNumero(vector[i]);
            crearArbol(actual, vector, tamaño, i + 1);
        }
        if (i * 2 + 2 < tamaño) {
            Nodo derecho = new Nodo(vector[i * 2 + 2]);
            actual.setHijoDer(derecho);
            crearArbol(derecho, vector, tamaño, i * 2 + 2);
        }
        if (i * 2 + 1 < tamaño) {
            Nodo izquierdo = new Nodo(vector[i * 2 + 1]);
            actual.setHijoIzq(izquierdo);
            crearArbol(izquierdo, vector, tamaño, i * 2 + 1);
        }
    }
    
    /**
     * Llamada a la funcion que crea un arbol del tipo ABB
     * @param vector: vector que se transformara en ABB
     * @param lista: lista que contendrá todo el arbol
     */
    public static void Arboldebusqueda(int[] vector, Arbol lista) {
        Nodo nuevo = new Nodo(vector[0]);
        lista.setRaiz(nuevo);

        insertarrec(lista.getRaiz(), vector, 1, lista);
    }
    
    /**
     * Metodo recursivo que transformara el vector en arbol de la forma ABB
     * @param actual: sera el nodo actual del arbol
     * @param vector: vector que se transformara
     * @param i: posicion del vector
     * @param lista: lista que contendrá todo el arbol
     */
    private static void insertarrec(Nodo actual, int[] vector, int i, Arbol lista) {
        if (i < vector.length) {
            if (vector[i] > actual.getNumero()) {
                if (actual.getHijoDer() != null) {
                    insertarrec(actual.getHijoDer(), vector, i, lista);
                } else {
                    Nodo nuevo = new Nodo(vector[i]);
                    actual.setHijoDer(nuevo);
                    insertarrec(lista.getRaiz(), vector, ++i, lista);
                }
            } else if (actual.getHijoIzq() != null) {
                insertarrec(actual.getHijoIzq(), vector, i, lista);
            } else {
                Nodo nuevo = new Nodo(vector[i]);
                actual.setHijoIzq(nuevo);
                insertarrec(lista.getRaiz(), vector, ++i, lista);
            }
        }
    }
    
    /**
     * Transformara los 2 arboles en un String el cual sera la impresion de este arbol en preOrden para compararlos y saber
     * si es o no un ABB
     * @param lista: lista que contiene todo el arbol del sistema que se explica en el enunciado
     * @param listaBdB: lista que contiene todo el ABB
     * @return un booleano si es o no un ABB
     */
    public static boolean sonIguales(Arbol lista, Arbol listaBdB) {
        String comparativo1 = "";
        String comparativo2 = "";
        comparativo1 = crearComparativo(comparativo1, lista.getRaiz());
        comparativo2 = crearComparativo(comparativo2, listaBdB.getRaiz());
        if (comparativo1.equals(comparativo2)) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Transforma los arboles en un string (impresion es preOrden)
     * @param comparativo: String que contiene la impresion del arbol
     * @param nodo: nodo actual
     * @return : el String realizado
     */
    private static String crearComparativo(String comparativo, Nodo nodo) {
        if (nodo != null) {
            comparativo = comparativo + nodo.getNumero() + " ";
            return crearComparativo(comparativo, nodo.getHijoIzq()) + crearComparativo(comparativo, nodo.getHijoDer());
        } else {
            return comparativo;
        }
    }
    
    /**
     * Llama a la funcion max que obtendra el maximo de un vector
     * @param vector: vector a evaluar
     * @return : maximo
     */
    public static int Max(int[] vector) {
        return (Max(0, vector.length - 1, vector));
    }
    
    /**
     * Funcion recursiva que obtiene el valor maximo
     * @param posI: posicion incial de la parte a evaluar del vector
     * @param posF: posicion final de la parte a evaluar del vector
     * @param vector: vector a evaluar
     * @return valor maximo
     */
    private static int Max(int posI, int posF, int[] vector) {
        int mayor = 0;
        if (posI == posF) {//un solo elemento
            mayor = vector[posI];
            return mayor;
        } else if (posI == posF - 1) { //Dos elementos
            if (vector[posI] > vector[posF]) {
                mayor = vector[posI];
            } else {
                mayor = vector[posF];
            }
            return mayor;
        } else {
            int mitad = (posI + posF) / 2;
            int may1 = Max(posI, mitad, vector);
            int may2 = Max(mitad + 1, posF, vector);
            if (may1 > may2) {
                return may1;
            } else {
                return may2;
            }
        }
    }
    
    /**
     * Llama a la funcion min que obtendra el minimo de un vector
     * @param vector: vector a evaluar
     * @return : minimo
     */
    public static int Min(int[] vector) {
        return (Min(0, vector.length - 1, vector));
    }
    
    /**
     * Funcion recursiva que obtiene el valor minimo
     * @param posI: posicion incial de la parte a evaluar del vector
     * @param posF: posicion final de la parte a evaluar del vector
     * @param vector: vector a evaluar
     * @return valor minimo
     */
    private static int Min(int posI, int posF, int[] vector) {
        int minimo = 0;
        if (posI == posF) {//un solo elemento
            minimo = vector[posI];
            return minimo;
        } else if (posI == posF - 1) { //Dos elementos
            if (vector[posI] < vector[posF]) {
                minimo = vector[posI];
            } else {
                minimo = vector[posF];
            }
            return minimo;
        } else {
            int mitad = (posI + posF) / 2;
            int min1 = Min(posI, mitad, vector);
            int min2 = Min(mitad + 1, posF, vector);
            if (min1 < min2) {
                return min1;
            } else {
                return min2;
            }
        }
    }
    /**
     * MAIN
     * @param args 
     */
    public static void main(String[] args) {
        leerYValidar();
    }

}
