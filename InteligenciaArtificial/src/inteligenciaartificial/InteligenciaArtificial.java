package inteligenciaartificial;

public class InteligenciaArtificial {

    public static char[][] ejecucion(int[][] tablero, int posx, int posy) {
        char[][] resultado = new char[10][10];
        int cant = 0;
        int posActualX, posActualY;
        if (tablero[posx][posy] == 1) {
            resultado[posx][posy] = 'L';
        }
        Agente a = new Agente(posy, posy);
        while (true) {
            

            a.setTablero(tablero);
            posActualX = a.getPosicionX();
            posActualY = a.getPosicionY();
            int[] nuevas = a.determinarPos();
            
            if (tablero[nuevas[0]][nuevas[1]] == 1) {
                resultado[nuevas[0]][nuevas[1]] = 'L';
            }
            cant++;
            if (cant == 100) {
                break;
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        //considere que los 1 significa una casilla sucia y el 0 una casilla limpia
        int[][] tablero = new int[10][10];
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                if ((Math.random() * 4) > 3) {
                    tablero[i][j] = 0;
                } else {
                    tablero[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println("");
        }

        char[][] resul = ejecucion(tablero, 4, 4);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(resul[i][j] + " ");
            }
            System.out.println("");
        }

    }

}
