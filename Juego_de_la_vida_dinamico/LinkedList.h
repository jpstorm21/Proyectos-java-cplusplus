//
// Created by Guillermo on 9/15/2018.
//

#ifndef TALLER1_LINKEDLIST_H
#define TALLER1_LINKEDLIST_H
#include "Node.h"
#include <string>

class LinkedList {
	private:
		Node* first;
	public:
		LinkedList();
		Node* getFirst();
		bool isEmpty();
		bool insert(int (*rule)(int,int,int[NEIGHBORS_SIZE],int), const char[MAX_NAME]);
		std::string getRules();
		bool remove(int);
		~LinkedList();

};


#endif //TALLER1_LINKEDLIST_H
