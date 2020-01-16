package taller3;


public interface SistemaInterfaz {

    public void IngresarPersona(Persona P);
    public ListaPersonas BuscarPersonaXCodigo();
    public void EliminarPersona(Persona P);
    public void IngresarCredito(Credito C);
    public ListaCreditos BuscarCreditoXCodigo();
    public void EliminarCredito(Credito C);
}
