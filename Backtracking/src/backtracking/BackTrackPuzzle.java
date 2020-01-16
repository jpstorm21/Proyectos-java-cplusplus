/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;
import ucn.*;
public class BackTrackPuzzle {
    public Puzzle goal;
    public ListaNexoSimple list;
    public int[] moves;
    public int nosolve=0;

    public BackTrackPuzzle(int size, Puzzle g, Puzzle q){
        list = new ListaNexoSimple();
        moves = new int[size];
        goal = q;
        list.agregar(g);
    }
    

    public boolean solve(Puzzle cfg) {        
        if (isSolution(cfg)) { System.out.println ("SOLVE"); return true;}
    	ListaNexoSimple nodes = explode_node(cfg);
        int i=0, xX;
        do {
		Puzzle child = new Puzzle((Puzzle)nodes.get(i));
		if (isAcceptable(child)) {
                        list.agregar(child);
                        if (list.tamanio()%1000 == 0) System.out.println("list:" + list.tamanio());
		        if (solve(child)) {
                             System.out.println("camino a solucion: " + child);
                             return true;
                        }    
		} 
                i++;
	} while (i<nodes.tamanio());                
        return false;
    }       
    
    ListaNexoSimple explode_node(Puzzle cfg){
        ListaNexoSimple l = new ListaNexoSimple();
        
        int[] moves_x = {0,-1,0,1};
        int[] moves_y = {1,0,-1,0};
        
        for (int i=0;i<4;i++){
            int new_x = cfg.vacio_x+moves_x[i];
            int new_y = cfg.vacio_y+moves_y[i];
            if (new_x>=0 && new_x<3 && new_y>=0 && new_y<3){
                Puzzle p = new Puzzle(cfg);
                p.tablero[p.vacio_x][p.vacio_y]=cfg.tablero[new_x][new_y];
                p.tablero[new_x][new_y]=0;
                p.vacio_x=new_x;
                p.vacio_y=new_y;
                l.agregar(p);
            }            
        }  
        
        return l;
    }
    
    boolean isSolution(Puzzle cfg){
        return cfg.equals(goal);        
    }
    
    boolean isAcceptable(Puzzle cfg){
        if (!list.esVacia()){
            return !list.contiene(cfg);        
        } else
            return true;
    }
    
}    