package problema;

public class ListaProfesores {
    private NodoProfesor primerProfesor;
    private NodoProfesor lastProfesor;
    public ListaProfesores(){
        primerProfesor = null;
        lastProfesor = null;
    }
    public void insertarProfesor(Profesor P){
        NodoProfesor nuevoNodo = new NodoProfesor(P);
        if(primerProfesor == null){
            primerProfesor = nuevoNodo;
            lastProfesor = nuevoNodo;
        }else{
            nuevoNodo.setSiguienteProfesor(primerProfesor);
            primerProfesor.setPrevioProfesor(nuevoNodo);
            nuevoNodo.setPrevioProfesor(null);
            primerProfesor = nuevoNodo;
        }   
    }
    public void insertarOrdenado(Profesor P){
        NodoProfesor nuevoNodo = new NodoProfesor(P);
        NodoProfesor prevProfesor =null; 
        NodoProfesor actual = primerProfesor;
        while(actual != null && P.getNombre().compareTo(actual.getProfesor().getNombre())>0){
            prevProfesor = actual;
            actual = actual.getSiguienteProfesor();
        }
        if (prevProfesor == null){ 
		primerProfesor = nuevoNodo;
		
	}else{ 
		prevProfesor.setSiguienteProfesor(nuevoNodo);
		nuevoNodo.setPrevioProfesor(prevProfesor);
	}
	nuevoNodo.setSiguienteProfesor(actual); 
	
	if(actual != null){
		actual.setPrevioProfesor(nuevoNodo);
	}else{
		lastProfesor = nuevoNodo;
	}
    }
    public Profesor buscarProfesor(String rut){
        NodoProfesor actual = primerProfesor;
        while(actual != null && !actual.getProfesor().getRut().equalsIgnoreCase(rut)){
            actual = actual.getSiguienteProfesor();
        }
        if(actual != null){
            return actual.getProfesor();
        }else{
            return null;
        }
    }
    public NodoProfesor getPrimerProfesor(){
        return primerProfesor;
    }
    public void setPrimerProfesor(NodoProfesor N){
        this.primerProfesor = N;
    }

    public NodoProfesor getLastProfesor() {
        return lastProfesor;
    }

    public void setLastProfesor(NodoProfesor lastProfesor) {
        this.lastProfesor = lastProfesor;
    }
    
    public boolean eliminarProfesor(String rut){
        NodoProfesor actual = primerProfesor;
        while(actual != null && !actual.getProfesor().getRut().equalsIgnoreCase(rut)){
            actual = actual.getSiguienteProfesor();
            
        }
        if(actual != null){
            if(actual == primerProfesor){
                primerProfesor = primerProfesor.getSiguienteProfesor();
            }else{
                actual.getPrevioProfesor().setSiguienteProfesor(actual.getSiguienteProfesor());
            }
            if(actual == lastProfesor){
                lastProfesor = lastProfesor.getPrevioProfesor();
            }else{
                actual.getSiguienteProfesor().setPrevioProfesor(actual.getPrevioProfesor());
            }
            return true;
        }else{
            return false;
        }
    }
 
}
