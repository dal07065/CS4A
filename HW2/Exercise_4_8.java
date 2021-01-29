// Lina Kang
// 1072568
// 09/05/2020
// HW2 4.8 - Determine the character based on its ASCII code

package HW2;

import java.util.Scanner;

public class Exercise_4_8 {
    public static void main(String[]args)
    {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an ASCII code: ");
        int code = input.nextInt();
        char character = (char)code;

        System.out.println("The character for ASCII code " + code + " is " + character);
    }
    
}
