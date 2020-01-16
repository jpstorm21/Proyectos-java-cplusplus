/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package revisiones;

import java.io.IOException;
import java.util.Scanner;
import ucn.ArchivoEntrada;
import ucn.ArchivoSalida;
import ucn.Out;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Revisiones {
	public static void CargaMaquinas(String[]maquinas,int[][]trenes) {
		for(int x=0;x<20;x++) {
			int suma=0;
			StdOut.println("Carga maquina "+maquinas[x]+": ");
			for(int y=0;y<10;y++) {
				suma+=trenes[x][y];
			}
			StdOut.println(suma);
		}
	}
	public static void CargaMenor(String[]maquinas,int[][]trenes) {
		int cargaMenor=9999;
		String maquinaMenor="";
		for(int x=0;x<20;x++) {
			int suma=0;
			for(int y=0;y<10;y++) {
				suma+=trenes[x][y];
			}
			if(suma<cargaMenor) {
				cargaMenor=suma;
				maquinaMenor=maquinas[x];
			}
		}
		StdOut.println("La maquina con la menor carga es la "+maquinaMenor+", carga: "+cargaMenor);
	}
	public static void CargaExedida(String[]maquinas,int[][]trenes,int[]cargaMaxima) {
		StdOut.println("Maquinas que exceden su carga: ");
		for(int x=0;x<20;x++) {
			int suma=0;
			for(int y=0;y<10;y++) {
				suma+=trenes[x][y];
			}
			if(suma>cargaMaxima[x]) {
				StdOut.println(maquinas[x]);
			}
		}
	}
	public static void Aportes(String[]maquinas,int[][]trenes,double promedio) {
		StdOut.println("Maquinas que llevan mas carga que el promedio: ");
		for(int x=0;x<20;x++) {
			int suma=0;
			for(int y=0;y<10;y++) {
				suma+=trenes[x][y];
			}
			if(suma>promedio) {
				StdOut.println(maquinas[x]);
			}
		}
	}
	public static void ArchivoSalida(String[]maquinas,int[][]trenes,int[]carros,int[]capacidad) {
		Out archivoSalida=new Out("resultados.txt");
		for(int x=0;x<20;x++) {
			String linea="";
			int suma=0;
			for(int y=0;y<10;y++) {
				suma+=trenes[x][y];
			}
			linea=linea+maquinas[x]+","+capacidad[x]+","+capacidad[x]+","+suma;
			archivoSalida.println(linea);
		}
	}
	public static void main(String[]args) throws IOException {
		int contador=0;
		int totalCarga=0;
		String[]maquinas=new String[20];
		int[]carros=new int[20];
		int[]CapacidadMaxima=new int[20];
		int[][]MatrizTrenes=new int[20][10];
		ArchivoEntrada arch=new ArchivoEntrada("datosEntradaTrenes.txt");
		while(!arch.isEndFile()) {
			Registro linea=arch.getRegistro();
			String Codigo=linea.getString();
			int capMax=linea.getInt();
			int cantCarros=linea.getInt();
			for(int x=0;x<cantCarros;x++) {
				int carga=linea.getInt();
				totalCarga+=carga;
				MatrizTrenes[contador][cantCarros]=carga;
			}
			carros[contador]=cantCarros;
			CapacidadMaxima[contador]=capMax;
			maquinas[contador]=Codigo;
			contador++;
		}
		double promedio=totalCarga/20;
		CargaMaquinas(maquinas,MatrizTrenes);
		CargaMenor(maquinas,MatrizTrenes);
		CargaExedida(maquinas,MatrizTrenes,CapacidadMaxima);
		Aportes(maquinas,MatrizTrenes,promedio);
		ArchivoSalida(maquinas,MatrizTrenes,carros,CapacidadMaxima);
	}

}
