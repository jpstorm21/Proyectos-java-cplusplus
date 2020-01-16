

#ifndef CELULA_H
#define CELULA_H

class Celula {
public:
    Celula(int i,int j,int estadoActual,int ciclos);
    int getFila();
    int getColumna();
    int getEstadoActual();
    int getCiclos();
    void setCiclos(int);
    void setFila(int i);
    void setColumna(int j);
    void setEstado(int estadoActual);
    virtual ~Celula();
private:
    int i;
    int j;
    int estadoActual;
    int ciclos;
    
};

#endif /* CELULA_H */

