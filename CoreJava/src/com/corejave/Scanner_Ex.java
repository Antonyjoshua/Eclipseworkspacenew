package com.corejave;

import java.util.Scanner;

public class Scanner_Ex {
	public static void main(String[] args) {
		// Create a Scanner object to read input
		Scanner scanner = new Scanner(System.in);

		// Prompt the user to enter their name
		System.out.print("Enter your name: ");
		String name = scanner.nextLine(); // Read a line of text

		// Prompt the user to enter their age
		System.out.print("Enter your age: ");
		int age = scanner.nextInt(); // Read an integer

		// Consume the newline left-over scanner.nextLine(); - This is necessary to
		// consume the newline character left in the input buffer by nextInt(). Without
		// this step, the subsequent nextLine() call would return immediately, consuming
		// this leftover newline.
		scanner.nextLine();

		// Prompt the user to enter their favorite quote
		System.out.print("Enter your favorite quote: ");
		String quote = scanner.nextLine(); // Read another line of text

		// Display the input values
		System.out.println("Name: " + name);
		System.out.println("Age: " + age);
		System.out.println("Favorite Quote: " + quote);

		// Close the scanner
		scanner.close();
	}
}
