

#ifndef JUEGO_H
#define JUEGO_H
#include <string.h>
#include <iostream>
using namespace std;

class Juego {
public:
    Juego(string codigo, string nombre, string desarrollador, string plataforma, string fecha, int stockInicial, int stockActual, int precio);
    string getCodigo();
    string getNombre();
    string getDesarrollador();
    string getPlataforma();
    string getFecha();
    int getStockInicial();
    int getStockActual();
    int getPrecio();
    void setCodigo(string codigo);
    void setNombre(string nombre);
    void setDesarrollador(string desarrollador);
    void setPlataforma(string plataforma);
    void setFecha(string fecha);
    void setStockInicial(int stockInicial);
    void setStockActual(int stockActual);
    void setPrecio(int precio);
    
    virtual ~Juego();
private:
    string codigo;
    string nombre;
    string desarrollador;
    string plataforma;
    string fecha;
    int stockInicial;
    int stockActual;
    int precio;

};

#endif /* JUEGO_H */

