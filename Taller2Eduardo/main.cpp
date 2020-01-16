#include <iostream>
#include "Matriz.h"
#include "NodoM.h"
#include <fstream>
#include <string>
using namespace std;

/*Creamos el método para su definición posterior*/
void ingresarFoto(Matriz *m1,Matriz *m2);

/*
@brief: compara dos fotos par ver si son iguales
@param: matriz FOTO1: primera matriz a comparar
@param: matriz FOTO2: segunda matriz a comparar
*/
void compara(Matriz *FOTO1,Matriz *FOTO2) {
	cout << "Comparando las dos fotos..." << endl;
	//si su máximo de columnas y filas y su color de fondo coinciden, comparamos nodo por nodo
	if(FOTO1->cantColumnas == FOTO2->cantColumnas && FOTO1->cantFilas == FOTO2->cantFilas && FOTO1->colorFondo == FOTO2->colorFondo) {
		NodoM *cursorColFOTO1 = FOTO1->principal->nextColIz;
		NodoM *cursorColFOTO2 = FOTO2->principal->nextColIz;
		//nos posicionamos en el último header de columna
		while(cursorColFOTO1->nextColIz != FOTO1->principal->nextColIz) {
			NodoM *cursorFilaColFOTO1 = cursorColFOTO1->nextFilaUp;
			NodoM *cursorFilaColFOTO2 = cursorColFOTO2->nextFilaUp;
			//recorremos las filas
			while(cursorFilaColFOTO1->nextFilaUp != cursorColFOTO1->nextFilaUp) {
				//si los nodos son distintos las fotos no son iguales y termina el método
				if(cursorFilaColFOTO1->color != cursorFilaColFOTO2->color || cursorFilaColFOTO1->numColumna != cursorFilaColFOTO2->numColumna || cursorFilaColFOTO1->numFila != cursorFilaColFOTO2->numFila){
					cout << "Las fotos No son iguales" << endl;
					return;
				}
				//iteramos filas
				cursorFilaColFOTO1 = cursorFilaColFOTO1->nextFilaUp;
				cursorFilaColFOTO2 = cursorFilaColFOTO2->nextFilaUp;		
			}
			//iteramos columnas
			cursorColFOTO1 = cursorColFOTO1->nextColIz;
			cursorColFOTO2 = cursorColFOTO2->nextColIz;
		}
	//si los tamaños o color de fondo no coinciden, no son iguales y termina el metodo
	} else {
		cout << "Las fotos no son iguales" <<endl;
		return;
	}
	//si llega al final las fotos son iguales
	cout << "Las fotos son iguales" <<endl;
}


/*
@brief:elimina un pixel de una foto a elegir
@param: matriz FOTO1: primera foto de la que se puede eliminar un pixel
@param: matriz FOTO2: segunda matriz de la que se puede eliminar un pixel
*/
void eliminarColorPixel(Matriz *FOTO1 , Matriz *FOTO2){
	int fila,col,opcion;
	cout << "Elija foto a eliminar el color del pixel: " << endl;
	cout << "[1] Foto 1    [2] Foto 2" << endl;
	cin >> opcion;
	//eliminamos en la primera matriz
	if(opcion==1) {
		cout << "Ingrese fila del pixel a eliminar: " <<endl;
		cin >> fila;
		cout <<"Ingrese columna del pixel a eliminar: " <<endl;
		cin >> col;
		//invocamos el método eliminar de la matriz
		FOTO1->eliminarColorPix(fila,col);
		cout << "Pixel (" <<fila<<","<<col<< ") eliminado" << endl;
	//eliminamos en la seguna
	} else {
		if(opcion==2) {
			cout << "Ingrese fila del pixel a eliminar: " <<endl;
			cin >> fila;
			cout <<"Ingrese columna del pixel a eliminar: " <<endl;
			cin >> col;
			//invocamos el método eliminar de la matriz
			FOTO2->eliminarColorPix(fila,col);
			cout << "Pixel (" <<fila<<","<<col<< ") eliminado" << endl;
		}
	}
}


