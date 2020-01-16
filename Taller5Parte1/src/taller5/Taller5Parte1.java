package taller5;

import java.util.Scanner;
import ucn.*;
import java.util.ArrayList;
import java.util.List;

public class Taller5Parte1 {

    public static int mayor(ArrayList<Integer> vec) {
        int mayor = -999;
        int largo = vec.size();
        int pos = 0;
        return recmayor(mayor, vec, largo, pos);
    }

    private static int recmayor(int mayor,ArrayList<Integer> vec, int largo, int pos) {
        if (pos < largo) {
            if (vec.get(pos) > mayor) {
                mayor = vec.get(pos);
                pos++;
                return recmayor(mayor, vec, largo, pos);
            } else {
                pos++;
                return recmayor(mayor, vec, largo, pos);
            }
        }
        return mayor;

    }

    public static int menor(ArrayList<Integer> vec) {
        int menor = 999;
        int largo = vec.size();
        int pos = 0;
        return recmenor(menor, vec, largo, pos);
    }

    private static int recmenor(int menor,ArrayList<Integer> vec, int largo, int pos) {
        if (pos < largo) {
            if (vec.get(pos)< menor) {
                menor = vec.get(pos);
                pos++;
                return recmenor(menor, vec, largo, pos);
            } else {
                pos++;
                recmenor(menor, vec, largo, pos);
            }
        }
        return menor;
    }

    public static boolean arbol(ArrayList<Integer> vec) {
        int largo = vec.size();
        int pos = 0;
        int esArbol = 0;
        return recarbol(esArbol,largo, pos, vec);
    }

    private static boolean recarbol(int esArbol,int largo, int pos, ArrayList<Integer> vec) {
        if (pos < largo) {
            int raiz = vec.get(pos);
            int hijoizquierdo = 2 * pos + 1;
            int hijoderecho = 2 * pos + 2;
            if (hijoizquierdo < raiz && raiz < hijoderecho) {
                pos++;
                esArbol = 1;
                return recarbol(esArbol,largo, pos, vec);
            } else {
                pos++;
                esArbol = 2;
                return recarbol(esArbol,largo, pos, vec);

            }
        }
        if(esArbol == 1) {
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        /*int[] vector = {5, 2, 4, 3};
        int mayor = Taller5.mayor(vector);
        int menor = Taller5.menor(vector);
        System.out.println("el mayor es: " + mayor);
        System.out.println("el mayor es: " + menor);*/
        In abb = new In("abb.txt");
        for (int j = 0; j < 22; j++) {
            String leelinea = abb.readLine();
            List<Integer> vec = new ArrayList<Integer>();
            String[] linea = null;
            int lineaV = 1 + j;
            if (lineaV % 2 == 0) {
                linea = leelinea.split(",");
                for (int i = 0; i < linea.length; i++) {
                    vec.add(Integer.parseInt(linea[i]));
                }
            }
            boolean esArbol = Taller5Parte1.arbol((ArrayList<Integer>) vec);
            for(Integer c : vec){
                    StdOut.print(c + ",");
                    
                }
                StdOut.println("");
            if (esArbol== true) {
                   System.out.println("es un ABB");
                   int mayor = Taller5Parte1.mayor((ArrayList<Integer>) vec);
                   int menor = Taller5Parte1.menor((ArrayList<Integer>) vec);
                   System.out.println("el mayor es: " + mayor);
                   System.out.println("el menor es: " + menor);
            }else{
                System.out.print("no es un ABB");
            }
            /*for(Integer c : vec){
                    StdOut.print(c + ",");
                }
                StdOut.println("");
             */

        }

    }
}