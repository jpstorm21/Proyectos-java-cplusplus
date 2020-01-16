package taller1;
//* Autores: Juan Martinez y Leonel Villagra
//* NOTA: Leimos los archivos de la forma antigua, debido a que con el registro se nos ocasionaron algunos problemas

import ucn.*;

public class Taller1 {

    /**
     *
     * @param matrizproducto Esta es la Matriz donde guardaremos los datos de
     * productos del Archivo txt
     * @param matrizventa Esta es la Matriz donde guardaremos los datos de
     * ventas del Archivo txt
     * @param cantproducto Es la cantidad de datos que leyo en la matriz
     * productos
     * @param cantventa Es la cantidad de datos que leyo en la matriz ventas
     * @param categorias Es un vector que contiene las Categorias del problema
     * @param catemes Es una matriz que en las filas lleva las categorias y en
     * las columnas los meses
     *
     * El Procedimiento Menu tiene como objetivo dar a conocer las opciones al
     * usuario y una vez seleccionada comenzar a trabajar con los datos
     * requeridos
     */
    public static void menu(String[][] matrizproducto, int[][] matrizventa, int cantproducto, int cantventa, String[] categorias, int[][] catemes) {
        int opcionmenu = 0;
        while (opcionmenu != 5) {
            StdOut.println("menu: ");
            StdOut.println("RF1(venta por mes)");
            StdOut.println("RF2(dia con mayor recaudacion)");
            StdOut.println("RF3(promedio)");
            StdOut.println("RF4(total de ventas)");
            StdOut.println("RF5(salir)");
            StdOut.println("------------------");
            StdOut.println("ingrese opcion: ");
            opcionmenu = StdIn.readInt();
            if (opcionmenu == 1) {
                Taller1.RF1(catemes, categorias);
            }
            if (opcionmenu == 2) {
                Taller1.RF2(matrizproducto, matrizventa, cantproducto, cantventa);
            }
            if (opcionmenu == 3) {
                Taller1.RF3(catemes, categorias);
            }
            if (opcionmenu == 4) {
                Taller1.RF4(catemes, categorias);
            }

        }
    }

