package tareanodos;

public class ListaEmpleados {

    private NodoEmpleado firstEmpleado;
    private NodoEmpleado lastEmpleado;

    public ListaEmpleados() {
        firstEmpleado = null;
        lastEmpleado = null;
    }

    public NodoEmpleado getFirstEmpleado() {
        return firstEmpleado;
    }

    public void setFirstEmpleado(NodoEmpleado firstEmpleado) {
        this.firstEmpleado = firstEmpleado;
    }

    public NodoEmpleado getLastEmpleado() {
        return lastEmpleado;
    }

    public void setLastEmpleado(NodoEmpleado lastEmpleado) {
        this.lastEmpleado = lastEmpleado;
    }

    public void ingresarEmpleado(Empleado E) {
        NodoEmpleado nuevoN = new NodoEmpleado(E);
        if (firstEmpleado == null) {
            firstEmpleado = nuevoN;
            lastEmpleado = nuevoN;
        } else {
            nuevoN.setPrevEmpleado(lastEmpleado);
            lastEmpleado.setNextEmpleado(nuevoN);
            nuevoN.setNextEmpleado(firstEmpleado);
            firstEmpleado.setPrevEmpleado(nuevoN);
            firstEmpleado = nuevoN;
    }
    }

    public Empleado buscarEmpleado(String rut) {
        NodoEmpleado actual = firstEmpleado;
        while (actual.getNextEmpleado() != firstEmpleado && !actual.getEmpleado().getRut().equalsIgnoreCase(rut)) {
            actual = actual.getNextEmpleado();
        }
        if (actual.getEmpleado().getRut().equalsIgnoreCase(rut)) {
            return actual.getEmpleado();
        } else {
            return null;
        }
    }

    public boolean eliminarEmpleado(String rut) {
        NodoEmpleado actual = firstEmpleado;
        while (actual.getNextEmpleado() != firstEmpleado && !actual.getEmpleado().getRut().equalsIgnoreCase(rut)) {
            actual = actual.getNextEmpleado();
        }
        if (actual != null) {
            if (actual == firstEmpleado) {
                firstEmpleado = firstEmpleado.getNextEmpleado();
                firstEmpleado.setPrevEmpleado(lastEmpleado);
                lastEmpleado.setNextEmpleado(firstEmpleado);
            } else {
                actual.getPrevEmpleado().setNextEmpleado(actual.getNextEmpleado());
            }
            if (actual == lastEmpleado) {
                lastEmpleado = lastEmpleado.getPrevEmpleado();
                lastEmpleado.setNextEmpleado(firstEmpleado);
                firstEmpleado.setPrevEmpleado(lastEmpleado);
            } else {
                actual.getNextEmpleado().setPrevEmpleado(actual.getPrevEmpleado());
            }

            return true;
        } else {
            return false;
        }
    }
}
