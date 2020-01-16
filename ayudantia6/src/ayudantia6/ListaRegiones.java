
package ayudantia6;

public class ListaRegiones {
    private int max;
    private int cantRegiones;
    private Region [] lr;
    
    public ListaRegiones(int max) {
        this.max = max;
        cantRegiones =0;
        lr = new Region[max];
    }

    public int getMax() {
        return max;
    }

    public int getCantRegiones() {
        return cantRegiones;
    }

    public Region getRegion(int i) {
        return lr[i];
    }
    
    public boolean insertarRegion(Region R) {
        if(cantRegiones < max) {
            lr[cantRegiones] = R;
            cantRegiones++;
            return true;
        } else {
            return false;
        }
    }
    
    public Region buscarRegion(String nombre) {
        int i=0;
        for(i=0 ; i< cantRegiones ;i++) {
            if(lr[i].getNomRegion().equalsIgnoreCase(nombre)) { // ignore case sirve para comparar dos strings sin importar mayusculas ( es util )
                break;
            }
        }
        if( i==cantRegiones) {
            return null;
        } else {
            return lr[i];
        }
    }
    
    public int calcularMontoChile() {
        int sumador=0;
        for(int i=0; i<cantRegiones; i++) {
            Region R = lr[i];
            sumador += R.getLd().getDonante(i).getMontoDonado();
            
        }
        return sumador;
    }
}

