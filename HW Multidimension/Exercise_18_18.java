// Lina Kang
// CS4A TTH 7:30-9:50PM
// HW Multidimensional Arrays and Recursion
// Exercise 18.18 - Tower of Hanoi but find number of moves needed to move n disks

package HW4;
import java.util.Scanner;
public class Exercise_18_18 
{
    // Make a static variable to keep count of # of moves
    static int moveNumber = 0;
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = input.nextInt();
        System.out.println("The moves are: ");
        moveDisks(n, 'A', 'B', 'C');
        // Print number of Moves
        System.out.println("\nNumber of moves taken for " + n + " disks: " + moveNumber);
    }
    // increment moveNumber everytime it prints a move
    public static void moveDisks(int n, char fromTower, char toTower, char auxTower)
    {
        if(n == 1)
        {
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            moveNumber++; // increment moveNumber
        }
        else
        {
            moveDisks(n - 1, fromTower, auxTower, toTower);
            System.out.println("Move disk " + n + " from " + fromTower + " to " + toTower);
            moveNumber++; // increment moveNumber
            moveDisks(n - 1, auxTower, toTower, fromTower);
        }
    }
}
