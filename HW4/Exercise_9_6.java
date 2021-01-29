// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 9.6 - Design and Test StopWatch Class

import java.util.Random;

public class Exercise_9_6
{
    public static void main(String[]args)
    {
        StopWatch watch = new StopWatch();

        Random rand = new Random();

        int[] numbers = new int[100_000];

        // initialize the array of 100_000 numbers
        for(int i = 0; i < numbers.length; i++)
        {
            numbers[i] = rand.nextInt(100_000);
        }

        // Selection sort

        watch.start();  // start counting

        for(int i = 0; i < numbers.length-1; i++)
        {
            int min = i;
            for(int j = i + 1; j < numbers.length; j++)

            {
                if(numbers[j] > numbers[min])
                {
                    min = j;
                }
            }
            int temp = numbers[min];
            numbers[min] = numbers[i];
            numbers[i] = temp;
        }

        watch.stop(); // stop counting

        System.out.println("The total elapsed time: " + watch.getElapsedTime());

    }
}

class StopWatch
{
    private long startTime;
    private long endTime;

    StopWatch()
    {
        startTime = System.currentTimeMillis();
    }
    void start()
    {
        startTime = System.currentTimeMillis();
    }
    void stop()
    {
        endTime = System.currentTimeMillis();
    }
    long getElapsedTime()
    {
        return endTime - startTime;
    }
    long getStartTime()
    {
        return startTime;
    }
    long getEndTime()
    {
        return endTime;
    }
}