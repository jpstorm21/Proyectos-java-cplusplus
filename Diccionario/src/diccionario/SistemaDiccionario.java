/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diccionario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author Usuario
 */
public class SistemaDiccionario implements InterfaceDiccionario {

    private ArrayList<Palabra> Diccionario;

    public SistemaDiccionario() {
        this.Diccionario = new ArrayList<Palabra>();
    }

    @Override
    public void insertarPalabra(String palabra, String Significado) {
        Palabra P = new Palabra(palabra, Significado);
        Diccionario.add(P);
    }

    @Override
    public String buscarSignificado(String palabra) {
        String significado = "";
        for (Palabra iterador : Diccionario) {
            if (iterador.getNombre().equalsIgnoreCase(palabra)) {
                significado = iterador.getSignificado();
                break;
            }
        }
        return significado;
    }

    @Override
    public String [] listadoPalabras() {
        String [] palabras = new String[Diccionario.size()];
        Collections.sort(Diccionario, new Comparator<Palabra>() {
            public int compare(Palabra P1, Palabra P2) {
                return P1.getNombre().compareTo(P2.getNombre());
            }
        });
        for (int i = 0; i<Diccionario.size();i++) {
            palabras[i] = Diccionario.get(i).getNombre() + ",";
        }
        return palabras;
    }

    @Override
    public String [] listaPalabrasP(String letra) {
        String [] palabras = new String[Diccionario.size()];
        for (int i = 0; i<Diccionario.size();i++) {
            if (Diccionario.get(i).getNombre().charAt(0) == letra.charAt(0)) {
                palabras[i] = Diccionario.get(i).getNombre() + ",";
            }
        }
        return palabras;
    }
}
