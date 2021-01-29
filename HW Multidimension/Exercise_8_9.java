// Lina Kang
// CS4A TTH 7:30-9:50PM
// HW Multidimensional Arrays and Recursion
// Exercise 8.9 - Tic Tac Toe game 

package HW4;

import java.util.Scanner;

public class Exercise_8_9 {
    public static void main(String[]args)
    {
        int row,col;
        Scanner input = new Scanner(System.in);
        char player = 'X';
        boolean gameOver = false;
        String endingMessage = "It is a draw";

        boolean playerTurn = true;

        char[][] x = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };

        for(int i = 0; i < 9; i++)
        {
            // Lay out the board
            System.out.println("-------------");
            System.out.println("| "+ x[0][0] + " | " + x[0][1] + " | " + x[0][2] + " |");
            System.out.println("-------------");
            System.out.println("| "+ x[1][0] + " | " + x[1][1] + " | " + x[1][2] + " |");
            System.out.println("-------------");
            System.out.println("| "+ x[2][0] + " | " + x[2][1] + " | " + x[2][2] + " |");

            //Get user's input choice
            System.out.print("Enter a row (0, 1, or 2) for player "+ player +": ");
            row = input.nextInt();

            System.out.print("Enter a column (0, 1, or 2) for player " + player + ": ");
            col = input.nextInt();

            //Place the user's choice onto board
            x[row][col] = player;

            //Check whether the user has won or not
            if(isGameOver(x))
            {
                i = 9; //terminate the loop
                endingMessage = player + " player won";
            }
            else
            {
                if(playerTurn)
                    player = 'O';
                else
                    player = 'X';
                playerTurn = !playerTurn;
            }
            System.out.println();
        }

        // Win situation
        System.out.println("-------------");
        System.out.println("| "+ x[0][0] + " | " + x[0][1] + " | " + x[0][2] + " |");
        System.out.println("-------------");
        System.out.println("| "+ x[1][0] + " | " + x[1][1] + " | " + x[1][2] + " |");
        System.out.println("-------------");
        System.out.println("| "+ x[2][0] + " | " + x[2][1] + " | " + x[2][2] + " |");

        System.out.println(endingMessage);
    }

    //Check whether any straight lines/diagonals have been made
    public static boolean isGameOver(char[][] x)
    {
        return  (x[0][0] == 'X' && x[0][1] == 'X' && x[0][2] == 'X') || 
                (x[1][0] == 'X' && x[1][1] == 'X' && x[1][2] == 'X') ||
                (x[2][0] == 'X' && x[2][1] == 'X' && x[2][2] == 'X') ||

                (x[0][0] == 'X' && x[1][0] == 'X' && x[2][0] == 'X') ||
                (x[0][1] == 'X' && x[1][1] == 'X' && x[2][1] == 'X') ||
                (x[0][2] == 'X' && x[1][2] == 'X' && x[2][2] == 'X') ||

                (x[0][0] == 'X' && x[1][1] == 'X' && x[2][2] == 'X') ||
                (x[0][2] == 'X' && x[1][1] == 'X' && x[2][0] == 'X') ||
                
                
                (x[0][0] == 'O' && x[0][1] == 'O' && x[0][2] == 'O') || 
                (x[1][0] == 'O' && x[1][1] == 'O' && x[1][2] == 'O') ||
                (x[2][0] == 'O' && x[2][1] == 'O' && x[2][2] == 'O') ||

                (x[0][0] == 'O' && x[1][0] == 'O' && x[2][0] == 'O') ||
                (x[0][1] == 'O' && x[1][1] == 'O' && x[2][1] == 'O') ||
                (x[0][2] == 'O' && x[1][2] == 'O' && x[2][2] == 'O') ||

                (x[0][0] == 'O' && x[1][1] == 'O' && x[2][2] == 'O') ||
                (x[0][2] == 'O' && x[1][1] == 'O' && x[2][0] == 'O');
    }
}