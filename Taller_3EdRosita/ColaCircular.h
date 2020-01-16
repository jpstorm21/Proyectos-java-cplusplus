#ifndef COLACIRCULAR_H
#define COLACIRCULAR_H

class ColaCircular {
public:
    ColaCircular(int size);
    virtual ~ColaCircular();
    bool push(int dato); // Retorna true si se pudo ingresar un dato, falso si no.
    int pop();
    int getSize();
private:
    int* vector;
    int size;
    int primero; // Con este se hace pop
    int ultimo; // con este se hace push
};

#endif /* COLACIRCULAR_H */

