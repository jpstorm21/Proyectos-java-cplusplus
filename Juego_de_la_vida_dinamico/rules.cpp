//
// Created by Guillermo on 9/15/2018.
//
#include <math.h>
#include "constants.h"

static int overPopulation(int i, int j, int neighbors[NEIGHBORS_SIZE], int currentState){
    const int OVERPOPULATION_NUMBER = 3;

    if(currentState <= DEAD_CELL){
        return currentState;
    }
    int cellCounter = 0;

    for(int k = 0; k < NEIGHBORS_SIZE; k++) {

        if(neighbors[k] > DEAD_CELL){
            cellCounter++;
        }

        if (cellCounter > OVERPOPULATION_NUMBER) {
            return DEAD_CELL;
        }
    }
    return currentState;
}

static int solitude(int i, int j, int neighbors[NEIGHBORS_SIZE], int currentState){
    const int SOLITUDE_NUMBER = 2;

    if(currentState <= DEAD_CELL){
        return currentState;
    }
    int cellCounter = 0;

    for(int k = 0; k < NEIGHBORS_SIZE; k++) {

        if (neighbors[k] > DEAD_CELL) {
            cellCounter++;
        }
    }

    if(cellCounter < SOLITUDE_NUMBER){
        return DEAD_CELL;
    }
    return currentState;
}

static int revive(int i, int j, int neighbors[NEIGHBORS_SIZE], int currentState){
    const int NEWBORN_CELL = 1;
    const int REVIVE_NUMBER = 3;

    if(currentState != DEAD_CELL){
        return currentState;
    }

    int cellCounter = 0;

    for(int k = 0; k < NEIGHBORS_SIZE; k++) {

        if (neighbors[k] > DEAD_CELL) {
            cellCounter++;
        }
    }

    if(cellCounter == REVIVE_NUMBER){
        return NEWBORN_CELL;
    }
    return currentState;
}

static int oldAge(int i, int j, int neighbors[NEIGHBORS_SIZE], int currentState){
    const int OLD_AGE = 25;

    if(currentState > OLD_AGE){
        return DEAD_CELL;
    }
    return currentState;
}

static int historicNeighborhood(int i, int j, int neighbors[NEIGHBORS_SIZE], int currentState) {
	const int ADULT_CELL_NUMBER = 4;

	if(currentState == DEAD_CELL){
		return currentState;
	}
	int adultCellCounter = 0;

	for(int k = 0; k < NEIGHBORS_SIZE; k++) {

		if (neighbors[k] > ADULT_AGE) {
			adultCellCounter++;
		}

		if (adultCellCounter >= ADULT_CELL_NUMBER) {
			return currentState*-1;
		}
	}
	return currentState;
}


static int timeJump(int i, int j, int neighbors[NEIGHBORS_SIZE], int currentState){
    const int EXTRA_PERIODS = 5;
    const int YOUNG_CELL_NUMBER = 3;

    if(abs(currentState) >= ADULT_AGE){
        int youngCellCounter = 0;

        for(int k = 0; k < NEIGHBORS_SIZE; k++) {

            if (neighbors[k] > DEAD_CELL && neighbors[k] < ADULT_AGE) {
                youngCellCounter++;
            }

            if (youngCellCounter >= YOUNG_CELL_NUMBER) {

				if (currentState > 0) {
					return currentState + EXTRA_PERIODS;
				}
				return currentState - EXTRA_PERIODS;
            }
        }
    }
    return currentState;
}


static int geneticDefect(int i, int j, int neighbors[NEIGHBORS_SIZE], int currentState){
	const int NEWBORN_CELL = 5;
	const int REVIVE_NUMBER = 4;

	if(currentState != DEAD_CELL){
		return currentState;
	}

	int adultCellCounter = 0;

	for(int k = 0; k < NEIGHBORS_SIZE; k++) {

		if (neighbors[k] > DEAD_CELL && neighbors[k] < ADULT_AGE) {
			adultCellCounter++;
		}
	}

	if(adultCellCounter == REVIVE_NUMBER){
		return NEWBORN_CELL;
	}
	return currentState;
}