/*
@brief:cambia un pixel de una foto a elegir
@param: matriz FOTO1: primera foto de la que se puede cambiar un pixel
@param: matriz FOTO2: segunda matriz de la que se puede cambiar un pixel
*/
void cambiaColorPixel(Matriz *FOTO1, Matriz *FOTO2) {
	int fila,col,color,opcion;
	//se presentan las dos opciones y se invoca al método respectivo de la clase matriz
	cout << "Elija foto a cambiar el color del pixel: " << endl;
	cout << "[1] Foto 1    [2] Foto 2" << endl;
	cin >> opcion;
	if(opcion==1) {
		cout << "Ingrese fila del pixel a cambiar: " <<endl;
		cin >> fila;
		cout <<"Ingrese columna del pixel a cambiar: " <<endl;
		cin >> col;
		cout << "Ingrese nuevo color del pixel: " <<endl;
		cin >> color;
		FOTO1->cambiarColorPix(fila,col,color);
		cout << "Pixel (" <<fila<<","<<col<< ") cambiado a color " << color <<endl;
	} else {
	if(opcion==2) {
		cout << "Ingrese fila del pixel a cambiar: " <<endl;
		cin >> fila;
		cout <<"Ingrese columna del pixel a cambiar: " <<endl;
		cin >> col;
		cout << "Ingrese nuevo color del pixel: " <<endl;
		cin >> color;
		FOTO2->cambiarColorPix(fila,col,color);
		cout << "Pixel (" <<fila<<","<<col<< ") cambiado a color " << color <<endl;
		}
	}
}

/*
@brief:cambia una región de pixeles de una foto a elegir
@param: matriz FOTO1: primera foto de la que se puede cambiar una región
@param: matriz FOTO2: segunda matriz de la que se puede cambiar una región
*/
void cambiarColorDeUnaRegion(Matriz *FOTO1, Matriz *FOTO2) {
	int fila1,fila2,col1,col2,color,opcion;
	//se piden los datos correspondientes de fila y columna para invocar el método de la matriz
	cout << "Elija foto a cambiar el color de una region: " << endl;
	cout << "[1] Foto 1    [2] Foto 2" << endl;
	cin >> opcion;
	if(opcion==1) {
		cout << "Ingrese fila 1 del pixel a cambiar: " <<endl;
		cin >> fila1;
		cout << "Ingrese columna 1 del pixel a cambiar: " <<endl;
		cin >> col1;
		cout << "Ingrese fila 2 del pixel a cambiar: 2" << endl;
		cin >> fila2;
		cout << "Ingrese columna 2 del pixel a cambiar: 2" << endl;
		cin >> col2;
		cout << "Ingrese nuevo color de la region: " <<endl;
		cin >> color;
		FOTO1->cambiarColorRegion(fila1,col1,fila2,col2,color);
		cout << "Region cambiada a color" <<color << endl;
	} else {
		if(opcion==2){
			cout << "Ingrese fila 1 del pixel a cambiar: " <<endl;
			cin >> fila1;
			cout << "Ingrese columna 1 del pixel a cambiar: " <<endl;
			cin >> col1;
			cout << "Ingrese fila 2 del pixel a cambiar: 2" << endl;
			cin >> fila2;
			cout << "Ingrese columna 2 del pixel a cambiar: 2" << endl;
			cin >> col2;
			cout << "Ingrese nuevo color de la region: " <<endl;
			cin >> color;
			FOTO2->cambiarColorRegion(fila1,col1,fila2,col2,color);
			cout << "Region cambiada a color" <<color <<endl;
		}
	}
	
	
}

