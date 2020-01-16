package proyectito;

import java.io.IOException;
import ucn.*;

public class Proyectito {

    public static void main(String[] args) throws IOException {
        //Los datos
        String[] nombres = new String[1000]; 
        String[] apes = new String[1000];
        double[] notas = new double[1000];
        //Lee
        int cantDatos = leer(nombres, apes, notas);
        //Escribe en estado.txt (aprobado o reprobado)
        escribir(nombres, apes, notas, cantDatos);
        //Fin programa
        System.out.println("Fin");
    }
    
    public static int leer(String[] nombres, String[] apes, double[] notas) throws IOException{
        ArchivoEntrada arch = new ArchivoEntrada("alumnos.txt");
        //contador para meter datos al arreglo
        int i = 0; 
        //Mientras hayan datos en el archivo
        while(!arch.isEndFile()){
            //Lee la línea y separa por ',' altiro
            Registro reg = arch.getRegistro();
            //Almacena datos en el arreglo
            nombres[i] = reg.getString();
            apes[i] = reg.getString();
            notas[i] = reg.getDouble();
            i++;
        }
        //Recuerden cerrar archivo
        arch.close();
        return i;
    }
    
    //Línea ejemplo:
    //juan,perez,reprobado
    public static void escribir(String[] nombres, String[] apes, double[] notas, int cantDatos) throws IOException{
        ArchivoSalida arch = new ArchivoSalida("estado.txt");
        for(int i = 0; i < cantDatos; i++){
            String estado;
            if (notas[i] >= 4){
                estado = "aprobado";
            }else{
                estado = "reprobado";
            }
            //Los datos que se quieren escribir en estado.txt
            //El 3 es la cantidad de 'campos' que quieren escribir en el archivo
            //en este caso son 3: nombre, apellido y estado
            Registro reg = new Registro(3);
            reg.agregarCampo(nombres[i]);
            reg.agregarCampo(apes[i]);
            reg.agregarCampo(estado);
            //Escribe el registro en el estado.txt
            arch.writeRegistro(reg);
        }
        //Recuerden cerrar archivo
        arch.close();
    }

    
}
