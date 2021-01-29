// Lina Kang
// CS4A TTH 7:30-9:50PM
// HW Multidimensional Arrays and Recursion
// Exercise 8.20 - Connect four game

package HW4;
import java.util.Scanner;

public class Exercise_8_20 {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        String color = "red";
        int column = 0;
        char[][] connectBoard = {
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '}
        };

        // Start Game
        do
        {
            printBoard(connectBoard);

            System.out.print("Drop a " + color + " disk at column (0-6): ");
            column = input.nextInt();

            if(putDiskInColumn(connectBoard, column, color))
                color = changeColor(color);
    
        }while(!isGameOver(connectBoard));

    }
    // Print the current board
    public static void printBoard(char[][] connectBoard)
    {
        System.out.println();
        for(int i = 0; i < connectBoard.length; i++)
        {
            for(int j = 0; j < connectBoard[0].length; j++)
            {
                System.out.print("|" + connectBoard[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("---------------");
    }
    // Place the disc in a specified column of the board
    public static boolean putDiskInColumn(char[][] x, int column, String color)
    {
        for(int i = x.length-1; i >= 0;i--)
        {
            if(x[i][column] == ' ')
            {
                if(color == "red")
                    x[i][column] = 'R';
                else
                    x[i][column] = 'Y';
                return true;
            }
        }
        System.out.println("This column is full. Try again");
        return false;
    }
    // Change turns of players
    public static String changeColor(String color)
    {
        if(color == "red")
            color = "yellow";
        else
            color = "red";
        return color;
    }

    // honestly... I am not sure if I can explain this algorithm...
    public static boolean isGameOver(char[][] x)
    {
        // All check algorithms will check if a same character has 
        // shown up 4 times in a row consecutively
        // (and is NOT the empty character)

        char temp;
        int count = 0;

        //horizontal check
        for(int i = 5; i >= 0; i--)
        {
            temp = x[i][0];
            for(int j = 1; j < 7; j++)
            {
                if(temp == x[i][j] && temp != ' ')
                    count++;
                else
                    count = 0;
                
                temp = x[i][j];

                // if 4 characters have been found consecutively
                if(count == 3)  // 3, not 4 because A==B, B==C, C==D } ABCD
                {
                    printBoard(x);
                    if(x[i][j] == 'R')
                        System.out.println("The red player won");
                    else
                        System.out.println("The yellow player won");
                    return true;
                }
            }
        }
        //vertical check
        for(int i = 0; i < 7; i++)
        {
            temp = x[5][i];
            for(int j = 4; j >= 0; j--)
            {
                if(temp == x[j][i] && temp != ' ')
                    count++;
                else
                    count = 0;
                temp = x[j][i];
                if(count == 3)
                {
                    printBoard(x);
                    if(x[j][i] == 'R')
                        System.out.println("The red player won");
                    else
                        System.out.println("The yellow player won");
                    return true;
                }
            }
        }

        //diagonal check "/" shape pt.1
        for(int i = 3; i < 6; i++)
        {
            int ipoint = i;
            for(int j = 0; j < i; j++)
            {
                if(x[ipoint][j] == x[ipoint-1][j+1] && x[ipoint][j] != ' ')
                    count++;
                else
                    count = 0;
                ipoint--;
                if(count == 3)
                {
                    printBoard(x);
                    if(x[ipoint][j] == 'R')
                        System.out.println("The red player won");
                    else
                        System.out.println("The yellow player won");
                    return true;
                }
            }
        }
        //diagonal check "/" shape pt.2
        for(int i = 0; i < 3; i++)
        {
            int ipoint = i;
            for(int j = 6; j > i+1; j--)
            {
                if(x[ipoint][j] == x[ipoint+1][j-1] && x[ipoint][j] != ' ')
                    count++;
                else
                    count = 0;
                ipoint++;
                if(count == 3)
                {
                    printBoard(x);
                    if(x[ipoint][j] == 'R')
                        System.out.println("The red player won");
                    else
                        System.out.println("The yellow player won");
                    return true;
                }
            }
        }
        //diagonal check "\" shape pt.1
        int jpoint = 3;
        for(int i = 3; i < 6; i++)
        {
            int ipoint = i;
            for(int j = 6; j > jpoint; j--)
            {
                if(x[ipoint][j] == x[ipoint-1][j-1] && x[ipoint][j] != ' ')
                    count++;
                else
                    count = 0;
                ipoint--;
                if(count == 3)
                {
                    printBoard(x);
                    if(x[ipoint][j] == 'R')
                        System.out.println("The red player won");
                    else
                        System.out.println("The yellow player won");
                    return true;
                }
            }
            jpoint--;
        }
        //diagonal check "\" shape pt.2
        jpoint = 5;
        for(int i = 0; i < 3; i++)
        {
            int ipoint = i;
            for(int j = 0; j < jpoint; j++)
            {
                if(x[ipoint][j] == x[ipoint+1][j+1] && x[ipoint][j] != ' ')
                    count++;
                else
                    count = 0;
                ipoint++;
                if(count == 3)
                {
                    printBoard(x);
                    if(x[ipoint][j] == 'R')
                        System.out.println("The red player won");
                    else
                        System.out.println("The yellow player won");
                    return true;
                }
            }
            jpoint--;
        }
        return false;
    }
}