/*
@brief:elimina una región de pixeles de una foto a elegir
@param: matriz FOTO1: primera foto de la que se puede eliminar una región
@param: matriz FOTO2: segunda matriz de la que se puede eliminar una región
*/
void eliminarColorDeUnaRegion(Matriz *FOTO1, Matriz *FOTO2) {
	int fila1,fila2,col1,col2,opcion;
	//se piden los datos correspondientes de fila y columna para invocar el método de la matriz
	cout << "Elija foto a eliminar una region: " << endl;
	cout << "[1] Foto 1    [2] Foto 2" << endl;
	cin >> opcion;
	if(opcion==1) {
		cout << "Ingrese fila 1 del pixel a eliminar: " <<endl;
		cin >> fila1;
		cout << "Ingrese columna 1 del pixel a eliminar: " <<endl;
		cin >> col1;
		cout << "Ingrese fila 2 del pixel a eliminar: " << endl;
		cin >> fila2;
		cout << "Ingrese columna 2 del pixel a eliminar: " << endl;
		cin >> col2;
		FOTO1->eliminaColorRegion(fila1,col1,fila2,col2);
		cout << "Region eliminada "<< endl;
		
	} else {
		if(opcion==2){
			cout << "Ingrese fila 1 del pixel a cambiar: " <<endl;
			cin >> fila1;
			cout << "Ingrese columna 1 del pixel a cambiar: " <<endl;
			cin >> col1;
			cout << "Ingrese fila 2 del pixel a cambiar: 2" << endl;
			cin >> fila2;
			cout << "Ingrese columna 2 del pixel a cambiar: 2" << endl;
			cin >> col2;
			FOTO2->eliminaColorRegion(fila1,col1,fila2,col2);
			cout << "Region eliminada"<<endl;
			
		}
	}
}


/*
@brief: superpone dos matrices, FOTO1 sobre FOTO2
@param: matriz FOTO1: matriz que será superpuesta sobre foto2
@param: matriz FOTO2: matriz base
*/
void superponer(Matriz *FOTO1, Matriz *FOTO2) {
	//nos posicionamos en el último header columna
	NodoM *cursorColFOTO1 = FOTO1->principal->nextColIz;
	//recorremos las columnas
	while(cursorColFOTO1->nextColIz != FOTO1->principal->nextColIz) {
		//siguiente fila del header
		NodoM *cursorFilaColFOTO1 = cursorColFOTO1->nextFilaUp;
		NodoM *navegadorFilaCol  = cursorFilaColFOTO1;
		//recorremos una columna
		while(cursorFilaColFOTO1->nextFilaUp != cursorColFOTO1->nextFilaUp) {
			// aqui busco la posicion del navegador pero en la foto 2 , si es null significa que no hay nada en la foto 2, al contrario no se hace nada.
			NodoM *existePosEnFoto2 = FOTO2->buscarNodoPorPosicion(navegadorFilaCol->numFila,navegadorFilaCol->numColumna);
			//si en la foto2 no existe una posición que sí está en la foto1, se crea
			if(existePosEnFoto2==NULL) {
				FOTO2->ingresarDato(navegadorFilaCol->color,navegadorFilaCol->numFila,navegadorFilaCol->numColumna);
			} 
			//itera filas
			cursorFilaColFOTO1 = cursorFilaColFOTO1->nextFilaUp;
		}
		//itera columnas
		cursorColFOTO1 = cursorColFOTO1->nextColIz;
	}
	cout << "El resultado de superponer la foto 1 en la foto 2 es: " << endl;
	
	//imprime la matriz
	FOTO2->imprimirMatriz(); 
}
/*
@brief: agrega sombra un espacio a la derecha para una matriz a elegir
@param: matriz FOTO1: primera foto a la que se le puede agregar sombra
@param: matriz FOTO2: segunda foto a la que se le puede agregar sombra
*/
void agregarSombraDerecha(Matriz *FOTO1, Matriz *FOTO2) {
	int opcion;
	cout << "Elija foto para agregar sombra: " << endl;
	cout << "[1] Foto 1    [2] Foto 2" << endl;
	cin >> opcion;
	if(opcion==1) {
		FOTO1->sombraDerecha();
		cout << "Se agrego sombra en la foto 1" << endl;
	} else {
		if(opcion==2) {
			FOTO2->sombraDerecha();
			cout << "Se agrego sombra en la foto 2" << endl;
		}
	}
}

/*
@brief: imprime una matriz a elegir
@param: matriz FOTO1: primera foto que se puede imprimir
@param: matriz FOTO2: segunda foto que se puede imprimir
*/
void imprimir(Matriz *FOTO1, Matriz *FOTO2) {

	int opcion;
	cout << "Elija foto para imprimir: " << endl;
	cout << "[1] Foto 1    [2] Foto 2" << endl;
	cin >> opcion;
	if(opcion==1) {
		FOTO1->imprimirMatriz();
	} else {
		if(opcion==2) {
			FOTO2->imprimirMatriz();
		}
	}
}

