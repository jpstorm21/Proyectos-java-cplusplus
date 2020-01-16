/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applaberinto;
import ucn.*;


/**
 *
 * @author Dario
 */
public class Laberinto {
	private static final char PARED = 'o';
	private static final char LIBRE = ' ';
	private static final char [] VISITADO = {'A','D','B','I','#'};
	private char[][] tablero;	
        private int filas;
	private int columnas;
	private int fin;
	private int cin;
	private int fout;
	private int cout;
        private int [] movFila = { -1, 0, 1, 0 };
        private int [] movColumna = { 0, 1, 0, -1 };


	public Laberinto(int filas, int columnas, int fin, int cin, int fout, int cout) {
		this.tablero = new char[filas][columnas];
		for (int i=0; i<filas; i++)
                    for (int j=0; j<columnas; j++)
                        tablero[i][j]=LIBRE;
                //tablero[fin][cin] = VISITADO[4];
		this.filas = filas;
		this.columnas = columnas;
		this.fin = fin;
		this.cin = cin;
		this.fout = fout;
		this.cout = cout;
        }

        
	public void addPared(int fil, int col) {
		// TODO: Validacion de parametros
		this.tablero[fil][col] = PARED;
	}
        
	public void addLibre(int fil, int col) {
		// TODO: Validacion de parametros
		this.tablero[fil][col] = LIBRE;
	}
        
	public void addVisitado(int fil, int col, int k) {
		// TODO: Validacion de parametros
		this.tablero[fil][col] = VISITADO[k];
	}
	
	public boolean isAceptable(int fil, int col) {
		if (fil < 0 || fil >= this.filas) return false;
		if (col < 0 || col >= this.columnas) return false;
		if (this.tablero[fil][col] == PARED) return false;
                for (int k=0; k<5; k++)
		  if (this.tablero[fil][col] == VISITADO[k]) 
                      return false;
                return true;
                
	}
        
	public int solve() {
		return this.solve(this.fin, this.cin);
	}
	
	private int solve(int f, int c) {
                System.out.println("------------------------------------------------");
                System.out.println("f:"+f + "  c:"+c+" begin \n"+this);
             //   StdIn.readString();
		if (f == this.fout && c == this.cout) {System.out.println("SOLVE!"); return 1; }
		for (int k = 0; k < 4; k++) {
			int ff = f + this.movFila[k];
			int fc = c + this.movColumna[k];
			if (this.isAceptable(ff, fc)) {
                            System.out.println("ff:"+ff+" fc:"+fc+" aceptable");
				this.tablero[ff][fc] = VISITADO[k];
                                int res = this.solve(ff, fc);
				if (res==0) {
                                        System.out.println("ff:"+ff+" fc:"+fc+" NO solve, liberando");
					this.tablero[ff][fc] = LIBRE;
				} else if (res==-1) {
                                        System.out.println("ff:"+ff+" fc:"+fc+" NO solve, inviable esta rama");
					this.tablero[ff][fc] = VISITADO[4];                                    
                                } else {
                                  System.out.println("SOLVE RET"); return 1; 
                                }
			} else
                            System.out.println("ff:"+ff+" fc:"+fc+" INaceptable");
		}
                System.out.println("se acabaron candidatos");                
                return -1;
	}	
        
        
        public String toString() {
            String str="";
            
            for (int i=0;i<filas;i++) {
                for (int j=0;j<columnas;j++){
                    str += tablero[i][j];
                }
                str += "\n";
            }
            return str;
            
        }
}	

