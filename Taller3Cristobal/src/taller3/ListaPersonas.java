package taller3;

public class ListaPersonas {

    private int max;
    private int cantPers;
    private Personas[] LPers;

    public ListaPersonas(int max) {
        this.max = max;
        cantPers = 0;
        LPers = new Personas[max];
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getCantPers() {
        return cantPers;
    }

    public void setCantPers(int cantPers) {
        this.cantPers = cantPers;
    }

    public Personas getLPers(int i) {
        return LPers[i];
    }

    public void setLPers(Personas[] LPers) {
        this.LPers = LPers;
    }

    public boolean IngresarPersona(Persona P) {
        if (cantPers >= max) {
            return false;

        } else {
            LPers[cantPers] = P;
            cantPers++;
            return true;
        }
    }

    public Persona BuscarPersonaXCodigo(int codigo) {
        int i;
        for (i = 0; i < cantPers; i++) {
            if (LPers[i].getCodigo() == codigo) {
                break;
            }
        }
        if (i == cantPers) {
            return null;

        } else {
            return LPers[i];
        }
    }

    public boolean EliminarPersona(Persona P) {
        int i;
        for (i = 0; i < cantPers; i++) {
            if (LPers[i] == P) {
                break;
            }
        }
        if (i == cantPers) {
            return false;

        } else {
            int j;
            for (j = 0; j < cantPers; j++) {
                LPers[j] = LPers[j + 1];
            }
            cantPers--;
            return true;
        }
    }

}
