
package appbacktrackingcaballo;

class Backtracking {    
   int n,meta,tablero [][],pos_x,pos_y;
    int ejex[] = {2,-2, 2,-2,1,-1, 1,-1};
    int ejey[] = {1, 1,-1,-1,2, 2,-2,-2};

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
    
    private boolean solve(int meta,int pos_x, int pos_y) {
        if(this.isSolved(meta-1))
            return true;
        for(int i=0;i<8;i++){
            int x=pos_x+this.ejex[i];
            int y=pos_y+this.ejey[i];
            
            System.out.println("Nuevo movimiento: "+x+","+y);
            
            if(this.isAceptable(x, y)){
                
                System.out.println("Es aceptable?: "+this.isAceptable(x,y));
                this.tablero[x][y]=meta; // marcar la solucion
                System.out.println("Valor agregado: "+this.tablero[x][y]);
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
        if(exito){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) {
                    System.out.print(String.format("%02d",tablero[i][j])+" ");
                }
                System.out.println();
            }
        }else{
            System.out.println("No existe solucion");
        }     
    }
    
    private void imprimir(){
        
        for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(String.format("%02d",tablero[i][j])+" ");      
        }
        System.out.println();
    }
    System.out.println("**************************************************");  
          
    }
}
    
      
    

