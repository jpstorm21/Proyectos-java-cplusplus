package noescribanasi;

import java.util.Scanner;

public class NoEsCrIbAnAsI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int N = sc.nextInt();
        String palabra = sc.nextLine();
        String[] linea = palabra.split(" ");
        int par = 0;
        for (int i = 0; i < linea.length; i++) {
            char[] frase = linea[i].toCharArray();
            for (int j = 0; j < frase.length; j++) {
                if (Character.isLetter(frase[j])) {
                    if (par % 2 == 0) {
                        frase[j] = Character.toUpperCase(frase[j]);
                    } else {
                        frase[j] = Character.toLowerCase(frase[j]);
                    }
                    par++;
                }
            }
            for (int j = 0; j < frase.length; j++) {
                System.out.print(frase[j]);
            }
            System.out.print(" ");
        }
    }
}
