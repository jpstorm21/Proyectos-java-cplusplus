/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Matriz.h
 * Author: Usuario
 *
 * Created on 10 de mayo de 2017, 20:01
 */

#ifndef MATRIZ_H
#define MATRIZ_H
#include "NodoM.h"

class Matriz
{
	public:
	/*Header ubicado en 0,0*/	
	NodoM *principal;
	/*Ultimo header de columna*/
	NodoM *headerC;
	/*Ultimo header de fila*/
	NodoM *headerF;
	/*cantidad de datos distinto del color de fondo que tiene la matriz*/
	int cantPixeles;
	/*máxima cantidad de columnas*/
	int cantColumnas;
	/*maxima cantidad de filas*/
	int cantFilas;
	/*color de fondo*/
	int colorFondo;
	/*
	@brief: Constructor de la clase matriz
	*/
	Matriz();
	
	/*
	@brief: ingresa un dato en la posición fila, col
	@param: int dato: dato o color a ingresar en la posición
	@param: int fila: fila donde se agregará el dato en la matriz
	@param: int col: columna donde de agregará el dato en la matriz
	*/
	void ingresarDato(int dato, int fila, int col );

	/*
	@brief: cambia el color de un pixel en las coordenadas especificadas
	@param: int color: dato o color a ingresar en la posición
	@param: int fila: fila donde se agregará el dato en la matriz
	@param: int columna: columna donde de agregará el dato en la matriz
	*/
	void cambiarColorPix(int fila, int columna,int color);
	
	/*
	@brief: elimina un dato en la posición fila, col
	@param: int fila: fila donde se eliminará el dato en la matriz
	@param: int col: columna donde se eliminará el dato en la matriz
	*/
	
	void eliminarColorPix(int fila , int col );
	
	/*
	@brief: cambia el color de una región comprendida entre fila1-fila2 y col1*col2
	@param: int fila1: fila desde donde parte la modificación de color en la matriz
	@param: int col1: columna desde donde parte la modificación de color en la matriz
	@param:int fila2: fila donde finaliza el cambio de color de la matriz
	@param: int col2: columna donde finaliza el cambio de color de la matriz
	@param: int color: color que al que será modificado la región antes señalada
	*/
	void cambiarColorRegion(int fila1, int col1, int fila2, int col2,int color);
	
	/*
	@brief: elimina el color de una región comprendida entre fila1-fila2 y col1*col2
	@param: int fila1: fila desde donde parte la eliminación de color en la matriz
	@param: int col1: columna desde donde parte la eliminación de color en la matriz
	@param:int fila2: fila donde finaliza la eliminación de color de la matriz
	@param: int col2: columna donde finaliza la eliminación de color de la matriz
	*/
	void eliminaColorRegion(int fila1, int col1, int fila2, int col2);
	
	/*
	@brief: mueve a la izquierda la matriz la cantidad especificada
	@param: int cantidad: cantidad de veces posiciones que la matriz se mueve a la izquierda
	*/
	void mueveIzquierda(int cantidad);
	
	/*
	@brief: busca un nodo en la posición [fila][col], retorna el nodo si lo encuentra y null en caso contrario
	@param: int fila: fila en la que está el nodo buscado
	@param: int col: columna en la que está el nodo buscado
	*/
	NodoM *buscarNodoPorPosicion(int fila, int col);
	
	/*
	@brief: imprime la matriz completa
	*/
	void imprimirMatriz();
	
	/*
	@brief: agrega sombra a la derecha de cada uno de los nodos
	*/
	void sombraDerecha();
	
	

};

#endif /* MATRIZ_H */

