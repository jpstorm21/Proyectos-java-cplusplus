package ayu_5_2017;
import java.util.Scanner;
public class App {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        SistemaVeterinario sistema = new SistemaVeterinarioImpl();
        
        
        Dueño D = new Dueño("eduardo", 19, 2);
        Dueño D2 = new Dueño("ines", 20, 3);
       
        Perro P = new Perro("bulldog", "tomy", 10);
        Perro P2 = new Perro("poodle", "sofi", 8);
        Perro P3 = new Perro("york", "rick", 1);
        Conejo C = new Conejo(20.3, "jerry", 3);
        Gato G = new Gato(5, "carne", "mateo", 4);
        Gato G2 = new Gato(6,"pollo","gatito",6);
        
        // LISTAS GENERALES
       
        sistema.ingresarDueño(D);
        sistema.ingresarDueño(D2);
        
        
        sistema.ingresarMascota(P);
        sistema.ingresarMascota(P2);
        sistema.ingresarMascota(P3);
        sistema.ingresarMascota(G);
        sistema.ingresarMascota(C);
        sistema.ingresarMascota(G2);
        
        // A CADA MASCOTA, UN DUEÑO
        P.setRefDueño(D);
        P2.setRefDueño(D);
        P3.setRefDueño(D2);
        C.setRefDueño(D2);
        G.setRefDueño(D2);
        G2.setRefDueño(D);
        
        // INGRESO MASCOTAS A LISTAS PARTICULAES MASCOTAS DEL DUEÑO
        
        D.getRefListaMascotas().ingresarMascota(P);
        D.getRefListaMascotas().ingresarMascota(P2);
        D.getRefListaMascotas().ingresarMascota(G2);
        D2.getRefListaMascotas().ingresarMascota(P3);
        D2.getRefListaMascotas().ingresarMascota(C);
        D2.getRefListaMascotas().ingresarMascota(G);
       
        
        
        // requerimientos. 
        sistema.desplegarDueñosConConejoMayor();
        
        System.out.println("Ingrese nombre de dueño a buscar: ");
        String nom = sc.nextLine();
        
        sistema.desplegarMascotasDeUnDueño(nom);
        
        sistema.desplegarTotalMascotas();
        
        
    }
}