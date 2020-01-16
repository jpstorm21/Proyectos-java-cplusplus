package cachipun;

import java.util.Scanner;

public class Cachipun {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int VBenjamin = 0;
        int Vmartina = 0;
        int empate = 0;
        int N = sc.nextInt();
        int puntosbenja;
        int puntosMartina;
        for (int i = 0; i <= N; i++) {
            puntosbenja = 0;
            puntosMartina = 0;
            String palabra = sc.nextLine();
            char[] vec = palabra.toCharArray();
            for (int j = 0; j < vec.length; j++) {
                if (vec[j] == '1') {
                    puntosbenja++;
                } else if (vec[j] == '0') {
                    puntosMartina++;
                }
            }
            if (puntosMartina > puntosbenja) {
                Vmartina++;
            } else if (puntosMartina< puntosbenja) {
                VBenjamin++;
            } else {
               empate++;
            }
        }
        System.out.println(Vmartina + " " + VBenjamin + " " + empate);
    }

}
