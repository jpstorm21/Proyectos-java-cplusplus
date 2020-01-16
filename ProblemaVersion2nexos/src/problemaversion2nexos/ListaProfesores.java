package problemaversion2nexos;

public class ListaProfesores {

    private NodoProfesor firstProfesor;
    private NodoProfesor lastProfesor;

    public ListaProfesores() {
        this.firstProfesor = null;
        this.lastProfesor = null;
    }

    public NodoProfesor getFirstProfesor() {
        return firstProfesor;
    }

    public void setFirstProfesor(NodoProfesor firstProfesor) {
        this.firstProfesor = firstProfesor;
    }

    public NodoProfesor getLastProfesor() {
        return lastProfesor;
    }

    public void setLastProfesor(NodoProfesor lastProfesor) {
        this.lastProfesor = lastProfesor;
    }

    public void ingresarProfesor(Profesor P) {
        NodoProfesor nuevo = new NodoProfesor(P);
        if (firstProfesor == null) {
            firstProfesor = nuevo;
            lastProfesor = nuevo;
        } else {
            nuevo.setNextProfesor(firstProfesor);
            firstProfesor.setPrevProfesor(nuevo);
            nuevo.setPrevProfesor(null);
            firstProfesor = nuevo;
        }
    }

    public Profesor buscarProfesor(String rut) {
        NodoProfesor actual = firstProfesor;
        while (actual != null && !actual.getProfesor().getRut().equalsIgnoreCase(rut)) {
            actual = actual.getNextProfesor();
        }
        if (actual != null) {
            return actual.getProfesor();
        } else {
            return null;
        }
    }

    public boolean eliminarProfesor(String rut) {
        NodoProfesor actual = firstProfesor;
        while (actual != null && !actual.getProfesor().getRut().equalsIgnoreCase(rut)) {
            actual = actual.getNextProfesor();
        }
        if (actual != null) {
            if (actual == firstProfesor) {
                firstProfesor = firstProfesor.getNextProfesor();
            } else {
                actual.getPrevProfesor().setNextProfesor(actual.getNextProfesor());
            }
            if (actual == lastProfesor) {
                lastProfesor = lastProfesor.getPrevProfesor();
            } else {
                actual.getNextProfesor().setPrevProfesor(actual.getPrevProfesor());
            }
            return true;
        } else {
            return false;
        }
    }
}
