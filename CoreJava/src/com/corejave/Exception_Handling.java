package com.corejave;

public class Exception_Handling {

	public static void main(String[] args) {
		// If we feel it might throw an error, we could simply skip and make script pass
		// and catch the error

		try// this block will try works or not
			// once it goes out of the try block it won't come inside again
			// one try can be followed by multiple catch blocks and catch should be followed
			// by try
		{
//		int k=5/0;
//		System.out.println(k);
			int arr[] = new int[5];
			arr[5] = 5;
			System.out.println(arr[5]);
		} 
		catch (ArithmeticException ae)// this is only specific to arithmetic exception
		{
			System.out.println("Arithmetic Exception");
		}
//		catch (Exception e)// This is an generic one.if fails, it enter the catch block and execute the code
//		{
//			System.out.println(" Exception");
//		}
		catch (IndexOutOfBoundsException te)// if fails, it enter the catch block and execute the code
		{
			System.out.println("Indexoutofboundexception");
		}
		finally
		//this block is executed irrespective of exception thrown or not
		//before exiting the program, it should come to the finally block and exit the statement present
		//finally won't work without try block
		{
			System.out.println("Finally block");
		}
		
	}

}
