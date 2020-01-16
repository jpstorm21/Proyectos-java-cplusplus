#include <iostream>
#include "MatrizDinamica.cpp"
using namespace std;

int main(){
	
	MatrizDinamica mx;
	
	mx.ingresarDato(10,  3,  6);
	mx.ingresarDato(20,  2,  2);
	mx.ingresarDato( 7, 10,  9);
	mx.ingresarDato(81,  5, 13);
	
	mx.imprimirDatos();
	
	int** matrizNueva = mx.toArray();

}