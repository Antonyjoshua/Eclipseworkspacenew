package com.corejave;
//you cannot directly create an instance (object) of an abstract class. Abstract classes are designed to be incomplete and meant to serve as base classes for other classes. They can contain abstract methods, which are methods without a body that must be implemented by subclasses.

public abstract class Abstract {
	// ex:school, subject is common for all but uniform and name differs from
	// schools
	// except private we can use any access specifier
	public void subjects() {
		System.out.println("tam,eng,math,science, soc science");

	}

	// abstract- method without the body
	// any method in a class is abstract then the class will be treated as abstract
	// class
	// we cannot create object for the abstract class
	public abstract void uniform();

	public abstract void schoolname();

}
