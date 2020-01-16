package taller1.pkg2018.s1;

import ucn.*;

/**
 *
 * @author Juan Pablo Martinez
 */
public class Taller12018S1 {

    public static int leerProductos(String[][] Mproductos) {
        int pos = 0;
        In entrada = new In("productos.txt");
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            Mproductos[pos][0] = linea[0];
            Mproductos[pos][1] = linea[1];
            Mproductos[pos][2] = linea[2];
            Mproductos[pos][3] = linea[3];
            pos++;
        }
        entrada.close();
        return pos;
    }

    public static int leerClientes(String[][] Mclientes) {
        int pos = 0;
        In entrada = new In("clientes.txt");
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            Mclientes[pos][0] = linea[0];
            Mclientes[pos][1] = linea[1];
            Mclientes[pos][2] = linea[2];
            pos++;
        }
        entrada.close();
        return pos;
    }

    public static int leerCompras(String[][] Mcompras) {
        int pos = 0;
        In entrada = new In("compras.txt");
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            Mcompras[pos][0] = linea[0];
            Mcompras[pos][1] = linea[1];
            Mcompras[pos][2] = linea[2];
            Mcompras[pos][3] = linea[3];
            pos++;
        }
        entrada.close();
        return pos;
    }

    public static int rankingClientes(String[][] Mclientes, String[][] Mproductos, String[][] Mcompras, int cantProductos, int cantClientes, int cantCompras, String[][] RankingClientes) {
        int pos = 0;
        for (int i = 0; i < cantClientes; i++) {
            String cliente = Mclientes[i][0];
            int cant = 0;
            String ultimoDia = "";
            Double ganancia = obtenerGananciaCliente(Mproductos, Mcompras, cantProductos, cantCompras, cliente);
            for (int j = 0; j < cantCompras; j++) {
                if (Mcompras[j][0].equalsIgnoreCase(cliente)) {
                    String[] fecha = Mcompras[j][2].split("-");
                    String dia = fecha[0];
                    if (!dia.equals(ultimoDia)) {
                        cant++;
                        ultimoDia = dia;
                    }
                }
            }
            Double puntajeCliente = ganancia * cant;
            int puntaje = (int) puntajeCliente.doubleValue();
            RankingClientes[pos][0] = cliente;
            RankingClientes[pos][1] = String.valueOf(puntaje);
            pos++;
        }
        return pos;
    }

    public static String buscarClientes(String[][] Mclientes, int cantClientes, String rut) {
        String cliente = "";
        for (int i = 0; i < cantClientes; i++) {
            if (Mclientes[i][0].equalsIgnoreCase(rut)) {
                cliente = Mclientes[i][0];
                break;
            }
        }
        return cliente;
    }

    public static Double obtenerGananciaCliente(String[][] Mproductos, String[][] Mcompras, int cantProductos, int cantCompras, String cliente) {
        Double ganancia = 0.0;
        for (int i = 0; i < cantCompras; i++) {
            if (Mcompras[i][0].equalsIgnoreCase(cliente)) {
                String sku = Mcompras[i][1];
                Double porcentaje = 0.0;
                Double gananciaEmpresa = 0.0;
                for (int j = 0; j < cantProductos; j++) {
                    if (Mproductos[j][0].equalsIgnoreCase(sku)) {
                        porcentaje = Double.parseDouble(Mproductos[j][3]) / 100;
                        gananciaEmpresa = Double.parseDouble(Mproductos[j][2]) * porcentaje;
                        break;
                    }
                }
                ganancia = ganancia + gananciaEmpresa;
            }
        }
        return ganancia;
    }

    public static void main(String[] args) {
        String[][] Mproductos = new String[999][4];
        String[][] Mclientes = new String[999][3];
        String[][] Mcompras = new String[999][4];
        String[][] RankingClientes = new String[999][2];
        int cantProductos = leerProductos(Mproductos);
        int cantClientes = leerClientes(Mclientes);
        int cantCompras = leerCompras(Mcompras);
        int cantRanking = rankingClientes(Mclientes, Mproductos, Mcompras, cantProductos, cantClientes, cantCompras, RankingClientes);
        System.out.println("RUT    PUNTAJE");
        for (int i = 0; i < cantClientes; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(RankingClientes[i][j] + " ");
            }
            System.out.println("");
        }
        if(cantClientes ==cantRanking ){
            System.out.println("exito");
        }
    }
}
