/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package talleer3;

import ucn.StdIn;
import ucn.StdOut;

/**
 *
 * @author Victor Huerta
 */
public class InterfaceImpl implements Interface {

    private Usuario refUsuario;
    private ListaUsuarios lu;
    private ListaPaginasGrupos lpg;

    public InterfaceImpl() {

        lu = new ListaUsuarios(1000);
        lpg = new ListaPaginasGrupos(1000);
    }

    @Override
    public void ingresarUsuario(Usuario U) {
        boolean sepudo = lu.ingresarUsuario(U);
        if (sepudo) {
            System.out.println("Se ingreso correctamente");
        } else {
            System.out.println("Lista llena");
        }
    }

    @Override
    public Usuario buscarUsuario(String correoE) {
        Usuario U = lu.buscarUsuario(correoE);
        return U;
    }

    @Override
    public void eliminarUsuario(Usuario U) {
        boolean sepudo = lu.eliminarUsuario(U);
        if (sepudo) {
            System.out.println("Se elimino correctamente");
        } else {
            System.out.println("Lista llena");
        }
    }

    @Override
    public void ingresarPaginaGrupo(PaginaGrupo PG) {
        boolean sepudo = lpg.ingresarPaginaGrupo(PG);
        if (sepudo) {
            System.out.println("Se ingreso correctamente");
        } else {
            System.out.println("Lista llena");
        }
    }

    @Override
    public PaginaGrupo buscarPaginaGrupo(int codigo) {
        PaginaGrupo PG = lpg.buscarPaginaGrupo(codigo);
        return PG;
    }

    @Override
    public void eliminarPaginaGrupo(PaginaGrupo PG) {
        boolean sepudo = lpg.eliminarPaginaGrupo(PG);
        if (sepudo) {
            System.out.println("Se elimino correctamente");
        } else {
            System.out.println("Lista llena");
        }

    }

    @Override
    public void menuInicio() {
        int opcionmenu = 0;
        while (opcionmenu != 3) {
            StdOut.println("Bienvenidos a Facebook:");
            StdOut.println("1.- registrarse");
            StdOut.println("2.- iniciar sesion");
            StdOut.println("3.- Finalizar aplicación");
            System.out.println("--------------------------------------");
            StdOut.print("Ingrese opcion: ");
            opcionmenu = StdIn.readInt();
            if (opcionmenu == 1) {
                registrarUsuario();
                System.out.println("---------------------------------------------------");
            }
            if (opcionmenu == 2) {
                iniciarSesion();
                System.out.println("---------------------------------------------------");
            }
            if (opcionmenu == 3) {
                StdOut.println("Se ha finalizado el programa");
                System.out.println("---------------------------------------------------");
            }
        }
    }

    @Override
    public void menuSesion() {
        int opcionmenu = 0;
        StdOut.println("A iniciado sesion correctamente:");
        while (opcionmenu != 8) {
            StdOut.println("1.- agregar usuario");
            StdOut.println("2.- eliminar usuario");
            StdOut.println("3.- crear pagina o grupo");
            StdOut.println("4.- agregar amigo a grupo");
            StdOut.println("5.- unirse a pagina");
            StdOut.println("6.- salirse de una pagina o grupo");
            StdOut.println("7.- ver puntaje");
            StdOut.println("8.- cerrar sesion");
            StdOut.print("Ingrese opcion: ");
            opcionmenu = StdIn.readInt();
            if (opcionmenu == 1) {
                RFA();
                System.out.println("----------------------------------------------");
            }
            if (opcionmenu == 2) {
                RFB();
                System.out.println("----------------------------------------------");
            }
            if (opcionmenu == 3) {
                RFC();
                System.out.println("----------------------------------------------");
            }
            if (opcionmenu == 4) {
                RFD();
                System.out.println("----------------------------------------------");
            }
            if (opcionmenu == 5) {
                RFE();
                System.out.println("----------------------------------------------");
            }
            if (opcionmenu == 6) {
                RFF();
                System.out.println("----------------------------------------------");
            }
            if (opcionmenu == 7) {
                RFG();
                System.out.println("----------------------------------------------");
            }
            if (opcionmenu == 8) {
                System.out.println("------------------------------------------------");
                StdOut.println("Se ha cerrado sesion");
                setUsuario(null);
                menuInicio();
            }

        }
    }

    @Override
    public void RFA() {
        System.out.print("Ingrese correo del amigo: ");
        String correoA = StdIn.readString();
        Usuario amigo = lu.buscarUsuario(correoA);
        if (amigo != null) {
            refUsuario.getLu().ingresarUsuario(amigo);
            amigo.getLu().ingresarUsuario(refUsuario);
            System.out.println("amigo ingresado exitosamente");
        } else {
            System.out.println("correo invalido");
        }
    }

