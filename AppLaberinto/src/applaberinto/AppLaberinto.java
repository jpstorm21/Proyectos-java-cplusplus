/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package applaberinto;

/**
 *
 * @author Dario
 */
public class AppLaberinto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Laberinto l = new Laberinto(20, 20, 0, 0, 19, 19);
        
        for (int i=0;i<20; i++) 
           for (int j=0; j<20; j++)
               if (Math.random()>0.8 && i!=0 && j!=0)
                   l.addPared(i,j);
            
       
       System.out.println("incial\n"+ l);
        
       System.out.println(l.solve());
        
        System.out.println("final\n"+ l);
        System.out.println(l);
        
           
    }
}
