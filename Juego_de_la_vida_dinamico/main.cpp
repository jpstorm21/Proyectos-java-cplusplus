#include "main.h"
#include <bits/stdc++.h>
#include <afxres.h>
#include "LifeSystem.h"
#include "LifeSystemImpl.h"
#include "constants.h"
#include <unistd.h>
#include <conio.h>
#include <stdlib.h>
#include <windows.h>
#include <tchar.h>
#include <string.h>
#include <dshow.h>

using namespace std;

static LifeSystem* sistema = new LifeSystemImpl();

void readFile() {

    ifstream archivoEntrada;
    string linea;

    archivoEntrada.open("celulas.txt", ios::in); //abriendo el archivo en modo lectura

    if (archivoEntrada.fail()) {
        cout << "No se pudo abrir el archivo!";
        exit(1);
    }
    /**
     * al cambiar el board_size a 60, incrementa el tamanio de la matriz
     * lo ideal seria que si cambian el archivo algo mas pequenio no estar
     * modificando el tamanio, el pipe me dijo que nos basaramos en la lectura
     * de la ultima ayudantia.
     * #volvi a dejar en 30
     * */
    for (int i = 0; i < BOARD_SIZE; i++) {
        getline(archivoEntrada, linea);

        for (int j = 0; j < BOARD_SIZE; j++) {
            int cell;
            archivoEntrada >> cell;
            sistema->setCurrentCell(i, j, cell);
        }
    }

    archivoEntrada.close();
}

void startGame(HWND hWnd, int turns) {
    const int WAIT_TIME = 90;

    for (int i = 0; i < turns; i++) {
        sistema->runGame();
        sistema->finishTurn();
        MSG msg;
        PeekMessage(&msg, hWnd, NULL, 0, 0);
        Sleep(WAIT_TIME);
        InvalidateRect(hWnd, NULL, FALSE);
        UpdateWindow(hWnd);

    }
}

// Global variables

// The main window class name.
static TCHAR szWindowClass[] = _T("win32app");

// The string that appears in the application's title bar.
static TCHAR szTitle[] = _T("Dynamic Conway's Game of Life");

HINSTANCE hInst;

// Forward declarations of functions included in this code module:
LRESULT CALLBACK WndProc(HWND, UINT, WPARAM, LPARAM);

int CALLBACK WinMain(
        _In_ HINSTANCE hInstance,
        _In_ HINSTANCE hPrevInstance,
        _In_ LPSTR lpCmdLine,
        _In_ int nCmdShow
        ) {
    readFile();

    WNDCLASSEX wcex;

    wcex.cbSize = sizeof (WNDCLASSEX);
    wcex.style = CS_HREDRAW | CS_VREDRAW;
    wcex.lpfnWndProc = WndProc;
    wcex.cbClsExtra = 0;
    wcex.cbWndExtra = 0;
    wcex.hInstance = hInstance;
    wcex.hIcon = LoadIcon(hInstance, IDI_APPLICATION);
    wcex.hCursor = LoadCursor(NULL, IDC_ARROW);
    wcex.hbrBackground = (HBRUSH) (COLOR_WINDOW + 1);
    wcex.lpszMenuName = NULL;
    wcex.lpszClassName = szWindowClass;
    wcex.hIconSm = LoadIcon(wcex.hInstance, IDI_APPLICATION);

    if (!RegisterClassEx(&wcex)) {
        MessageBox(NULL,
                _T("Llamado to RegisterClassEx fallo!"),
                _T("Dynamic Conway's Game of Life"),
                NULL);

        return 1;
    }

    hInst = hInstance; // Store instance handle in our global variable

    // The parameters to CreateWindow explained:
    // szWindowClass: the name of the application
    // szTitle: the text that appears in the title bar
    // WS_OVERLAPPEDWINDOW: the type of window to create
    // CW_USEDEFAULT, CW_USEDEFAULT: initial position (x, y)
    // NULL: the parent of this window
    // NULL: this application does not have a menu bar
    // hInstance: the first parameter from WinMain
    // NULL: not used in this application
    HWND hWnd = CreateWindow(
            szWindowClass,
            szTitle,
            WS_OVERLAPPEDWINDOW,
            CW_USEDEFAULT, CW_USEDEFAULT,
            WINDOW_SIZEX, WINDOW_SIZEY,
            NULL,
            NULL,
            hInstance,
            NULL
            );


    if (!hWnd) {
        MessageBox(NULL,
                _T("Llamado a CreateWindow fallo!"),
                _T("Dynamic Conway's Game of Life"),
                NULL);

        return 1;
    }

    // The parameters to ShowWindow explained:
    // hWnd: the value returned from CreateWindow
    // nCmdShow: the fourth parameter from WinMain
    ShowWindow(hWnd,
            nCmdShow);
    UpdateWindow(hWnd);

    // Main message loop:
    MSG msg;
    while (GetMessage(&msg, NULL, 0, 0)) {
        TranslateMessage(&msg);
        DispatchMessage(&msg);
    }

    return (int) msg.wParam;
}




