#include <iostream>
#include <stdio.h>
#include <stdlib.h>

#include "MatrizDinamica.h"
using namespace std;

MatrizDinamica::MatrizDinamica(){
	this->cabezalColumna = NULL;
	this->cabezalFila    = NULL;

	cantidadDatos = 0; maxFilas = 0; maxColumnas = 0;
}

int MatrizDinamica::totalDatos()		{ return this->cantidadDatos; }
int MatrizDinamica::cantColumnas()		{ return this->maxColumnas; }
int MatrizDinamica::cantFilas()			{ return this->maxFilas; }


void MatrizDinamica::ingresarDato(int dato, int fila, int columna){
	MatrixNode* datoNuevo = new MatrixNode(dato, fila, columna);
	if (cantidadDatos == 0){
		
		this->cabezalFila    = new MatrixNode(0, fila, 0);
		this->cabezalColumna = new MatrixNode(0, 0, columna);
		
		datoNuevo->nodoDerecha = this->cabezalFila;
		datoNuevo->nodoAbajo = this->cabezalColumna;
		
		this->cabezalFila->nodoDerecha = datoNuevo;
		this->cabezalColumna->nodoAbajo = datoNuevo;
			
		cantidadDatos = 1; maxFilas = fila; maxColumnas = columna;
	} else {
		MatrixNode* FilaDelValor;
		if(fila < this->cabezalFila->numFila){
			FilaDelValor = new MatrixNode(0,fila,0);
			MatrixNode* cursor = this->cabezalFila;



			while(cursor->nodoAbajo != this->cabezalFila){
				cursor = cursor->nodoAbajo;
			}
			FilaDelValor->nodoAbajo = this->cabezalFila;
			this->cabezalFila = FilaDelValor;
			cursor->nodoAbajo = FilaDelValor;
		} else {
			FilaDelValor = BuscarFila(fila);
		}
		
		MatrixNode* columnaDelValor;
		if (columna < this->cabezalColumna->numColumna){
			columnaDelValor = new MatrixNode(0,0,columna);
			MatrixNode* cursor = this->cabezalColumna;
			while(cursor->nodoDerecha != this->cabezalColumna){
				cursor = cursor->nodoDerecha;
			}
			columnaDelValor->nodoDerecha = this->cabezalColumna;
			this->cabezalColumna = columnaDelValor;
			cursor->nodoDerecha = columnaDelValor;
		} else {	
			columnaDelValor = BuscarColumna(columna);
		}
		
		
		
		Agregar(FilaDelValor, columnaDelValor, datoNuevo);
		
		if(maxFilas   < fila)    maxFilas = fila;
		if(maxColumnas < columna) maxColumnas = columna;
	}
	
}

MatrixNode* MatrizDinamica::BuscarFila(int fila){
	MatrixNode* cursor = this->cabezalFila;
	
	do {
		if (fila <= cursor->numFila){
			break;
		}
		if (fila < cursor->nodoAbajo->numFila){
			break;
		}
		cursor = cursor->nodoAbajo;
	} while (cursor->nodoAbajo != this->cabezalFila);
	
	if(fila != cursor->numFila){
		MatrixNode* nuevoCabezal = new MatrixNode(0,fila,0);
		
		nuevoCabezal->nodoAbajo = cursor->nodoAbajo;
		cursor->nodoAbajo = nuevoCabezal;
		
		return nuevoCabezal;
	}
	return cursor;
}

MatrixNode* MatrizDinamica::BuscarColumna(int columna){
	MatrixNode* cursor = this->cabezalColumna;
	
	do {
		if (columna <= cursor->numColumna){
			break;
		}
		if (columna < cursor->nodoDerecha->numColumna){
			break;
		}
		cursor = cursor->nodoDerecha;
	} while (cursor->nodoDerecha != this->cabezalColumna);
	
	if(columna != cursor->numColumna){
		MatrixNode* nuevoCabezal = new MatrixNode(0,0,columna);
		
		nuevoCabezal->nodoDerecha = cursor->nodoDerecha;
		cursor->nodoDerecha = nuevoCabezal;
		
		return nuevoCabezal;
	}
	return cursor;
}


void MatrizDinamica::Agregar(MatrixNode* fila, MatrixNode* columna, MatrixNode* dato){
	while(columna->nodoAbajo->numFila != 0){
		if (dato->numFila < columna->nodoAbajo->numFila){
			break;
		}
		columna = columna->nodoAbajo;
	}
	
	if (dato->numFila != columna->numFila || dato->numColumna != columna->numColumna){
		dato->nodoAbajo = columna->nodoAbajo;
		columna->nodoAbajo = dato;
	} else {
		columna->datoGuardado = dato->datoGuardado;
		delete dato;
		return;
	}
	
	while(fila->nodoDerecha->numColumna != 0){
		if (dato->numColumna < fila->nodoDerecha->numColumna){
			break;
		}
		fila = fila->nodoDerecha;
	}
	dato->nodoDerecha = fila->nodoDerecha;
	fila->nodoDerecha = dato;
	cantidadDatos++;
}


int MatrizDinamica::obtenerDato (int fila, int columna){
	printf("Este metodo aun no esta implementado\n");
	return 0;
}

void MatrizDinamica::imprimirDatos(){
	MatrixNode* cursor = this->cabezalColumna;
	do {
		do {
			cursor = cursor->nodoAbajo;
			cout << "(" << cursor->numFila << "," << cursor->numColumna << "): "
			     << cursor->datoGuardado <<endl;
		} while(cursor->nodoAbajo->numFila!=0);
		cursor = cursor->nodoAbajo;
		cursor = cursor->nodoDerecha;
	} while(cursor != this->cabezalColumna);
	cout << endl;
}


void MatrizDinamica::imprimirMatriz(){
	printf("Este metodo aun no esta implementado\n");
}
		
int** MatrizDinamica::toArray(){
	printf("Este metodo aun no esta implementado\n");
	return NULL;
}
		
MatrizDinamica MatrizDinamica::multiplicarPor(MatrizDinamica factor){
	printf("Este metodo aun no esta implementado\n");
	return MatrizDinamica();
}