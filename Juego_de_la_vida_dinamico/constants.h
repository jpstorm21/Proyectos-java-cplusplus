//
// Created by Guillermo on 9/21/2018.
//

#ifndef TALLER1_CONSTANTS_H
#define TALLER1_CONSTANTS_H

static const int NEIGHBORS_SIZE = 8;
static const int DEAD_CELL = 0;
static const int ADULT_AGE = 10;
static const int BOARD_SIZE = 30;
static const int WINDOW_SIZEX = 1000;
static const int WINDOW_SIZEY = 720;
static const int MATRIX_LEFT = 340;
static const int MATRIX_TOP = 590;
static const int MATRIX_RIGHT = 880;
static const int MATRIX_BOTTOM = 50;
static const int CELL_SIDE = (MATRIX_TOP-MATRIX_BOTTOM)/BOARD_SIZE;
static const int INFOBOX_LEFT = 7;
static const int INFOBOX_TOP = 500;
static const int INFOBOX_RIGHT = 330;
static const int INFOBOX_BOTTOM = 650;
static const int RULE_SIZE = 7;
static const char* ruleNames[] = {"Sobrepoblacion", "Soledad", "Revivir", "Vejez", "Barrio Historico", "Salto en el tiempo", "Defecto Genetico"};
static const char* ruleInfo[] = {"Sobrepoblacion: Si la celula tiene mas de 3 celulas vecinas, esta morira.",
								 "Soledad: Si la celula tiene menos de 2 celulas vecinas, esta morira.",
								 "Revivir: Si la celula tiene 3 celulas vecinas, esta revivira.",
								 "Vejez: Si la celula supera los 25 periodos de edad, esta celula morira.",
								 "Barrio Historico: Si la celula tiene una vecindad con 4 o mas celulas adultas"
								 " (es decir, con mas de 10 periodos de vida), la celula persiste.",
								 "Salto en el tiempo: : Si la celula tiene 10 o mas periodos y ademas, tiene una vecindad"
		   						 "con 3 o mas celulas jovenes (es decir, con menos de 10 periodos de vida), esta celula "
								 "aumentara 5 periodos extra por periodo real de la simulacion.",
								 "Defecto Genetico: Si una celula tiene una vecindad con 4 celulas adultas, esa revive con 5 turnos de edad."};


#endif //TALLER1_CONSTANTS_H
