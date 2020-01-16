/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alimentos;

/**
 *
 * @author Usuario
 */
public class Backtraking_alimentos {
    private Alimento [] solucion;
    private int grupos;
    private int min;
    private int max;
    private Alimento []la;
    private  int cantAlimentosSolucion;
    private  int cantAlimentos;
    private  int [] Vgrupos;
    public Backtraking_alimentos(int grupos, int min, int max, Alimento[] la, int cantAlimentos) {
        this.solucion = new Alimento[100];
        this.grupos = grupos;
        this.min = min;
        this.max = max;
        this.la = la;
        this.cantAlimentos = cantAlimentos;
        this.Vgrupos =  new int [7];
        for(int i = 0; i <this.cantAlimentos;i++){
         this.Vgrupos[i] = 0;   
        }
        
        this.cantAlimentosSolucion = 0;
    }
     public  void desplegarSolucion(){
        System.out.println("*****************************************************************");
        System.out.println("\t\tSolucion:");
        System.out.println("*****************************************************************");
        for(int i = 0 ; i <= cantAlimentosSolucion ; i++){
            System.out.println("Alimento: "+solucion[i].getNombre());
        }
    }
    public boolean intentar(int pos){
        boolean q;
        int k = 0;
        do{
            k++;
            q = false;
            if(esAceptable(k)){
                registrarSeleccion(la[k]);
                //Elige el k-esimo alimento
                if(solucionIncompleta()){
                    q = intentar(pos+1);
                    if(!q)
                        cancelarSeleccion();
                }else
                    q = true;
            }
        }while(!q && k != cantAlimentos);
        return q;
    }
     public  boolean esAceptable(int k){
        if(caloriasEnRango(k) && cantAlimentosGrupo(k))
            return true;
        else
            return false;
    }
     public  void registrarSeleccion(Alimento A){
        cantAlimentosSolucion++;
        solucion[cantAlimentosSolucion] = A;
        int grupo = A.getGrupo();
        Vgrupos[grupo]++;
    }
     public  boolean caloriasEnRango(int k){
        int suma = 0;
        for(int i = 1 ; i <= cantAlimentosSolucion ; i++)
            suma = suma + solucion[i].getCalorias();
        
        if(suma <= max)
            return true;
        else
            return false;
    }
    
    public  boolean cantAlimentosGrupo(int k){
        int grupo = la[k].getGrupo();
        if(Vgrupos[grupo] >= 2)
            return false;
        else
            return true;
    }
    public  boolean solucionIncompleta(){
        if(!caloriasDentroDeRango() || (!gruposOK()))
            return true;
        else
            return false;
    }
    
    public  boolean caloriasDentroDeRango(){
        int suma = 0;
        for(int i = 1 ; i <= cantAlimentosSolucion ; i++)
            suma = suma + solucion[i].getCalorias();
        if(suma >= min && suma <= max)
            return true;
        else
            return false;
    }
    
    public  boolean gruposOK(){
        //retorna falso cuando hay algun grupo con 0, es decir,
        //no se han considerado alimentos de todos los grupos
        boolean resp = true;
        int i = 1;
        while(i <= grupos && resp){
            if(Vgrupos[i] == 0)
                resp = false;
            i++;
        }
        return resp;
    }
    
    public  void cancelarSeleccion(){
        Alimento A = solucion[cantAlimentosSolucion];
        cantAlimentosSolucion--;
        int grupo = A.getGrupo();
        Vgrupos[grupo]--;
    }
    
}
