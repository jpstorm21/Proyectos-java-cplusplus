/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Juan Pablo Martinez
 *
 * Created on 25 de septiembre de 2018, 19:26
 */

#include <cstdlib>
#include "LinkedList.h"
#include <string.h>
#include <stdio.h>
#include <iostream>
using namespace std;

int countWords(char s[100]) {
    int cont = 0;
    bool b = false;
    for (int i = 0; i < strlen(s); i++) {
        b = false;
        if (s[i] == '-') {
            cout << "la cantidad es: " << cont << endl;
            cont = 0;
            b = true;
        }
        if (s[i] == ' ') {
            cout << "la cantidad es: " << cont << endl;
            cont = 0;
            b = true;
        }
        if (s[i] == '.') {
            cout << "la cantidad es: " << cont << endl;
            cont = 0;
            b = true;
        }
        if (!b) {
            cont++;
        }
    }
    cout << "la cantidad es: " << cont << endl;
}

bool isPalindrome(const char *s) {
    bool sol = false;
    int size = strlen(s) - 1;
    cout << size << endl;
    for (int i = 0; i < strlen(s) - 1; i++) {
        if (s[i] == s[size]) {
            sol = true;
            size--;
        } else {
            sol = false;
        }
    }
    return sol;
}

class X {
    char a;
public:

    X() {
        a = 'x';
    };

    virtual void
    mA() {
        printf("X:%c\n", a);
    }
};

class Y : public X {
    char a;
public:

    Y() {
        a = 'y';
    }

    void mA() {
        printf("Y:%c\n", a);
    }
};

int main() {
    /*  LinkedList *l = new LinkedList();
      l->ingresar(5);
      l->ingresar(6);
      l->ingresar(7);
      l->ingresar(8);
   
      l->imprimir();
    
      l->eliminar(7);
      l->imprimir();
      l->eliminar(5);
      l->imprimir();
      l->eliminar(8);
      l->imprimir();
      system("pause");*/
    char s[100] = "Anita lava la tina";
    countWords(s);
    bool x = isPalindrome(s);
    if (x) {
        cout << "es palindrome" << endl;
    }
    Y* y = new Y();
    X* xy = new X();
    y->mA();
    xy->mA();


}

