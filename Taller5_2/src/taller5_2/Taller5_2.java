package taller5_2;

public class Taller5_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String titulo = "Taller 5: Zombie Air Attack!";
        int ancho = 480;
        int alto = 480;
        int matrizSize = 5; //cantidad de celdas
        ZombieAirGame zag = new ZombieAirGame(titulo, ancho, alto, matrizSize);
    }
    
}
