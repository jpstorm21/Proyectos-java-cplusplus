package ejemplitotrycatch;

import java.util.Scanner;

/**
 *  Ejemplo rápido de try - catch
 */
public class EjemplitoTryCatch {

    public static void main(String[] args) {
        //Ejemplo sin menú:
        sinmenu();
        //Ejemplo con menú:
        conmenu();
    }
    
    public static void sinmenu(){
        System.out.println(" - - - Sin menu: ");
        //Acá tu ves lo que haces con la excepción 
        //(finalizas el programa o sigues normal)
        try{
            unRfHipotetico();
        }catch(NumberFormatException nfe){
            System.out.println("Error. " + nfe.getMessage());
            System.exit(-1); //-1: Falla
            /*
                O puede haber alguna forma de q se repita 
                (como en el caso del menú)
            */
        }
        System.out.println(" - - - Fin Sin menu");
    }
    
    public static void conmenu(){
        System.out.println(" - - - Con menu: ");
        Scanner sc = new Scanner(System.in);
        String opcion = "a";
        while(!opcion.equals("2")){
            System.out.println("1. RF hipotetico");
            System.out.println("2. Salir");
            opcion = sc.nextLine();
            switch(opcion){
                case "1":
                    try{
                        unRfHipotetico();
                    }catch(NumberFormatException nfe){
                        System.out.println("Ha ingresado mal un dato.");
                        System.out.println(nfe.getMessage());
                    }
                    break;
                case "2":
                    System.out.println("chao");
                    break;
                default:
                    System.out.println("Ingresa 1 o 2");
            }
        }
        System.out.println(" - - - Fin Con menu");
    }
    
    public static void unRfHipotetico(){
        //Ejemplo con leer mes
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese mes: ");
        String linea = sc.nextLine();
        int mes = Integer.parseInt(linea);
        try{
            mes = Integer.parseInt(linea);
        }catch(NumberFormatException nfe){
            throw nfe; //Lanza la misma excepción que capturó
        }
        //Acá ya se convirtió a número, pero tiene q ser 1 - 12
        if (mes < 1 || mes > 12){
            throw new NumberFormatException("mes debe estar entre 1 y 12");
        }
        //Si ocurre el throw, esto no se ejecuta:
        //Acá sigue el método normalmente...
        int valorMagico = (int)(Math.random() * mes * 10 + 1);
        System.out.println("Tu valor mágico es: " + valorMagico);
        
    }
}
