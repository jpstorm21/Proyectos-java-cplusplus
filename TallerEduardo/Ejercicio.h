#ifndef EJERCICIO_H
#define EJERCICIO_H

class Ejercicio {
public:
    Ejercicio();
    double getNota();
    void setNota(double);
    int getIdentificador();
    void setIdentificador(int);
    ~Ejercicio();
private:
    double nota;
    int identificador;

};

#endif
