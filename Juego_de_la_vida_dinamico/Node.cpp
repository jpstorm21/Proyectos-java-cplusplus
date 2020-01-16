//
// Created by Guillermo on 9/15/2018.
//
#include "Node.h"

Node::Node(int (*rule)(int, int, int[NEIGHBORS_SIZE], int),const char name[MAX_NAME]) {
	this->name = name;
	this->rule = rule;
	this->next = nullptr;
}

int Node::applyRule(int i, int j , int neighbors[NEIGHBORS_SIZE], int currentState) {
	return this->rule(i, j, neighbors, currentState);
}

Node* Node::getNext() {
	return this->next;
}

void Node::setNext(Node *newNode){
	this->next = newNode;
}

bool Node::hasNext() {

	if(next == nullptr){
		return false;
	}
	return true;
}

const char* Node::getName() {
	return name;
}