/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Juan Pablo Martinez
 *
 * Created on 1 de octubre de 2018, 19:11
 */

#include <cstdlib>
#include <windows.h>
#include <iostream>
using namespace std;

double calcularTiempo(LARGE_INTEGER *a, LARGE_INTEGER *b) {
    LARGE_INTEGER frecuencia;
    QueryPerformanceFrequency(&frecuencia);
    return (double) (a->QuadPart - b->QuadPart) / (double) frecuencia.QuadPart;
}

void crear200Procesos() {
    HANDLE proceso;
    STARTUPINFO si;
    PROCESS_INFORMATION pi;
    DWORD idproceso = 0;
    ZeroMemory(&si, sizeof (si));
    ZeroMemory(&pi, sizeof (pi));
    bool creadorProceso = NULL;
    LARGE_INTEGER t_ini, t_fin;
    double secs;
    QueryPerformanceCounter(&t_ini);
    for (int i = 0; i < 200; i++) {
        creadorProceso = CreateProcess("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\Hilos", NULL, NULL, NULL, FALSE, 0, NULL, NULL, &si, &pi);
    }
    CloseHandle(pi.hProcess);
    QueryPerformanceCounter(&t_fin);
    secs = calcularTiempo(&t_fin, &t_ini);
    double time1 = secs * 1000.0;
    cout << "El tiempo que transcurrio en crear 200 procesos usando Windows es: " << time1 << endl;


}

DWORD WINAPI hiloF(LPVOID lpParam) {
    return 0;
}

void crear200Hilos() {
    HANDLE hilo;
    DWORD idhilo;

    hilo = CreateThread(NULL, 0, hiloF, NULL, 0, &idhilo);

    LARGE_INTEGER t_ini, t_fin;
    double secs;
    QueryPerformanceCounter(&t_ini);
    for (int i = 0; i < 200; i++) {
        hilo = CreateThread(NULL, 0, hiloF, NULL, 0, &idhilo);
    }
    CloseHandle(hilo);
    QueryPerformanceCounter(&t_fin);
    secs = calcularTiempo(&t_fin, &t_ini);
    double time1 = secs * 1000.0;
    cout << "El tiempo que trnascurrio en crear 200 hilos usando windows es : " << time1 << endl;
}


int main() {
    crear200Hilos();
    crear200Procesos();
    system("pause");
}

