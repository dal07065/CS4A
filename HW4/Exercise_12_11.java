// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 12.11 - Removes a string from a text file

import java.io.*;
import java.util.*;
public class Exercise_12_11 {

	public static void main(String[] args) {
		
		String remove = args[0];
		File file = new File(args[1]);
		
		try 
		{
			Scanner input = new Scanner(file);
			
			// builder will accumulate all the words EXCEPT for "John".
			// at the end of reading, PrintWriter will write this onto the file again
			StringBuilder builder = new StringBuilder();

			String nextStr;

			System.out.println("Before the removal of \"John\"...\n");

			// Read through the input file + accumulate words + print current file to console

			while(input.hasNext())
			{
				nextStr = input.nextLine();
				System.out.println(nextStr);
				nextStr = nextStr.replaceAll(remove, "");
				builder.append(nextStr + '\n');
				
			}

			// Rewrite all the words onto the file

			PrintWriter output = new PrintWriter(file);
			
			output.write(builder.toString());
			output.close();
			input.close();

			// Print the final result to console

			input = new Scanner(file);

			System.out.println("\nAfter the removal of \"John\"...\n");

			while(input.hasNext())
				System.out.println(input.nextLine());
			input.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File is not found.");
		}
		
	}

}