    @Override
    public void RFB() {
        if (refUsuario.getLu().getCantUsuarios() != 0) {
            for (int i = 0; i < refUsuario.getLu().getCantUsuarios(); i++) {
                Usuario U = refUsuario.getLu().getUsuario(i);
                System.out.println("correo : " + U.getCorreoE());
            }
            System.out.print("ingrese correo del usuario a eliminar: ");
            String correo = StdIn.readString();
            Usuario amigo = refUsuario.getLu().buscarUsuario(correo);
            if (amigo != null) {
                refUsuario.getLu().eliminarUsuario(amigo);
                amigo.getLu().eliminarUsuario(refUsuario);
                System.out.println("amigo eliminado");
            } else {
                System.out.println("correo no valido");
            }
        } else {
            System.out.println("usuario no tiene amigos registrado");
        }
    }

    @Override
    public void RFC() {
        System.out.print("ingrese codigo: ");
        int codigo = StdIn.readInt();
        System.out.print("ingrese nombre: ");
        String nombre = StdIn.readString();
        System.out.print("ingrese fecha forma (D-M-A)");
        String fecha = StdIn.readString();
        System.out.print("lo que esta creando es pagina o grupo");
        String tipo = StdIn.readString();
        if (tipo.equalsIgnoreCase("pagina")) {
            System.out.print("ingrese categoria: ");
            String catego = StdIn.readString();
            System.out.print("ingrese clasificacion: ");
            String clasificacion = StdIn.readString();
            if (clasificacion.equalsIgnoreCase("negocio")) {
                System.out.print("ingrese direccion: ");
                String direccion = StdIn.readString();
                System.out.print("ingrese nombre de ciudad: ");
                String ciudad = StdIn.readString();
                System.out.print("ingrese codigo postal: ");
                String postal = StdIn.readString();
                System.out.print("ingrese telefono: ");
                int telefono = StdIn.readInt();
                Pagina pag = new PaginaNegocio(direccion, ciudad, postal, telefono, catego, clasificacion, codigo, nombre, fecha);
                pag.setRefUsuario(refUsuario);
                pag.getLu().ingresarUsuario(refUsuario);
                refUsuario.getLpg().ingresarPaginaGrupo(pag);
                lpg.ingresarPaginaGrupo(pag);
            } else {
                PaginaGrupo pag = new Pagina(catego, clasificacion, codigo, nombre, fecha) {
                };
                pag.setRefUsuario(refUsuario);
                pag.getLu().ingresarUsuario(refUsuario);
                refUsuario.getLpg().ingresarPaginaGrupo(pag);
                lpg.ingresarPaginaGrupo(pag);
            }
        } else {
            PaginaGrupo grupo = new Grupo(codigo, nombre, fecha);
            grupo.setRefUsuario(refUsuario);
            grupo.getLu().ingresarUsuario(refUsuario);
            refUsuario.getLpg().ingresarPaginaGrupo(grupo);
            lpg.ingresarPaginaGrupo(grupo);
        }
        System.out.println("grupo o pagina creada exitosamente");
    }

    @Override
    public void RFD() {
        if (refUsuario.getLpg().getCantPaginasGrupos() != 0) {
            System.out.println("-------------lista de grupos disponibles------------------");
            for (int i = 0; i < refUsuario.getLpg().getCantPaginasGrupos(); i++) {
                PaginaGrupo P = refUsuario.getLpg().getPaginaGrupo(i);
                if (P instanceof Grupo) {
                    System.out.println((i + 1) + "- " + P.getNombre() + " codigo: " + P.getCodigo());
                }
            }
            System.out.print("ingrese codigo del grupo a seleccionar: ");
            int cod = StdIn.readInt();
            PaginaGrupo P2 = refUsuario.getLpg().buscarPaginaGrupo(cod);
            if (P2 != null) {
                System.out.println("lista de amigos que no esta en el grupo");
                for (int i = 0; i < refUsuario.getLu().getCantUsuarios(); i++) {
                    Usuario U = refUsuario.getLu().getUsuario(i);
                    if (P2.getLu().buscarUsuario(U.getCorreoE()) == null) {
                        System.out.println("nombre: " + U.getNombre1() + " correo: " + U.getCorreoE());
                    }
                }
                System.out.print("ingrese correo del amigo a seleccionar: ");
                String correo = StdIn.readString();
                Usuario amigo = refUsuario.getLu().buscarUsuario(correo);
                if (amigo != null) {
                    P2.getLu().ingresarUsuario(amigo);
                    amigo.getLpg().ingresarPaginaGrupo(P2);
                    System.out.println("amigo unido exitosamente");
                } else {
                    System.out.println("correo no valido");
                }
            } else {
                System.out.println("codigo no valido");
            }
        } else {
            System.out.println("amigo no se encuentra unido a grupos");
        }
    }

