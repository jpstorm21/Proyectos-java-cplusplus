//
// Created by Guillermo on 9/17/2018.
//

#ifndef TALLER1_BOARD_H
#define TALLER1_BOARD_H


class Board {
	private:
		int** currentBoard;
		int** nextBoard;
	public:
		Board();
		int getCurrentCell(int,int);
		int* getNeighborhood(int, int);
		void setCell(int,int,int,bool);
		void nextBoardToCurrent();
		~Board();
};


#endif //TALLER1_BOARD_H
