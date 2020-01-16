#ifndef MATRIZDINAMICA_H
#define MATRIZDINAMICA_H

#include <cstdio>
#include "MatrixNode.h"

class MatrizDinamica{
	private:
		MatrixNode* cabezalColumna;	// Lista de nodos cabezales de las columnas
		MatrixNode* cabezalFila;	// Lista de nodos cabezales de las filas
		
		int cantidadDatos;	// Cantidad de datos que contiene la matriz
		
		int maxFilas;		// Cantidad maxima de filas que tiene la matriz
		int maxColumnas;	// Cantidad maxima de columnas que tiene la matriz
		
		// Metodos exclusivos de la clase, no son accesibles desde fuera de ella
		MatrixNode* BuscarColumna(int pos);
		MatrixNode* BuscarFila(int pos);
		void Agregar(MatrixNode* fila, MatrixNode* columna, MatrixNode* dato);
	
	
	public:
		MatrizDinamica();	// Contructor por defecto
		
		int totalDatos();		// Retorna la cantidad de datos que contiene la matriz
		int cantColumnas();		// Obtiene la cantidad de columnas que la matriz posee en el momento
		int cantFilas();		// Obtiene la cantidad de filas que la matriz posee en el momento
		
		void ingresarDato(int dato, int fila, int columna);	// Inserta un dato en coordenadas especificas
		int obtenerDato (int fila, int columna);			// Obtiene el dato de una cierta posicion
		
		void imprimirDatos();	// Imprime los datos que contiene la matriz con sus coordenadas en formato lista
		void imprimirMatriz();	// Imprime la matriz completa
		
		
		int** toArray();	// Transforma la matriz a una matriz estática (DESAFIO!!)
		MatrizDinamica multiplicarPor(MatrizDinamica factor);	// DESAFIO!!
};

#endif /* MATRIZDINAMICA_H */