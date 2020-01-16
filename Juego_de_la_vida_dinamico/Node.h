//
// Created by Guillermo on 9/15/2018.
//

#ifndef TALLER1_NODE_H
#define TALLER1_NODE_H

#include "constants.h"
const int MAX_NAME = 20;

class Node {
	private:
		int (*rule)(int, int, int[], int);
		const char* name;
		Node* next;
	public:
		Node(int (*)(int, int, int[NEIGHBORS_SIZE], int), const char[MAX_NAME]);
		int applyRule(int,int,int*,int);
		Node* getNext();
		void setNext(Node*);
		const char* getName();
		bool hasNext();
};

#endif //TALLER1_NODE_H
