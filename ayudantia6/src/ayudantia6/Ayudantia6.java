package ayudantia6;
import ucn.*;




public class Ayudantia6 {
    public static void leeregion(ListaDonantes ld,ListaRegiones lr){
        StdOut.print("ingrese nombre de la region: ");
        String nomregion = StdIn.readString();
        Region R= new Region(nomregion);
        StdOut.print("ingrese meta de la region: ");
        int meta = StdIn.readInt();
        R.setMontoPorRegion(meta);
        boolean sepudo = lr.insertarRegion(R);
        if(sepudo == true){
            StdOut.print("region ingresada exitosamente");
        }else{
            StdOut.print("lista llena");
        }
            
        
        
    }
    public static void leerdonante(ListaDonantes ld,ListaRegiones lr){
        StdOut.print("ingrese region a la cual pertence el donante: ");
        for(int i = 0; i< lr.getCantRegiones();i++){
            Region R = lr.getRegion(i);
            StdOut.println(R.getNomRegion());
        }
        String region = StdIn.readString();
        Region R = lr.buscarRegion(region);
        if(R != null){
        StdOut.print("ingrese nombre del donante: ");
        String nomdonante = StdIn.readString();
        StdOut.print("ingrese rut del donante: ");
        int rut = StdIn.readInt();
        StdOut.print("ingrese monto a donar: ");
        int montodonado = StdIn.readInt();
        StdOut.print("que tipo de persona es juridica(empresa) o normal ");
        String tipo = StdIn.readString();
        Donante D = new Donante(nomdonante,rut,montodonado,tipo);
        boolean sepudo = ld.ingresarDonante(D);
        if(sepudo == true){
            StdOut.print("donante ingresado exitosamente");
            D.setRefRegion(R);
            D.getRefRegion().setMontoActual(montodonado);
            R.getLd().ingresarDonante(D);
        }else{
            StdOut.print("lista llena");
        }
        
        
        
    }
    }
    public static void requerimiento1(ListaDonantes ld,ListaRegiones lr, int metachile){
        int montorecaudado = lr.calcularMontoChile();
        if(montorecaudado == metachile ){
            StdOut.println("se cumplio la meta");
        }else{
            if(montorecaudado > metachile){
                StdOut.println("se cumplio la meta y  sobro " + (montorecaudado -metachile));
            }else{
                if(montorecaudado < metachile){
                    StdOut.println(" no se cumplio la meta y falto " + (metachile - montorecaudado));
                }
            }
        }
    }
    public static void requerimiento2(ListaDonantes ld,ListaRegiones lr){
        for(int i = 0; i < lr.getCantRegiones();i++){
            Region R  = lr.getRegion(i);
            if(R.getMontoActual() >= R.getMontoPorRegion()){
                StdOut.println(R.getNomRegion());
            }
        }
    }
    public static void requerimiento3(ListaDonantes ld,ListaRegiones lr){
        for(int i = 0; i < lr.getCantRegiones();i++){
            Region R  = lr.getRegion(i);
            if(R.getMontoActual()< R.getMontoPorRegion()){
                StdOut.println(R.getNomRegion());
            }
        }
    }
    public static void requerimiento4(ListaDonantes ld,ListaRegiones lr){
        for(int i =0 ; i<ld.getCantDonantes();i++){
            Donante D = ld.getDonante(i);
            if(D.getMontoDonado() > 1000000){
                StdOut.println("nombre del donante: " + D.getNomDonante());
                StdOut.println("tipo de persona: " + D.getTipoPersona());
                StdOut.println("region a la cual pertenece: " + D.getRefRegion().getNomRegion());
            }
        }
    }
    public static void requerimiento5(ListaDonantes ld,ListaRegiones lr){
        StdOut.print("ingrese nombre de la region de la cual desea buscar: ");
        String regionb = StdIn.readString();
        Region R = lr.buscarRegion(regionb);
        if(R != null){
        for(int i = 0; i<R.getLd().getCantDonantes();i++){
                StdOut.println("nombre del donante: " + R.getLd().getDonante(i).getNomDonante());
                StdOut.println("rut del donante: " + R.getLd().getDonante(i).getRut());
                StdOut.println("monto aportado por el donante : " + R.getLd().getDonante(i).getMontoDonado());
        }
    }
    }
    public static void menuApp(ListaDonantes ld, ListaRegiones lr,int metaChile) {
     
       int opcion = 0;
        while (opcion != 8) {
            System.out.println("---------------------------------------------------");
            System.out.println("\t[MENU]");
            System.out.println("1. Leer region");
            System.out.println("2. Leer donante");
            System.out.println("3. Determinar si chile cumplio la meta");
            System.out.println("4. Lista regiones que cumplieron meta");
            System.out.println("5. Lista regiones que no cumplieron meta");
            System.out.println("6. Desplegar donadores mayor a un millon");
            System.out.println("7. Desplegar datos de una region en particular");
            System.out.println("8. Salir");
            System.out.println("---------------------------------------------------");
            System.out.print("> ");
            opcion = StdIn.readInt();
            switch (opcion) {
                case 1:
                    leeregion(ld, lr);
                    break;
                case 2:
                    leerdonante(ld, lr);
                    break;
                case 3:
                    requerimiento1(ld,lr, metaChile);
                    break;        
                case 4:
                    requerimiento2(ld, lr);
                    break;
                case 5:
                    requerimiento3(ld, lr);
                    break;
                case 6:
                    requerimiento4(ld, lr);
                    break;
                case 7:
                    requerimiento5(ld, lr);
                    break;
                default:
                    opcion = 8;
            }
        }
    }
    public static void main(String[] args) {
      ListaDonantes ld = new ListaDonantes(1000);
      ListaRegiones lr = new ListaRegiones(1000);
      System.out.print("Ingrese meta actual de chile: ");
      int metaChile = StdIn.readInt();
      Ayudantia6.menuApp(ld, lr, metaChile);
     
   
      
        
    }
    
}

