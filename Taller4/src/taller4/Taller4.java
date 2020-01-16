package taller4;

import ucn.*;

public class Taller4 {

     /**
     * 
     * @param lc  utilizamos la ListaContenedores para la busqueda de informacion
     */ 
    
    public static void menu(ListaContenedores lc) {
        StdOut.println("consola");
        StdOut.println("------------------");
        StdOut.println("escriba help para ayuda");
        int cod = 1;
        Carpeta C = new Carpeta(cod, "root");
        lc.ingresarContenedor(C);
        Carpeta actual = C;
        cod++;
        String opcionmenu = "hola";
        while (!opcionmenu.equals("exit")) {
            StdOut.print("> " + actual.getNombre() + "/:");
            opcionmenu = StdIn.readLine();

            if (opcionmenu.equalsIgnoreCase("help")) {
                Taller4.help();
            } else if (opcionmenu.equalsIgnoreCase("cd ..")) {
                if (actual.getNombre().equals("root")) {
                    StdOut.println("no hay carptea anterior a root");
                } else {
                    actual = Taller4.cdPunto(actual);
                }
            } else if (opcionmenu.equalsIgnoreCase("cd /")) {
                actual = Taller4.cdslash(lc);
            } else if (opcionmenu.equalsIgnoreCase("ls")) {
                Taller4.ls(actual);
            } else {
                String[] linea = opcionmenu.split(" ");
                if (linea.length == 2 && linea[0].equals("mkdir")) {
                    Taller4.mkdirCarpeta(actual, lc, linea[1], cod);
                    
                    cod++;
                } else if (linea.length == 2 && linea[0].equals("rm")) {
                    Taller4.rm(actual, lc, linea[1]);
                } else if (linea.length == 3 && linea[0].equals("ln")) {
                    Taller4.enlace(lc, linea[1], linea[2], cod, actual);
                    cod++;
                } else if (linea.length == 2 && linea[0].equals("cd")) {
                    actual = Taller4.cdDirectorio(actual, lc, linea[1]);
                } else if (linea.length == 2 && linea[0].equals("touch")) {
                    String[] tok = linea[1].split("\\.");
                    if (tok.length == 2 && !tok[0].equals("") && !tok[1].equals("")) {
                        Taller4.touch(tok[0], cod, tok[1], actual, lc);
                        cod++;
                    }
                }

            }

        }

    }
    /**
     * Aqui realizamos el metodo "help" para mostrar que significa cada opcion
     */

    public static void help() {
        StdOut.println("cd  nomCarpeta                    cambiadirectorio a carpeta de nombre nomCarpte");
        StdOut.println("cd ..                             cambia de directorio a caperta padre");
        StdOut.println("cd /                              cambia de directorio a carpeta root");
        StdOut.println("ls                                muestra lista de contenedores de la carpéta actual");
        StdOut.println("rm nomContenedor                  eliminar  el contenedor de nombre nomContenedor de la carpeta actual");
        StdOut.println("ln nomEnlance nomContendor        crea un enlace de nombre nomEnlace hacia el contenedor");
        StdOut.println("mkdir nomCarpeta                  crear un directorio de nombre nomCarpeta");
        StdOut.println("touch nomArchivo.extension        crear un archivo de nombre nomArchivo y extension 'extension'");
        StdOut.println("help                              muestra lista de comandos y su descripcion");
        StdOut.println("exit                              finaliza consola");

    }
    /**
 * 
 * @param actual utilizamos un contendor actual para retornar el padre de este mismo
 * @return 
 */
    

    public static Carpeta cdPunto(Carpeta actual) {
        return actual.getPadre();

    }
    /**
 * 
 * @param lc Utilizamos la ListaContenedores para retornar la carpeta donde se encuentre el root buscado
 * @return 
 */

    public static Carpeta cdslash(ListaContenedores lc) {
        return (Carpeta) lc.buscarContenedor("root");
    }
 
    /**
 * 
 * @param carp con la clase Carpeta imprimos la lista que se encuentra en esa clase, es decir todas las carpetas
 */ 
    
