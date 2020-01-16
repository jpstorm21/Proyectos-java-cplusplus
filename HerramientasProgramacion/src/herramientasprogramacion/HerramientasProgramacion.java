/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramientasprogramacion;

import ucn.*;

/**
 *
 * @author Usuario
 */
public class HerramientasProgramacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        In entrada = new In("mantenciones.txt");
        Double [][] matriz = {{6.0, 4.0, 20.0, 2.0},
                            {12.0, 16.0, 48.0, 6.0},
                            {44.0, 40.0, 140.0, 6.0},
                            {2.0, 3.0, 5.0, 0.5},};
        String [] tipos = {"C","B","P","M"};
        String [] motivos = {"M","E","R","I"};
        String[] maquinas = new String[30];
        String[] trabajadores = new String[30];
        double [][] horas =  new double[30][30];
        int cantTrabajador = 0;
        int cantMaquinas = 0;
        while(!entrada.isEmpty()){
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            String cod = linea[0];
            String rut = linea[1];
            String tipo = linea[2];
            String motivo = linea[3];
            
            int posTrabajador =0;           
            boolean estaba = false;                    
            for (int i = 0; i < cantTrabajador; i++) {
                if (rut.equalsIgnoreCase(trabajadores[i])) {
                    posTrabajador = i;
                    estaba = true;
                    break;
                }
            }
            if(estaba == false){
                posTrabajador = cantTrabajador;
                trabajadores[posTrabajador]=rut;
                cantTrabajador++;
            }
            int posMaquinas = 0;
            boolean estaba2 = false;                       
            for (int i = 0; i < cantMaquinas; i++) {
                if (cod.equalsIgnoreCase(maquinas[i])) {
                    posMaquinas = i;
                    estaba = true;
                    break;
                }
            }
            if(estaba2 == false){
                posMaquinas = cantMaquinas;
                maquinas[posMaquinas ]=cod;
                cantMaquinas++;
            }
            

            int pos = 0;
            for(int w = 0;w<4;w++){
                if(tipo.equalsIgnoreCase(tipos[w])){
                    pos = w;
                    break;
                }
            }
            int pos2=0;
            for(int j = 0;j<4;j++){
                if(motivo.equalsIgnoreCase(motivos[j])){
                    pos2 = j;
                    break;
                }
            }
            double hora = matriz[pos][pos2];
            horas[posTrabajador][posMaquinas] = hora;
        }
        
        for(int i =0;i<cantTrabajador;i++){
            StdOut.println("rut: " + trabajadores[i]);
            double suma = 0;
            for(int j = 0;j<cantMaquinas;j++){
                if(horas[i][j] != 0.0){
                      StdOut.println(maquinas[j] + " : " + horas[i][j] + " horas");
                }
                suma = suma +  horas[i][j];
            }
            StdOut.println("total: " + suma + " horas");    
        }        
    }
}
