/**
 *
 * @author sebastian
 */
public class Alimento {
    private String nomAlim;
    private int calorias;
    private int grupo;

    public Alimento(int calorias, int grupo, String nomAlim) {
        this.nomAlim = nomAlim;
        this.calorias = calorias;
        this.grupo = grupo;
    }

    public String getNomAlim() {
        return nomAlim;
    }

    public int getCalorias() {
        return calorias;
    }

    public int getGrupo() {
        return grupo;
    }
}
