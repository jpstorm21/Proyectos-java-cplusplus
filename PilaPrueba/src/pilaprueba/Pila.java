/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pilaprueba;

/**
 *
 * @author Usuario
 */
public class Pila {

    int cantA;
    int cantB;
    int cantC;
    int cantD;
    int inicioA;
    int terminoA;
    int inicioB;
    int terminoB;
    int inicioC;
    int terminoC;
    int inicioD;
    int terminoD;
    int[] pila;

    Pila() {
        this.cantA = 0;
        this.cantB = 0;
        this.cantC = 0;
        this.cantD = 0;
        this.inicioA = -1;
        this.terminoA = -1;
        this.inicioB = -1;
        this.terminoB = -1;
        this.inicioC = -1;
        this.terminoC = -1;
        this.inicioD = -1;
        this.terminoD = -1;
        this.pila = new int[20];
    }

    public void insertarA(int dato) {
        if (cantA + cantB + cantC + cantD < 20) {
            if (cantA == 0) {
                for (int i = 19; i > 0; i--) {
                    pila[i] = pila[i - 1];
                }
                pila[0] = dato;
                inicioA = 0;
                terminoA = 0;
                cantA++;
                if (inicioB >= 0) {
                    inicioB++;
                    terminoB++;
                }
                if (inicioC >= 0) {
                    inicioC++;
                    terminoC++;
                }
                if (inicioD >= 0) {
                    inicioD++;
                    terminoD++;
                }
            } else {
                for (int i = 19; i > 0; i--) {
                    pila[i] = pila[i - 1];
                }
                pila[inicioA] = dato;
                cantA++;
                terminoA++;

                if (cantB > 0) {
                    inicioB++;
                    terminoB++;
                }
                if (cantC > 0) {
                    inicioC++;
                    terminoC++;
                }
                if (cantD > 0) {
                    inicioD++;
                    terminoD++;
                }
            }
        } else {
            System.out.println("la pila esta llena!");
        }
    }

    public void insertarB(int dato) {
        if (cantA + cantB + cantC + cantD < 20) {
            if (cantB == 0) {
                if (cantA > 0) {
                    for (int i = 19; i > terminoA + 1; i--) {
                        pila[i] = pila[i - 1];
                    }
                    pila[terminoA + 1] = dato;
                    inicioB = terminoA + 1;
                    terminoB = inicioB;
                    cantB++;
                    if (inicioC >= 0) {
                        inicioC++;
                        terminoC++;
                    }
                    if (inicioD >= 0) {
                        inicioD++;
                        terminoD++;
                    }
                } else {
                    for (int i = 19; i > 0; i--) {
                        pila[i] = pila[i - 1];
                    }
                    pila[0] = dato;
                    inicioB = 0;
                    terminoB = 0;
                    cantB++;
                    if (inicioC >= 0) {
                        inicioC++;
                        terminoC++;
                    }
                    if (inicioD >= 0) {
                        inicioD++;
                        terminoD++;
                    }
                }
            } else {
                inicioB++;
                for (int i = 19; i > inicioB; i--) {
                    pila[i] = pila[i - 1];
                }
                pila[inicioB] = dato;
                cantB++;
                if (cantC > 0) {
                    inicioC++;
                    terminoC++;
                }
                if (cantD > 0) {
                    inicioD++;
                    terminoD++;
                }
            }
        } else {
            System.out.println("la pila esta llena!");
        }
    }

    public void insertarC(int dato) {
        if (cantA + cantB + cantC + cantD < 20) {
            if (cantC == 0) {
                if (cantB > 0) {
                    for (int i = 19; i > terminoB + 1; i--) {
                        pila[i] = pila[i - 1];
                    }
                    pila[terminoB + 1] = dato;
                    inicioC = terminoB + 1;
                    terminoC = inicioC;
                    cantC++;
                    if (inicioD >= 0) {
                        inicioD++;
                        terminoD++;
                    }
                } else {
                    if (cantA > 0) {
                        for (int i = 19; i > terminoA + 1; i--) {
                            pila[i] = pila[i - 1];
                        }
                        pila[terminoA + 1] = dato;
                        inicioC = terminoA + 1;
                        terminoC = inicioC;
                        cantC++;
                        if (inicioD >= 0) {
                            inicioD++;
                            terminoD++;
                        }
                    } else {
                        for (int i = 19; i > 0; i--) {
                            pila[i] = pila[i - 1];
                        }
                        pila[0] = dato;
                        inicioC = 0;
                        terminoC = 0;
                        cantC++;
                        if (inicioD >= 0) {
                            inicioD++;
                            terminoD++;
                        }
                    }
                }
            } else {
                for (int i = 19; i > inicioC; i--) {
                    pila[i] = pila[i - 1];
                }
                pila[inicioC] = dato;
                cantC++;
                terminoC++;
                if (cantD > 0) {
                    inicioD++;
                    terminoD++;
                }
            }
        } else {
            System.out.println("la pila esta llena!");
        }
    }

    public void insertarD(int dato) {
        if (cantA + cantB + cantC + cantD < 20) {
            if (cantD == 0) {
                if (cantC > 0) {
                    for (int i = 19; i > terminoC + 1; i--) {
                        pila[i] = pila[i - 1];
                    }
                    pila[terminoC + 1] = dato;
                    inicioD = terminoC + 1;
                    terminoD = inicioD;
                    cantD++;
                } else {
                    if (cantB > 0) {
                        for (int i = 19; i > terminoB + 1; i--) {
                            pila[i] = pila[i - 1];
                        }
                        pila[terminoB + 1] = dato;
                        inicioD = terminoB + 1;
                        terminoD = inicioD;
                        cantD++;
                    } else {
                        if (cantA > 0) {
                            for (int i = 19; i > terminoA + 1; i--) {
                                pila[i] = pila[i - 1];
                            }
                            pila[terminoA + 1] = dato;
                            inicioD = terminoA + 1;
                            terminoD = inicioD;
                            cantD++;
                        } else {
                            for (int i = 19; i > 0; i--) {
                                pila[i] = pila[i - 1];
                            }
                            pila[0] = dato;
                            inicioD = 0;
                            terminoD = 0;
                            cantD++;
                        }
                    }
                }
            } else {
                inicioD++;
                pila[inicioD] = dato;
                cantD++;
            }
        } else {
            System.out.println("la pila esta llena!");
        }
    }

    public void imprimeA() {
        if (cantA > 0) {
            for (int i = inicioA; i <= terminoA; i++) {
                System.out.print(pila[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("La pila A no tiene datos");
        }
    }

    public void imprimeB() {
        if (cantB > 0) {
            for (int i = terminoB; i <= inicioB; i++) {
                System.out.print(pila[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("La pila B no tiene datos");
        }
    }

    public void imprimeC() {
        if (cantC > 0) {
            for (int i = inicioC; i <= terminoC; i++) {
                System.out.print(pila[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("La pila C no tiene datos");
        }
    }

    public void imprimeD() {
        if (cantD > 0) {
            for (int i = terminoD; i <= inicioD; i++) {
                System.out.print(pila[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("La pila D no tiene datos");
        }
    }

    public void imprimePila() {
        if (cantA + cantB + cantC + cantD > 0) {
            for (int i = 0; i < (cantA + cantB + cantC + cantD); i++) {
                System.out.print(pila[i] + " ");
            }
            System.out.println();
        } else {
            System.out.println("La pila D no tiene datos");
        }
    }

}
