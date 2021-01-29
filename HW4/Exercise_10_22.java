// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 10.22 - Create my own String class - "MyString" and implement
//					commonly used String functions such as substring() or charAt()

public class Exercise_10_22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] chars = {'G', 'o', 'o', 'd', 'b', 'y', 'e', ',', 
						' ', 'W', 'o', 'r', 'l', 'd', '!'};
		
		MyString1 str = new MyString1(chars);
		
		System.out.print("*Created a new MyString1 called \"str\": ");
		printMyString1(str);
		
		System.out.print("Testing - charAt(5): ");
		System.out.println(str.charAt(5));
		System.out.println();
		
		System.out.print("Testing - length(): ");
		System.out.println(str.length());
		System.out.println();
		
		System.out.print("Testing - substring(2,6): ");
		printMyString1(str.substring(2,6));
		
		System.out.print("Testing - toLowerCase(): ");
		printMyString1(str.toLowerCase());
		
		char[] charsTemp = {'H', 'e', 'l', 'l', 'o', ',', 
							' ', 'W', 'o', 'r', 'l', 'd', '!'};

		MyString1 strTemp = new MyString1(charsTemp);
		
		System.out.print("*Created a new MyString1 called \"strTemp\": ");
		printMyString1(strTemp);
		
		System.out.print("Testing - str.equals(strTemp): " + str.equals(strTemp));
		System.out.println('\n');
		
		MyString1 value;
		
		System.out.println("*Created a new MyString1 called \"value\" : Not Initialized Yet\n");
		
		System.out.print("Testing - value = str.valueOf(2_147_483_647): ");
		value = str.valueOf(2_147_483_647);
		printMyString1(value);

		
	}
	public static void printMyString1(MyString1 str)
	{
		for(int i = 0; i < str.length(); i++)
		{
			System.out.print(str.charAt(i));
		}
		System.out.println('\n');
	}

}

class MyString1
{
	private char[] chars;
	public MyString1(char[] chars)
	{
		this.chars = chars;
	}
	public char charAt(int index)
	{
		return chars[index];
	}
	public int length()
	{
		return chars.length;
	}
	public MyString1 substring(int begin, int end)
	{
		// figure out the length of the substring
		int length = chars.length - end;
		length = chars.length - length;
		length = length - begin;
		
		// new substring to make
		char[] temp = new char[length];
		
		// copy the new substring from old string
		int index = 0;
		for(int i = begin; i < end; i++)
		{
			temp[index] = chars[i];
			index++;
		}
		
		return new MyString1(temp);
	}
	public MyString1 toLowerCase()
	{
		for(int i = 0; i < chars.length; i++)
		{
			char temp = chars[i];
			
			if(temp > 64 && temp < 91) // using ASCII values 'A' to 'Z'
				chars[i] = (char)(temp + 32); // convert it to lowercase
		}
		return this;
	}
	public boolean equals(MyString1 s)
	{
		if(s.length() != chars.length)
		{
			return false;
		}
		else
		{
			for(int i = 0; i < chars.length; i++)
			{
				if(s.charAt(i) != chars[i])
				{
					return false;
				}
			}
		}
		return true;
	}
	/*
	 *  valueOf function - converts an integer into a string version
	 *  
	 *  algorithm:
	 *  
	 *  - Starting from its highest place value,
	 *    divide up the integer, extract the highest place value,
	 *    and repeat until there are no more numbers in the integer
	 */
	public static MyString1 valueOf(int i)
	{
		// what to return at the end of this function
		char[] str = new char[10];
		
		// number to begin dividing the integer by
		
		/*
		 *  division - to "extract" a place value from the integer
		 *  
		 *  how it is used:
		 *  
		 *  - divide the integer by "division" (e.g. 2_147_483_647 / 1_000_000_000)
		 *  - the integer is now 2
		 *  - insert this integer into char[]
		 *  - reset the integer WITHOUT the extracted number (e.g. 147_483_647) 
		 */
		int division = 1_000_000_000;
		
		int temp = i;
		int index = 0;
		
		/*
		 *  checked - to count for zeros within the integer 
		 *    		  (to prevent this: 10000345 -> 1345) 
		 *    
		 *  how it is used:
		 *  
		 *  - set to true as soon as the highest place value has been
		 *    reached when starting from 1_000_000_000
		 *    (to prevent this: 2045 -> 0000002045)
		 */
		boolean checked = false;
		
		while(index < 10 && division >= 1)
		{
			if((temp/division) == 0)
			{
				if(checked)
				{
					str[index] = '0';
					index++;
				}
			}
			else
			{
				temp /= division;					// extract highest place value
				
				str[index] = (char)(temp+'0');		// insert extracted number
				index++;
				
				temp = i - (division*temp);			// "delete" the highest place value from integer
				i = temp;
				
				checked = true;
			}
			division /= 10;
			
			// check for the next highest place value
		}
		
		return new MyString1(str);
	}
}