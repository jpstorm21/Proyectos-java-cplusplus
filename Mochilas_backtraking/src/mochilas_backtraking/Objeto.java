/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilas_backtraking;

/**
 *
 * @author Usuario
 */
public class Objeto implements Comparable<Objeto>{ 
    int peso; 
    int valor; 
    double ratio; 
     
    public Objeto(){ 
        peso = 0; 
        valor = 0; 
        ratio = -1; 
    } 
     
    public Objeto(int peso, int valor){ 
        this.peso = peso; 
        this.valor = valor; 
        if(peso > 0){ 
            ratio = this.valor / this.peso; 
        }else{ 
            ratio = -1; 
        } 
    } 
 
    @Override 
    public int compareTo(Objeto o) { 
        int res = 0; 
        if((this.ratio > o.ratio) || 
            ((this.ratio == o.ratio) && (this.peso < o.peso))){ 
            res = -1; 
        }else if((this.ratio < o.ratio) || 
                ((this.ratio == o.ratio) && (this.valor > o.valor)) || 
                ((this.ratio == o.ratio) && (this.valor == o.valor) && 
                        (this.peso < o.peso))){ 
            res = 1; 
        } 
        return res; 
    } 
     
    public String toString(){ 
        return "(" + peso + " , " + valor + " , " + ratio + ")"; 
    } 
} 