/*
@brief: despliega el menú de opciones para las posibles operciones sobre las matrices a elegir
@param: matriz FOTO1: primera foto que puede acceder a los métodos del menú
@param: matriz FOTO2: segunda foto que puede acceder a los métodos del menú
*/
void menuApp(Matriz *FOTO1, Matriz *FOTO2) {
	
	int opcion=0;
	while (opcion != 11) {
		cout << "\t[MENU]" << endl;
		cout << "[1] Ingresar Foto" << endl;
		cout << "[2] Imprimir Foto" << endl;
		cout << "[3] Cambiar color a un pixel" << endl;
		cout << "[4] Eliminar color de un pixel" <<endl;
		cout << "[5] Cambiar color de una region " << endl; 
		cout << "[6] Eliminar color de una region" << endl;
		cout << "[7] Mover foto hacia la izquierda" <<endl;
		cout << "[8] Agregar sombra a la foto" << endl;
		cout << "[9] Comparar si dos fotos son iguales " <<endl;
		cout << "[10] Superponer dos fotos" <<endl;
		cout << "[11] Salir" <<endl;
		cin >> opcion;
		switch(opcion) {
			case 1:
				ingresarFoto(FOTO1,FOTO2);
				cout << "-----------------------" << endl;
				break;
			case 2:
				imprimir(FOTO1,FOTO2);
				cout << "-----------------------" << endl;
				break;
			case 3:
				cambiaColorPixel(FOTO1,FOTO2);
				cout << "-----------------------" << endl;
				break;
			case 4:
				eliminarColorPixel(FOTO1,FOTO2);
				cout << "-----------------------" << endl;
				break;
			case 5:
				cambiarColorDeUnaRegion(FOTO1,FOTO2);
				cout << "-----------------------" << endl;
				break;
			case 6:
				eliminarColorDeUnaRegion(FOTO1,FOTO2);
				cout << "-----------------------" << endl;
				break;
			case 7:
				// not supported yet
				break;
			case 8:
				agregarSombraDerecha(FOTO1,FOTO2);
				cout << "-----------------------" << endl;
				break;
			case 9:
				compara(FOTO1,FOTO2);
				cout << "-----------------------" << endl;
				break;
			case 10:
				superponer(FOTO1,FOTO2);
				cout << "-----------------------" << endl;
				break;
			default:
				opcion =11;
				
		}
	}
}

/*
@brief: lee coordenadas de un archivo txt para transformarlas en una matriz que veremos como foto
@param: matriz FOTO1: primera matriz a leer
@param: matriz FOTO2: segunda matriz a leer
*/
void ingresarFoto(Matriz *FOTO1,Matriz *FOTO2) {
	int color,fila,col,colorFondo;
	//archivo de entrada de la primera foto
	ifstream foto1("foto1.txt");
	foto1 >> colorFondo;
	while(!foto1.eof()) {	
		foto1 >> fila;
		foto1 >> col;
		foto1 >> color;
		if(color != colorFondo) {
			FOTO1->ingresarDato(color,fila,col);
		}	
	}
	FOTO1->colorFondo = colorFondo;
	foto1.close();
	cout << "Datos de foto 1 cargados" << endl;
	
	//archivo de entrada de la segunda foto
	ifstream foto2("foto2.txt");
	foto2 >> colorFondo;
	while(!foto2.eof()) {
		
		foto2 >> fila;
		foto2 >> col;
		foto2 >> color;
		if(color != colorFondo) {
			FOTO2->ingresarDato(color,fila,col);
		}
		
	}
	FOTO2->colorFondo = colorFondo;
	foto2.close();
	cout << "Datos de foto 2 cargados" << endl;
} 

/*
@brief: Hacer los llamados a las distintas funciones y crear los objeto a utilizar
*/
int main(int argc, char** argv) {
	
	Matriz foto1;
	Matriz foto2;
	
	menuApp(&foto1,&foto2);
	
	return 0;
	
}

