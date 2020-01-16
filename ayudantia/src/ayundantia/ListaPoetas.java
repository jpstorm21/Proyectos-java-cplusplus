/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayundantia;


public class ListaPoetas {
    private int max;
    private int cantpoetas;
    private Poeta [] lp;
    public ListaPoetas(int max){
    this.max = max;
    cantpoetas = 0;
    lp = new Poeta[max];
    
}

    public int getMax() {
        return max;
    }

    public int getCantpoetas() {
        return cantpoetas;
    }

    public Poeta getPoeta(int i) {
        return lp[i];
    }
    public boolean ingresarPoeta( Poeta p){
        if(cantpoetas >= max){
            System.out.print("execede el maximo");
            return false;
        }else{
            lp[cantpoetas]= p;
            cantpoetas++;
            return true;
        }
    }
    public Poeta buscarPoeta(String rut){
        int i = 0;
        for(i = 0;i<cantpoetas;i++){
            if(lp[i].getRut().equalsIgnoreCase(rut)){
                break;   
            }   
        }
        if( i == cantpoetas){
            return null;
        }else{
          return lp[i];  
        }
    }
    
}
