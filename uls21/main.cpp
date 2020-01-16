
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <time.h>
#include <math.h>
#include <fstream>
#include <sstream>
#include <iostream>
FILE*z;
using namespace std;
#define N 5
int Mat[N][N];
int i, j;

void llenar_matriz() {
    int aleatorio;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            aleatorio = rand() % 101 - 51;
            Mat[i][j] = aleatorio;
        }

    }
}

void muestra_matriz() {

    for (i = 0; i < N; i++) {
        printf("\n");
        for (j = 0; j < N; j++) {
            printf("\t%i", Mat[i][j]);

        }

    }
}

void graba_matriz() {
    ofstream a1("archivo1.1.txt");
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            a1 << (Mat[i][j]) << " ";
        }
        a1 << "\n";
    }
}

void contar_positivos() {
    ofstream a2("archivo1.2.txt");
    int cont_positivos = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] > 0) cont_positivos++;

        }
    }

    a2 << "En la matriz se encontraron  una cantidad numeros positivos: " << cont_positivos << endl;
}

void contar_negativos() {
    ofstream a3("archivo1.3.txt");
    int cont_negativos = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] < 0) cont_negativos++;

        }
    }
    a3 << "En la matriz se encontraron una cantidad numeros negativos" << cont_negativos << endl;
}

void determina_valores() {
    ofstream a4("archivo1.4.txt");
    int cont_positivos = 0;
    int cont_negativos = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] > 0) cont_positivos++;
            if (Mat[i][j] < 0) cont_negativos++;
        }

    }
    if (cont_positivos > cont_negativos) {
        a4 << "En la matriz hay mas valores positivos que negativos" << endl;
    } else {
        a4 << "En la matriz hay mas valores negativos que positivos" << endl;
    }
    if (cont_positivos == cont_negativos) {
        a4 << "En la matriz hay igual numero de valores positivos que negativos" << endl;
    }

}

void sumatoria_positivos() {
    ofstream a5("archivo1.5.txt");
    int suma = 0;
    for (i = 1; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] > 0) {
                suma = suma + Mat[i][j];
            }
        }
    }
    a5 << "La suma de los numeros positivos es " << suma << endl;
}

void sumatoria_negativos() {
    ofstream a6("archivo1.6.txt");
    int suma = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] < 0) {
                suma = suma + Mat[i][j];
            }
        }
    }
    a6 << "La suma de los numeros negativos es " << suma << endl;
}

void determina_sumatoria() {
    ofstream a7("archivo1.7.txt");
    int suma1 = 0;
    int suma2 = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] > 0) {
                suma1 = suma1 + Mat[i][j];
            }
            if (Mat[i][j] < 0) {
                suma2 = suma2 + Mat[i][j];
            }
        }

    }
    if (suma1 > suma2) {
        a7 << "La sumatoria de numeros positivos es mayor que la de numeros negativos." << endl;
    } else {
        a7 << "La sumatoria de numeros negativos es mayor que la de numeros positivos." << endl;

    }


}

void promedio() {
    ofstream a8("archivo1.8.txt");
    float promedio;
    int suma = 0;
    int cont_positivos = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] > 0) cont_positivos++, suma = suma + Mat[i][j];

        }
    }
    promedio = (suma / cont_positivos);
    a8 << "El promedio de los numeros positivos es: " << promedio << endl;

    //printf("\n\nSumatoria de filas y columnas:\n-------------------------------");


}

void sumatoria_fila() {
    int suma1, sumafila[i], i;
    for (i = 0; i < N; i++) {
        suma1 = 0;
        for (j = 0; j < N; j++) {
            suma1 = suma1 + Mat[i][j];
        }
        sumafila[i] = suma1;
    }
    for (i = 0; i < N; i++) {

        //printf("\n\tLa suma de la fila %i es : %i",i,sumafila[i]);
    }
}

void sumatoria_columna() {
    int suma2, sumacolumna[j], j;
    for (j = 0; j < N; j++) {
        suma2 = 0;
        for (i = 0; i < N; i++) {
            suma2 = suma2 + Mat[i][j];
        }
        sumacolumna[j] = suma2;
    }
    for (j = 0; j < N; j++) {

        //printf("\n\tLa suma de la columna %i es : %i",j,sumacolumna[j]);
    }

}

void diagonal_pares() {
    ofstream a9("archivo1.9.txt");
    int suma = 0, cont_pares = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (i == j) {
                if (Mat[i][j] > 0 && Mat[i][j] % 2 == 0) {
                    suma = suma + Mat[i][j];
                }
            }
        }
    }
    a9 << "La suma de los numeros pares de la diagonal positiva es: " << suma << endl;

}

