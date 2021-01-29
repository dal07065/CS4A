// Lina Kang
// CS4A TTH 7:30-9:50PM
// HW Multidimensional Arrays and Recursion
// Exercise 8.6 - Multiplying Matrices

package HW4;

import java.util.Scanner;

public class Exercise_8_6 {
    public static void main(String[]args)
    {
        double[][] a = new double[3][3];
        double[][] b = new double[3][3];
        
        // Input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix1: ");
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                a[i][j] = input.nextDouble();
            }
        }
        System.out.print("Enter matrix2: ");
        for(int i = 0; i < b.length; i++)
        {
            for(int j = 0; j < b[i].length; j++)
            {
                b[i][j] = input.nextDouble();
            }
        }

        // Processing
        double[][] c = multiplyMatrix(a, b);

        // Output
        System.out.println("The multiplication of the matrices is");
        for(int i = 0; i < a.length; i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                System.out.printf("%.1f ", a[i][j]);
            }
            if(i == 1)
                System.out.print("   *  ");
            else
                System.out.print("      ");
            for(int j = 0; j < b[i].length; j++)
            {
                System.out.printf("%.1f ", b[i][j]);
            }
            if(i == 1)
                System.out.print("   =  ");
            else
                System.out.print("      ");
            for(int j = 0; j < c[i].length; j++)
            {
                System.out.printf("%.1f ",c[i][j]);
            }
            System.out.println();
        }

    }
    public static double[][] multiplyMatrix(double[][] a, double[][] b)
    {
        double[][] c = new double[3][3]; 

        // perform calculation per "c" element in order
        for(int i = 0; i < a.length;i++)
        {
            for(int j = 0; j < a[i].length; j++)
            {
                // the 0's, 1's, and 2's are from a pattern I noticed
                // by writing down sample calculations 
                c[i][j] = (a[i][0] * b[0][j]) + (a[i][1] * b[1][j]) + (a[i][2] * b[2][j]);
            }
        }
        return c;
    }
}
