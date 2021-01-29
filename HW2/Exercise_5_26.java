// Lina Kang
// 1072568
// 09/05/2020
// HW2 5.26 - Calculate the 'e' value for different 'i'

package HW2;

public class Exercise_5_26 {
    public static void main(String[]args)
    {
        int i = 0;
        double e = 1;

        // previousI will hold previous value of i
        // Ex: 
        //     i = 20000
        //     previousI = 10000
        // factorial will keep count of current factorial and will never reset.
        
        int previousI = 0;
        double factorial = 1;
        
        // For loop for each i = 10000, i = 20000, upto i = 100000
        for(int x = 0; x < 10; x++)
        {
            previousI = i+1;
            i += 10000;
            
            // For loop to calculate factorial of i and add 1/i! to e
            for(int a = previousI; a <= i; a++)
            {
                factorial *= a;
                e += 1.0/factorial;

            }
            System.out.println("'i' is : " + i + "\ne is : " + e + '\n');
        }
    }
    
}
