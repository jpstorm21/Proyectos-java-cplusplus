#include <cstdlib>
#include <vector>
#include <iostream>
#include "Usuario.h"
#include "Amigo.h"
#include <string>
#include <iosfwd>
using namespace std;
struct ListaAmigos{
    Amigo *la[];    
};

int leerDatos(Usuario *Usuarios[]){
    int pos =0;
    string usuario;
    cout<<"ingrese nombre de usuario: ";
    cin>>usuario;
    string profesion;
    int recPositivas;
    int recNegativas;
    while(usuario != "fin"){
        cout<<"ingrese profesion: ";
        cin>>profesion;
        cout<<"ingrese recomendaciones positivas: ";
        cin>>recPositivas;
        cout<<"ingrese recomendaciones negativas: ";
        cin>>recNegativas;
        string amigo;
        cout<<"ingrese nombre de amigo: ";
        cin>>amigo;
        Usuario *U = new Usuario(usuario,profesion,recPositivas,recNegativas,amigo);
        Usuarios[pos] = U;
        pos++;
        
        cout<<"ingrese nombre de usuario: ";
        cin>>usuario;
    }
    return pos; 
}
int main(int argc, char** argv) {
    Usuario *Usuarios[100];
    Amigo *Amigos[100];
    for(int i = 0;i<100;i++){
        Usuarios[i]= NULL;
    }
    int pos= leerDatos(Usuarios);
    return 0;
}

