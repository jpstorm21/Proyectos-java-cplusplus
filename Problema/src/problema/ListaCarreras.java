package problema;

public class ListaCarreras {
    private NodoCarrera primerCarrera;
    private NodoCarrera lastCarrera;
    public ListaCarreras(){
        primerCarrera = null;
        lastCarrera = null;
    }
    public NodoCarrera getPrimerCarrera(){
        return primerCarrera;
    }
    public void setPrimerCarrera(NodoCarrera N){
        this.primerCarrera = N;
    }
    public void insertarCarrera(Carrera C){
        NodoCarrera nuevoNodo = new NodoCarrera(C);
        if(primerCarrera == null){
            primerCarrera = nuevoNodo;
            lastCarrera = nuevoNodo;
        }else{
        nuevoNodo.setSiguienteCarrera(primerCarrera);
        primerCarrera.setPrevioCarrera(nuevoNodo);
        nuevoNodo.setPrevioCarrera(null);
        primerCarrera = nuevoNodo;
    }
    }
    public void insertarOrdenado(Carrera C){
        NodoCarrera nuevoNodo = new NodoCarrera(C);
        NodoCarrera prevCarrera =null; 
        NodoCarrera actual = primerCarrera;
        while(actual != null && C.getNombre().compareTo(actual.getCarrera().getNombre())>0){
            prevCarrera = actual;
            actual = actual.getSiguienteCarrera();
        }
        if (prevCarrera == null){ 
		primerCarrera = nuevoNodo;
		
	}else{ 
		prevCarrera.setSiguienteCarrera(nuevoNodo);
		nuevoNodo.setPrevioCarrera(prevCarrera);
	}
	nuevoNodo.setSiguienteCarrera(actual); 
	
	if(actual != null){
		actual.setPrevioCarrera(nuevoNodo);
	}else{
		lastCarrera = nuevoNodo;
	}
    }
    public Carrera buscarCarrera(int codigo){
        NodoCarrera actual = primerCarrera;
        while(actual != null && actual.getCarrera().getCodigo() != codigo){
            actual = actual.getSiguienteCarrera();
        }
        if(actual != null){
            return actual.getCarrera();
        }else{
            return null;
        }
    }
    
}
