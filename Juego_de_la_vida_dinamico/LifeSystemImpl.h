//
// Created by Guillermo on 9/20/2018.
//

#ifndef TALLER1_LIFESYSTEMIMPL_H
#define TALLER1_LIFESYSTEMIMPL_H
#include "LifeSystem.h"
#include "LinkedList.h"
#include "Board.h"

class LifeSystemImpl : public LifeSystem {
	private:
		LinkedList* activeRules;
		Board* game;
	public:
		LifeSystemImpl();
		bool addRule(int) override;
		bool removeRule(int) override;
		void runGame() override;
		void setCurrentCell(int,int,int) override;
		std::string getActiveRules() override;
		int getCurrentCell(int,int) override;
		void finishTurn() override;
		~LifeSystemImpl();
};


#endif //TALLER1_LIFESYSTEMIMPL_H
