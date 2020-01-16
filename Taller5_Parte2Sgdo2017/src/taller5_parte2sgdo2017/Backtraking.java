/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5_parte2sgdo2017;

/**
 *
 * @author Usuario
 */
public class Backtraking {
    private int tamaño;
    private int [][] matriz;
    public static enum ID{NADA,LITIOBOT,LITIO};
    private ListaMatrices lm;
    
    public Backtraking(int tamaño) {
        this.tamaño = tamaño;
        matriz = new int [tamaño][tamaño];
        this.tamaño= tamaño;
        lm = new ListaMatrices();
    }
     public void generar(){
        this.matriz = new int[this.tamaño][this.tamaño]; 
        double litio = 0.10; //%
        for(int i = 0; i < this.tamaño; i++){
            for(int j = 0; j < this.tamaño; j++){
                double prob = Math.random();
                if (prob <= litio){ //litio
                    this.matriz[i][j] = ID.LITIO.ordinal();              
                }else{
                    this.matriz[i][j] = ID.NADA.ordinal();
                }
            }
        }
        lm.insertarUltimo(copia());
    }
      private int[][] copia(){
        int[][] copiaMatriz = new int[this.tamaño][this.tamaño];
        for(int i = 0; i < this.tamaño; i++){
            for(int j = 0; j < this.tamaño; j++){
                copiaMatriz[i][j] = this.matriz[i][j];
            }
        }
        return copiaMatriz;
    }
      public ListaMatrices getListaMatrices(){
        return this.lm;
    }
      public void resolver(){
        this.intentar();
    }
    
 
    public void reiniciar(){
        this.lm = new ListaMatrices();
    }
    private void intentar(){
        int i = 0; //litio
        int x = 0;
        int y = 0;
        //Hasta el éxito, o que no hayan más candidatos
        while(!exito() && y < this.tamaño){
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
                if (id == ID.LITIO.ordinal()){
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
    
}
