/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taller1;

import java.io.IOException;
import ucn.*;

public class Taller1 {

    public static void menu(String[] nombreClientes, int[] destino, int[] mesViaje, int[] destino2, String[] nombreCiudad, int[] valorViaje, int cont, int cont2, int[][] matriz, int [][]matriz2, String []listaClientes) {
        int seleccion = 0;
        while (seleccion != 5) {

            StdOut.println("");
            StdOut.println("MENU");
            StdOut.println("1. Viajes por mes ");
            StdOut.println("2. Registro de clientes");
            StdOut.println("3. Las 3 ciudades mas visitadas");
            StdOut.println("4. clientes que realizaron mas viajes ne el año");
            StdOut.println("5. Salir");
            StdOut.print("> ");
            seleccion = StdIn.readInt();

            switch (seleccion) {

                case 1:
                    cantidadViajesPorMes(nombreCiudad, valorViaje, matriz);
                    StdOut.println("Archivo ViajesPorMes.txt creado!");
                    break;

                case 2:
                    infoClientes(matriz2, listaClientes, nombreCiudad, valorViaje);
                    break;
                case 3:
                    tresCiudadesMasVisitadas(matriz, nombreCiudad);
                    break;
                case 4:
                    cuatroClientesConMasViajes(matriz2, listaClientes, valorViaje);
                    break;
                case 5:
                    StdOut.println("FIN");
                    break;

            }
        }
    }