    /**
     *
     * @param matrizventa Esta es la Matriz donde guardaremos los datos de
     * ventas del Archivo txt
     * @return Retorna el tamaño de la matriz venta
     */
    public static int leeventas(int[][] matrizventa) {
        int pos = 0;
        In entrada = new In("ventas.txt");
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            matrizventa[pos][0] = Integer.parseInt(linea[0]);
            matrizventa[pos][1] = Integer.parseInt(linea[1]);
            matrizventa[pos][2] = Integer.parseInt(linea[2]);
            matrizventa[pos][3] = Integer.parseInt(linea[3]);
            pos++;
        }
        entrada.close();
        return pos;

    }

    /**
     *
     * @param matrizproducto Esta es la Matriz donde guardaremos los datos de
     * productos del Archivo txt
     * @return Retorna el tamaño de la matriz productos
     */
    public static int leeproductos(String[][] matrizproducto) {
        int pos = 0;
        In entrada = new In("productos.txt");
        while (!entrada.isEmpty()) {
            String leelinea = entrada.readLine();
            String[] linea = leelinea.split(",");
            matrizproducto[pos][0] = linea[0];
            matrizproducto[pos][1] = linea[1];
            matrizproducto[pos][2] = linea[2];
            matrizproducto[pos][3] = linea[3];
            pos++;
        }
        entrada.close();
        return pos;

    }

    /**
     * Los parametros de esta funcion son los mismos que fueron mencionados
     * anteriormente
     *
     * @param matrizproducto
     * @param matrizventa
     * @param cantproducto
     * @param cantventa
     * @param categorias
     * @param catemes
     *
     * El objetivo de este procedimiento es calcular la venta de cada categoria
     * en cada mes
     */

    public static void mesventa(String[][] matrizproducto, int[][] matrizventa, int cantproducto, int cantventa, String[] categorias, int[][] catemes) {
        for (int i = 0; i < cantventa; i++) {
            String codigoproducto = Integer.toString(matrizventa[i][0]);
            int cant = matrizventa[i][1];
            int mes = matrizventa[i][3];
            String catego = "";
            int precio = 0;
            for (int j = 0; j < cantproducto; j++) {
                if (codigoproducto.equals(matrizproducto[j][0])) {
                    precio = Integer.parseInt(matrizproducto[j][2]);
                    catego = matrizproducto[j][3];
                    break;
                }
            }
            int w;
            for (w = 0; w <= 12; w++) {
                if (catego.equals(categorias[w])) {
                    break;

                }
            }
            catemes[w][mes - 1] = catemes[w][mes - 1] + cant * precio;
        }
    }

    /**
     * Los siguientes parametros fueron definidos anteriormente
     *
     * @param catemes
     * @param categorias
     *
     * En el procedimiento RF1, despliega las ventas de cada categoria en un mes
     * especifico
     */
    public static void RF1(int[][] catemes, String[] categorias) {
        StdOut.print("por favor ingrese mes que se desea examinar: ");
        int mes = StdIn.readInt();
        while (mes < 1 || mes > 12) {
            StdOut.println("mes ingresado no valido ingrese nuevamente:");
            mes = StdIn.readInt();
        }
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        StdOut.println("--------------------------------------------");
        StdOut.println(" las ventas del mes " + "" + meses[mes - 1] + " para cada categoria son: ");
        for (int i = 0; i <= 12; i++) {
            StdOut.println(categorias[i] + ":" + catemes[i][mes - 1]);
        }

    }

    /**
     * Los siguientes parametros fueron definidos anteriormente
     *
     * @param matrizproducto
     * @param matrizventa
     * @param cantproducto
     * @param cantventa
     *
     * El procedimiento RF2 despliega el dia con mayor ingreso dentro de un mes
     * especifico
     */
    public static void RF2(String[][] matrizproducto, int[][] matrizventa, int cantproducto, int cantventa) {
        int[] diames = new int[31];
        StdOut.print("por favor ingrese mes que se desea examinar: ");
        int mes = StdIn.readInt();
        while (mes < 1 || mes > 12) {
            StdOut.println("mes ingresado no valido ingrese nuevamente:");
            mes = StdIn.readInt();
        }
        String[] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
        for (int i = 0; i < cantventa; i++) {
            if (mes == matrizventa[i][3]) {
                int cant = matrizventa[i][1];
                int dia = matrizventa[i][2];
                String codigoproducto = Integer.toString(matrizventa[i][0]);
                int precio = 0;
                for (int j = 0; j < cantproducto; j++) {
                    if (codigoproducto.equals(matrizproducto[j][0])) {
                        precio += Integer.parseInt(matrizproducto[j][2]);
                        break;
                    }

                }
                diames[dia - 1] = diames[dia - 1] + precio * cant;
            }

        }
        int mayor = 0;
        int Ndia = -1;
        for (int i = 0; i < 31; i++) {
            if (diames[i] > mayor) {
                mayor = diames[i];
                Ndia = i + 1;
            }
        }
        StdOut.println("el dia del mes de " + meses[mes - 1] + " con mayor recaudacion es el dia : " + Ndia + " con un monto de :" + mayor);
    }

    /**
     * Los siguientes parametros fueron definidos anteriormente
     *
     * @param catemes
     * @param categorias
     *
     * El procedimiento RF3 despliega un archivo txt llamado promedio, que en el
     * conlleva el promedio anual de las ventas en cada categoria
     */
    public static void RF3(int[][] catemes, String[] categorias) {
        Out salida = new Out("promedio.txt");
        salida.print(" el promedio anual de las ventas en cada categorias es: ");
        for (int i = 0; i < 13; i++) {
            int sumanual = 0;
            for (int j = 0; j < 12; j++) {
                sumanual = sumanual + catemes[i][j];

            }
            salida.println(categorias[i] + ":" + sumanual / 12);
        }
        salida.close();
        StdOut.print("el archivo fue generado exisitosamente");
    }

    /**
     * Los siguientes parametros fueron definidos anteriomente
     *
     * @param catemes
     * @param categorias
     *
     * El procedimiento RF4 despliega un archivo txt llamado total_ventas, que
     * en el llevara el dinero recaudado por cada categoria en el año 2016 con
     * una suma total de este dinero recaudado
     */
    public static void RF4(int[][] catemes, String[] categorias) {
        Out salida = new Out("total_ventas.txt");
        salida.println(" el dinero recaudado por cada unas de las categorias en el año 2016:");
        int sumanualtotal = 0;
        for (int i = 0; i < 13; i++) {
            int sumanual = 0;
            for (int j = 0; j < 12; j++) {
                sumanual = sumanual + catemes[i][j];
            }
            sumanualtotal = sumanualtotal + sumanual;
            salida.println(categorias[i] + ": " + sumanual);
        }
        salida.println("el total en cada una de las categorias es: ");
        salida.println(" el total es : " + sumanualtotal);
        StdOut.println("el archivo fue generado exisitosamente");

    }

    public static void main(String[] args) {
        int[][] matrizventa = new int[9999][4];
        int cantventa = Taller1.leeventas(matrizventa);
        String[][] matrizproducto = new String[9999][4];
        int cantproducto = Taller1.leeproductos(matrizproducto);
        String[] categorias = {"Telefonia", "Electrohogar", "Computacion", "TV Audio", "Entretenimiento", "Muebles", "Dormitorio", "Ripley Home", "Deporte", "Infantil", "Belleza", "Zapatos y Bolsos", "Moda"};
        int[][] catemes = new int[13][12];
        Taller1.mesventa(matrizproducto, matrizventa, cantproducto, cantventa, categorias, catemes);
        Taller1.menu(matrizproducto, matrizventa, cantproducto, cantventa, categorias, catemes);

    }

}
