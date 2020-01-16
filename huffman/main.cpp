//Programa en C para el algoritmo de Huffman

#include <stdio.h>
#include <stdlib.h>
#include <conio.h>

/** Esta variable se puede evitar calculando la altura del árbol de Huffman */
#define MAX_TREE_HT 100

/** MinHeapNode: Nodo del árbol de Huffman */
struct MinHeapNode {
    /** Caracter de entrada */
    char data;
    /** Frecuencia del caracter */
    unsigned freq;
    /** Izquierda o derecha del nodo Niño */
    struct MinHeapNode *left, *right;
};

/** MinHeap: Colección de nodos o árbol */
struct MinHeap {
    /** Tamaño actual */
    unsigned size;
    /** Capacidad */
    unsigned capacity;
    /** Matriz de punteros a los nodos */
    struct MinHeapNode **array;
};

/** Utilizamos la funcion para asignar un nuevo nodo con su caracter dado y la frecuencia del caracter */
struct MinHeapNode* newNode(char data, unsigned freq) {
    struct MinHeapNode* temp =
            (struct MinHeapNode*) malloc(sizeof (struct MinHeapNode));
    temp->left = temp->right = NULL;
    temp->data = data;
    temp->freq = freq;
    return temp;
}

/** Uilizamos esta funcion para crear la capacidad de la coleccíon de nodos */
struct MinHeap* createMinHeap(unsigned capacity) {
    struct MinHeap* minHeap = (struct MinHeap*) malloc(sizeof (struct MinHeap));
    /** Tamaño actual es 0*/
    minHeap->size = 0;
    minHeap->capacity = capacity;
    minHeap->array =
            (struct MinHeapNode**) malloc(minHeap->capacity * sizeof (struct MinHeapNode*));
    return minHeap;
}

/** Utilizamos esta funcion para cambiar 2 nodos de la coleccíon de nodos */
void swapMinHeapNode(struct MinHeapNode** a, struct MinHeapNode** b) {
    struct MinHeapNode* t = *a;
    *a = *b;
    *b = t;
}

/** La funcion estandar de minheapify */
void minHeapify(struct MinHeap* minHeap, int idx) {
    int smallest = idx;
    int left = 2 * idx + 1;
    int right = 2 * idx + 2;

    if (left < minHeap->size &&
            minHeap->array[left]->freq < minHeap->array[smallest]->freq)
        smallest = left;

    if (right < minHeap->size &&
            minHeap->array[right]->freq < minHeap->array[smallest]->freq)
        smallest = right;

    if (smallest != idx) {
        swapMinHeapNode(&minHeap->array[smallest], &minHeap->array[idx]);
        minHeapify(minHeap, smallest);
    }
}

/** Utilizamos esta funcion para comprobar si el tamaño de la coleccíon de nodos es 1 o no */
int isSizeOne(struct MinHeap* minHeap) {
    return (minHeap->size == 1);
}

/** Funcion estandar para extraer el nodo de menor valor de la coleccíon de nodos */
struct MinHeapNode* extractMin(struct MinHeap* minHeap) {
    struct MinHeapNode* temp = minHeap->array[0];
    minHeap->array[0] = minHeap->array[minHeap->size - 1];
    --minHeap->size;
    minHeapify(minHeap, 0);
    return temp;
}

/** Utilizamos esta funcion para inserter un nodo en la coleccíon de nodos */
void insertMinHeap(struct MinHeap* minHeap, struct MinHeapNode* minHeapNode) {
    ++minHeap->size;
    int i = minHeap->size - 1;
    while (i && minHeapNode->freq < minHeap->array[(i - 1) / 2]->freq) {
        minHeap->array[i] = minHeap->array[(i - 1) / 2];
        i = (i - 1) / 2;
    }
    minHeap->array[i] = minHeapNode;
}

/** Funcion estandar para construir un MinHeap */
void buildMinHeap(struct MinHeap* minHeap) {
    int n = minHeap->size - 1;
    int i;
    for (i = (n - 1) / 2; i >= 0; --i)
        minHeapify(minHeap, i);
}

