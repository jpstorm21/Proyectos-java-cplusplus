//
// Created by Guillermo on 9/15/2018.
//

#include "LinkedList.h"
#include <string>

LinkedList::LinkedList() {
	first = nullptr;
}

Node* LinkedList::getFirst() {
	return first;
}

bool LinkedList::isEmpty() {
	if(this->first == nullptr){
		return true;
	}
	return false;
}

bool LinkedList::insert(int (*rule)(int, int, int[NEIGHBORS_SIZE], int), const char name[MAX_NAME]) {
	Node *newNode = new Node(rule, name);

	if(this->isEmpty()){
		first = newNode;
		return true;
	}
	else {
		if (first->getName() == newNode->getName()) return false;
		Node *current = this->first;

		while (current->hasNext()) {
			current = current->getNext();
			if (current->getName() == newNode->getName()) return false;
		}
		if (!current->hasNext()) {
			current->setNext(newNode);
			return true;
		}
	}
	return false;
}

std::string LinkedList::getRules(){

	std::string sRules;
	sRules += "[ ";

	Node *current = this->first;
	if(current != nullptr) {
		sRules += current->getName();
		sRules += ", ";


		while (current->hasNext()) {
			current = current->getNext();
			sRules += current->getName();
			sRules += ", ";
		}
	}
	sRules += " ]";
	return sRules;
}

bool LinkedList::remove(int position) {
	Node* current = this->first;

	if(first != nullptr) {

		if (position == 0) {
			first = current->getNext();
			delete current;
			return true;
		} else {
			Node *previous;
			int i;

			for (i = 0; i < position; i++) {
				if (current->hasNext()) {
					previous = current;
					current = current->getNext();
				} else {
					break;
				}
			}

			if (i == position) {
				previous->setNext(current->getNext());
				delete current;
				return true;
			}
		}
	}
	return false;
}

LinkedList::~LinkedList() {
	Node* current = this->first;

	if(!this->isEmpty()) {
		Node *previous;

		while (current->hasNext()) {
			previous = current;
			current = current->getNext();
			delete previous;
		}
	}
	delete current;
}
