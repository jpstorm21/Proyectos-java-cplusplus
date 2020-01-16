package ayu_12;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Ayu_12 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Equipo> le = new LinkedList<>();
        ArrayList<Jugador> lj = new ArrayList<>();
        Equipo eq = new Equipo("b", 50, 2);
        Equipo eq2 = new Equipo("c", 60, 3);
        Equipo eq3 = new Equipo("a", 7, 0);
        
        le.add(eq);
        le.add(eq2);
        le.add(eq3);
        
        Jugador j = new Jugador("chuliox", 2);
        j.setEquipo(eq2);
        eq2.getLj().add(j);
        
        Jugador j2 = new Jugador("leo", 3);
        j2.setEquipo(eq2);
        eq2.getLj().add(j2);

        //eq2.getLj().forEach(System.out::println);
        eq2.obtenerCapANDgoleador();
        //System.out.println("-----------------------------------");
        //eq2.getLj().forEach(System.out::println);
        //System.out.println("golador ucn : " + eq2.getGoleador().getNombre());
        //System.out.println("capitan de la ucn : " + eq2.getCapitan().getNombre());
       // Collections.sort(le);
        Iterator<Equipo> it = le.iterator();//RF1
        while (it.hasNext()) {
            Equipo e = it.next();
            System.out.println(e.getNombre());
        }
        
        Iterator<Equipo> it2 = le.iterator();//RF2
        double sum = 0;
        double cant = 0;
        while (it2.hasNext()) {
            Equipo e = it2.next();
            if (e.getAños() >= 50) {
                sum += 1;
            }
            cant++;
        }
        double promedio = (sum / cant) * 100;
        System.out.println(promedio);
        
        eq2.getLj().remove(j);
        eq2.getLj().forEach(System.out::println);
    }
    
}
