#ifndef NODO_H
#define NODO_H

class Nodo {
public:
    Nodo();
    Nodo(int dato);
    Nodo *getHijoIzqui();
    Nodo *getHijoDerech();
    int getDato();
    void setHijoIzqui(Nodo *);
    void setHijoDerech(Nodo *);
    void setDato(int dato);
    virtual ~Nodo();
private:
    Nodo *hijoIzqu;
    Nodo *hijoDerech;
    int dato;

};

#endif /* NODO_H */

