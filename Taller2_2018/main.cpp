#include <cstdlib>
#include "LinkedList.h"
#include "ArrayList.h"
#include "ABB.h"
#include "Arbol_AVL.h"
#include <iostream>
#include <windows.h>
#include <stdio.h>

using namespace std;

double performancecounter_diff(LARGE_INTEGER *a, LARGE_INTEGER *b) {
    LARGE_INTEGER freq;
    QueryPerformanceFrequency(&freq);
    return (double) (a->QuadPart - b->QuadPart) / (double) freq.QuadPart;
}

void datosArrayList(int cantDatos) {
    ArrayList *array = new ArrayList(cantDatos);
    
    LARGE_INTEGER t_ini, t_fin;
    double secs;
    QueryPerformanceCounter(&t_ini);
    for (int i = 0; i < cantDatos; i++) {
        int num = 1 + rand() % (101 - 1);
        array->ingresar(num);
    }
    QueryPerformanceCounter(&t_fin);
    secs = performancecounter_diff(&t_fin, &t_ini);
    
    
    double time1 =  secs * 1000.0;
    double time2 = array->burbujaSort();
    double time3 = array->megersort(0, array->getCant() - 1);
    cout<<"--------------------ARRAYLIST----------------------------------"<<endl;
    cout << "tiempo demorado en ingresar "<<cantDatos<<" datos: " << time1<< endl;
    cout << "tiempo demorado en ordenar con metodo burbuja: " << time2<< endl;
    cout << "tiempo demorado en ordenar con metodo mergerSort: " << time3 << endl;
    cout<<"---------------------------------------------------------------------"<<endl<<endl;

}

void datosLinkedList(int cantDatos) {
    LinkedList *linked = new LinkedList();
     
    LARGE_INTEGER t_ini, t_fin;
    double secs;
    QueryPerformanceCounter(&t_ini);
    for (int i = 0; i < cantDatos; i++) {
        int num = 1 + rand() % (101 - 1);
        linked->ingresar(num);
    }
    QueryPerformanceCounter(&t_fin);
    secs = performancecounter_diff(&t_fin, &t_ini);
    double time1 =  secs * 1000.0;
    cout<<"--------------------LINKEDLIST----------------------------------"<<endl;
    cout << "tiempo demorado en ingresar "<<cantDatos<<" datos: " << time1<< endl;
    cout<<"---------------------------------------------------------------------"<<endl<<endl;

}


void datosABB(int cantDatos) {
    ABB *AB = new ABB();
     
    LARGE_INTEGER t_ini, t_fin;
    double secs;
    QueryPerformanceCounter(&t_ini);
    for (int i = 0; i < cantDatos; i++) {
        int num = 1 + rand() % (101 - 1);
        AB->ingresar(num);
    }
    QueryPerformanceCounter(&t_fin);
    secs = performancecounter_diff(&t_fin, &t_ini);
    double time1 =  secs * 1000.0;
    cout<<"--------------------ABB----------------------------------"<<endl;
    cout << "tiempo demorado en ingresar "<<cantDatos<<" datos: " << time1<< endl;
    cout<<"---------------------------------------------------------------------"<<endl<<endl;

}


void datosAVL(int cantDatos) {
    Arbol_AVL<int> *Avl = new Arbol_AVL<int>();
     
    LARGE_INTEGER t_ini, t_fin;
    double secs;
    QueryPerformanceCounter(&t_ini);
    for (int i = 0; i < cantDatos; i++) {
        int num = 1 + rand() % (101 - 1);
        Avl->agregar(num);
    }
    QueryPerformanceCounter(&t_fin);
    secs = performancecounter_diff(&t_fin, &t_ini);
    double time1 =  secs * 1000.0;
    cout<<"--------------------AVL----------------------------------"<<endl;
    cout << "tiempo demorado en ingresar "<<cantDatos<<" datos: " << time1<< endl;
    cout<<"---------------------------------------------------------------------"<<endl<<endl;

}

int main(int argc, char** argv) {
    datosLinkedList(100);
    datosLinkedList(500);
    datosLinkedList(1000);
    datosLinkedList(10000);
    datosLinkedList(100000);
    
    datosArrayList(100);
    datosArrayList(500);
    datosArrayList(1000);
    datosArrayList(10000);
    //datosArrayList(100000);
       
    datosABB(100);
    datosABB(500);
    datosABB(1000);
    datosABB(10000);
    datosABB(100000);
    
    datosAVL(100);
    datosAVL(500);
    datosAVL(1000);
    datosAVL(10000);
    datosAVL(100000);
    return 0;
}

