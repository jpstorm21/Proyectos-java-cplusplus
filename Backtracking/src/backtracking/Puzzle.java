/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

public class Puzzle implements Elemento {
    int[][] tablero;
    int vacio_x;
    int vacio_y;

    public Puzzle(Puzzle p){
        tablero = new int[3][3];
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                tablero[i][j] = p.tablero[i][j];    
        vacio_x=p.vacio_x;
        vacio_y=p.vacio_y;
    }
    
    public Puzzle(int[][] p){
        tablero = new int[3][3];
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++) {
                tablero[i][j] = p[i][j];
                if (p[i][j]==0){
                    vacio_x=i;
                    vacio_y=j;
                }
            }
    }
    
    public boolean equals(Elemento e){
        for (int i=0;i<3;i++)
            for (int j=0; j<3; j++)
                if ( ((Puzzle)e).tablero[i][j] != tablero[i][j])
                    return false;
        return true;
    }
    
    public int compareTo(Elemento e){
        return 0;
    }    
    
    public String toString(){ 
        String str=""+vacio_x+":"+vacio_y+"\n    ";
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++)
                str+=tablero[i][j];
            str+="\n    ";
        }
        return str;
    }
}
