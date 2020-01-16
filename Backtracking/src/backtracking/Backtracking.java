package backtracking;

import ucn.*;

public class Backtracking {
    ListaNexoSimple list = new ListaNexoSimple();
    int[] m = new int[1000];
    
    public static void main(String[] args) {
        int[][] m = {{2,8,3},{1,6,4},{7,0,5}};
        Puzzle p = new Puzzle(m);

        int[][] n = {{1,2,3},{8,0,4},{7,6,5}};
        Puzzle q = new Puzzle(n);

        System.out.println(p + "\n" + q);
        
        BackTrackPuzzle b = new BackTrackPuzzle(1000, p, q);
        System.out.println("Objetivo:" + q);
        System.out.println("Inicial:" + p);
        b.solve(p);
    }

    
}