    public static void ls(Carpeta carp) {
        NodoContenedor actual = carp.getLc().getFirstContenedor();
        StdOut.println("Codigo:                       Nombre:                          Tipo:");
        StdOut.println("-------                       -------                          -----");
        while (actual != null) {
            Contenedor C = actual.getContenedor();
            StdOut.print(C.getCodigo() + "                     " + C.getNombre() + "                        ");
            if (C instanceof Carpeta) {
                StdOut.println("DIR");
            } else if (C instanceof Archivo) {
                StdOut.println("FILE");
            } else if (C instanceof Enlace) {
                StdOut.println("LINK");
            }
            actual = actual.getNextContenedor();
        }

    }
    /**
 * 
 * @param actual utilizamos un actual para recorrer la lista y eliminar un nodo
 * @param lc recorremos la ListaContenedores
 * @param nombre buscamos por nombre aquel nodo que se desea eliminar
 */

    public static void rm(Carpeta actual, ListaContenedores lc, String nombre) {
        Carpeta C = actual;
        boolean eliminar = C.getLc().eliminarContenedor(nombre);
        
        if (!nombre.equals("root") && eliminar == true) {
            lc.eliminarContenedor(nombre);
            StdOut.println("elemento eliminado");
        }else{
            if(nombre.equals("root")){
            StdOut.println("no se puede eliminar la carpeta root");
        }else{
           
            StdOut.println("no existe elemento");
        }
    
    }
    }
    /**
 * 
 * @param actual usamos un nodo actual para setearle la carpeta a la clase padre
 * @param lc insertamos una nueva carpeta en la ListaContenedores
 * @param nombre creamos una nue va carpeta con su  nombre
 * @param codigo creamos una nueva carpeta con su codigo correspondiente
 */

    public static void mkdirCarpeta(Carpeta actual, ListaContenedores lc, String nombre, int codigo) {
        Carpeta C = new Carpeta(codigo, nombre);
        C.setPadre(actual);
        Contenedor con = actual.getLc().buscarContenedor(nombre);
        if(con == null){
        actual.getLc().ingresarContenedor(C);
        lc.ingresarContenedor(C);
        StdOut.println("carpeta creada");
    }else{
            StdOut.println("existe una carpeta con ese nombre");
        }
    }
    /**
 * 
 * @param lc creamos un enlace y lo ingresamos a la ListaContenedor
 * @param nombre le damos un nombre al enlace
 * @param contenedor buscamos un contenedor donde ingresar el enlace
 * @param codigo un codigo le damos al enlace
 * @param actual usamso u actual para encontrar el contenedor
 */
    public static void enlace(ListaContenedores lc, String nombre, String contenedor, int codigo, Carpeta actual) {
        Enlace E = new Enlace(codigo, nombre);
        E.setContenedor(lc.buscarContenedor(contenedor));
        Contenedor C = actual.getLc().buscarContenedor(contenedor);
        if(C != null){
        actual.getLc().ingresarContenedor(E);
        lc.ingresarContenedor(E);
        StdOut.println("enlace creado");

    }else{
            StdOut.println("directorio no existe");
        }
    }

    /**
 * 
 * @param actual buscamos una carpeta utlizando un actual
 * @param lc llamamos a la ListaContenedores para retornar nu carpeta
 * @param nombre a traves de nombre retornaremos la carpeta solicitada
 * @return 
 */
    public static Carpeta cdDirectorio(Carpeta actual, ListaContenedores lc, String nombre) {
        Contenedor C = (Carpeta) lc.buscarContenedor(nombre);
        if (C != null) {
            return (Carpeta) C;
        } else {
            StdOut.println("directorio no existe");
            return actual;
        }
    }
  /**
 * 
 * @param actual buscamos una carpeta utlizando un actual
 * @param lc llamamos a la ListaContenedores para retornar nu carpeta 
 */
    public static void touch(String nombre, int codigo, String tipo, Carpeta actual, ListaContenedores lc) {
        Archivo A = new Archivo(tipo, codigo, nombre);
        actual.getLc().ingresarContenedor(A);
        lc.ingresarContenedor(A);
        StdOut.println("archivo creado");

    }
    public static void main(String[] args) {
        ListaContenedores lc = new ListaContenedores();
        Taller4.menu(lc);
    }

}
