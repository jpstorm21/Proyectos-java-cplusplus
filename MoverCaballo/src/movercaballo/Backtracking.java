/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package movercaballo;

import ucn.StdOut;


public class Backtracking {
    
    int n;
    int meta;
    int tablero [][];
    int pos_x;
    int pos_y;
    int ejex[] = {-1,-2,-2,-1,1,2,2,1};
    int ejey[] = {-2,-1,1,2,2,1,-1,-2};

    public Backtracking(int n,int pos_x, int pos_y) {
        this.n = n;
        this.meta = n*n;
        this.tablero = new int [n][n];
        this.pos_x = pos_x;
        this.pos_y = pos_y;
        this.tablero[pos_x][pos_y]=1;
    }
    
    private boolean isAceptable(int x, int y){
        if(x<0 || x>n-1)
            return false;
        if(y<0 || y>n-1)
            return false;
        if(this.tablero[x][y]!=0)
            return false;
        return true;
    }
    
    private boolean isSolved(int meta){
        if(meta==this.meta)
            return true;
        else
            return false;
    }
    
    public boolean solve(){
        return this.solve(2,this.pos_x,this.pos_y);
    }

    /*private boolean solve(int meta,int pos_x, int pos_y) {
        
        for(int i=0;i<8;i++){
            int x=pos_x+this.ejex[i];
            int y=pos_y+this.ejey[i];
            StdOut.println("Nuevo movimiento: "+x+","+y);
            if(this.isAceptable(x, y)){
                StdOut.println("Es aceptable?: "+this.isAceptable(x,y));
                this.tablero[x][y]=meta;
                StdOut.println("Valor agregado: "+this.tablero[x][y]);
                imprimir();
                if(!this.isSolved(meta)){
                    this.solve(meta+1,x,y);
                    this.tablero[x][y]=0;
                }
                else
                    return true;
            } 
        }
        return false;
    }*/
    private boolean solve(int meta,int pos_x, int pos_y) {
        if(this.isSolved(meta-1))
            return true;
        for(int i=0;i<8;i++){
            int x=pos_x+this.ejex[i];
            int y=pos_y+this.ejey[i];
            StdOut.println("Nuevo movimiento: "+x+","+y);
            if(this.isAceptable(x, y)){
                StdOut.println("Es aceptable?: "+this.isAceptable(x,y));
                this.tablero[x][y]=meta;
                StdOut.println("Valor agregado: "+this.tablero[x][y]);
                imprimir();
                if(!this.solve(meta+1,x,y)){
                    this.tablero[x][y]=0;
                }
                else
                    return true;
            } 
        }
        return false;
    }
    
    public void imprimir(boolean exito){
        if(exito)
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    StdOut.print(tablero[i][j]+" ");
                StdOut.println();
            }
        else
            StdOut.println("No existe solucion");
               
    }
    
    private void imprimir(){
        for(int i=0;i<n;i++){
                for(int j=0;j<n;j++)
                    StdOut.print(tablero[i][j]+" ");
                StdOut.println();
            }
    }
    
    
    
}
