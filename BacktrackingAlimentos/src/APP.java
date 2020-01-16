
import java.util.Scanner;

/**
 *
 * @author sebastian
 */
public class APP {
    static int [] grupos = new int[8];// almacena la cantidad de alimentos utilizados por grupos
    static int cantGrupos;// cantidad total de grupos
    static Alimento [] solucion = new Alimento[100];// almacena los alimentos que son solucion
    static int cantAlimentosSolucion = 0;// cantidad de alimentos 
    static int calMin;// calorias minimas
    static int calMax;// calorias maximas
    static Alimento [] listaAlimentos = new Alimento[200]; // la lista general de alimentos
    static int cantTotalAlimentos; // la cantidad total de alimentos
    
    public static void desplegarSolucion(){
        System.out.println("*****************************************************************");
        System.out.println("\t\tSolucion:");
        System.out.println("*****************************************************************");
        for(int i = 0 ; i <= APP.cantAlimentosSolucion ; i++){
            System.out.println("Alimento: "+solucion[i].getNomAlim());
        }
    }
    
    public static void ingresoDatos(){
        Scanner leer = new Scanner(System.in);
        
        //ingreso de la cantidad de grupos
        System.out.println("Ingrese cantidad de grupos:");
        cantGrupos = leer.nextInt();
        System.out.println("");
        
        //ingreso de la cantidad de alimentos
        System.out.println("Cantidad de alimentos a ingresar:");
        cantTotalAlimentos = leer.nextInt();
        System.out.println("");
        
        //ingreso de los alimentos a la lista de alimentos
        for(int i = 1 ; i <= cantTotalAlimentos ; i++){
            System.out.println("Ingrese el nombre del alimento:");
            String nomAlim = leer.next();
            System.out.println("Ingrese calorias del alimento:");
            int cal = leer.nextInt();
            System.out.println("Ingrese grupo del alimento: ");
            int grupo = leer.nextInt();
            Alimento al = new Alimento(cal,grupo,nomAlim);
            listaAlimentos[i] = al;
            System.out.println("");
        }
        
        //ingreso del rango de calorias
        System.out.println("Ingrese cantidad minima de calorias a consumir:");
        calMin = leer.nextInt();
        System.out.println("Ingrese cantidad maxima de calorias a consumir:");
        calMax = leer.nextInt();
        System.out.println("");
        
        //Inicializar el vector grupos
        for(int i = 1 ; i <= APP.cantGrupos ; i++)
            grupos[i] = 0;
    }
    
    public static boolean intenta (int i){
        boolean q;
        int k = 0;
        do{
            k++;
            q = false;
            if(esAceptable(k)){
                registrarSeleccion(listaAlimentos[k]);
                //Elige el k-esimo alimento
                if(solucionIncompleta()){
                    q = intenta(i+1);
                    if(!q)
                        cancelarSeleccion();
                }else
                    q = true;
            }
        }while(!q && k != cantTotalAlimentos);
        return q;
    }
    
    public static boolean esAceptable(int k){
        if(caloriasEnRango(k) && cantAlimentosGrupo(k))
            return true;
        else
            return false;
    }
    
    public static boolean caloriasEnRango(int k){
        int suma = 0;
        for(int i = 1 ; i <= cantAlimentosSolucion ; i++)
            suma = suma + solucion[i].getCalorias();
        suma = suma + listaAlimentos[k].getCalorias();
        if(suma <= calMax)
            return true;
        else
            return false;
    }
    
    public static boolean cantAlimentosGrupo(int k){
        int grupo = listaAlimentos[k].getGrupo();
        if(grupos[grupo] >= 2)
            return false;
        else
            return true;
    }
    
    public static void registrarSeleccion(Alimento al){
        cantAlimentosSolucion++;
        solucion[cantAlimentosSolucion] = al;
        int grupo = al.getGrupo();
        grupos[grupo]++;
    }
    
    public static boolean solucionIncompleta(){
        if(!caloriasDentroDeRango() || (!gruposOK()))
            return true;
        else
            return false;
    }
    
    public static boolean caloriasDentroDeRango(){
        int suma = 0;
        for(int i = 1 ; i <= cantAlimentosSolucion ; i++)
            suma = suma + solucion[i].getCalorias();
        if(suma >= calMin && suma <= calMax)
            return true;
        else
            return false;
    }
    
    public static boolean gruposOK(){
        //retorna falso cuando hay algun grupo con 0, es decir,
        //no se han considerado alimentos de todos los grupos
        boolean resp = true;
        int i = 1;
        while(i <= cantGrupos && resp){
            if(grupos[i] == 0)
                resp = false;
            i++;
        }
        return resp;
    }
    
    public static void cancelarSeleccion(){
        Alimento al = solucion[cantAlimentosSolucion];
        cantAlimentosSolucion--;
        int grupo = al.getGrupo();
        grupos[grupo]--;
    }
    
    public static void main (String [] args){
        ingresoDatos();
        boolean resp = intenta(1);
        if(resp){
            desplegarSolucion();
        }else{
            System.out.println("El problema no tiene solucion");
        }
    }
}
