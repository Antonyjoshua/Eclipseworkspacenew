package com.corejave;

public class ClaSS implements InterFACE {
	public void car()
	{
		System.out.println("Class car");
	}
	public void bike()
	{
		System.out.println("Class bike");
	}


	public static void main(String[] args) {
		ClaSS c = new ClaSS();
		c.car();
		c.bike();
		InterFACE in= new ClaSS();
		in.bike();
		in.walf();
		
		
	}
	//An interface in Java is a contract. Any class implementing the interface must provide concrete implementations for all its methods.
	//If InterFACE has methods bike() and walf(), the implementing class must override them.
	@Override
	public void walf() {
		System.out.println("Interface walf");
		
	}

}
//When you call a method like driver.get("https://example.com"), the method implementation in the ChromeDriver class is executed at runtime.
//This behavior of resolving method calls to the actual implementation at runtime is called runtime polymorphism.
