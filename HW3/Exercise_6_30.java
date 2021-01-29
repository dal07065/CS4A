// Lina Kang
// 1072568
// 09/12/2020
// Exercise 6.30 - Game of Craps

public class Exercise_6_30{
    public static void main(String[]args)
    {
        // Roll Two dice

        int die1 = (int)(1 + Math.random() * 6);
        int die2 = (int)(1 + Math.random() * 6);

        // Sum two dice

        int sum = die1 + die2;

        System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum);

        // Check if sum is 2,3,12(craps); 7,11(natural:win); 

        if(sum == 2 || sum == 3 || sum == 12)
            System.out.println("You lose");
        else if(sum == 7 || sum == 11)
            System.out.println("You win");

        // else if (4,5,6,8,9,10)(point)- roll two dice, sum two dice, check if sum is SAME(win) or 7(lose)
        else
        {
            do
            {
                System.out.println("point is " + (die1 + die2));

                die1 = (int)(1 + Math.random() * 6);
                die2 = (int)(1 + Math.random() * 6);

                int sum2 = die1 + die2;

                System.out.println("You rolled " + die1 + " + " + die2 + " = " + sum2);

                if(sum == sum2)
                {
                    System.out.println("You win");
                    break;
                }
                else if(sum2 == 7)
                {
                    System.out.println("You lose");  
                    break;
                }

            } while(true);
        }

    }
}