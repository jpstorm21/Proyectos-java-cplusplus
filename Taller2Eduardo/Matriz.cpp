#include "Matriz.h"
#include <iostream>
#include <string>
#include <fstream> // biblioteca que sirve para trabajar con archivos tanto de escritura y lectura
using namespace std;


Matriz::Matriz(){
	/*Inicializa los atributos en 0*/
	cantColumnas=0;
	cantFilas=0;
	cantPixeles=0;
	colorFondo=0;
	/*Nodo Principial ubicado en 0,0*/
	principal= new NodoM();
	
	/*los header de fila y columna no existen aún*/
	headerC= NULL;
	headerF= NULL;
	
}

/*Se crea el método para que el compilador no arroje error, se define posteriormente*/
NodoM *buscarNodoPorPosicion(int fila,int col);

/*Se crea el método para que el compilador no arroje error, se define posteriormente*/
void ingresarDato(int dato,int fila, int col);

/*Se crea el método para que el compilador no arroje error, se define posteriormente*/
void eliminarColorPix(int fila, int col);


void Matriz::imprimirMatriz() {
	string nombre;
	cout<<"Ingrese nombre del archivo a crear, no olvide finalizar con .txt"<<endl;
	cin>>nombre;
	std::ofstream ofFile;
	ofFile.open(nombre.c_str(), ios::out);
	/*Posiciones iniciales de fila y columna i=fila, j=col*/
	int i=1,j=1;
	while(i<=cantFilas) { //hasta que no llegue al máximo de filas
		j=1;//resetea el valor de las columnas
		while(j<=cantColumnas) {//hasta que llegue al maximo de columnas
			NodoM *nodoPorPos = buscarNodoPorPosicion(i,j); //busca el nodo en la posición i,j
			
			if(nodoPorPos == NULL) {//si el nodo no existe imprime el color de fondo
				ofFile << colorFondo << "   ";
			} else {
				ofFile << nodoPorPos->color << "   " ;	//si el nodo si existe imprime el color del nodo
			}
			j++;
		}
		i++;
		ofFile << "\n";
	}
}
void Matriz::ingresarDato(int dato, int fila, int col){
	/*Creamos nodo con el dato*/
	NodoM *nuevoPixel = new NodoM(dato, fila, col);
	
	/*cuando no hay datos en la matriz*/
	if(cantPixeles == 0){
		/*Creamos los header de la posicion*/
		headerC = new NodoM(0, col);
		headerF = new NodoM(fila,0);
		
		/*Enlazamos el principal con los header*/
		principal->nextColIz=headerC;
		principal->nextFilaUp= headerF;
		
		/*Enlazamos los header con el principal*/
		headerC->nextColIz=principal;
		headerF->nextFilaUp= principal;
		
		/*enlazamos el pixel con los header*/
		nuevoPixel->nextColIz = headerF;
		nuevoPixel->nextFilaUp = headerC;
		
		/*enlazamos los header con el pixel*/
		headerC->nextFilaUp= nuevoPixel;
		headerF->nextColIz= nuevoPixel;
		
		/*Se setean los máximos*/
		cantFilas = fila; 
		cantColumnas= col;
		
	/*cuando hay datos en la matriz*/	
	} else {
		/* cuando se quiere agregar un nodo entre el existente y el principal */
		if( col <= headerC->numColumna) {
			// primero se ve el caso de que se agrega en el header columna existente
			if(col == headerC->numColumna ) {
				// como estamos agregando un nodo donde ya hay un header, trabajamos con un cursor que se pone atras
				NodoM *cursorFilaCol = headerC->nextFilaUp;
				while (cursorFilaCol->nextFilaUp->numFila >= fila ) {
					cursorFilaCol = cursorFilaCol->nextFilaUp;
				}
				if(cursorFilaCol->nextFilaUp->numFila < fila) {
					nuevoPixel->nextFilaUp = headerC->nextFilaUp;
					headerC->nextFilaUp = nuevoPixel;
				} else {
					nuevoPixel->nextFilaUp = cursorFilaCol->nextFilaUp;
					cursorFilaCol->nextFilaUp= nuevoPixel;
				}
			
			/*cuando no está en la última columna*/	
			} else {
				/*Recorremos hasta posicionarnos en la columna anterior o en la misma*/
				NodoM* cursorCol = headerC;
				while(cursorCol->nextColIz->numColumna >= col) {
					cursorCol = cursorCol->nextColIz;
				}
				//si el header de columna existe en esa posición
				if(cursorCol->numColumna == col) {
					// cumple la misma funcion que el anterior solo que este revisa cada header columna
					NodoM *cursorFilaCol2 = cursorCol->nextFilaUp;
					while(cursorFilaCol2->nextFilaUp->numFila >= fila) {
						cursorFilaCol2 = cursorFilaCol2->nextFilaUp; 
					}
					//si queremos ingresar el nodo en una fila mayor a la última fila de esa columna
					if(cursorCol->nextFilaUp->numFila< fila){
     					nuevoPixel->nextFilaUp=cursorCol->nextFilaUp;
     					cursorCol->nextFilaUp=nuevoPixel;
     				//si queremos ingresarlo en una fila menor oigual a la última fila de la columna	
    				}else{
    					 nuevoPixel->nextFilaUp = cursorFilaCol2->nextFilaUp;
   						cursorFilaCol2->nextFilaUp = nuevoPixel;
   					 }
   					 
   				//si no existe header en esa columna	 
				} else {
					//creamos el header de la columna y hacemos sus enlaces
					NodoM* headerColumna = new NodoM(0,col);
					headerColumna->nextColIz = cursorCol->nextColIz;
					cursorCol->nextColIz = headerColumna;
					nuevoPixel->nextFilaUp = headerColumna;
					headerColumna->nextFilaUp = nuevoPixel;
				}
				
			}
		//si el numero de columna es mayor a la última columna registrada	
		} else {
			//creamos el header de columna y lo enlazamos, actualizamos el máximo de columnas
			NodoM* headerColumna2 = new NodoM(0,col);
			principal->nextColIz = headerColumna2;
			headerColumna2->nextColIz = headerC;
			headerC = headerColumna2;
			nuevoPixel->nextFilaUp = headerC;
			headerC->nextFilaUp = nuevoPixel;
			cantColumnas = col;
		}
		/*
		AHORA TRABAJAMOS CON LAS FILAS PARA ENLAZAR LOS DATOS
		*/
		
		//si la fila es menor igual a la fila máxima
		if(fila <= headerF->numFila) {
			
			//si la fila es igual a la fila máxima
			if(fila==headerF->numFila) {
				//nos posicionamos justo en la columna anterior o en la misma
				NodoM *cursorColFila = headerF->nextColIz;
				while(cursorColFila->nextColIz->numColumna >= col) {
					cursorColFila = cursorColFila->nextColIz;
				}
				if(cursorColFila->nextColIz->numColumna < col) {
					nuevoPixel->nextColIz = headerF->nextColIz;
					headerF->nextColIz = nuevoPixel;
				} else {
					nuevoPixel->nextColIz =cursorColFila->nextColIz;
					cursorColFila->nextColIz = nuevoPixel;
				}
				
				
			//si nos es la última fila de la matriz	
			} else {
				//nos posicionamos en la fila anterior o en la misma
				NodoM *cursorFila = headerF;
				while(cursorFila->nextFilaUp->numFila >= fila) {
					cursorFila = cursorFila->nextFilaUp;
				}
				//si existe el header de la fila
				if(cursorFila->numFila == fila) {
					//nos posicionamos en la columna anterior o en la misma
					NodoM *cursorColFila2 = cursorFila->nextColIz;
					while(cursorColFila2->nextColIz->numColumna >= col) {
						cursorColFila2 = cursorColFila2->nextColIz;
					}
					
					//si queremos ingresar en una columna mayor a la última columna de esa fila
					if(cursorFila->nextColIz->numColumna<col){
      					nuevoPixel->nextColIz=cursorFila->nextColIz;
    					cursorFila->nextColIz=nuevoPixel;
    				//columna menor	
    		   		}else{
   						nuevoPixel->nextColIz = cursorColFila2->nextColIz;
    					cursorColFila2->nextColIz = nuevoPixel;
 			        }
 			     //si no existe header para esa fila   
				} else {
					NodoM *headerFila = new NodoM(fila,0);
					headerFila->nextFilaUp = cursorFila->nextFilaUp; 
					cursorFila->nextFilaUp = headerFila; 
					headerFila->nextColIz = nuevoPixel;
					nuevoPixel->nextColIz = headerFila;
				}
			}
		//si supera a la última fila	
		} else {
			NodoM *headerFila2 = new NodoM(fila,0);
			principal->nextFilaUp = headerFila2;
			headerFila2->nextFilaUp = headerF;
			headerF = headerFila2;
			nuevoPixel->nextColIz = headerF;
			headerF->nextColIz = nuevoPixel;
			cantFilas = fila;
		}
	}
	//aumentamos la cantidad de datos
	cantPixeles++;
}

