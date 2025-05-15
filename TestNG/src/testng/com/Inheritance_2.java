package testng.com;

import org.testng.annotations.Test;

public class Inheritance_2 extends Inheritance_1 {
	// in testng, if you use inheritance concept we don't need to create object to
	// call the method which is in parent class
	@Test
	public void childmethod() {
		// int a=3;
		parentmethod();
		Inherit_3 in = new Inherit_3(2);
		System.out.println(in.increment());
		System.out.println(in.decrement());
		System.out.println(in.multiplytwo());
		System.out.println(in.multiplythree());

	}
	// when we run the child class, it will check the parent class and get the
	// knowledge about all the methods present in the parent class and keep it in
	// the child
	// even if the before and after method where in parent class the child class has
	// all the memory.
	// What is Boilerplate Code?
	// Boilerplate code refers to repetitive, standard code that is often required
	// in many programs but doesn’t contribute to the core logic of the application.
	// It is typically used for setup, configuration, or structure in programming.
}
