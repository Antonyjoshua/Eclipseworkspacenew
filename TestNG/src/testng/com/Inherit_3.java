package testng.com;

public class Inherit_3 extends Super_Inherit {
	int a; // instance variable

	public Inherit_3(int a)// local variable

	{
		// super keyword invoke the parent class constructor and pass the value of a
		// when we use super keyword in child class, it should be in the first line of
		// the constructor.
		super(a);
		this.a = a;

	}

	public int increment() {
//		a=a+1;
//		return a;
		a++;
		return a;
	}

	public int decrement() {
		a = a - 1;
		return a;
	}

}
