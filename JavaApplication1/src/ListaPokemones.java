/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class ListaPokemones {
   private int cantPokemones;
   private Pokemon [] lp;
   private int max;
   
   public ListaPokemones(int max) {
       this.max = max;
       cantPokemones =0;
       lp = new Pokemon[max];
   }

    public int getCantPokemones() {
        return cantPokemones;
    }
    
    public Pokemon getPokemon(int i) {
        return lp[i];
    }


    public int getMax() {
        return max;
    }
    
    public boolean ingresarPokemon(Pokemon P) {
        if( cantPokemones > max) {
            return false;
        } else {
            lp[cantPokemones] = P;
            cantPokemones++;
            return true;
        }
    }
    
   
}
