/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   NodoM.h
 * Author: Usuario
 *
 * Created on 10 de mayo de 2017, 20:01
 */

#ifndef NODOM_H
#define NODOM_H
class NodoM
{
	public:
	/*Numero del color*/
	int color;
	/*Posición de la columna*/
	int numColumna;
	/*Posicion de la fila*/
	int numFila;

	/*Puntero de la derecha, nextCol*/
	NodoM *nextColIz;

	/*Puntero hacia abajo, nextFila*/
	NodoM *nextFilaUp;

	/*
	@brief:Constructor de nodo con dato incluido
	@param: int dato: color del pixel a crear en las coordenadas [fila][col]
	@param: int fila: fila en la que se creará el pixel
	@param: int col: columna en la que se creará el pixel
	*/
	NodoM(int dato, int fila, int col) {
		color = dato;
		numColumna = col;
		numFila = fila;
		nextColIz = this;
		nextFilaUp= this;
	}

	/*
	@brief:Constructor de headers
	@param: int fila: fila en la que se creará el header
	@param: int col: columna en la que se creará el header
	*/
	NodoM(int fila, int col) {
		numColumna = col;
		numFila = fila;
		color=0;
		nextColIz = this;
		nextFilaUp= this;
	}
	/*
	@brief:Constructor de nodo principal
	*/
	NodoM() {
		nextColIz = this;
		nextFilaUp= this;
		color=0;
		numFila = 0;
		numColumna=0;
		

	}
	
	
};


#endif /* NODOM_H */