void Matriz::eliminarColorPix(int fila, int col) { /* este metodo busca el nodo anterior al eliminar y le hace bypass */
	NodoM *nodoEncontrado = buscarNodoPorPosicion(fila,col);
	if(nodoEncontrado!=NULL) {
	
	/* buscar el header de fila del nodo encontrado */
	NodoM *headerFila = nodoEncontrado;
	
	while(headerFila->numColumna != 0) {
		headerFila = headerFila->nextColIz;
	}
	
	/* buscar el anterior al header de fila */
	NodoM *ColumnaAnteriorHeaderFila = headerFila;
	while(ColumnaAnteriorHeaderFila->nextFilaUp != headerFila) {
		ColumnaAnteriorHeaderFila = ColumnaAnteriorHeaderFila->nextFilaUp;
	}
	
	/* buscar el header de columna del nodo encontrado */
	NodoM *headerColumna = nodoEncontrado;
	while(headerColumna->numFila !=0 ){
		headerColumna = headerColumna->nextFilaUp;
	}
	/* buscar el anterior al header de columna */
	NodoM *FilaAnteriorHeaderColumna = headerColumna;
	while(FilaAnteriorHeaderColumna->nextColIz != headerColumna) {
		FilaAnteriorHeaderColumna = FilaAnteriorHeaderColumna->nextColIz;
	}
	/* buscar el anterior de fila del nodo encontrado */
	NodoM *anteriorNodoEncontradoFila = nodoEncontrado;
	while(anteriorNodoEncontradoFila->nextColIz != nodoEncontrado) {
		anteriorNodoEncontradoFila = anteriorNodoEncontradoFila->nextColIz;
	}
	/* buscar el anterior de columna del nodo encontrado */
	NodoM *anteriorNodoEncontradoCol = nodoEncontrado;
	while(anteriorNodoEncontradoCol->nextFilaUp != nodoEncontrado) {
		anteriorNodoEncontradoCol =  anteriorNodoEncontradoCol->nextFilaUp;
	}
	
	/* ver si la siguiente columna del nodo encontrado es el header, si es asi eliminar enlaces header y nodo */
	if(nodoEncontrado->nextColIz == headerFila && headerFila->nextColIz == nodoEncontrado){
		// significa que solo hay un nodo en esa fila, por ende eliminamos los enlaces del header fila
		ColumnaAnteriorHeaderFila->nextFilaUp = headerFila->nextFilaUp;
		headerFila->nextFilaUp = headerFila;
		headerFila->nextColIz = headerFila;
		nodoEncontrado->nextColIz = nodoEncontrado; // se apunta a el mismo
	} else { // si no , hacemos bypass en fila
		anteriorNodoEncontradoFila->nextColIz = nodoEncontrado->nextColIz;
		nodoEncontrado->nextColIz = nodoEncontrado;
	}
	
	if(nodoEncontrado->nextFilaUp == headerColumna && headerColumna->nextFilaUp == nodoEncontrado ) { // malo
		// significa que solo hay un nodo en esa columna , por ende eliminamos los enlaces del header columna
		FilaAnteriorHeaderColumna->nextColIz = headerColumna->nextColIz;
		headerColumna->nextColIz = headerColumna;
		headerColumna->nextFilaUp = headerColumna;
		nodoEncontrado->nextFilaUp = nodoEncontrado; // se apunta a el mismo	
			 
	} else { // si no, hacemos bypass en columna
		anteriorNodoEncontradoCol->nextFilaUp = nodoEncontrado->nextFilaUp;
		nodoEncontrado->nextFilaUp = nodoEncontrado;
	}
 }
}

