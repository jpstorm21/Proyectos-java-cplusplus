/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scripgames;

import ucn.*;

/**
 *
 * @author Juan Pablo Martinez
 */
public class ScripGames {

    public static void leerGames() {
        In archivo = new In("games.txt");
        Out salida = new Out("insert.txt");
        int i = 1;
        int cantMalos1 = 0;
        int cantMalos2 = 0;
        while (!archivo.isEmpty()) {
            String insert = "";
            String insert2 = "";
            String insert3 = "";
            String leelinea = archivo.readLine();
            String[] linea = leelinea.split(",");
            insert = "INSERT INTO juegos(idjuego,nombrejuego, idcategoria) VALUES ("+i+","+"'"+linea[0]+"'"+","+linea[3]+");";
            insert2= "INSERT INTO plataformajuego(idjuego,idplataforma) VALUES("+i+",1);";
            int estado = 0;
            boolean instalado = false;
            if (linea[1].equalsIgnoreCase("me lo pase")) {
                estado = 1;
            } else if (linea[1].equalsIgnoreCase("multiplayer")) {
                estado = 1;
            }
            if (linea[2].equalsIgnoreCase("instalado")) {
                instalado = true;
            }
            insert3 = "INSERT INTO usuariojuego(idjuego,estado,nombreusuario,instalado) VALUES("+i+","+"'"+estado+"'"+",'19.042.481-2',"+instalado+");";
            System.out.println(insert);
            System.out.println(insert2);
            System.out.println(insert3);
            i++;
        }
        System.out.println("Cantidad de juegos: " + i);
        //System.out.println("Cantidad de juegos que no cumplen el estado: " + cantMalos1);
        //System.out.println("Cantidad de juegos que no cumplen el instalado: " + cantMalos2);
        archivo.close();
    }

    public static void main(String[] args) {
        leerGames();
    }

}
