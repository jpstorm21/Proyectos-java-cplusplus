package juank.BuscaMinas.utils;

import java.awt.Color;
import static juank.BuscaMinas.Ventanas.VentanaPrincipal.jTime;

/**
 * compilador Java SE 7 IDE NetBeans 8.1
 *
 * @version 1.0, 25 jun 2016
 * @author Juan Carlos Lamas Alfaro
 */
public class Cronometro extends Thread {

    /**
     *constructor del temorizador
     */
    public Cronometro() {// Contructor porque la clase es heredada 
        super();
    }
    private static int nuMin = 0;//El Contador de minutos
    private static int nuSeg = 0;//El Contador de de segundos
    private static int nuHora = 0;//El Contador de Horas      

    public void run() {
        try {//si ocurre un error al dormir el proceso(sleep(999))
            for (;;) {//inicio del for infinito          
                if (nuSeg != 59) {//si no es el ultimo segundo
                    nuSeg++;  //decremento el numero de segundos                                  
                } else {
                    if (nuMin != 59) {//si no es el ultimo minuto
                        nuSeg = 0;//segundos comienzan en 59
                        nuMin++;//decremento el numero de minutos
                    } else {
                        if (nuHora != 24) {
                            nuHora++;//decremento el numero de horas
                            nuMin = 0;//minutos comienzan en 59
                            nuSeg = 0;//segundos comienzan en 59
                        } else {
                            break;//seacabo el tiempo fin hilo  
                        }
                    }
                }
                if (nuMin == 0 && nuSeg == 0) {                    
                    this.setNuHora(0);
                    this.setNuMin(3);
                    this.setNuSeg(0);
                    jTime.setForeground(Color.red);
                }
                jTime.setText(nuHora + ":" + nuMin + ":" + nuSeg);//Muestro en pantalla el temporizador
                sleep(998);//Duermo el hilo durante 999 milisegundos(casi un segundo, quintandole el tiempo de proceso)
            }
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }//Fin try   
    }
    
    public static void reiniciar(){
        nuSeg = 0;
        nuMin = 0;
        nuHora = 0;
    }
    
    //setters y getters

    /**
     *
     * @return minuto
     */
        public static int getNuMin() {
        return nuMin;
    }

    /**
     *
     * @param nuMin
     *          minuto
     */
    public static void setNuMin(int nuMin) {
        Cronometro.nuMin = nuMin;
    }

    /**
     *
     * @return segundo
     */
    public static int getNuSeg() {
        return nuSeg;
    }

    /**
     *
     * @param nuSeg
     *          segundo
     */
    public static void setNuSeg(int nuSeg) {
        Cronometro.nuSeg = nuSeg;
    }

    /**
     *
     * @return hora
     */
    public static int getNuHora() {
        return nuHora;
    }

    /**
     *
     * @param nuHora
     *          hora
     */
    public static void setNuHora(int nuHora) {
        Cronometro.nuHora = nuHora;
    }

}