//
//  FUNCTION: WndProc(HWND, UINT, WPARAM, LPARAM)
//
//  PURPOSE:  Processes messages for the main window.
//
//  WM_PAINT    - Paint the main window
//  WM_DESTROY  - post a quit message and return
//
//

LRESULT CALLBACK WndProc(HWND hWnd, UINT message, WPARAM wParam, LPARAM lParam) {

    const int X_BUTTON_POSITION = 150;
    const int Y_BUTTON_POSITION = 60;
    const int X_BUTTON_DISTANCE = 100;
    const int Y_BUTTON_DISTANCE = 40;
    const int BUTTON_WIDTH = 80;
    const int BUTTON_HEIGHT = 20;
    const int X_TEXT_POSITION = 7;
    const int Y_TEXT_POSITION = 100;
    const int Y_TEXT_DISTANCE = 40;

    PAINTSTRUCT ps;
    HDC hdc;

    static string info = "";

    switch (message) {
        case WM_CREATE:
        {

            for (int i = 1; i <= RULE_SIZE; i++) {
                CreateWindow(TEXT("BUTTON"), // Predefined class; Unicode assumed
                        TEXT("Agregar"), // Button text
                        WS_TABSTOP | WS_VISIBLE | WS_CHILD | BS_DEFPUSHBUTTON, // Styles
                        X_BUTTON_POSITION, // x position
                        Y_BUTTON_POSITION + i * Y_BUTTON_DISTANCE, // y position
                        BUTTON_WIDTH, // Button width
                        BUTTON_HEIGHT, // Button height
                        hWnd, // Parent window
                        (HMENU) i,
                        NULL,
                        NULL
                        );

                CreateWindow(TEXT("BUTTON"), // Predefined class; Unicode assumed
                        TEXT("Info"), // Button text
                        WS_TABSTOP | WS_VISIBLE | WS_CHILD | BS_DEFPUSHBUTTON, // Styles
                        X_BUTTON_POSITION + X_BUTTON_DISTANCE, // x position
                        Y_BUTTON_POSITION + i * Y_BUTTON_DISTANCE, // y position
                        BUTTON_WIDTH, // Button width
                        BUTTON_HEIGHT, // Button height
                        hWnd, // Parent window
                        (HMENU) (i + RULE_SIZE),
                        NULL,
                        NULL
                        );
            }

            CreateWindow(TEXT("EDIT"), // Predefined class; Unicode assumed
                    TEXT(""), // Button text
                    WS_TABSTOP | WS_VISIBLE | WS_CHILD | WS_BORDER, // Styles
                    X_BUTTON_POSITION, // x position
                    Y_BUTTON_POSITION + (RULE_SIZE + 1) * Y_BUTTON_DISTANCE, // y position
                    BUTTON_WIDTH, // Button width
                    BUTTON_HEIGHT, // Button height
                    hWnd, // Parent window
                    (HMENU) ((RULE_SIZE * 2) + 1),
                    NULL,
                    NULL
                    );

            CreateWindow(TEXT("BUTTON"), // Predefined class; Unicode assumed
                    TEXT("Remover"), // Button text
                    WS_TABSTOP | WS_VISIBLE | WS_CHILD, // Styles
                    X_BUTTON_POSITION + X_BUTTON_DISTANCE, // x position
                    Y_BUTTON_POSITION + (RULE_SIZE + 1) * Y_BUTTON_DISTANCE, // y position
                    BUTTON_WIDTH, // Button width
                    BUTTON_HEIGHT, // Button height
                    hWnd, // Parent window
                    (HMENU) ((RULE_SIZE * 2) + 2),
                    NULL,
                    NULL
                    );



            CreateWindow(TEXT("EDIT"), // Predefined class; Unicode assumed
                    TEXT(""), // Button text
                    WS_TABSTOP | WS_VISIBLE | WS_CHILD | WS_BORDER, // Styles
                    X_BUTTON_POSITION, // x position
                    Y_BUTTON_POSITION + (RULE_SIZE + 2) * Y_BUTTON_DISTANCE, // y position
                    BUTTON_WIDTH, // Button width
                    BUTTON_HEIGHT, // Button height
                    hWnd, // Parent window
                    (HMENU) ((RULE_SIZE * 2) + 3),
                    NULL,
                    NULL
                    );

            CreateWindow(TEXT("BUTTON"), // Predefined class; Unicode assumed
                    TEXT("Empezar"), // Button text
                    WS_TABSTOP | WS_VISIBLE | WS_CHILD | BS_DEFPUSHBUTTON, // Styles
                    X_BUTTON_POSITION - X_BUTTON_DISTANCE, // x position
                    Y_BUTTON_POSITION + (RULE_SIZE + 3) * Y_BUTTON_DISTANCE, // y position
                    BUTTON_WIDTH, // Button width
                    BUTTON_HEIGHT, // Button height
                    hWnd, // Parent window
                    (HMENU) ((RULE_SIZE * 2) + 4),
                    NULL,
                    NULL
                    );

            CreateWindow(TEXT("BUTTON"), // Predefined class; Unicode assumed
                    TEXT("Salir"), // Button text
                    WS_TABSTOP | WS_VISIBLE | WS_CHILD | BS_DEFPUSHBUTTON, // Styles
                    X_BUTTON_POSITION + X_BUTTON_DISTANCE, // x position
                    Y_BUTTON_POSITION + (RULE_SIZE + 3) * Y_BUTTON_DISTANCE, // y position
                    BUTTON_WIDTH, // Button width
                    BUTTON_HEIGHT, // Button height
                    hWnd, // Parent window
                    (HMENU) ((RULE_SIZE * 2) + 5),
                    NULL,
                    NULL
                    );

            break;
        }
        case WM_COMMAND:
        {
            int id = LOWORD(wParam);
            info = "";

            if (id <= RULE_SIZE) {
                info = sistema->addRule(id) ? info + ruleNames[id - 1] + " agregada con exito." : "Error, regla ya existe.";
                InvalidateRect(hWnd, NULL, FALSE);
                UpdateWindow(hWnd);
            } else {

                if (id <= RULE_SIZE * 2) {
                    info = ruleInfo[id - RULE_SIZE - 1];
                    InvalidateRect(hWnd, NULL, FALSE);
                    UpdateWindow(hWnd);
                } else {

                    switch (id) {
                        case (RULE_SIZE * 2) + 2:
                        {
                            char *sRemove = new char[10];
                            Edit_GetText(GetDlgItem(hWnd, ((RULE_SIZE * 2) + 1)), sRemove, 10);
                            int remove = atoi(sRemove);
                            delete sRemove;
                            info = sistema->removeRule(remove - 1) ? "Regla removida con exito" : "Error, posicion no valida.";
                            InvalidateRect(hWnd, NULL, FALSE);
                            UpdateWindow(hWnd);
                            break;
                        }
                        case (RULE_SIZE * 2) + 4:
                        {
                            char *sTurns = new char[10];
                            Edit_GetText(GetDlgItem(hWnd, ((RULE_SIZE * 2) + 3)), sTurns, 10);
                            int turns = atoi(sTurns);
                            delete sTurns;
                            if (turns != 0) {
                                startGame(hWnd, turns);
                            } else {
                                info = "Numero de turnos invalido.";
                                InvalidateRect(hWnd, NULL, FALSE);
                                UpdateWindow(hWnd);
                            }
                            break;
                        }
                        case (RULE_SIZE * 2) + 5:
                        {
                            delete sistema;
                            exit(1);
                        }
                    }
                }
            }
            break;
        }
        case WM_PAINT:
        {
            TCHAR title[] = _T("Agrega tus reglas: ");
            TCHAR underline[] = _T("-----------------------------");
            TCHAR remove[] = _T("Quitar Regla #:");
            TCHAR turns[] = _T("Numero de turnos:");
            TCHAR nota[] = _T("Nota: Mas oscura == mas vieja.");

            hdc = BeginPaint(hWnd, &ps);
            HPEN hPen = CreatePen(PS_DASHDOTDOT, 2, NULL);
            TextOut(hdc, X_TEXT_POSITION, 40, title, _tcslen(title));
            TextOut(hdc, X_TEXT_POSITION, 60, underline, _tcslen(underline));

            for (int i = 0; i < RULE_SIZE; i++) {
                TextOut(hdc, X_TEXT_POSITION, Y_TEXT_POSITION + i * Y_TEXT_DISTANCE, ruleNames[i],
                        _tcslen(ruleNames[i]));
            }
            TextOut(hdc, X_TEXT_POSITION, Y_TEXT_POSITION + RULE_SIZE * Y_TEXT_DISTANCE, remove, _tcslen(remove));
            TextOut(hdc, X_TEXT_POSITION, Y_TEXT_POSITION + (RULE_SIZE + 1) * Y_TEXT_DISTANCE, turns, _tcslen(turns));
            SelectObject(hdc, hPen);
            Rectangle(hdc, MATRIX_LEFT, MATRIX_TOP, MATRIX_RIGHT, MATRIX_BOTTOM);

            for (int i = 0; i < BOARD_SIZE; i++) {
                for (int j = 0; j < BOARD_SIZE; j++) {

                    Rectangle(hdc,
                            MATRIX_LEFT + j * CELL_SIDE,
                            MATRIX_BOTTOM + i * CELL_SIDE + CELL_SIDE,
                            MATRIX_LEFT + j * CELL_SIDE + CELL_SIDE,
                            MATRIX_BOTTOM + i * CELL_SIDE);

                    RECT cellSquare = {
                        MATRIX_LEFT + j * CELL_SIDE,
                        MATRIX_BOTTOM + i * CELL_SIDE + CELL_SIDE,
                        MATRIX_LEFT + j * CELL_SIDE + CELL_SIDE,
                        MATRIX_BOTTOM + i * CELL_SIDE
                    };

                    int intensity = sistema->getCurrentCell(i, j);
                    COLORREF cellColor = intensity == 0 ? RGB(255, 255, 255) : RGB(0, 255 - intensity, 0);
                    HBRUSH hBrush = CreateSolidBrush(cellColor);
                    FillRect(hdc, &cellSquare, hBrush);
                    DeleteObject(hBrush);
                    DeleteObject(hPen);
                }
            }
            Rectangle(hdc, INFOBOX_LEFT, INFOBOX_TOP, INFOBOX_RIGHT, INFOBOX_BOTTOM);
            Rectangle(hdc, MATRIX_LEFT, MATRIX_TOP + 10, MATRIX_RIGHT, MATRIX_TOP + 50);
            RECT infoSquare = {INFOBOX_LEFT + 5, INFOBOX_TOP + 5, INFOBOX_RIGHT - 5, INFOBOX_BOTTOM};
            RECT ruleSquare = {MATRIX_LEFT + 5, MATRIX_TOP + 15, MATRIX_RIGHT - 5, MATRIX_TOP + 50};

            DrawText(hdc, info.c_str(), info.length(), &infoSquare, DT_WORDBREAK);
            std::string activeRules = sistema->getActiveRules();
            DrawText(hdc, activeRules.c_str(), activeRules.length(), &ruleSquare, DT_WORDBREAK);
            TextOut(hdc, MATRIX_LEFT, MATRIX_TOP + 60, nota, _tcslen(nota));
            // End application-specific layout section.

            EndPaint(hWnd, &ps);
            break;
        }
        case WM_DESTROY:
        {
            PostQuitMessage(0);
            break;
        }
        case WM_GETMINMAXINFO:
        {
            LPMINMAXINFO lpMMI = (LPMINMAXINFO) lParam;
            lpMMI->ptMinTrackSize.x = WINDOW_SIZEX;
            lpMMI->ptMaxTrackSize.x = WINDOW_SIZEX;
            lpMMI->ptMinTrackSize.y = WINDOW_SIZEY;
            lpMMI->ptMaxTrackSize.y = WINDOW_SIZEY;
        }



        default:
        {
            return DefWindowProc(hWnd, message, wParam, lParam);
        }
    }
    return 0;
}
