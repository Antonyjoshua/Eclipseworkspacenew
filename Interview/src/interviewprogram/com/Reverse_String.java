package interviewprogram.com;

public class Reverse_String {

	public static void main(String[] args) {
		/*
		 * Note:
		 * In Java, '==' and '.equals()' behave differently when comparing Strings.
		 *
		 * 1. '==' → Compares the reference (memory address)
		 *    - Checks if both String variables point to the same object in memory.
		 *    - Example:
		 *        String s1 = "MOM";
		 *        String s2 = "MOM";
		 *        (s1 == s2) → true  [both refer to same String literal in String pool]
		 *
		 * 2. '.equals()' → Compares the actual content (value) of the Strings
		 *    - Checks if both Strings have the same sequence of characters.
		 *    - Example:
		 *        String s1 = "MOM";
		 *        String s2 = new String("MOM");
		 *        (s1 == s2) → false  [different objects]
		 *        (s1.equals(s2)) → true  [same content]
		 *
		 * In the palindrome program:
		 * 's1' is created dynamically using concatenation in a loop,
		 * so it is stored as a new object (not same as 's' in memory).
		 *
		 * Therefore, always use 'equals()' to compare String values.
		 */
		//s.length() gives 3, but valid indexes are 0, 1, and 2.

		String s="MOM";
		String s1="";
		System.out.println(s.length());
		for(int i=s.length()-1; i>=0;i--)
		{
			s1=s1+s.charAt(i);
		}
		if(s.equals(s1))
		{
			System.out.println("Given string is palindrone");
		}
		else
		{
			System.out.println("Given string is not palindrone");
		}
		System.out.println(s==s1);
		System.out.println(s1);

	}

}
