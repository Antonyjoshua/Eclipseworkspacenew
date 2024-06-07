package com.corejave;

import java.util.Scanner;

public class Inheritance extends Indian_Rules_class {
	// Direct Call: If a method from the parent class is not overridden in the child
	// class, you can call it directly within the child class. Using super:If a
	// method is overridden in the child class and you want to call the parent class
	// version of the method, you use super.methodName().

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String next = sc.nextLine();// next- It does not include the whitespace (space, tab, newline) in the token,
									// and it stops reading when it encounters whitespace.
		// nextline-This reads an entire line of text from the user, which includes
		// everything until the user presses Enter.
		//

		System.out.println("Your name is " + next);
		Inheritance in = new Inheritance();
		in.greenlight();
		in.redlight();
		in.yellowlight();
		in.helmet();
		System.out.println(i);

	}

}
