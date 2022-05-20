package tictactoe;

import java.util.Scanner;

public class Main {
    public static void printBoard(char[][] cells) {
        System.out.println();
        System.out.println("---------");
        System.out.println("| " + cells[0][0] + " " + cells[0][1] + " " + cells[0][2] + " |");
        System.out.println("| " + cells[1][0] + " " + cells[1][1] + " " + cells[1][2] + " |");
        System.out.println("| " + cells[2][0] + " " + cells[2][1] + " " + cells[2][2] + " |");
        System.out.println("---------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*System.out.print("Enter cells: ");
        String layout = scanner.next();*/
        char[][] cells = new char[3][3];
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = '_';
            }
        }

        char move = 'X';
        char move2 = 'O';

        printBoard(cells);

        while (true) {
            while (true) {
                System.out.print("Enter the coordinates: ");
                String xCoord = scanner.next();
                String yCoord = scanner.next();
                int xPos;
                int yPos;
                try {
                    xPos = Integer.parseInt(xCoord);
                    yPos = Integer.parseInt(yCoord);
                } catch (NumberFormatException e) {
                    System.out.println("You should enter numbers!");
                    continue;
                }
                if (!(xPos >= 1 && xPos <= 3) || !(yPos >= 1 && yPos <= 3)) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    continue;
                }
                xPos--;
                yPos--;
                if (cells[xPos][yPos] == '_') {
                    cells[xPos][yPos] = move;
                    break;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            }

            printBoard(cells);

            boolean xRow = false;
            boolean oRow = false;
            boolean blank = false;

            for (int a = 0; a < cells.length; a++) {
                if (cells[a][0] == 'X' && cells[a][1] == 'X' && cells[a][2] == 'X') {
                    xRow = true;
                } else if (cells[a][0] == 'O' && cells[a][1] == 'O' && cells[a][2] == 'O') {
                    oRow = true;
                }
            }

            for (int b = 0; b < cells.length; b++) {
                if (cells[0][b] == 'X' && cells[1][b] == 'X' && cells[2][b] == 'X') {
                    xRow = true;
                } else if (cells[0][b] == 'O' && cells[1][b] == 'O' && cells[2][b] == 'O') {
                    oRow = true;
                }
            }

            if ((cells[0][0] == 'X' && cells[1][1] == 'X' && cells[2][2] == 'X') || (cells[0][2] == 'X' && cells[1][1] == 'X' && cells[2][0] == 'X')) {
                xRow = true;
            } else if ((cells[0][0] == 'O' && cells[1][1] == 'O' && cells[2][2] == 'O') || (cells[0][2] == 'O' && cells[1][1] == 'O' && cells[2][0] == 'O')) {
                oRow = true;
            }

            for (int c = 0; c < cells.length; c++) {
                for (int d = 0; d < cells[c].length; d++) {
                    if (cells[c][d] == '_') {
                        blank = true;
                    }
                }
            }

            int xCount = 0;
            int oCount = 0;

            for (int e = 0; e < cells.length; e++) {
                for (int f = 0; f < cells[e].length; f++) {
                    if (cells[e][f] == 'X') {
                        xCount++;
                    }
                }
            }

            for (int g = 0; g < cells.length; g++) {
                for (int h = 0; h < cells[g].length; h++) {
                    if (cells[g][h] == 'O') {
                        oCount++;
                    }
                }
            }

            char temp = 'Y';
            if (xRow && !oRow) {
                System.out.print("X wins");
                break;
            } else if (!xRow && oRow) {
                System.out.print("O wins");
                break;
            /*} else if (xRow && oRow || Math.abs(xCount - oCount) >= 2) {
                System.out.print("Impossible");*/
            } else if (!xRow && !oRow && blank) {
                //System.out.print("Game not finished");
                temp = move;
                move = move2;
                move2 = temp;
                continue;
            } else if (!xRow && !oRow && !blank) {
                System.out.print("Draw");
                break;
            }
        }
    }
}
