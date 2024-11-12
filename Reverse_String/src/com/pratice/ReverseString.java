package com.pratice;

public class ReverseString {

	public static void main(String[] args) {
		String str= "Malayalam";
		String str1="";
		for(int i=str.length()-1;i>=0;i--)
			
		{
			System.out.print(str.charAt(i));
			str1=str1+str.charAt(i);
			
		}
		     System.out.println();
             System.out.println(str1);
             if(str1.equalsIgnoreCase(str))
             {
            	 System.out.println("The given string is palindrom");
             }
             else 
             {
            	 System.out.println("Not palindrom");
             }
	}

	
}
