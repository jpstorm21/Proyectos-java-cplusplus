/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayu_5_2017;

/**
 *
 * @author Eduardo
 */
public class SistemaVeterinarioImpl implements SistemaVeterinario{
    private ListaDueño ld;
    private ListaMascota lm;
    
    public SistemaVeterinarioImpl() {
        ld = new ListaDueño(1000);
        lm = new ListaMascota(1000);
    }
    
    @Override
    public void ingresarDueño(Dueño D) {
        boolean sePudo = ld.ingresarDueño(D);
        if(!sePudo){
            throw new IllegalArgumentException("No se pudo ingresar el dueño");
        }
    }

    @Override
    public void ingresarMascota(Mascota M) {
        boolean sePudo = lm.ingresarMascota(M);
        if(!sePudo) {
            throw new IllegalArgumentException("No se pudo ingresar la mascota");
        }
    }

    @Override
    public void desplegarTotalMascotas() {
        int cantGatos=0,cantPerros=0,cantConejos=0;
        for(int i=0; i<lm.getCantMascotas(); i++) {
            Mascota M = lm.getMascota(i);
            if( M instanceof Gato) {
                cantGatos++;
            } else{
                if( M instanceof Perro) {
                    cantPerros++;
                } else {
                    cantConejos++;
                }
            }
        }
        System.out.println("En el dia se atendieron: " +cantGatos +" Gatos, " +cantPerros +" Perros y " +cantConejos +" Conejos.");
        
    }

    @Override
    public void desplegarMascotasDeUnDueño(String nom) {
        
        Dueño D = ld.buscarDueño(nom);
        System.out.println("Mascotas de " +D.getNomDueño()+ " : ");
        if( D != null) {
            for(int i=0; i<D.getRefListaMascotas().getCantMascotas();i++) {
                Mascota M = D.getRefListaMascotas().getMascota(i);
                if( M instanceof Conejo) {
                    Conejo C = (Conejo)M;
                    System.out.println(C.getApodo() +" (Conejo)");
                    System.out.println("Peso: " +C.getPeso());
                } else {
                    if( M instanceof Gato) {
                        Gato G = (Gato)M;
                        System.out.println(G.getApodo() + " (Gato");
                        System.out.println("Comida favorita: " +G.getComidaFav());
                    } else {
                        Perro P = (Perro)M;
                        System.out.println(P.getApodo() +" (Perro)");
                        System.out.println("Raza: " +P.getRaza());
                    }
                }
            }
        }
    }

    @Override
    public void desplegarDueñosConConejoMayor() {
        System.out.println("Dueños con conejos mayores de 2 años: ");
        for(int i=0; i<ld.getCantDueños();i++) {
            Dueño D = ld.getDueño(i);
            for(int j=0; j<D.getRefListaMascotas().getCantMascotas(); j++) {
                Mascota M = D.getRefListaMascotas().getMascota(j);
                if( M instanceof Conejo) {
                    Conejo C = (Conejo)M;
                    if( C.getEdad() > 2) {
                        System.out.println(D.getNomDueño());
                    }
                }
            }
        }
    }

    @Override
    public int promedioPorPersona() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    
    
    
}
