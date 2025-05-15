package testng.com;

public class Super_Inherit {
	
	//Single Responsibility Principle (SRP) - Short Explanation for Code
//	SRP states that a class should have only one reason to change.
//
//	Instead of writing all logic in one place, separate reusable functions into a utility class.
//	This makes the code modular, reusable, and easier to maintain.
		int a; //instance variable
		
		public Super_Inherit(int a)//local variable
		{
			this.a=a;
			
		}
		public int multiplytwo()
		{
			a=a*2;
			return a;
		}
		public int multiplythree()
		
		{
			System.out.println(a);
			a=a*3;
			return a;
		}


}
