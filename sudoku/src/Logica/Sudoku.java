package Logica;

public class Sudoku {

	/*
	 * Variables de Clase
	 * Entero = 9 para los numeros a insertar en el Sudoku
	 * Matriz de enteros para el tablero de Sudoku 
	 * */
	private static final int SIZE = 9;
	private int[][] tablero;
		
	
	/**
	 * Constructor
	 * Se rellena la matriz con 0
	 */
	public Sudoku() {
		//tablero ser� una matriz de 9 x 9
		this.tablero = new int[SIZE][SIZE];
		//La llenamos de 0
		for(int i=0; i < 9; i++){
			for(int j=0; j < 9; j++){
				this.tablero[i][j] = 0;
			}
		}
	}

	/**
	 * M�todo para agregar un valir al Sudoku, inserta valor en las coordenadas fila, columna
	 * @param valor
	 * @param fila
	 * @param columna
	 */
	public void addValor(int valor, int fila, int columna) {
		if (fila >= 0 && fila <= SIZE){
			if (columna >= 0 && columna <= SIZE){
				this.tablero[fila][columna] = valor;
			}
		}
	}
		
	/**
	 * @return String con el tablero de Sudoku
	 */
	public String imprimir(){
		String resp = "";
		String a = " ";
		for(int i=0; i < 9; i++){
			if(i == 3 || i == 6){
				resp += "- - - + - - - + - - - \n";
			}
			for(int j=0; j < 9; j++){
				if(this.tablero[i][j] == 0){
					a = " ";
				}else{
					a = Integer.toString(this.tablero[i][j]);
				}
				if(j == 3 || j == 6){
					resp += "| " + a + " ";
				}else{
					resp += a + " ";
				}				
			}
			resp += "\n";
		}		
		return resp;
	}

	/**
	 * M�todo que retorna un entero desde las coordenadas fila, columna
	 * @param fila
	 * @param columna
	 * @return entero
	 */
	public int getValor(int fila, int columna) {
		int valor = -1;
		if (fila > 0 && fila <= SIZE){
			if (columna > 0 && columna <= SIZE){
				valor = this.tablero[fila][columna];
			}
		}
		return valor;
	}

	/**
	 * M�todo que retorna verdadero si el valor puede ser insertado en las coordenadas fila, columna
	 * @param valor
	 * @param f
	 * @param c
	 * @return boolean
	 */
	private boolean isAceptable(int valor, int fila, int columna) {
		//Booleano para la respuesta, verdadero al inicio (S� podemos ocupar la coordenada con el valor)
		boolean resp = true;
		//Si hay un valor distinto de 0 en la coordenada, dejamos respuesta en falso (No se puede usar la coordenada)
		if (this.tablero[fila][columna] != 0){
			resp =  false;
		}
		//Validamos toda la fila y toda la columna de la coordenada para ver si podemos agregar el valor, si alguna
		//coordenada de ellas es igual al valor, dejamos la respuesta en falso
		for (int i = 0; i < 9; i++) {
			if (this.tablero[fila][i] == valor){
				resp = false;
			}
			if (this.tablero[i][columna] == valor){
				resp = false;
			}
		}
		//Validamos el cuadrante de 3x3 dondo queremos agregar el valor, si alguna coordenada del caudrante
		//es igual a valor, dejamos la respuesta en falso
		int fesq = 3 * ( fila / 3 );
		int cesq = 3 * ( columna / 3 );
		for (int i = fesq; i < fesq+3; i++ ) {
			for ( int j = cesq; j < cesq+3; j++ ) {
				if ( this.tablero[i][j] == valor ) {
					resp = false;
				}
			}
		}
		//Retornamos el valor de respuesta
		return resp;
	}
	
	/**
	 * M�todo p�blico para resolver el sudoku
	 * @return verdadero si el sudoku tiene soluci�n, falso en caso contrario 
	 */
	public boolean solve() {	
		return this.solve(0, 0);
	}
	
	
	/**
	 * M�todo privado recursivo que utiliza backtracking para resolver el sudoku 
	 * @param i
	 * @param j
	 * @return verdadero si pudo resolverlo, falso en caso contrario
	 */
	private boolean solve(int i, int j){
		//Buscamos la siguiente posici�n con un 0, Generaci�n de Candidatos paso 1
		while (true) {
			//Si llegamos al final de las columnas, cambiamos la fila y volvemos a la columna 0
			if (j > 8) { j = 0; i++; }						
			//Si llegamos al final de las filas, retornamos verdadero (No quedan casillas pendientes de llenar
			if (i > 8) { return true; /* final */}			
			//Si la posici�n es distinta de 0, avanzamos a la siguiente columna, en caso contrario terminamos la b�squeda
			if (this.tablero[i][j] != 0){j++;}else{break;}  
		}
		//Generamos los posibles candidatos de valor a probar, Generaci�n de Candidatos paso 2
		for (int valor = 1; valor <= 9; valor++) {
			//System.out.println("[" + i + "," + j + "] = " + valor); //S�lo para mostrar la prueba de candidatos para cada celda a llenar
			//Verificamos si el candidato es aceptable
			if (isAceptable(valor, i, j)) {
				//Si es aceptable, registramos el valor en la coordenada correspondiente
				this.tablero[i][j] = valor;
				//Intentamos resolver recursivamente la siguiente posici�n disponible
				if (!this.solve(i, j + 1)) {
					//Si no tenemos �xito, desregistrmos el valor en la coordenada
					this.tablero[i][j] = 0;
				} else {
					//Si hay �xito, retornamos verdadero
					return true;
				}
			}
		}
		//Si no hay soluci�n, retornamos falso
		return false;
	}
}
