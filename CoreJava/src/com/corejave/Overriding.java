package com.corejave;

public class Overriding extends Overloading {
	// parentclass methods override by child class with the help of extends keyword
	 
	public void cod() {

		// super keyword get the data from the parent class
		// super.cod();
		System.out.println("Overriding price");
	}
	public void check() {
		System.out.println("summa");

	}

	public static void main(String[] args) {

		Overriding or = new Overriding();
		or.cod();// Calls overridden method in the child class
		Overloading v= new Overriding();
		v.cod();// Calls overridden method in the child class using a reference of the parent class
		or.check();
	}

}
