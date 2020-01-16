package arbolesbinarios;

/**
 *
 * @author Usuario
 */
public class ABB {

    private NodoArbol raiz;

    public ABB() {
        this.raiz = null;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public void ingresarNodo(int dato) {
        if (raiz == null) {
            raiz = new NodoArbol(dato);
        } else {
            ingresarNodoRecursivo(dato, raiz);
        }
    }

    public void ingresarIter(int dato) {
        if (raiz == null) {
            raiz = new NodoArbol(dato);
        } else {
            NodoArbol actual = raiz;
            while (actual != null) {
                if (actual.getDato() > dato) {//izquierda
                    if (actual.getIzquierdo() == null) {
                        actual.setIzquierdo(new NodoArbol(dato));
                        break;
                    } else {
                        actual = actual.getIzquierdo();
                    }
                } else {
                    if (actual.getDerecho() == null) {
                        actual.setDerecho(new NodoArbol(dato));
                        break;
                    } else {
                        actual = actual.getDerecho();
                    }
                }
            }
        }
    }

    private void ingresarNodoRecursivo(int dato, NodoArbol nodo) {
        if (dato < nodo.getDato()) {
            if (nodo.getIzquierdo() == null) {
                nodo.setIzquierdo(new NodoArbol(dato));
            } else {
                ingresarNodoRecursivo(dato, nodo.getIzquierdo());
            }
        } else if (dato > nodo.getDato()) {
            if (nodo.getDerecho() == null) {
                nodo.setDerecho(new NodoArbol(dato));
            } else {
                ingresarNodoRecursivo(dato, nodo.getDerecho());
            }
        }
    }

    public boolean desbalanceo(NodoArbol nodo) {
        if (nodo != null && nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
            if ((nodo.getDerecho().getDato() - nodo.getIzquierdo().getDato()) > 5) {
                return true;
            } else {
                boolean b1 = desbalanceo(nodo.getIzquierdo());
                boolean b2 = desbalanceo(nodo.getDerecho());
                if (b1 == false && b2 == false) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
    }
    
    public int contarHojas(NodoArbol nodo){
        if(nodo == null){
            return 0;
        }else{
            if(nodo.getIzquierdo() == null && nodo.getDerecho() == null){
                return 1;
            }else{
                return contarHojas(nodo.getIzquierdo()) + contarHojas(nodo.getDerecho());
            }
        }
    }

    public boolean buscarNodo(int dato, NodoArbol nodo) {//nodo es la raiz
        if (nodo != null) {
            if (dato == nodo.getDato()) {
                return true;
            } else if (dato < nodo.getDato()) {
                return buscarNodo(dato, nodo.getIzquierdo());
            } else {
                return buscarNodo(dato, nodo.getDerecho());
            }
        } else {
            return false;
        }
    }

    //ENCONTRAR EL NODO MAYOR DEL ARBOL
    public int buscarMayor(NodoArbol nodo) {
        int mayor = -9999;
        if (nodo != null) {
            while (nodo != null) {
                if (nodo.getDato() > mayor) {
                    mayor = nodo.getDato();
                }
                nodo = nodo.getDerecho();
            }
            return mayor;
        }
        return -1;
    }

    public int buscarMenor(NodoArbol nodo) {
        int menor = 9999;
        if (nodo != null) {
            while (nodo != null) {
                if (nodo.getDato() < menor) {
                    menor = nodo.getDato();
                }
                nodo = nodo.getIzquierdo();
            }
            return menor;
        }
        return -1;
    }

    public boolean esABB(NodoArbol nodo) {
        if (nodo != null && nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
            if (nodo.getDato() > nodo.getIzquierdo().getDato()) {
                esABB(nodo.getIzquierdo());
            } else {
                return false;
            }
            if (nodo.getDato() < nodo.getDerecho().getDato()) {
                esABB(nodo.getDerecho());
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean esABBdcp(NodoArbol nodo) {
        boolean estado = true;
        if (nodo == null) {
            return estado;
        } else {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                return estado;
            } else {
                if ((nodo.getIzquierdo().getIzquierdo() == null && nodo.getIzquierdo().getDerecho() == null)
                        && (nodo.getDerecho().getIzquierdo() == null && nodo.getDerecho().getDerecho() == null)) {

                    if (nodo.getIzquierdo().getDato() < nodo.getDato()) {
                        estado = true;
                    } else {
                        estado = false;
                    }
                    if (nodo.getDerecho().getDato() > nodo.getDato()) {
                        estado = true;
                    } else {
                        estado = false;
                    }
                    return estado;
                }
            }
        }
        boolean b1 = esABBdcp(nodo.getDerecho());
        boolean b2 = esABBdcp(nodo.getIzquierdo());
        if (b1 == b2) {
            return true;
        } else {
            return false;
        }
    }

    public int calcularAltura(NodoArbol nodo) {
        int h = 0;
        if (nodo != null) {
            int hIzquierdo = calcularAltura(nodo.getIzquierdo());
            int hDerecho = calcularAltura(nodo.getDerecho());

            if (hIzquierdo > hDerecho) {
                h = hIzquierdo + 1;
            } else {
                h = hDerecho + 1;
            }
        }
        return h;
    }

    public boolean arbolCompleto(NodoArbol nodo) {
        if (nodo == null) {
            return true;
        } else if (calcularAltura(nodo.getIzquierdo()) != calcularAltura(nodo.getDerecho())) {
            return false;
        } else {
            return arbolCompleto(nodo.getIzquierdo()) && arbolCompleto(nodo.getDerecho());
        }
    }

    public void imprimir(NodoArbol nodo, int nivel) {
        int i;
        if (nodo != null) {
            imprimir(nodo.getDerecho(), nivel + 1);
            System.out.print("\n");
            if (nodo == raiz) {
                System.out.print("raiz -> ");
            }
            for (i = 0; i < nivel && nodo != raiz; i++) {
                System.out.print("        ");
            }
            System.out.print(nodo.getDato());
            imprimir(nodo.getIzquierdo(), nivel + 1);
        }
    }

    public NodoArbol buscar(int dato, NodoArbol nodo) {//nodo es la raiz
        if (nodo != null) {
            if (dato == nodo.getDato()) {
                return nodo;
            } else if (dato < nodo.getDato()) {
                return buscar(dato, nodo.getIzquierdo());
            } else {
                return buscar(dato, nodo.getDerecho());
            }
        } else {
            return null;
        }
    }

    public int MayorHijoIzq(int dato) {
        NodoArbol nuevo = buscar(dato, raiz);
        int mayor = -9999;
        if (nuevo != null) {
            return recMayorHijoIzq(nuevo.getIzquierdo(), mayor);
        } else {
            return -1;
        }
    }

    private int recMayorHijoIzq(NodoArbol nodo, int mayor) {
        if (nodo != null) {
            if (nodo.getDerecho() != null) {
                if (nodo.getDerecho().getDato() > mayor) {
                    mayor = nodo.getDerecho().getDato();
                }
                return recMayorHijoIzq(nodo.getDerecho(), mayor);
            } else if (nodo.getIzquierdo() != null) {
                if (nodo.getIzquierdo().getDato() > mayor) {
                    mayor = nodo.getIzquierdo().getDato();
                }
                return recMayorHijoIzq(nodo.getIzquierdo(), mayor);
            } else {
                return mayor;
            }
        } else {
            return mayor;
        }
    }

    public int MenorHijoDer(int dato) {
        NodoArbol nuevo = buscar(dato, raiz);
        int menor = 9999;
        if (nuevo != null) {
            return recMenorHijoDer(nuevo.getDerecho(), menor);
        } else {
            return -1;
        }
    }

    private int recMenorHijoDer(NodoArbol nodo, int menor) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                if (nodo.getIzquierdo().getDato() < menor) {
                    menor = nodo.getIzquierdo().getDato();
                }
                return recMenorHijoDer(nodo.getIzquierdo(), menor);
            } else if (nodo.getDerecho() != null) {
                if (nodo.getDerecho().getDato() < menor) {
                    menor = nodo.getDerecho().getDato();
                }
                return recMenorHijoDer(nodo.getDerecho(), menor);
            } else {
                return menor;
            }
        } else {
            return menor;
        }
    }

    public int contarNodos(NodoArbol nodo) {
        int cant = 0;
        if (nodo == null) {
            return 0;
        } else {
            cant = contarNodos(nodo.getIzquierdo()) + contarNodos(nodo.getDerecho());
            return cant + 1;//se le suma 1 por la raiz
        }
    }

    public NodoArbol ancestroComum(int dato1, int dato2) {
        if (raiz == null) {
            return null;
        } else {
            return ancestroComunRec(raiz, dato1, dato2);
        }
    }

    public NodoArbol ancestroComunRec(NodoArbol nodo, int dato1, int dato2) {
        if (nodo != null) {
            if (nodo.getDato() > dato1 && nodo.getDato() > dato2) {
                return ancestroComunRec(nodo.getIzquierdo(), dato1, dato2);
            }
            if (nodo.getDato() < dato1 && nodo.getDato() < dato2) {
                return ancestroComunRec(nodo.getDerecho(), dato1, dato2);
            }
            return nodo;
        } else {
            return nodo;
        }
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public boolean esCompleto() {
        if (this.isEmpty()) {
            return true;
        } else {
            return esCompleto(this.raiz);
        }
    }

    private boolean esCompleto(NodoArbol raizLocal) {
        if (raizLocal.getIzquierdo() == null && raizLocal.getDerecho() == null) {
            return true;
        } else {
            if (raizLocal.getIzquierdo() != null && raizLocal.getDerecho() != null) {
                return esCompleto(raizLocal.getIzquierdo()) && esCompleto(raizLocal.getDerecho());
            } else {
                return false;
            }
        }
    }

    public boolean desbalanceado() {
        boolean resp = false;
        if (this.raiz != null) {
            int suma1 = suma(raiz.getIzquierdo());
            int suma2 = suma(raiz.getDerecho());
            if (suma1 - suma2 > 5 || suma2 - suma1 > 5) {
                resp = true;
            }
        }
        return resp;
    }

    private int suma(NodoArbol raizLocal) {
        int suma = 0;
        if (raizLocal != null) {
            suma = raizLocal.getDato() + suma(raizLocal.getIzquierdo()) + suma(raizLocal.getDerecho());
        }
        return suma;
    }

}
