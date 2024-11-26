package com.corejave;

public class Overloading {
	//same method with different argument list
	//Argument count should differ of argument data type should differ
	public void payment(int creditcard) {
		
		System.out.println(creditcard);
		

	}
	
	public void payment(String cash) {
  System.out.println(cash);
	}
	
	public void payment(int creditcard, String cash) {
		
        System.out.println(creditcard + cash);
	}
	public void cod() {
		System.out.println("Overloading price");

	}

//	public static void main(String[] args) {
//		Overloading ov= new Overloading();
//		ov.payment(471704);
//		ov.payment("Thousand");
//		ov.payment(471704, "Thousand");
//
//	}

}