    @Override
    public void RFE() {
        if (lpg.getCantPaginasGrupos() != 0) {
            System.out.println("---------------------------------------");
            for (int i = 0; i < lpg.getCantPaginasGrupos(); i++) {
                PaginaGrupo P = lpg.getPaginaGrupo(i);
                if (P instanceof Pagina) {
                    if (refUsuario.getLpg().buscarPaginaGrupo(P.getCodigo()) != null) {
                        System.out.println("usuario registrado en la pagina: " + ((Pagina) P).nombre + " codigo: " + ((Pagina) P).codigo);
                    } else {
                        System.out.println("usuario no registrado en la pagina: " + ((Pagina) P).nombre + " codigo: " + ((Pagina) P).codigo);
                    }
                    System.out.println("---------------------------------------");
                }
            }
            System.out.print("ingrese codigo de la pagina a unir: ");
            int cod = StdIn.readInt();
            PaginaGrupo pagina = lpg.buscarPaginaGrupo(cod);
            if (pagina != null) {
                if (refUsuario.getLpg().buscarPaginaGrupo(cod) == null) {
                    refUsuario.getLpg().ingresarPaginaGrupo(pagina);
                    pagina.getLu().ingresarUsuario(refUsuario);
                    System.out.println("unido exitosamente");
                } else {
                    System.out.println("ya registrado en la pagina");
                }
            } else {
                System.out.println("pagina no existe");
            }
        } else {
            System.out.println("no hay paginas registradas");
        }
    }

    @Override
    public void RFF() {
        if (lpg.getCantPaginasGrupos() != 0) {
            System.out.println("lista de grupos o  paginas");
            System.out.println("-----------------------------------------------------");
            for (int i = 0; i < refUsuario.getLpg().getCantPaginasGrupos(); i++) {
                PaginaGrupo P = refUsuario.getLpg().getPaginaGrupo(i);
                System.out.println("nombre: " + P.nombre + " codigo: " + P.codigo);
                System.out.println("---------------------------------------------------");
            }
            System.out.print("ingrese codigo de la pagina a eliminar: ");
            int cod = StdIn.readInt();
            PaginaGrupo pagina = refUsuario.getLpg().buscarPaginaGrupo(cod);
            if (pagina != null) {
                if (pagina.getRefUsuario().getCorreoE().equalsIgnoreCase(refUsuario.getCorreoE())) {
                    if (pagina.getLu().getCantUsuarios() == 1) {
                        refUsuario.getLpg().eliminarPaginaGrupo(pagina);
                        lpg.eliminarPaginaGrupo(pagina);
                    } else {
                        int i = 1;
                        refUsuario.getLpg().eliminarPaginaGrupo(pagina);
                        pagina.setRefUsuario(pagina.getLu().getUsuario(i));
                        pagina.getLu().eliminarUsuario(refUsuario);
                    }
                } else {
                    refUsuario.getLpg().eliminarPaginaGrupo(pagina);
                    pagina.getLu().eliminarUsuario(refUsuario);
                }
            } else {
                System.out.println("pagina no existe");
            }
        } else {
            System.out.println("no hay paginas o grupos creadas");
        }
    }

    @Override
    public void RFG() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registrarUsuario() {
        System.out.println("Ingrese nombre: ");
        String nom = StdIn.readString();
        System.out.println("Ingrese segundo nombre: ");
        String nom2 = StdIn.readString();
        System.out.println("Ingrese primer apellido: ");
        String ape = StdIn.readString();
        System.out.println("Ingrese segundo apellido: ");
        String ape2 = StdIn.readString();
        System.out.println("Ingrese correo electronico: ");
        String correoE = StdIn.readString();
        System.out.println("Ingrese contraseña: ");
        String pw = StdIn.readString();
        System.out.println("Ingrese fecha de nacimiento: ");
        String fechaN = StdIn.readString();
        System.out.println("Ingrese sexo (M o F): ");
        char sexo = StdIn.readChar();
        Usuario U = new Usuario(nom, nom2, ape, ape2, correoE, pw, fechaN, sexo);
        ingresarUsuario(U);
        setUsuario(U);
    }

    @Override
    public void iniciarSesion() {
        System.out.println("Ingrese correo electrónico: ");
        String correoE = StdIn.readString();
        Usuario U = buscarUsuario(correoE);
        if (U != null) {
            System.out.println("Ingrese contraseña: ");
            String pw = StdIn.readString();
            if (!U.getContraseña().equalsIgnoreCase(pw)) {
                System.out.println("contraseña invalida");
            } else {
                menuSesion();
                setUsuario(U);
            }
        } else {
            System.out.println("correo no valido");
        }
    }

    @Override
    public void setUsuario(Usuario U) {
        refUsuario = U;
    }

}