NodoM *Matriz::buscarNodoPorPosicion(int fila ,int col) { /* este metodo sirve para buscar el nodo, por posicion */
	//se para en la última columna de la matriz
	NodoM *cursorCol = principal->nextColIz;
	
	//avanza mientras la columna sgte no sea la 0,0 o la principal
	while(cursorCol->nextColIz != principal->nextColIz) {
		//se posiciona en la última fila de la columna
		NodoM *cursorFilaCol = cursorCol->nextFilaUp;
		
		//avanza mientras la fila sgte no sea el cabezal
		while(cursorFilaCol->nextFilaUp != cursorCol->nextFilaUp) {
			
			//si la fila y la columna coinciden con el nodo, lo retorna
			if(cursorFilaCol->numFila == fila && cursorFilaCol->numColumna == col) {
				return cursorFilaCol;
			} 
			//itera filas
			cursorFilaCol = cursorFilaCol->nextFilaUp;
		}
		//itera columnas
		cursorCol = cursorCol->nextColIz;
	}
	//recorrió todo y no lo encontró, retorna null
	return NULL;
}

void Matriz::sombraDerecha(){
	NodoM *cursorCol = principal->nextColIz;
	while(cursorCol->nextColIz != principal->nextColIz) {
		NodoM *cursorFilaCol = cursorCol->nextFilaUp;
		while(cursorFilaCol->nextFilaUp != cursorCol->nextFilaUp) { // aqui nos ponemos en la ultima fila de la ultima columna
			NodoM *buscadorDeDatos = cursorFilaCol;
			NodoM *sombra = buscarNodoPorPosicion(buscadorDeDatos->numFila,buscadorDeDatos->numColumna+1); // vemos si a la derecha del nodo hay algun dato para agregar la sombra
			if(sombra==NULL) {
				ingresarDato(1,buscadorDeDatos->numFila,buscadorDeDatos->numColumna+1); // si no hay, agregamos un dato en columna +1
			}
			cursorFilaCol = cursorFilaCol->nextFilaUp;
		}
		cursorCol = cursorCol->nextColIz;
	}
}

void Matriz::cambiarColorPix(int fila,int col,int color) {
	NodoM *nodoCambio = buscarNodoPorPosicion(fila,col); // buscamos el pixel para cambiar el color
	if(nodoCambio==NULL) {
		ingresarDato(color,fila,col); // si no existe , lo creamos 
	} else {
		nodoCambio->color = color; // si existe , simplemente le cambiamos el color
	}
}

void Matriz::cambiarColorRegion(int fila1,int col1,int fila2 , int col2, int color) {
	// para cambiar el color de la region se recorre el area y en cada iteracion cambia el color
	for(int i=fila1 ; i<= fila2; i++) {
		for(int j=col1 ; j<= col2; j++) {
			cambiarColorPix(i,j,color);
		}
	}
}

void Matriz::eliminaColorRegion(int fila1, int col1, int fila2, int col2) {
	// para eliminar una region , se recorre el area y en cada iteracion se elimina el pixel
	for(int i=fila1; i<= fila2; i++) {
		for(int j=col1; j<= col2 ;j++) {
			eliminarColorPix(i,j);
		}
	}
}


