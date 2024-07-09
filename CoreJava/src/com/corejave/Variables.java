package com.corejave;

public class Variables {
	String name= "Antony"; // Instance variable - Variable which is declared after class and outside the
					 // method, constructor
	String address;
	static String city = "Chennai";// All static variables are global or class variables, remaining variable which
									// are declared in class belong to instance variable and variable which are
									// declared in constructor or methods are local variables
	static int i = 0;
	static int j;
	//Static block is used to initialize the static variables in a block
	static {
		city="bangalore";
		j=3;
		
	}

	public Variables(String name, String address)// local variable- declared within the method
	{
		// this- Refers the current instance,current variable
		this.name = name;
		this.address = address;
		System.out.println(j);

	}
	
	public static String getcity()
	{
		//Static method only accept static variable
		System.out.println(city);
		System.out.println("Using object");
		return city;
		
	}

	public void getdata() {
		System.out.println(name);
		System.out.println(address);
		System.out.println(city);
		i++;
		System.out.println(i);

	}

	public static void main(String[] args) {
		Variables v = new Variables("Hope", "Poonamallee");
		Variables v1 = new Variables("Joshua", "Poonamallee");
		v.getdata();
		v1.getdata();
		Variables.getcity();
		System.out.println(getcity());
		//Instance variable can be invoked using the object
		System.out.println(v.name);
		System.out.println(10+20+"Antony"+10+20);
	}

}
