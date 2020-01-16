package taller5_2;

/**
 * Aquí se aplica el backtracking.
 * @author JOSE
 */
public class BackGame {

    //Tipos de de id
    //Nada = 0, Zombie = 1, Survivor = 2, Bomba = 3
    public static enum ID{NADA, ZOMBIE, SURVIVOR, BOMBA};
    
    //Matriz estado actual
    private int[][] matrizActual;
    private int size;
    //Todos los estados por los que ha pasado la matriz
    ListaMatrices listaMatrices;
    
    /**
     * Constructior del backtracking
     * @param size Tamaño de la matriz
     */
    public BackGame(int size){
        if (size <= 0){
            throw new IllegalArgumentException("Tamaño debe ser mayor que 0");
        }
        this.size = size;
        this.matrizActual = new int[size][size]; 
        this.listaMatrices = new ListaMatrices();
    }
    
    /**
     * Genera el estado inicial de la matriz.
     * 30% Zombie
     * 10% Survivor
     * 60% Nada (Celda vacía)
     */
    public void generar(){
        this.matrizActual = new int[this.size][this.size]; 
        double zombieProb = 0.20; //%
        double survivorProb = 0.05; //%
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                double prob = Math.random();
                if (prob <= zombieProb){ //Zombie
                    this.matrizActual[i][j] = ID.ZOMBIE.ordinal();
                }else if (zombieProb < prob && prob <= zombieProb + survivorProb){ //Survivor
                    this.matrizActual[i][j] = ID.SURVIVOR.ordinal();
                }else{
                    this.matrizActual[i][j] = ID.NADA.ordinal();
                }
            }
        }
        //Primer estado a la lista
        listaMatrices.insertarUltimo(copia());
    }
    
    
    /**
     * Resuelve el backtracking
     */
    public void resolver(){
        this.intentar();
    }
    
    /**
     * Reinicia los datos del backGame
     */
    public void reiniciar(){
        this.listaMatrices = new ListaMatrices();
    }
    
    /**
     * Primer TRY del backtracking
     */
    private void intentar(){
        //Inicializa selección de candidatos
        int cantBombas = 4;
        int i = 0; //Bomba
        //Pos inicial bomba candidata actual
        int x = 0;
        int y = 0;
        //Hasta el éxito, o que no hayan más candidatos
        while(!exito() && i < cantBombas && y < this.size){
            //Si es aceptable
            if (aceptable(x, y)){
                //Registra la selección
                matrizActual[x][y] = ID.BOMBA.ordinal();
                listaMatrices.insertarUltimo(copia());
                //Si la solución es incompleta
                if (solucionIncompleta()){
                    //Intenta con el siguiente
                    intentar(i + 1, cantBombas);
                    //Si no hay éxito
                    if (!exito()){
                        //Cancela el registro
                        matrizActual[x][y] = ID.NADA.ordinal();
                        listaMatrices.insertarUltimo(copia());
                    }
                } //fin solución incompleta
            }//fin aceptable
            //Selecciona el siguiente
            x++;
            if (x >= this.size){
                x = 0;
                y++;
            }
            //Después de recorrer todo el tablero, se escoge siguiente bomba
            if (x >= this.size && y >= this.size){
                i++;
            }
        }
    }
    
    /**
     * Segundo TRY del backtracking
     * @param k Candidato
     * @param cantBombas Cantidad de bombas
     */
    public void intentar(int k, int cantBombas){
        int x = 0;
        int y = 0;
        while(!exito() && k < cantBombas && y < this.size){
            //Si aceptable
            if (aceptable(x, y)){
                //Registra selección
                matrizActual[x][y] = ID.BOMBA.ordinal();
                listaMatrices.insertarUltimo(copia());          
                if (k < cantBombas){
                    intentar(k + 1, cantBombas);
                    //Si no hay éxito
                    if (!exito()){
                        //Cancela el registro
                        matrizActual[x][y] = ID.NADA.ordinal();
                        listaMatrices.insertarUltimo(copia());
                    }
                }
            } //fin aceptable
            //Selecciona el siguiente
            x++;
            if (x >= this.size){
                x = 0;
                y++;
            }
            //Después de recorrer todo el tablero, se escoge siguiente bomba
            if (x >= this.size && y >= this.size){
                k++;
            }
        }
    }
    
    /**
     * Retorna si las bombas destruye todos los zombies, y no muere
     * ningún survivor
     * @return Retorna si se destruyen todos los zombies
     */
    public boolean exito(){
        //Copia matriz actual
        int[][] copiaMatriz = copia();
        //Para cada bomba encontrada, cambiará todos los valores de zombie a 0
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                int id = copiaMatriz[i][j];
                //Destruye vertical y horizontalmente
                if (id == ID.BOMBA.ordinal()){
                    for(int k = 0; k < this.size; k++){
                        if (copiaMatriz[k][j] == ID.ZOMBIE.ordinal()){
                            copiaMatriz[k][j] = 0;
                        }
                        if (copiaMatriz[i][k] == ID.ZOMBIE.ordinal()){
                            copiaMatriz[i][k] = 0;
                        }
                        if (copiaMatriz[i][k] == ID.SURVIVOR.ordinal()
                            || copiaMatriz[k][j] == ID.SURVIVOR.ordinal()){
                            return false;
                        }
                    }
                }
            }
        }
        //Repasada a la matriz
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                //Si pilla zombie no es éxito
                int id = copiaMatriz[i][j];
                if (id == ID.ZOMBIE.ordinal()){
                    return false;
                }
            }
        }
        return true;
    }
    
    /**
     * Es aceptable si al colocar la bomba en (x, y) no muere ningún survivor
     * (independiente de la cantidad de zombies que destruya).
     * (Además, no debe haber ninguna bomba en esa celda)
     * @param x Posición x bomba
     * @param y Posición y bomba
     * @return Si es aceptable coloca la bomba.
     */
    private boolean aceptable(int x, int y){
        //No puede haber nada encima
        if (matrizActual[x][y] != ID.NADA.ordinal()){
            return false;
        }
        //Si hay al menos un survivor, es false  
        for(int k = 0; k < this.size; k++){
            int idVer = matrizActual[k][y];
            int idHor = matrizActual[x][k];
            //Chequeo vertical y horizontal
            if (idVer == ID.SURVIVOR.ordinal() ||
                idHor == ID.SURVIVOR.ordinal()){
                return false;
            }
        }
        return true;
    }
    
    /**
     * Si hay al menos un zombie vivo es solución incompleta
     * @return Si hay solución incompleta
     */
    private boolean solucionIncompleta(){
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                if (matrizActual[i][j] == ID.ZOMBIE.ordinal()){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public int[][] getMatrizActual(){
        return this.matrizActual;
    }
    
    /**
     * Retorna la lista de matrices
     * (Todos los estados por los que ha pasado la matriz)
     * @return 
     */
    public ListaMatrices getListaMatrices(){
        return this.listaMatrices;
    }
    
     
    /**
     * Retorna una copia de la matrizActual
     * (Para evitar modificar datos por la referencia)
     * @return Copia de la matriz actual
     */
    private int[][] copia(){
        int[][] copiaMatriz = new int[this.size][this.size];
        for(int i = 0; i < this.size; i++){
            for(int j = 0; j < this.size; j++){
                copiaMatriz[i][j] = this.matrizActual[i][j];
            }
        }
        return copiaMatriz;
    }
    
}