    public static void main(String[] args) throws IOException {

        //vectores viajes.txt
        String[] nombreClientes = new String[999];
        int[] destino = new int[999];
        int[] mesViaje = new int[999];

        // vectores destinos.txt
        int[] destino2 = new int[10];
        String[] nombreCiudad = new String[10];
        int[] valorViaje = new int[10];
        // contadores retornados del txt viajes y destinos , estos contienen la cantidad de lineas o la cantidad de información de cada txt
        int cont = LeerViajes(nombreClientes, destino, mesViaje);
        int cont2 = LeerDestinos(destino2, nombreCiudad, valorViaje);
        // matrices retornadas 
        int[][] matriz = matrizCantViajes(nombreClientes, destino, mesViaje, cont, destino2, nombreCiudad, valorViaje, cont2);// esta matriz retorna la cantidad de veces que en un mes se viaja a una ciudad en particular
        int [][] matriz2= clientesXciudad(cantClientes(nombreClientes), nombreClientes, destino, cont);// esta matriz retorna la cantidad de veces que un cliente visita una ciudad en particular
       
        menu(nombreClientes, destino, mesViaje, destino2, nombreCiudad, valorViaje, cont, cont2, matriz, matriz2, cantClientes(nombreClientes));// aca se llama  al procedimiento menú, también se puede hacer sin procedimiento y ponerse direccto , pero por temas de orden es mejor  un procedimiento

    }
/*
    esta función me lee  el txt viajes y rellena los vectores vacios , ademas retorna un contador con la cantidad de datos
    */ 
    public static int LeerViajes(String[] nombreClientes, int[] destino, int[] mesViaje) throws IOException {

        ArchivoEntrada arch1 = new ArchivoEntrada("viajes.txt");

        int cont = 0;

        while (!arch1.isEndFile()) {
            Registro regEnt = arch1.getRegistro();

            nombreClientes[cont] = regEnt.getString();
            destino[cont] = regEnt.getInt();
            mesViaje[cont] = regEnt.getInt();

            cont++;

        }
        return cont;
    }
/*
    esta funcion lee el txt destinos , rellena los vectores  vacios y retorna un contador , llamado cont2 para diferenciarlo del  otro contador el cual contiene la cantidad de datos
    */
    public static int LeerDestinos(int[] destino2, String[] nombreCiudad, int[] valorViaje) throws IOException {

        ArchivoEntrada arch1 = new ArchivoEntrada("destinos.txt");

        int cont2 = 0;

        while (!arch1.isEndFile()) {
            Registro regEnt = arch1.getRegistro();

            destino2[cont2] = regEnt.getInt();
            nombreCiudad[cont2] = regEnt.getString();
            valorViaje[cont2] = regEnt.getInt();

            cont2++;

        }
        return cont2;
    }
    /*
    esta  función me retorna la cantidad de viajes a una  ciudad por mes 
    */
    public static int[][] matrizCantViajes(String[] nombreClientes, int[] destino, int[] mesViaje, int cont, int[] destino2, String[] nombreCiudad, int[] valorViaje, int cont2) {
        int[][] cantViajesPorMes = new int[12][10];

        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < cont; j++) {
                if (mesViaje[j] == (i + 1)) {
                    cantViajesPorMes[i][destino[j] - 1]++;
                }
            }
        }
        return cantViajesPorMes;
    }
    
    /*
    este procedimiento crea un archivo de salida  con la informacioón por mes , de la ciudad y las veces que  se  visitó , además el dinero total del mes
    */
    public static void cantidadViajesPorMes(String[] ciudad, int[] valorViaje, int[][] cantViajesPorMes) {
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        Out salida = new Out("ViajesPorMes.txt");

        for (int i = 0; i < 12; i++) {
            salida.println("Informacion mes de " + meses[i]);
            salida.println("----------------------");
            int dinero = 0;

            for (int j = 0; j < 10; j++) {
                salida.println("Ciudad : " + ciudad[j] + ", cantidad de viajes: " + cantViajesPorMes[i][j]);
                dinero = dinero + (cantViajesPorMes[i][j] * valorViaje[j]);
            }
            salida.println("Dinero recaudado en el mes de " + meses[i] + ": " + dinero);
            salida.println("------------------------------------------------------");
            salida.println();

        }
        salida.close();

    }
    /*
    esta función  calcula la cantidad de clientes que hay sin repetir y los guarda en una vector llamado listaClientes , la cual es retornada
    */
  
    public static String [] cantClientes(String[] nombresClientes){
        String []clientesSinRepetir = new String [100];
        int cantClientes=0;
        for(int i=0; i<10; i++){
            int j=0;
            for(j=0; j<100; j++){
                if(nombresClientes[i].equals(clientesSinRepetir[j])){
                    break;
                }
            }
            if(j==100){
                clientesSinRepetir[cantClientes]=nombresClientes[i];
                cantClientes++;
            }
        }
       
        String []listaClientes= new String[cantClientes];
        int cantClientes2=0;
        for(int i=0; i<10; i++){
            int j=0;
            for(j=0; j<cantClientes; j++){
                if(nombresClientes[i].equals(listaClientes[j])){
                    break;
                }
            }
            if(j==cantClientes){
                listaClientes[cantClientes2]=nombresClientes[i];
                cantClientes2++;
            }
        }
        
        return listaClientes;
    }
    /*
    esta función nos retorna la cantidad de veces  que un cliente va  a cada ciudad
    */
    public static int [][] clientesXciudad (String []listaClientes, String[] nombreClientes, int[] destino, int cant){
        int [][] matriz= new int [listaClientes.length][10];
        for( int i=0; i<listaClientes.length; i++){
            for(int j=0; j<cant; j++){
                if(nombreClientes[j].equals(listaClientes[i])){
                    matriz[i][destino[j]-1]++;
                }
            }
        }
        return matriz;
    }
    
    /*
    este procedimiento crea un archivo de salida con datos de cada cliente sin repetir , primero se vera el nombre del cliente , luego la cantidad de veces que visitó una ciudad y al final el monto total que gasto
    */
    public static void infoClientes(int [][] matriz2, String []listaClientes, String []ciudad, int[] valorViaje){
        Out salida = new Out("Clientes.txt");
        for(int i=0; i<matriz2.length; i++){
            salida.println("Datos del cliente "+ listaClientes[i] +" :");
            for(int j=0; j<matriz2[0].length; j++){
                if(matriz2[i][j]>0){
                    salida.println("Visitas en la ciudad "+ ciudad[j]+ " : "+ matriz2[i][j] + ", su dinero gastado es de: "+ (matriz2[i][j]*valorViaje[j]));
                }
            }
            salida.println();
        }
        salida.close();
    }
   
    /*
    este procedimiento despliega por pantalla las 3 ciudades mas visitadas, para esto primero sumamos todas las visitas de cada ciudad en cada mes, luego se ordenan de mayor a menos 
    y imprimimos con un for las tres primeras
    */    

    public static void tresCiudadesMasVisitadas(int[][] cantViajesPorMes, String[] ciudad) {
        int[] visitasXaño = new int[10];
        for (int i = 0; i < 10; i++) {
            int cont = 0;
            for (int j = 0; j < 12; j++) {
                cont = cont + cantViajesPorMes[j][i];
            }
            visitasXaño[i] = cont;
        }
        //ordenamiento burbuja para ordenar los datos de mayor a menor
        for (int i = 0; i <= 8; i++) {
            for (int j = i + 1; j <= 9; j++) {
                if (visitasXaño[i] < visitasXaño[j]) {
                    int aux = visitasXaño[i];
                    String aux2= ciudad[i];
                    visitasXaño[i] = visitasXaño[j];
                    ciudad[i]= ciudad[j];
                    visitasXaño[j] = aux;
                    ciudad[j]= aux2;
                }
            }
        }
        StdOut.println("Las tres ciudades mas visitadas son:");
        for(int i= 0; i<3; i++){// despliegue de las 3 primeras ciudades
            StdOut.println(ciudad[i] + ": " + visitasXaño[i]+ " visitas");
        }
    }
    /*
    este procedimiento despliega los 4 clientes con mas viajes , para esto recorremos cada cliente , contamos los  viajes sumando las veces que viajó  usando la matriz2 la que contiene 
    las visitas por cliente , luego sumamos los valores sumando los resultados de la multiplicación de la cantidad por el precio de cada  ciudad
     despues  se ordenan los datos de mayor a menos y se despliegan los 4 primeros con los premios respectivos    */
    public static void cuatroClientesConMasViajes(int [][]matriz2, String [] listaClientes, int []valorViaje){
        int[] cantXcliente = new int[listaClientes.length];
        int[] valorXcliente= new int[listaClientes.length];
        
        for (int i = 0; i < listaClientes.length; i++) {
            int cont = 0;
            int valor=0;
            for (int j = 0; j < 10; j++) {
                cont = cont + matriz2[i][j];
                valor= valor + (matriz2[i][j]* valorViaje[j]);
            }
            cantXcliente[i] = cont;
            valorXcliente[i]= valor;
        }
        // ordenamiento burbuja para  ordenar los datos de mayor  a menor
        for (int i = 0; i <= listaClientes.length-2; i++) {
            for (int j = i + 1; j <= listaClientes.length-1; j++) {
                if (cantXcliente[i] < cantXcliente[j]) {
                    int aux = cantXcliente[i];
                    String aux2= listaClientes[i];
                    int aux3= valorXcliente[i];
                    cantXcliente[i] = cantXcliente[j];
                    listaClientes[i]= listaClientes[j];
                    valorXcliente[i]= valorXcliente[j];
                    cantXcliente[j] = aux;
                    listaClientes[j]= aux2;
                    valorXcliente[j]= aux3;
                }
            }
        }
        StdOut.println("Los clientes que realizaron mas viajes son:");
        for(int i= 0; i<4; i++){// despliegue de los 4 primeros con los  premios
            StdOut.print(listaClientes[i] + ": " + cantXcliente[i]+ " viajes, el total gastado es de: "+ valorXcliente[i]);
            if(i==0){
                StdOut.println(" (obtiene un 75% de descuento en su próximo viaje)");
            }else{
                if(i==1){
                    StdOut.println(" (obtiene un 60% de descuento en su próximo viaje)");
                }else{
                    if(i==2){
                        StdOut.println(" (obtiene un 45% de descuento en su próximo viaje)");
                        
                    }else{
                        StdOut.println(" (obtiene un 30% de descuento en su próximo viaje)");
                            
                        }
                    }
                }
            }
        }
        
    }

