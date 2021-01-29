// Lina Kang
// CS4A TTH 7:30-9:50PM
// HW Multidimensional Arrays and Recursion
// Exercise 18.25 - String permutation 

package HW4;

public class Exercise_18_25 {
    public static void main(String[]args)
    {
        displayPermutation("abc");
    }
    // a fake method just for show
    public static void displayPermutation(String s)
    {
        displayPermutation("", s);
    }
    // the "helper" method that doesn't get credit for all the work it does
    public static void displayPermutation(String s1, String s2)
    {
        int length = s2.length();
        if(s2.isEmpty())
            System.out.println(s1);
        else{
            for(int i = 0; i < length; i++)
            {
                //takes one character at a time and makes a new string to permute
                displayPermutation(s1 + s2.charAt(i), s2.substring(0, i) + s2.substring(i+1));
            }
        }
        
    }
}
