
package taller3;


public class ListaPersonas {
   private int max;
   private int cantpersonas;
   private Persona [] lp;

    public ListaPersonas(int max) {
        this.max = max;
        cantpersonas = 0;
        lp = new Persona[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantpersonas() {
        return cantpersonas;
    }

    public Persona getPersona(int i) {
        return lp[i];
    }
    public boolean ingresarPersona(Persona P){
        if(cantpersonas < max){
            lp[cantpersonas] = P;
            cantpersonas++;
            return true;
        }else{
            System.out.println("lista llena");
            return false;
        }
    }
    public Persona buscarPersona(String codigo){
        int i;
        for(i=0;i<cantpersonas;i++){
            if(lp[i].getCodigo().equalsIgnoreCase(codigo)){
                break;
            }
        }
        if(i==cantpersonas){
            return null;
        }else{
            return lp[i];
        }
    }
   
}
