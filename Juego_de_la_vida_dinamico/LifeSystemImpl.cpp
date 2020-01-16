//
// Created by Guillermo on 9/20/2018.
//

#include <cstring>
#include <malloc.h>
#include "LifeSystemImpl.h"
#include "rules.cpp"
#include "constants.h"

LifeSystemImpl::LifeSystemImpl() {
	this->activeRules = new LinkedList();
	this->game = new Board();
}

bool LifeSystemImpl::addRule(int ruleN){
	switch(ruleN){
		case 1:
			return this->activeRules->insert(overPopulation, ruleNames[ruleN-1]);

		case 2:
			return this->activeRules->insert(solitude, ruleNames[ruleN-1]);

		case 3:
			return this->activeRules->insert(revive, ruleNames[ruleN-1]);

		case 4:
			return this->activeRules->insert(oldAge, ruleNames[ruleN-1]);

		case 5:
			return this->activeRules->insert(historicNeighborhood, ruleNames[ruleN-1]);

		case 6:
			return this->activeRules->insert(timeJump, ruleNames[ruleN-1]);

		case 7:
			return this->activeRules->insert(geneticDefect, ruleNames[ruleN-1]);

		default:
			return false;
	}
}

bool LifeSystemImpl::removeRule(int ruleN){
	return this->activeRules->remove(ruleN);
}

void LifeSystemImpl::runGame() {

	for (int i = 0; i < BOARD_SIZE; i++) {
		for (int j = 0; j < BOARD_SIZE; j++) {
			int cell = this->game->getCurrentCell(i,j);
			Node* current = this->activeRules->getFirst();

			while(current != nullptr){
				cell = current->applyRule(i,j,this->game->getNeighborhood(i,j),cell);
				current = current->getNext();
			}
			cell == 0?:cell++;
			this->game->setCell(i,j,cell,false);
		}
	}
}

void LifeSystemImpl::setCurrentCell(int i, int j, int cell) {
	this->game->setCell(i,j,cell,true);
}

std::string LifeSystemImpl::getActiveRules() {
	return this->activeRules->getRules();
}

int LifeSystemImpl::getCurrentCell(int i,int j) {
	return this->game->getCurrentCell(i,j);
}

void LifeSystemImpl::finishTurn() {
	this->game->nextBoardToCurrent();
};

LifeSystemImpl::~LifeSystemImpl() {
	delete this->game;
	delete this->activeRules;
}
