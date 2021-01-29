// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 12.12 - Reformat Java source code from Next-line brace style to End-of-line brace style

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise_12_12 
{
	public static void main(String[] args) 
	{

		File file = new File(args[0]);
		
		try 
		{
			Scanner input = new Scanner(file);
			
			// builder will accumulate all the words AND reformat the braces
			// at the end of reading, PrintWriter will write this onto the file again
			StringBuilder builder = new StringBuilder();
			
			String nextStr;

			System.out.println("Before the reformatting...\n");
			
			// Read the file (checks for '{', '}', ';' punctuations)

			while(input.hasNext())
			{
				nextStr = input.nextLine();
				System.out.println(nextStr);
				if(nextStr.indexOf('{') != -1)
				{
					builder.append(" { " + '\n');
				}
				else if(nextStr.indexOf(';') != -1 || nextStr.indexOf('}') != -1)
				{
					builder.append(nextStr + '\n');
				}
				else
				{
					builder.append(nextStr);
				}
			}
			
			// Rewrite all the words onto the file

			PrintWriter output = new PrintWriter(file);
			
			output.write(builder.toString());
			output.close();
			
			// Print the final result to console

			input = new Scanner(file);

			System.out.println("\nAfter reformatting...\n");

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
