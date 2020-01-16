//
// Created by Guillermo on 9/17/2018.
//
#include <bits/stdc++.h>
#include "Board.h"
#include "constants.h"
#include <stdlib.h>

Board::Board() {
	this->currentBoard = (int **)malloc(BOARD_SIZE * sizeof(int*));

	for(int i = 0; i < BOARD_SIZE; i++) {
		currentBoard[i] = (int *)malloc(BOARD_SIZE * sizeof(int));
	}
	this->nextBoard = (int **)malloc(BOARD_SIZE * sizeof(int*));

	for(int i = 0; i < BOARD_SIZE; i++) {
		nextBoard[i] = (int *)malloc(BOARD_SIZE * sizeof(int));
	}
}

int Board::getCurrentCell(int i, int j) {
	return this->currentBoard[i][j];
}

int* Board::getNeighborhood(int i, int j){
	const int START_OF_BOARD = 0;
	const int PROXIMITY_NUMBER = 1;

	int* neighborhood = new int[NEIGHBORS_SIZE];
	int position = 0;

	for(int k = i-PROXIMITY_NUMBER; k <= i+PROXIMITY_NUMBER; k++){

		for(int l = j-PROXIMITY_NUMBER; l <= j+PROXIMITY_NUMBER; l++) {

			if(!(k == i && l == j)){

				if(k < BOARD_SIZE && l < BOARD_SIZE && k >= START_OF_BOARD && l >= START_OF_BOARD){
					neighborhood[position] = this->currentBoard[k][l];
				}
				else{
					neighborhood[position] = -1;
				}
				position++;
			}
		}
	}
	return neighborhood;
}

void Board::setCell(int i, int j, int state, bool current) {

	if(current){
		this->currentBoard[i][j] = state;
	}
	else{
		this->nextBoard[i][j] = state;
	}
}

void Board::nextBoardToCurrent() {

	for(int i = 0; i < BOARD_SIZE; i++){

		for(int j = 0; j < BOARD_SIZE; j++) {
			this->currentBoard[i][j] = this->nextBoard[i][j];
		}
	}
}

Board::~Board() {

	for(int i = 0; i < BOARD_SIZE; i++) {
		free(currentBoard[i]);
	}

	for(int i = 0; i < BOARD_SIZE; i++) {
		free(nextBoard[i]);
	}
	free(currentBoard);
	free(nextBoard);
}