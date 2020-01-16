/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller5.tobal;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Taller5Tobal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String titulo = "Taller 5: Zombie Air Attack!";
        int ancho = 850;
        int alto = 900;
        int matrizSize = 10; //cantidad de celdas
        ZombieAirGame zag = new ZombieAirGame(titulo, ancho, alto, matrizSize);
    }
    
}