/** Utilizamos esta funcion para imprimir una matriz de tamaño n */
void printArr(int arr[], int n) {
    int i;
    for (i = 0; i < n; ++i)
        printf("%d", arr[i]);
    printf("\n");
}

/** Utilizamos esta funcion para comprobar que el nodo es hoja */
int isLeaf(struct MinHeapNode* root) {
    return !(root->left) && !(root->right);
}

/** Crea un min montón de la misma capacidad y tamaño e inserta todos los caracteres de data[] en minheap. Inicialmente minheap es igual a la capacidad */
struct MinHeap* createAndBuildMinHeap(char data[], int freq[], int size) {
    struct MinHeap* minHeap = createMinHeap(size);
    for (int i = 0; i < size; ++i)
        minHeap->array[i] = newNode(data[i], freq[i]);
    minHeap->size = size;
    buildMinHeap(minHeap);
    return minHeap;
}

/** La funcion principal para construir el árbol de Huffman */
struct MinHeapNode* buildHuffmanTree(char data[], int freq[], int size) {
    struct MinHeapNode *left, *right, *top;

    /** paso 1: crear un minheap (coleccion de nodos) de igual capacidad y tamaño que inicialmente ahy Nodos igual al tamaño */
    struct MinHeap* minHeap = createAndBuildMinHeap(data, freq, size);

    /** Reiterar mientras que el tamaño de almacenamiento dinámico no se convierte en 1 */
    while (!isSizeOne(minHeap)) {
        /** Paso 2: Extraiga los dos elementos con menor frecuencia de min heap */
        left = extractMin(minHeap);
        right = extractMin(minHeap);

        /** Paso 3: Crear un nuevo nodo interno con una frecuencia igual a la 
                Suma de las dos frecuencias de nodos. Hacer los dos nodos extraído como 
        Niños de derecha de este nuevo nodo a la izquierda y. Añadir este nodo a minheap
        '$' Es un valor especial para los nodos internos, no se utiliza */
        top = newNode('$', left->freq + right->freq);
        top->left = left;
        top->right = right;
        insertMinHeap(minHeap, top);
    }

    /** Paso 4: El nodo restante es el nodo raíz y el árbol esta completo. */
    return extractMin(minHeap);
}

/** Imprime códigos Huffman de la raíz del árbol de Huffman. Utiliza arr [] paracódigos de tienda */
void printCodes(struct MinHeapNode* root, int arr[], int top) {
    /** Asigna 0 en la izquierda y repite */
    if (root->left) {
        arr[top] = 0;
        printCodes(root->left, arr, top + 1);
    }

    /** Asigna 1 en la derecha y repite */
    if (root->right) {
        arr[top] = 1;
        printCodes(root->right, arr, top + 1);
    }

    /** Si esto es un nodo de hoja, entonces contiene una de las entradas 
        Caracteres, imprimen el carácter y su código de arr[] */
    if (isLeaf(root)) {
        printf("%c: ", root->data);
        printArr(arr, top);
    }
}

/** La función principal que construye un árbol de Huffman y códigos de impresión por la que atraviesa 
   Incorporado el árbol de Huffman */
void HuffmanCodes(char data[], int freq[], int size) {
    /**  Construir el aárbol de Huffman */
    struct MinHeapNode* root = buildHuffmanTree(data, freq, size);

    /** Imprimir los codigos de Huffman usando el árbol de Huffman */
    int arr[MAX_TREE_HT], top = 0;
    printCodes(root, arr, top);
}

/** Programa para probar y controlar las funciones anteriores */
int main() {
    char arr[] = {'j', 'u', 'a', 'n', 'i', 't', 'o', 'p', 'r', 's', 'q', '-'};
    int freq[] = {1, 2, 3, 1, 2, 1, 3, 2, 1, 1, 1, 3};
    int size = sizeof (arr) / sizeof (arr[0]);
    HuffmanCodes(arr, freq, size);

}