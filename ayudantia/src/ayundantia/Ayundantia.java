package ayundantia;

import ucn.*;

public class Ayundantia {

    public static void leerdatos(ListaPoetas lp, ListaLibros lb) {
        StdOut.print("ingrese cantidad de poetas:");
        int cant = StdIn.readInt();
        for (int i = 0; i < cant; i++) {
            StdOut.print("ingrese nomber artistico del poeta:");
            String nombrep = StdIn.readString();
            StdOut.print("ingrese rut del poeta:");
            String rut = StdIn.readString();
            StdOut.print("ingrese año de nacimiento del poeta:");
            int año = StdIn.readInt();
            StdOut.print("ingrese nacionalidad del poeta:");
            String nacionalidad = StdIn.readString();
            StdOut.print("ingrese cantidad de libro del poeta:");
            int cantli = StdIn.readInt();

            Poeta p = new Poeta(nombrep, rut, año, nacionalidad, cantli);
            lp.ingresarPoeta(p);
            for (int j = 0; j < cantli; j++) {
                StdOut.print("ingrese año de publicacion del libro:");
                int publicacion = StdIn.readInt();
                StdOut.print("ingrese titulo del libro:");
                String titulo = StdIn.readString();
                StdOut.print("ingrese cantidad de paginas del libro:");
                int cantpa = StdIn.readInt();
                StdOut.print("ingrese editorial del libro:");
                String editorial = StdIn.readString();
                Libro L = new Libro(publicacion,titulo,cantpa,editorial);
                lb.ingresarLibro(L);
                p.getLb().ingresarLibro(L);
                
            }

        }
    }
    public static void requerimiento1(ListaPoetas lp, ListaLibros lb){
        int mayor=0;
        String nombremayor = "";
        for(int i=0;i<lp.getCantpoetas();i++){
            if(lp.getPoeta(i).getCantlibros() > mayor){
                mayor = lp.getPoeta(i).getCantlibros();
                nombremayor = lp.getPoeta(i).getNombre();
                StdOut.println("el nombre del poeta con mayor cantidad de libros es: " + nombremayor);
            }
            
        }
    }
    
    public static void requerimiento2(ListaPoetas lp, ListaLibros lb){
        for(int i =0;i<lp.getCantpoetas();i++){
            Poeta P = lp.getPoeta(i);
            for(int j = 0 ; j<P.getCantlibros();j++){
            if(P.getLb().getLibro(j).getCantpaginas() == 50){
                StdOut.println("nombre del poeta con libros de 50 paginas: " + lp.getPoeta(i).getNombre());
               
                }
        }
    }
    }
    public static void requerimiento3(ListaPoetas lp, ListaLibros lb){
       int cant = 0;
        for(int i = 0;i<lp.getCantpoetas();i++){
            Poeta P = lp.getPoeta(i);
            for(int j = 0 ; j<P.getCantlibros();j++){
            if(P.getLb().getLibro(j).getPublicacion() == 2000){
                cant++;
                
                }
        }
        }
        StdOut.println("cantidad de poetas con libros publicados el 2000: " + cant);
    }
    public static void requerimiento5(ListaPoetas lp, ListaLibros lb){
        StdOut.print("ingrese rut del poeta a buscar: ");
        String rutb = StdIn.readString();
        Poeta P = lp.buscarPoeta(rutb);
        
        for(int i = 0; i < P.getCantlibros();i++){
            StdOut.println("los datos de sus libros son: " + (i + 1));
            StdOut.println("año de publicacion: " + P.getLb().getLibro(i).getPublicacion());
            StdOut.println("titulo: " + P.getLb().getLibro(i).getTitulo());
            StdOut.println("cantidad de paginas: " + P.getLb().getLibro(i).getCantpaginas());
            StdOut.println("su editorial: " + P.getLb().getLibro(i).getEditorial());
        }
        
    }
    public static void main(String[] args) {
        ListaPoetas lp = new ListaPoetas(1000);
        ListaLibros lb = new ListaLibros(1000);
        leerdatos(lp,lb);
        requerimiento1(lp,lb);
        requerimiento2(lp,lb);
        requerimiento3(lp,lb);
        requerimiento5(lp,lb);
    }

}
