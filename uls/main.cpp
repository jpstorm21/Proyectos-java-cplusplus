/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: Juan Pablo Martinez
 *
 * Created on 5 de septiembre de 2018, 19:06
 */

#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>
int N = 5, M = 5, i, j;
int Mat[100][100];
int vec[100];
int vecRepetidos[100];

void llenar_matriz() {
    int aleatorio;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            aleatorio = rand() % 101 - 51;
            Mat[i][j] = aleatorio;
        }

    }
}

void muestra_matriz() {
    for (i = 1; i <= N; i++) {
        printf("\n");
        for (j = 1; j <= M; j++) {
            printf("\t%i", Mat[i][j]);
        }
    }
}

void contar_positivos() {
    int cont_positivos = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (Mat[i][j] > 0) cont_positivos++;

        }
    }
    printf("\n\n\tdentro de la matriz se localizaron = %i numeros positivos", cont_positivos);
}

void contar_negativos() {
    int cont_negativos = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (Mat[i][j] < 0) cont_negativos++;

        }
    }
    printf("\n\n\tdentro de la matriz se localizaron = %i numeros negativos", cont_negativos);
}

void determina_valores() {
    int cont_positivos = 0;
    int cont_negativos = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (Mat[i][j] > 0) cont_positivos++;
            if (Mat[i][j] < 0) cont_negativos++;
        }

    }
    if (cont_positivos > cont_negativos) {
        printf("\n\n\tEn la matriz hay mas valores positivos que negativos");
    } else {
        printf("\n\n\tEn la matriz hay mas valores negativos que positivos");
    }
    if (cont_positivos == cont_negativos) {
        printf("\n\n\tEn la matriz hay igual numero de valores positivos que negativos");
    }
}

void sumatoria_positivos() {
    int suma = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (Mat[i][j] > 0) {
                suma = suma + Mat[i][j];
            }
        }
    }
    printf("\n\n\tla Suma de los numeros  Positivos es =%i", suma);
}

void sumatoria_negativos() {
    int suma = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (Mat[i][j] < 0) {
                suma = suma + Mat[i][j];
            }
        }
    }
    printf("\n\n\tla Suma de los numeros  negativos es =%i", suma);
}

void determina_sumatoria() {
    int suma1 = 0;
    int suma2 = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (Mat[i][j] > 0) {
                suma1 = suma1 + Mat[i][j];
            }
            if (Mat[i][j] < 0) {
                suma2 = suma2 + Mat[i][j];
            }
        }

    }
    if (suma1 > suma2) {
        printf("\n\n\tDe acuerdo a los valores obtenidos la suma de numeros positivos\n\tes mayor que la de numeros negativos.");
    } else {
        printf("\n\n\tDe acuerdo a los valores obtenidos la suma de numeros negativos\n\tes mayor que la de numeros positivos.");
    }

}

void promedio() {
    float promedio;
    int suma = 0;
    int cont_positivos = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (Mat[i][j] > 0) cont_positivos++, suma = suma + Mat[i][j];

        }
    }
    promedio = (suma / cont_positivos);
    printf("\n\n\t el promedio de los numeros positivos es:%.2f", promedio);

}

void sumatoria_fila() {
    int suma1, sumafila[i], i;
    for (i = 1; i <= 5; i++) {
        suma1 = 0;
        for (j = 1; j <= 5; j++) {
            suma1 = suma1 + Mat[i][j];
        }
        sumafila[i] = suma1;
    }
    for (i = 1; i <= 5; i++) {
        printf("\n\tLa suma de la fila es : %i", sumafila[i]);
    }
}

void sumatoria_columna() {
    int suma2, sumacolumna[j], j;
    for (j = 1; j <= 5; j++) {
        suma2 = 0;
        for (i = 1; i <= 5; i++) {
            suma2 = suma2 + Mat[i][j];
        }
        sumacolumna[j] = suma2;
    }
    for (j = 1; j <= 5; j++) {
        printf("\n\tLa suma de la columna es : %i", sumacolumna[j]);
    }

}

void diagonal_pares() {
    int suma = 0, cont_pares = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (i == j) {
                if (Mat[i][j] > 0 && Mat[i][j] % 2 == 0) {
                    suma = suma + Mat[i][j];
                }
            }
        }
    }
    printf("\n\n\tEl valor de la suma de los numeros pares de la diagonal positiva es: %i", suma);
}

void promedio_impares() {
    int suma = 0, cont_impares = 0, promedio;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (i == j) {
                if (Mat[i][j] < 0 && Mat[i][j] % 2 != 0) {
                    cont_impares++;
                    suma = suma + Mat[i][j];
                }
            }
        }
    }
    promedio = (suma / cont_impares);
    printf("\n\n\tEl promedio de los numeros impares de la diagonal negativa es: %i", promedio);

}

void igualdad_diagonales() {
    int suma1 = 0, suma2 = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (i == j) {
                if (Mat[i][j] > 0) {
                    suma1 = suma1 + Mat[i][j];
                } else if (Mat[i][j] < 0) {
                    suma2 = suma2 + Mat[i][j];
                }

            }
        }
    }
    if (suma1 == suma2) {
        printf("\n\n\tLa suma de la diagonal positiva es igual a la suma de la diagonal negativa");
    } else {
        printf("\n\n\tLa suma de la diagonal positiva es :%i y la suma de la diagonal negativa es: %i por lo tanto ambas no son iguales entre si", suma1, suma2);
    }
}

void matriz_varianza() {
    float promedio;
    int suma = 0;
    int cont_positivos = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (Mat[i][j] > 0) cont_positivos++, suma = suma + Mat[i][j];

        }
    }
    promedio = (suma / cont_positivos);
    printf("\n\n\t el promedio de los numeros positivos es:%.2f", promedio);




}

void contar_pares() {
    int cont_pares = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (Mat[i][j] % 2 == 0) cont_pares++;

        }
    }
    printf("\n\n\tTotal Pares=%i", cont_pares);
}

void diagonal() {
    int suma = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= M; j++) {
            if (i == j) {
                if (Mat[i][j] > 0) {
                    printf("\n%i", Mat[i][j]);
                    suma = suma + Mat[i][j];
                }

            }
        }
    }
    printf("\n\n\tSuma Positivos de la diagonal=%i", suma);
}

int main() {

    llenar_matriz();
    muestra_matriz();
    contar_positivos();
    contar_negativos();
    determina_valores();
    sumatoria_positivos();
    sumatoria_negativos();
    determina_sumatoria();
    promedio();
    sumatoria_fila();
    sumatoria_columna();
    diagonal_pares();
    promedio_impares();
    igualdad_diagonales();
    matriz_varianza();
    contar_pares();
    diagonal();

}


