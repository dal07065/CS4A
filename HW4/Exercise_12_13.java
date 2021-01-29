// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 12.13 - Count characters, words, and lines in a file

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exercise_12_13 {

	public static void main(String[] args) 
	{
		File file = new File(args[0]);
		int	countChar = 0, countWords = 0, countLines = 0, index = 0;
		
		try 
		{
			Scanner input = new Scanner(file);
			
			String nextStr, nextStrCopy;
						
			// Read from the file

			while(input.hasNext())
			{
				nextStr = input.nextLine();
				nextStrCopy = nextStr;
				
				// if the line begins with empty space or tab
				if(nextStr.indexOf(' ') == 0)
				{
					// System.out.println("Deleting empty spaces...");
					while(nextStr.length() > 0 && nextStr.charAt(0) == ' ')
					{
						nextStr = nextStr.substring(1);
					}
				}
				// if the line ends with empty spaces
				if(nextStr.lastIndexOf(' ') == nextStr.length()-1)
				{
					while(nextStr.length() > 0 && nextStr.charAt(nextStr.length()-1) == ' ')
					{
						nextStr = nextStr.substring(0, nextStr.length()-1);
					}
				}
				// Loop through the phrase until no spaces are left (a space is deleted as soon as a word is counted)
				while(nextStr.indexOf(' ') != -1)
				{
					countWords++;
					// System.out.println("Word: " + nextStr.substring(0, nextStr.indexOf(' ')) + "--");
					nextStr = nextStr.substring(nextStr.indexOf(' ') + 1);
				}
				// System.out.println("Word: " + nextStr + "--");

				// Count for the very last word, count for all the characters, count the line
				countWords++;
				countChar += (nextStrCopy.replaceAll(" ", "")).length();
				countLines++;
			}
			input.close();
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("File is not found.");
		}

		// Final Output

		System.out.println("File " + args[0] + " has");
		System.out.println(countChar + " characters");
		System.out.println(countWords + " words");
		System.out.println(countLines + " lines\n");

	}
}
