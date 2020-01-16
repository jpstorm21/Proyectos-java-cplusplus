
package ficha3;


public class Comuna {
    private int codigo;
    private ListaPropiedades  lp;

    public Comuna(int codigo) {
        this.codigo = codigo;
        lp = new ListaPropiedades(1000);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ListaPropiedades getLp() {
        return lp;
    }

    public void setLp(ListaPropiedades lp) {
        this.lp = lp;
    }
    
            
}
