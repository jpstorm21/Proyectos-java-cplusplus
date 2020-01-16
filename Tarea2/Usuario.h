#ifndef USUARIO_H
#define USUARIO_H
#include <string>
using namespace std;
class Usuario {
public:
    Usuario();
    Usuario(string nombre,string profesion,int RecPositivas,int RecNegativas,string amigo);
    int getRecNegativas();
    int getRecPositivas();
    string getNombre();
    string getProfesion();
    string getAmigo();
    void setRecNegativas(int RecNegativas);
    void setRecPositivas(int RecPositivas);
    void setNombre(string nombre);
    void setProfesion(string profesion);
    void setAmigo(string amigo);
    virtual ~Usuario();
private:
    string nombre;
    string profesion;
    int RecPositivas;
    int RecNegativas;
    string  amigo;
};

#endif /* USUARIO_H */

