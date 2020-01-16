package se_puede_jotear;

public class Main {

    public static void main(String[] args) {
        char[][] sala1 = {
                            {'M', 'H', 'N', 'N', 'H'},
                            {'M', 'M', 'N', 'M', 'M'},
                            {'H', 'M', 'N', 'H', 'N'},
                            {'H', 'H', 'M', 'M', 'M'},
                            {'N', 'H', 'M', 'N', 'N'},
                         };//M:10     H:7   N:8     <-- Aquí no se puede
        char[][] sala2 = {
                            {'M', 'H', 'N', 'N', 'H', 'N'},
                            {'M', 'M', 'N', 'M', 'M', 'H'},
                            {'M', 'M', 'N', 'H', 'N', 'M'},
                            {'M', 'H', 'M', 'M', 'M', 'H'},
                            {'N', 'M', 'M', 'N', 'N', 'M'},
                            {'M', 'H', 'M', 'N', 'N', 'N'},
                         };//M:17     H:7   N:12    <-- Aquí si se puede
        
        System.out.println("Se puede jotear en sala1? " + sePuedeJotear(sala1));
        System.out.println("Se puede jotear en sala2? " + sePuedeJotear(sala2));
        
    }
    
    public static boolean sePuedeJotear(char[][] sala){
        if (sala.length > 0){
            //cant[0] => cantidad de mujeres
            //cant[1] => cantidad de hombres
            int[] cant = sePuedeJotear(sala, 0, sala.length - 1, 
                                             0, sala[0].length - 1);
            System.out.println("Mujeres: " + cant[0]);
            System.out.println("Hombres: " + cant[1]);
            return cant[0] >= 2*cant[1];
        }
        return false;
    }
    
    //Devuelve un vector de tamaño 2. 
    private static int[] sePuedeJotear(char[][] sala, 
                                       int rowi, int rowj,
                                       int coli, int colj){
        int[] cant = new int[2]; //inicialmente en [0, 0]
        //de 1x1
        if (rowi == rowj && coli == colj){
            if (sala[rowi][coli] == 'M'){
                cant[0] = 1;
            }else if (sala[rowi][coli] == 'H'){
                cant[1] = 1;
            }
            return cant;
        }
        //de 2x1 o de 1x2
        if ( (rowi == rowj - 1 && coli == colj) ||
             (rowi == rowj && coli == colj - 1) ){
            char persona1 = sala[rowi][coli];
            char persona2 = sala[rowj][colj];
            if (persona1 == 'M'){
                cant[0]++;
            }else if (persona1 == 'H'){
                cant[1]++;
            }
            if (persona2 == 'M'){
                cant[0]++;
            }else if (persona2 == 'H'){
                cant[1]++;
            }
            return cant;
        }
        //de 2x2 o más
        int mitadrow = (rowi + rowj)/2;
        int mitadcol = (coli + colj)/2;
        //se 'dividen'
        int[] cantSupIzq = sePuedeJotear(sala, rowi, mitadrow, coli, mitadcol);
        int[] cantSupDer = sePuedeJotear(sala, rowi, mitadrow, mitadcol + 1, colj);
        int[] cantInfIzq = sePuedeJotear(sala, mitadrow + 1, rowj, coli, mitadcol);
        int[] cantInfDer = sePuedeJotear(sala, mitadrow + 1, rowj, mitadcol + 1, colj);
        //se junten y se añaden a cant[]
        cant[0] = cantSupIzq[0] + cantSupDer[0] + cantInfIzq[0] + cantInfDer[0];
        cant[1] = cantSupIzq[1] + cantSupDer[1] + cantInfIzq[1] + cantInfDer[1];
        return cant;
    }
    
}
