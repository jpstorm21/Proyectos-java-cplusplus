#ifndef EXAMEN_H
#define EXAMEN_H

#include <string>
using namespace std;

class Examen
{
	public:
		Examen(int codigo, string tipo);
		int getCodigo();
		void setCodigo(int codigo);
		string getTipo();
		void setTipo(string tipo);
                bool getRealizado();
	        void setRealizado(bool realizado);
		
	private:
		int codigo;
		string tipo;
                bool realizado;
		
};

#endif