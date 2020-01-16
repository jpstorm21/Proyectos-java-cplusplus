/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Nodo.h
 * Author: Juan Pablo Martinez
 *
 * Created on 28 de mayo de 2018, 19:44
 */

#ifndef NODO_H
#define NODO_H

class Nodo
{
	public:
		Nodo(int dato,int prioridad);
		Nodo *getNext();
		Nodo *getPrev();
		void setNext(Nodo *);
		void setPrev(Nodo*);
		int getDato();
		int getPrioridad();
	private:
		Nodo* next;
		Nodo *prev;
		int dato;
		int prioridad;
		
};

#endif
