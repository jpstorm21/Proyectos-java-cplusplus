
public class Sudoku {
  boolean usadosCuadrado[][];
  boolean usadosLinea[][];
  boolean usadosColumna[][];

  // Tablero , lo podrian haber creado random
  int tablero[][] = { 
	{0,6,0, 1,0,4, 0,5,0},
	{0,0,8, 3,0,5, 6,0,0},
	{2,0,0, 0,0,0, 0,0,1},

	{8,0,0, 4,0,7, 0,0,6},
	{0,0,6, 0,0,0, 3,0,0},
	{7,0,0, 9,0,1, 0,0,4},

	{5,0,0, 0,0,0, 0,0,2},
	{0,0,7, 2,0,6, 9,0,0},
	{0,4,0, 5,0,8, 0,7,0}};
  
  // Constructor:
  Sudoku() {
	
	// Inicializa posibles:
        // Esto fue lo que hablamos en la ayudantia, lo de ver las lineas y el mini cuadrado
	usadosCuadrado = new boolean[9][9];
	usadosLinea    = new boolean[9][9];
	usadosColumna  = new boolean[9][9];
	
	// Inicializa los arrays usadosCuadrado, usadosLinea y usadosColumna.
	for (int l=0 ; l<9 ; l++) 
	  for (int c=0 ; c<9 ; c++)
		if (tablero[l][c] != 0)
		  marca(tablero[l][c],l,c,true);
  }
  
  
  // Devuelve un array de 9 booleanos con los valores posibles de la posicion dada
  boolean[] posibles(int linea, int columna) {
	boolean[] resultado = new boolean[9];
	for (int i=0 ; i<9 ; i++) {
	  resultado[i] = !usadosCuadrado[linea/3*3+columna/3][i] && !usadosLinea[linea][i] && !usadosColumna[columna][i];
	}
	return resultado;
  }


  // Marca a "usado" el valor "numero", situado en (linea,columna), en la tabla de posibles.
  void marca(int numero, int linea, int columna, boolean usado) {
	usadosCuadrado[linea/3*3+columna/3][numero-1] = usado; // esto me salio de suerte xdxd
	usadosLinea[linea][numero-1] = usado;
	usadosColumna[columna][numero-1] = usado;
	tablero[linea][columna] = usado ? numero : 0;
  }

 
  // Busca la solucion.
  // Devuelve true si la encuentra.
  // pos es la posicion que indica el avance del backtracking.
  boolean intenta(int pos) {
	// recuerden el pseudocodigo de backtracking
	if (pos == 81) return true;
        // condicion de termino, significa que llego al ultimo casillero
 	int linea = pos / 9;
	int columna = pos % 9;
        // candidatos
	if (tablero[linea][columna] != 0) { //¿es aceptable?
	  return intenta(pos+1);
	} else {
	  boolean[] candidatos = posibles(linea,columna); // posibles soluciones
	  for (int i=0 ; i<9 ; i++) {
		if (candidatos[i]) {
		  marca(i+1,linea,columna,true);
		  if (intenta(pos+1))
			return true;
		  marca(i+1,linea,columna,false);
		}
	  }
	  return false;
	}
  }


  // imprime el tablero
  void imprime() {
	for (int l=0 ; l<tablero.length ; l++) {
	  for (int c=0 ; c<tablero[0].length ; c++)
		System.out.print(tablero[l][c]+" ");
	  System.out.println();
	}
  }

  public static void main(String[] args) {

	Sudoku s = new Sudoku();
  
	System.out.println("Tablero inicial:");
	s.imprime();

	if (s.intenta(0)) {
	  System.out.println("Solucion:");
	  s.imprime();
	} else {
	  System.out.println("Sin solucion");
	}
  }
  
}