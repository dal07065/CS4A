// Lina Kang
// 1072568
// 09/05/2020
// HW2 3.4 - Determine an appropriate month name based on a randomly generated number

package HW2;

public class Exercise_3_4 {
    public static void main(String[]args)
    {
        //Generate Random Number
        int random = (int)(Math.random()*12 + 1);
        String month = "";

        //Determine which month corresponds to the number
        switch(random)
        {
            case 1: 
                month = "January";
                break;
            case 2: 
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "September";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            case 12:
                month = "December";
                break;
        }
        //Output
        System.out.println("Random Number: " + random);
        System.out.println("Month: " + month);
    }
}
