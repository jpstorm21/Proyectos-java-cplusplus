//
// Created by Guillermo on 9/19/2018.
//

#ifndef TALLER1_LIFESYSTEM_H
#define TALLER1_LIFESYSTEM_H

#include <string>

class LifeSystem {
	public:
		virtual bool addRule(int) = 0;
		virtual bool removeRule(int) = 0;
		virtual void runGame() = 0;
		virtual void setCurrentCell(int,int,int) = 0;
		virtual std::string getActiveRules() = 0;
		virtual int getCurrentCell(int,int) = 0;
		virtual void finishTurn() = 0;
		virtual ~LifeSystem() = default;
};


#endif //TALLER1_LIFESYSTEM_H
