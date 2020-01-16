/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package apparbolbinario;

import ucn.StdOut;

/**
 *
 * @author featz
 */
public class Arbol {
    
    private NodoDoble start;

    public Arbol() {
        start=null;
    }
    
    public boolean agregar(int e){
        if(start==null){
            start=new NodoDoble(e);
        }
        else{
            NodoDoble aux=start;
            NodoDoble nn=new NodoDoble(e);
            do{
                if(aux.key>nn.key){
                    if(aux.left==null)
                        aux.left=nn;
                    else
                        aux=aux.left;
                }
                if(aux.key<nn.key){
                    if(aux.right==null)
                        aux.right=nn;
                    else
                        aux=aux.right;
                }                
            }while(aux.left!=nn && aux.right!=nn);
        }
        return true;
    }
    
    public boolean buscar(int key){
        NodoDoble aux=start;
        NodoDoble b = new NodoDoble(key);
        if(start==null)
            return false;
        else{
            do{             
                if(b.elemento==aux.elemento)
                    return true;
                else{
                    if(aux.key>b.key){
                        aux=aux.left;
                    }
                    if(aux.key<b.key){
                        aux=aux.right;
                    }  
                }
                //revisar hasta ke el ltimo sea null
            }while(aux!=null);
        }                    
        return false;
    }
    
    public void imprimir(){
       NodoDoble aux=start;
       inOrder(aux);
       StdOut.println();
       inAnchura(aux);
    }
    
       
    private void inOrder(NodoDoble a){
        if(a!=null){
            inOrder(a.left);
            if(a==start)
                StdOut.print("["+a.elemento+"] ");    
            else
                StdOut.print(a.elemento+" ");
            inOrder(a.right);
        }
    }
    
    private void inAnchura(NodoDoble a){
        if(a==start)
            StdOut.println(a.elemento);        
            if(a!=null){
                if(a.left!=null)
                    StdOut.print(a.left.elemento);
                if(a.right!=null)
                        StdOut.println(" "+a.right.elemento);            
            inAnchura(a.left);
            inAnchura(a.right);            
        }
    }
    
    private NodoDoble buscarRecursivo(NodoDoble aux,int key){
        if(aux==null || aux.elemento==key)
                return aux;
        if(aux.elemento>key)
            return buscarRecursivo(aux.left,key);
        else
            return buscarRecursivo(aux.right,key);            
           
    }
    
    public boolean buscarRecursivo(int key){
        NodoDoble aux=start;
        aux=buscarRecursivo(aux,key);
        if(aux!=null && aux.elemento==key)
            return true;
        return false;
    }
    
    public int minimo(){
        NodoDoble aux=start;
        if(start==null)
            return -1;
        else{
            while(aux.left!=null)
                aux=aux.left;
        }
        return aux.elemento;
    }
    
    public int maximo(){
        NodoDoble aux=start;
        if(start==null)
            return -1;
        else{
            while(aux.right!=null)
                aux=aux.right;
        }
        return aux.elemento;
    }

    
    
    
}
