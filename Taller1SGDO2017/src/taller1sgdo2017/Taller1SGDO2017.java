package taller1sgdo2017;

import ucn.*;

public class Taller1SGDO2017 {

    public static int leerJuegos(String[][] Mjuegos) {
        In entrada = new In("juegos.txt");
        int pos = 0;
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            Mjuegos[pos][0] = linea[0];
            Mjuegos[pos][1] = linea[1];
            Mjuegos[pos][2] = linea[2];
            Mjuegos[pos][3] = linea[3];
            Mjuegos[pos][4] = linea[4];
            Mjuegos[pos][5] = linea[5];
            pos++;
        }
        entrada.close();
        return pos;
    }

    public static int leerCategorias(String[][] Mcatego) {
        In entrada = new In("categorias.txt");
        int pos = 0;
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            Mcatego[pos][0] = linea[0];
            Mcatego[pos][1] = linea[1];
            pos++;
        }
        entrada.close();
        return pos;
    }

    public static void RF1(String[][] Mjuegos, int cantJuegos) {
        int cantVendidad = 0;
        double ganancia = 0.0;
        System.out.print("ingrese año del juego: ");
        String año = StdIn.readString();
        for (int i = 0; i < cantJuegos; i++) {
            if (Mjuegos[i][2].equalsIgnoreCase(año)) {
                int precio = Integer.parseInt(Mjuegos[i][3]);
                Double porcentaje = Double.parseDouble(Mjuegos[i][4]) / 100;
                int cantidad = Integer.parseInt(Mjuegos[i][5]);
                double g = ((precio * porcentaje) * cantidad);
                if (Integer.parseInt(Mjuegos[i][5]) > cantVendidad) {
                    cantVendidad = Integer.parseInt(Mjuegos[i][5]);
                }
                if (g > ganancia) {
                    ganancia = g;
                }
            }
        }
        System.out.println("el  o los juegos de mas unidades vendidas es : ");
        for (int i = 0; i < cantJuegos; i++) {
            if (Integer.parseInt(Mjuegos[i][5]) == cantVendidad) {
                System.out.println("-" + Mjuegos[i][1]);
            }
        }
        System.out.println("-con una cantidad de : " + cantVendidad);
        System.out.println("el o los juegos con mas ganacias es : ");
        for (int j = 0; j < cantJuegos; j++) {
            int precio = Integer.parseInt(Mjuegos[j][3]);
            double porcentaje = Double.parseDouble(Mjuegos[j][4]) / 100;
            int cantidad = Integer.parseInt(Mjuegos[j][5]);
            double g = ((precio * porcentaje) * cantidad);
            if (Double.compare(g, ganancia) == 0) {
                System.out.println("-" + Mjuegos[j][1]);
            }
        }
        System.out.println("-con una ganancia de : $" + (int) ganancia);
    }

    public static void RF2(String[][] Mjuegos, String[][] Mcatego, int cantJuegos, int cantCatego) {
        System.out.print("ingrese categoria(-1 para terminar): ");
        String catego = StdIn.readString();
        while (!catego.equalsIgnoreCase("-1")) {
            String[] vector = new String[cantCatego];
            int pos = vectorCatego(Mcatego, cantCatego, vector, catego);
            String[][] Mganancia = new String[pos][2];
            int cant = 0;
            for (int i = 0; i < pos; i++) {
                String cod = vector[i];
                double plata = 0.0;
                for (int j = 0; j < cantJuegos; j++) {
                    if (Mjuegos[j][0].equalsIgnoreCase(cod)) {
                        if (buscarXnombre(Mganancia, Mjuegos[j][1], cant) == false) {
                            int precio = Integer.parseInt(Mjuegos[j][3]);
                            Double porcentaje = Double.parseDouble(Mjuegos[j][4]) / 100;
                            int cantidad = Integer.parseInt(Mjuegos[j][5]);
                            plata = ((precio * porcentaje) * cantidad);
                            Mganancia[cant][0] = Mjuegos[j][1];
                            Mganancia[cant][1] = String.valueOf(plata);
                            cant++;
                        }
                    }
                }
            }
            double ganancia = 0.0;
            for (int i = 0; i < cant; i++) {
                ganancia = ganancia + Double.parseDouble(Mganancia[i][1]);
            }
            System.out.println("la ganancia todal de los juegos de la categoria : " + catego + " es: $" + (int) ganancia);
            System.out.print("ingrese categoria(-1 para terminar): ");
            catego = StdIn.readString();
        }
    }

    public static void RF3(String[][] Mjuegos, String[][] Mcatego, int cantJuegos, int cantCatego) {
        System.out.print("ingrese una categoria: ");
        String categoria = StdIn.readString();
        Out salida = new Out("top-ten-" + categoria + ".txt");
        String[] codJuegos = new String[cantCatego];
        int pos = vectorCatego(Mcatego, cantCatego, codJuegos, categoria);
        String[][] m = new String[pos][2];
        int cant = 0;
        for (int i = 0; i < pos; i++) {
            String cod = codJuegos[i];
            for (int j = 0; j < cantJuegos; j++) {
                if (Mjuegos[j][0].equalsIgnoreCase(cod)) {
                    if (buscarXnombre(m, Mjuegos[j][1], cant) == false) {
                        m[cant][0] = Mjuegos[j][1];
                        m[cant][1] = Mjuegos[j][5];
                        cant++;
                    }
                }
            }
        }
        int vector[] = new int[cant];
        String[][] Mfinal = ordenar(m, cant, vector);
        salida.println("juegos                             cantidad vendiddas");
        for (int i = 0; i < cant; i++) {
            salida.print(Mfinal[i][0] + "                             " + Mfinal[i][1]);
            salida.println();
        }
        System.out.println("archivo generado");
    }

    public static String[][] ordenar(String[][] matriz, int pos, int[] vector) {//ordenar la matriz[juegos][cantidad] por cantidad de mayor a menor
        String[][] Mordenada = new String[pos][2];
        for (int i = 0; i < pos; i++) {
            vector[i] = Integer.parseInt(matriz[i][1]);
        }
        ordenarVector(vector, pos);
        int pos1 = 0;
        for (int i = 0; i < pos; i++) {
            int cantidad = vector[i];
            for (int j = 0; j < pos; j++) {
                if (Integer.parseInt(matriz[j][1]) == cantidad) {
                    Mordenada[pos1][0] = matriz[j][0];
                    Mordenada[pos1][1] = matriz[j][1];
                    pos1++;
                }
            }
        }
        return Mordenada;
    }

    public static void ordenarVector(int[] arreglo, int pos) {//ordenamiento de un vector de enteros
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = 0; j < arreglo.length - 1; j++) {
                if (arreglo[j] < arreglo[j + 1]) {
                    int tmp = arreglo[j + 1];
                    arreglo[j + 1] = arreglo[j];
                    arreglo[j] = tmp;
                }
            }
        }
    }

    public static int vectorCatego(String[][] Mcatego, int cantCatego, String[] codJuegos, String categoria) {//sirve para rellenar un vector con codigos de juegos de una cierta categoria
        int pos = 0;
        for (int i = 0; i < cantCatego; i++) {
            if (Mcatego[i][1].equalsIgnoreCase(categoria)) {
                codJuegos[pos] = Mcatego[i][0];
                pos++;
            }
        }
        return pos;
    }

    public static boolean buscarXnombre(String[][] m, String nom, int pos) {//sirve buscar un juego dentro de una matriz recibida por parametro
        boolean encontrado = false;
        for (int i = 0; i < pos; i++) {
            if (m[i][0].equalsIgnoreCase(nom)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }

    public static void menu(String[][] Mjuegos, String[][] Mcatego, int cantJuegos, int cantCatego) {
        int opcionmenu = 0;
        while (opcionmenu != 4) {
            System.out.println("Bienvenido al sistema Zmart: ");
            System.out.println("1-juego mas vendido y juego con mas ganacia");
            System.out.println("2-ganancia total de un juego de cierta categoria");
            System.out.println("3-top-ten-categoria");
            System.out.println("4-salir");
            System.out.println("------------------");
            System.out.print("ingrese opcion: ");
            opcionmenu = StdIn.readInt();
            switch (opcionmenu) {
                case 1:
                    RF1(Mjuegos, cantJuegos);
                    System.out.println("------------------");
                    break;
                case 2:
                    RF2(Mjuegos, Mcatego, cantJuegos, cantCatego);
                    System.out.println("------------------");
                    break;
                case 3:
                    RF3(Mjuegos, Mcatego, cantJuegos, cantCatego);
                    System.out.println("------------------");
                    break;
                default:
                    opcionmenu = 4;
            }

        }
    }

    public static void main(String[] args) {
        String[][] Mjuegos = new String[999][6];
        String[][] Mcatego = new String[999][2];
        int cantJuegos = leerJuegos(Mjuegos);
        int cantCatego = leerCategorias(Mcatego);
        menu(Mjuegos, Mcatego, cantJuegos, cantCatego);
    }

}
