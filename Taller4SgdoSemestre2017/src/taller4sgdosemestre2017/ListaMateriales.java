package taller4sgdosemestre2017;

public class ListaMateriales {

    private NodoMaterial first;
    private int cant;

    public ListaMateriales() {
        this.first = null;
    }

    public NodoMaterial getFirst() {
        return first;
    }

    public void setFirst(NodoMaterial first) {
        this.first = first;
    }

    public void ingresarMaterial(Material M) {
        NodoMaterial nuevo = new NodoMaterial(M);
        if (first == null) {
            first = nuevo;
        } else {
            nuevo.setNext(first);
            first = nuevo;
        }
        cant++;
    }

    public Material buscarMaterial(int codigo) {
        NodoMaterial actual = first;
        while (actual != null && actual.getMaterial().getCodigo() != codigo) {
            actual = actual.getNext();
        }
        if (actual != null) {
            return actual.getMaterial();
        } else {
            return null;
        }
    }

    public int getCant() {
        return cant;
    }
    
}
