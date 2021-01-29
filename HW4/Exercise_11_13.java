// Lina Kang
// 1072568
// CS4A TTH 7:30 - 9:50
// Exercise 11.13 - Removes duplicate elements from an array list of integers 

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_11_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("Enter ten integers: ");
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 10; i++)
		{
			list.add(input.nextInt());
		}
		removeDuplicate(list);
		
		System.out.print("The distinct integers are ");
		
		for(int i : list)
		{
			System.out.print(i + " ");
		}
	}
	/*
		function: removeDuplicate()
		purpose: to remove duplicate numbers from a list of integers
		algorithm:
		- create a new ArrayList to keep track of distinct numbers only
		- traverse through the "list"
		- for each integer in "list", check if it coincides with numbers in the "distinct" list
		- if an integer from the list coincides with a number in distinct numbers list
			- remove this integer from "list" 
			- stop checking and DONT add to "distinct" list
			- (because an item was removed, i-- to get the new item in that spot)
		- else
			- add the number to "distinct" list

	*/
	public static void removeDuplicate(ArrayList<Integer> list)
	{
		ArrayList<Integer> distinct = new ArrayList<Integer>();
		boolean found = false;
		for(int i = 0; i < list.size(); i++)
		{
			int temp = list.get(i);
			for(int j = 0; j < distinct.size(); j++)
			{
				if(temp == distinct.get(j))
				{
					list.remove(i);
					found = true;
					break;
				}
			}
			if(!found)
				distinct.add(list.get(i));
			else
				i--;
			found = false;
		}
	}
}
