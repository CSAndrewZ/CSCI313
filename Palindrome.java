/**
 * @author andrewzheng	
 * Question:R-5.18 This recursive code check the input string if it is palindrome or not
 * It use several if statement to see if the two char are the same in reverse 
 * from first to last char of the string.  
 */

import java.util.Scanner;

public class Palindrome {
	public static boolean isPalindrome(String s) {
		if (s.length() <= 1) // if the length is 1 or less then String is palindrome
			return true;
		if (s.charAt(0) == s.charAt(s.length() - 1)) // check for first/last character of string
			// if the two char are same, it moves on the next two char
			// The first and last char removed. This if statement repeat through recursion
			return isPalindrome(s.substring(1, s.length() - 1));
		// recursive call to repeat until all string is checked

		return false;// return false if it doesn't met the if condition of being palindrome.
	}

	public static void main(String[] args) {
		// Allows user input of a string to test it
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a string:");
		String string = scanner.nextLine();
		boolean flag = isPalindrome(string);// true or false condition
		if (flag)
			System.out.println(string + " is a palindrome");
		else
			System.out.println(string + " is not a palindrome");
	}
}