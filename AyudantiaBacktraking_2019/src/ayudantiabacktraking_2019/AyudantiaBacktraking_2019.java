/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ayudantiabacktraking_2019;

/**
 *
 * @author Juan Pablo Martinez
 */
public class AyudantiaBacktraking_2019 {

    public static void main(String[] args) {
        video v1 = new video("naruto",20);
        video v2 = new video("one piece",1);
        video v3 = new video("cumple",3);
        video v4 = new video("navidad",4);
        video v5 = new video("bleach",14);
        video v6 = new video("año nuevo",10);
        video v7 = new video("graduacion",5);
        video v8 = new video("xd",2);
        video [] videos = {v1 , v2 , v3 , v4 , v5 , v6 , v7 , v8 };

        int capacidad = 15;
        int N = 3;
        
        Opciones op = intentar(videos,capacidad, N);
        op.imprimir();
    }
    
    public static Opciones intentar(video[] datos, int capacidad, int N){
        Opciones op = new Opciones(N);
        int i = 0;
        while(!exito(op,capacidad ) && i < datos.length){
            //seleccionar el sgte
            video dato = datos[i];
            //si es aceptable hace algo
            if (aceptable(op, capacidad, dato)){
                //registra la selección
                op.insertar(dato);
                //si la solución es incompleta hace algo
                if (solucionIncompleta(op, capacidad)){
                    //llama al try siguiente
                    intentar(op, datos, capacidad, i + 1);
                    //si no hay exito cancela el registro
                    if (!exito(op, capacidad)){
                        //cancela el registro
                        op.eliminarUltimo();
                    }
                }
            }
            i++;
        }
        return op;
    }
    
    private static void intentar(Opciones op, video[] datos, int capacidad, int i){
        int k = i;
        while(!exito(op, capacidad) && k < datos.length){
            //selección k-esimo candidato
            video dato = datos[k];
            if (aceptable(op, capacidad, dato)){
                op.insertar(dato);
                if (i < datos.length){
                    intentar(op, datos, capacidad, i + 1);
                    if (!exito(op, capacidad)){
                        op.eliminarUltimo();
                    }
                }
            }
            k++;
        }
    }
    
    private static boolean exito(Opciones op,int capacidad){
        return op.estaLleno() && op.suma() == capacidad;
    }
    
    private static boolean aceptable(Opciones op, int numero, video candidato){
        return !op.estaLleno() && (op.suma() + candidato.getPeso() <= numero);
    }
    
    private static boolean solucionIncompleta(Opciones op, int numero){
        return !op.estaLleno() || op.suma() != numero;
    }
    
}
