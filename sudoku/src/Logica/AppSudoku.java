package Logica;

import ucn.StdOut;

public class AppSudoku {

public static void main(String[] args) {
		
		//Creamos un nuevo objeto que simula el tablero del Sudoku
		Sudoku sudo = new Sudoku();
		
		//Agregamos valores para realizar la prueba
		sudo.addValor(4, 0, 0);
		sudo.addValor(5, 1, 0);
		sudo.addValor(6, 2, 0);
		sudo.addValor(7, 0, 2);
		sudo.addValor(9, 0, 1);

		sudo.addValor(3, 1, 4);
		sudo.addValor(4, 2, 5);
		sudo.addValor(5, 0, 4);
		
		sudo.addValor(1, 2, 8);
		sudo.addValor(6, 0, 7);
		
		sudo.addValor(1, 3, 2);
		sudo.addValor(3, 3, 1);
		
		sudo.addValor(1, 5, 5);
		sudo.addValor(5, 3, 3);
		
		sudo.addValor(2, 5, 6);
		sudo.addValor(5, 5, 7);
		
		sudo.addValor(3, 6, 0);
		sudo.addValor(8, 8, 1);
		
		sudo.addValor(1, 7, 4);
		sudo.addValor(2, 6, 3);
		sudo.addValor(4, 8, 4);
		
		sudo.addValor(2, 8, 7);
		sudo.addValor(3, 8, 6);
		sudo.addValor(5, 8, 8);
		sudo.addValor(7, 7, 8);
		sudo.addValor(9, 6, 8);
		
		//Imprimimos el tablero sin resolver
		StdOut.println(sudo.imprimir());
		
		//Intentamos resolver el Sudoku
		if(sudo.solve()){
			//Si hay �xito, imprimimos la soluci�n
			StdOut.println("*********************");
			StdOut.println("SOLUCION: ");
			StdOut.println(sudo.imprimir());
		}else{
			//En caso contrario imprimimos el mensaje de Sin Soluci�n!
			StdOut.println("Sin Solucion!!!");
		}
		
		
	}
}