void Promedio_impares() {
    ofstream a10("archivo1.10.txt");
    int suma = 0, cont_impares = 0, promedio;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (i == j) {
                if (Mat[i][j] < 0 && Mat[i][j] % 2 != 0) {
                    cont_impares++;
                    suma = suma + Mat[i][j];
                }
            }
        }
    }
    promedio = (suma / cont_impares);
    a10 << "El promedio de los numeros impares de la diagonal negativa es: " << promedio << endl;

}

void contador_Nprimo() {
    ofstream a11("archivo1.11.txt");

    int cont, b, p = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            cont = 0;
            for (b = 1; b <= Mat[i][j]; b++)
                if ((Mat[i][j] % b) == 0) {
                    cont = cont + 1;
                }

            if ((cont <= 2) &&(Mat[i][j] > 0)) {
                p = p + 1;
                printf("\n\n\tEl A[%d][%d]=%d es primo", i, j, Mat[i][j]);
            }
        }
    }
    a11 << "El total de numeros primos es: " << p << endl;
}

void promedio_impares() {
    ofstream a12("archivo1.12.txt");
    int suma = 0, cont_impares = 0, promedio;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (i == j) {
                if (Mat[i][j] < 0 && Mat[i][j] % 2 != 0) {
                    cont_impares++;
                    suma = suma + Mat[i][j];
                }
            }
        }
    }
    promedio = (suma / cont_impares);
    a12 << "El promedio de los numeros impares de la diagonal negativa es: " << promedio << endl;

}

void Contador_Nprimo() {
    ofstream a13("archivo1.13.txt");
    int cont, b, p = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            cont = 0;
            for (b = 1; b <= Mat[i][j]; b++)
                if ((Mat[i][j] % b) == 0) {
                    cont = cont + 1;
                }

            if ((cont <= 2) &&(Mat[i][j] > 0)) {
                p = p + 1;
            }
        }
    }
    a13 << "El total de numeros primos es: " << p << endl;

}

void igualdad_diagonales() {
    ofstream a14("archivo1.14.txt");
    int suma1 = 0, suma2 = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
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
        a14 << "La suma de la diagonal positiva es igual a la suma de la diagonal negativa" << endl;
    } else {
        a14 << "La suma de la diagonal positiva es: " << suma1 << " y la suma de la diagonal negativa es: " << suma2 << " por lo tanto ambas no son iguales entre si" << endl;
    }

}

void matriz_varianza() {
    float promedio;
    int suma = 0;
    int cont_positivos = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] > 0) cont_positivos++, suma = suma + Mat[i][j];

        }
    }
    promedio = (suma / cont_positivos);




}

void contar_pares() {
    int cont_pares = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] % 2 == 0) cont_pares++;

        }
    }
}

void diagonal() {
    int suma = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (i == j) {
                if (Mat[i][j] > 0) {
                    printf("\n%i", Mat[i][j]);
                    suma = suma + Mat[i][j];
                }

            }
        }
    }
    //printf("\n\n\tLa suma de los numeros positivos de la diagonal=%i",suma);
}

void repetidos() {
    ofstream a16("archivo1.16.txt");

    int frecuencias[10000][2];
    int total = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            int se_repite = 0;
            for (int k = 1; k <= (total); k++) {
                if (frecuencias[k][1] == Mat[i][j]) {
                    se_repite = 1;
                    frecuencias[k][2]++;
                }
            }
            if (se_repite == 0) {
                frecuencias[total + 1][1] = Mat[i][j];
                frecuencias[total + 1][2] = 1;
                total++;
            }
        }
    }

    a16 << "Numeros repetidos: " << endl;
    int repetidos = 0;
    for (i = 0; i <= total; i++) {
        if (frecuencias[i][2] >= 2) {
            repetidos++;


        }
    }
    a16 << "Hay: " << repetidos << " elementos repetidos" << endl;
    a16 << "Hay: " << total - repetidos << " elementos no repetidos" << endl;
    a16 << "Hay: " << total << " elementos distintos en total" << endl;
}

