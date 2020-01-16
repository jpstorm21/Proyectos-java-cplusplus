/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ciudades;

public class ListaDueños {
    
    private Dueño[] ld;
    private int cantidadDueños;
    private int max;

    public ListaDueños(int max) {
        this.max = max;
        cantidadDueños = 0;
        ld = new Dueño[max];
    }
    
    public Dueño getDueño(int i) {
        return ld[i];
    }

    public void setLd(Dueño[] ld) {
        this.ld = ld;
    }

    public int getCantidadDueños() {
        return cantidadDueños;
    }

    public void setCantidadDueños(int cantidadDueños) {
        this.cantidadDueños = cantidadDueños;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
    
    public boolean ingresarDueño(Dueño D){
        if(cantidadDueños>= max){
            return false;
        }else{
            ld[cantidadDueños] = D;
            cantidadDueños++;
            return true;
        }
    }
    
    public Dueño buscarDueño(String rut){
        int i = 0;
        for(i = 0; i < cantidadDueños; i++){
            if(ld[i].getNombre().equalsIgnoreCase(rut)){
                break;
            }
        }
        if(i == cantidadDueños){
            return null;
        }else{
            return ld[i];
        }
    }
    
    
    
}
