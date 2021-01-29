// Lina Kang
// CS4A TTH 7:30-9:50PM
// HW Multidimensional Arrays and Recursion
// Exercise 18.12 - Recursively display a string backwards

package HW4;

public class Exercise_18_12 {
    public static void main(String[]args)
    {
        reverseDisplay("Hello World!", 4);
    }
    // helper method with a "high" index
    public static void reverseDisplay(String value, int high)
    {
        value = value.substring(0, high+1);     //high+1 : substring(startIndex, endIndex-1)
        reverseDisplay(value);
    }
    // actual recursive method that prints the string backwards
    public static void reverseDisplay(String value)
    {
        // base case
        if(value.length() == 0)
            return;
        // general case - print last character & recursively repeat with one less character in the back each time
        System.out.print(value.charAt(value.length()-1));
        reverseDisplay(value.substring(0, value.length()-1));
    }
}