void filasparescolumnasimpares() {
    ofstream a17("archivo1.17.txt");
    a17 << "Division:" << endl;
    int sum_filas_pares = 0;
    int sum_columnas_impares = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (i % 2 == 0) {
                sum_filas_pares += Mat[i][j];
            }
            if (j % 2 != 0) {
                sum_columnas_impares += Mat[i][j];
            }
        }
    }

    a17 << "La sumatoria de las filas pares es : " << sum_filas_pares << endl;
    a17 << "La sumatoria de las columnas impares es: " << sum_columnas_impares << endl;
    float division = (1.0 * sum_filas_pares) / (1.0 * sum_columnas_impares);
    a17 << "La division de la sumatoria de las filas pares por la sumatoria de las columnas impares es: " << division << endl;

}

void Numero_perfecto() {
    ofstream a18("archivo1.18.txt");

    int p = 0, cont, b;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            cont = 0;
            for (b = 1; b <= Mat[i][j] - 1; b++)
                if ((Mat[i][j] % b) == 0) {
                    cont = cont + b;
                }

            if ((cont == Mat[i][j])&& (Mat[i][j] > 0)) {
                p = p + 1;
                a18 << "El A[" << i << "][" << j << "] es perfecto: " << Mat[i][j] << endl;
            }
        }
    }
    a18 << "Total de numeros perfectos: " << p << endl;


}

float calcularpromedio() {
    float promedio;
    int suma = 0;
    int cont_positivos = 0;
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            if (Mat[i][j] > 0) cont_positivos++, suma = suma + Mat[i][j];

        }
    }
    promedio = (suma / cont_positivos);
    return promedio;

}

void calcular_varianza() {
    ofstream a15("archivo1.15.txt");
    float desestandar, varianza, promedio;
    int sumcuadrado;
    sumcuadrado = 0;
    promedio = calcularpromedio();
    for (i = 0; i < N; i++) {
        for (j = 0; j < N; j++) {
            sumcuadrado = sumcuadrado + pow(Mat[i][j] - promedio, 2);
        }
    }
    varianza = (sumcuadrado / N);
    desestandar = sqrt(varianza);
    a15 << "Varianza : " << varianza << endl;
    a15 << " Desviacion Estandar : " << desestandar << endl;
}

void sumatoria_bordes() {
    ofstream a19("archivo1.19.txt");
    int suma = 0;
    for (i = 1; i <= N; i++) {
        for (j = 1; j <= N; j++) {
            if (i == 1 || i == N || j == 1 || j == N) {
                suma = suma + Mat[i][j];

            }
        }
    }
    a19 << "La suma de los bordes es : " << suma << endl;
}

void triangular_superiorder() {
    ofstream a20("archivo1.20.txt");
    int suma = 0;
    if (N == N) {
        for (i = 1; i < N; i++) {
            if (j > 1) {
                suma = suma + Mat[i][j];
            }
        }
    }



    a20 << "La suma de la matriz triangular superior derecha es : " << suma << endl;
}

void triangular_superiorizq() {
    ofstream a21("archivo1.21.txt");
    int suma = 0;
    if (N == N) {
        for (j = 1; j < N; j++) {
            for (i = 1; i < N + 1; i++) {
                if (i + j < N + 1) {
                    suma = suma + Mat[i][j];

                }
            }
        }

        a21 << "La suma de la matriz traingular inferior izq es : " << suma << endl;

    }



}

void triangular_inferiorizq() {
    ofstream a22("archivo1.22.txt");
    int suma = 0;
    if (N == N) {
        for (j = 1; j < N; j++) {
            for (i = 2; i <= N; i++) {
                if (i > j) {
                    suma = suma + Mat[i][j];
                }
            }
        }
    }
    a22 << "La suma de la matriz triangular inferior izq es : " << suma << endl;
}

void triangular_inferiorder() {
    ofstream a23("archivo1.23.txt");
    int suma = 0;
    if (N == N) {
        for (i = 2; i <= N; i++) {
            for (j = 2; j <= N; j++) {
                if (i + j > N + 1) {
                    suma = suma + Mat[i][j];
                }
            }
        }
    }

    a23 << "La suma de la matriz triangular inferior derecha es : " << suma << endl;
}

main() {
    srand(time(0));
    llenar_matriz();
    muestra_matriz();
    graba_matriz();
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
    Promedio_impares();
    Contador_Nprimo();
    igualdad_diagonales();
    matriz_varianza();
    contar_pares();
    diagonal();
    repetidos();
    filasparescolumnasimpares();
    Numero_perfecto();
    calcular_varianza();
    calcularpromedio();
    sumatoria_bordes();
    triangular_superiorder();
    triangular_superiorizq();
    triangular_inferiorizq();
    triangular_inferiorder();

}