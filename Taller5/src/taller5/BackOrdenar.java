package taller5;

/**
 * Aquí se aplica el backtracking.
 *
 * @author
 */
public class BackOrdenar {

    //Tipos de de id
    public static enum ID {
        NADA, OBSTACULO, CAJA
    };
    //Matriz estado actual
    private char[][] matrizActual;
    private int size;
    //Todos los estados por los que ha pasado la matriz
    ListaMatrices listaMatrices;
    private int cantFallos;

    /**
     * Constructior del backtracking
     *
     * @param size Tamaño de la matriz
     */
    public BackOrdenar(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Tamaño debe ser mayor que 0");
        }
        this.size = size;
        this.matrizActual = new char[size][size];
        this.listaMatrices = new ListaMatrices();
        cantFallos++;
    }

    /**
     * Genera el estado inicial de la matriz.
     */
    public void generar() {
        this.matrizActual = new char[this.size][this.size];
        double obstaculo = 0.10; //%
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                double prob = Math.random();
                if (prob <= obstaculo) { //Zombie
                    this.matrizActual[i][j] = 'o';
                } else {
                    this.matrizActual[i][j] = 'l';
                }
            }
        }
        //Primer estado a la lista
        listaMatrices.insertarUltimo(copia());
    }

    public void eliminarUltimo(int x, int y) {
        for (int i = 10; i >= 0; i--) {
            for (int j = 10; j >= 0; j--) {
                if (matrizActual[i][j] == 'c') {
                    matrizActual[i][j] = 'l';
                    matrizActual[i - 1][j - 1] = 'l';
                    matrizActual[i][j - 1] = 'l';
                    matrizActual[i - 1][j] = 'l';
                    return;
                }
            }
        }

    }

    /**
     * Resuelve el backtracking
     */
    public void resolver() {
        this.intentar(16);
    }

    /**
     * Reinicia los datos del backGame
     */
    public void reiniciar() {
        this.listaMatrices = new ListaMatrices();
        matrizActual = new char[size][size];
    }

    /**
     * Primer TRY del backtracking
     */
    public char[][] intentar(int cantCajas) {
        char[][] sol = matrizActual;
        int x = 0;
        int y = 0;
        while (!exito(cantCajas)) {
            //seleccionar el sgte

            //si es aceptable hace algo
            if (aceptable(x, y)) {
                //registra la selección
                matrizActual[x][y] = 'c';
                matrizActual[x + 1][y] = 'c';
                matrizActual[x][y + 1] = 'c';
                matrizActual[x + 1][y + 1] = 'c';

                listaMatrices.insertarUltimo(copia());

                //si la solución es incompleta hace algo
                if (solucionIncompleta(cantCajas)) {
                    //llama al try siguiente
                    intentar(matrizActual, cantCajas, x, y);
                    //si no hay exito cancela el registro
                    if (!exito(cantCajas)) {
                        //cancela el registro
                        eliminarUltimo(x, y);
                        listaMatrices.insertarUltimo(copia());
                        System.out.println("no funciono...");

                    }
                }
            }
            y++;
            if (y >= 10) {
                y = 0;
                x++;
            }
            if (x >= 10) {
                System.out.println("Falló!");
                cantFallos++;
                if (cantFallos > 1) {
                    this.reiniciar();
                    this.generar();
                    resolver();
                }
            }
        }
        return sol;

    }

    /**
     * Segundo TRY del backtracking
     *
     * @param k Candidato
     * @param cantBombas Cantidad de bombas
     */
    private void intentar(char[][] matrizActual, int cantCajas, int x, int y) {
        int xx = x;
        int yy = y + 1;
        while (!exito(cantCajas)) {
            //selección k-esimo candidato
            if (aceptable(xx, yy)) {
                matrizActual[x][y] = 'c';
                matrizActual[x + 1][y] = 'c';
                matrizActual[x][y + 1] = 'c';
                matrizActual[x + 1][y + 1] = 'c';

                listaMatrices.insertarUltimo(copia());
                imprimir();
                if (cantCajasPuestas() < cantCajas) {
                    intentar(matrizActual, cantCajas, xx, yy);
                    if (!exito(cantCajas)) {
                        eliminarUltimo(xx, yy);
                        listaMatrices.insertarUltimo(copia());
                        //System.out.println("el dato no funciono: "+  dato);
                        //conjunto.imprimir();
                    }
                }
            }
            yy++;
            if (yy >= 10) {
                yy = 0;
                xx++;
            }
            if (xx >= 10) {
                System.out.println("falló");
                this.reiniciar();
                this.generar();
                resolver();
            }
        }
    }

    /**
     *
     *
     * @return Retorna si se guardan todas las cajas
     */
    boolean exito(int cantCajas) {
        int cant = 0;
        for (int x = 0; x < matrizActual.length - 1; x++) {
            for (int y = 0; y < matrizActual.length - 1; y++) {
                if (matrizActual[x][y] == 'c') {
                    cant++;
                }
            }
        }
        return (cantCajas == cant);
    }

    /**
     *
     * @param x Posición x caja
     * @param y Posición y caja
     * @return Si es aceptable coloca la caja.
     */
    private boolean aceptable(int posX, int posY) {
        if (posX < 9 && posY < 9) {

            if (matrizActual[posX][posY] == 'l' && matrizActual[posX + 1][posY + 1] == 'l' && matrizActual[posX + 1][posY] == 'l' && matrizActual[posX][posY + 1] == 'l') {
                return true;
            }

        }

        return false;
    }

    private int cantCajasPuestas() {
        int cant = 0;
        for (int x = 0; x < matrizActual.length - 1; x++) {
            for (int y = 0; y < matrizActual.length - 1; y++) {
                if (matrizActual[x][y] == 'c') {
                    cant++;
                }
            }
        }
        return cant;
    }

    public void imprimir() {
        System.out.println("--------------------");
        for (int i = 0; i < 10; i++) {
            System.out.print("[");
            for (int j = 0; j < 10; j++) {
                if (matrizActual[i][j] == 'l') {
                    System.out.print(" ");
                }
                System.out.print(" " + matrizActual[i][j] + " ");
            }
            System.out.print("]");
            System.out.println("");
        }
        System.out.println("--------------------");
    }

    /**
     * Si las cajas son iguales a las cajas totales la solucion es completa
     *
     * @return Si hay solución incompleta
     */
    private boolean solucionIncompleta(int cantCajas) {
        return (cantCajasPuestas() == cantCajas);
    }

    public char[][] getMatrizActual() {
        return this.matrizActual;
    }

    /**
     * Retorna la lista de matrices (Todos los estados por los que ha pasado la
     * matriz)
     *
     * @return
     */
    public ListaMatrices getListaMatrices() {
        return this.listaMatrices;
    }

    /**
     * Retorna una copia de la matrizActual (Para evitar modificar datos por la
     * referencia)
     *
     * @return Copia de la matriz actual
     */
    private char[][] copia() {
        char[][] copiaMatriz = new char[this.size][this.size];
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                copiaMatriz[i][j] = this.matrizActual[i][j];
            }
        }
        return copiaMatriz;
    }

}
