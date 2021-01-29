// Lina Kang
// 1072568
// 09/05/2020
// HW2 4.21 - Checks whether its a valid social security number

package HW2;

import java.util.Scanner;

public class Exercise_4_21 {
    public static void main(String[]args)
    {
        // Input

        Scanner input = new Scanner(System.in);

        System.out.print("Enter a SSN: ");
        String ssn = input.nextLine();

        String valid = "a valid";       // will change to "an invalid" if invalid SSN is determined

        // Iterates through each character of SSN to distinguish btw numbers and '-' in correct positions.
        for(int i = 0; i < 11; i++)
        {
            if(ssn.charAt(i) >= '0' && ssn.charAt(i) <= '9')
                continue;
            else if((i == 3 || i == 6 ) && ssn.charAt(i) == '-')
                continue;
            else
            {
                valid = "an invalid";
                break;
            }
        }
        
        System.out.println(ssn + " is " + valid + " social security number");

    }
}
