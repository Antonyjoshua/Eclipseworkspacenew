package com.corejave;

public class While_do_while {

	public static void main(String[] args) {
		int i=1;
		while(i<5)//While loop will continue until the condition becomes false
		{
			System.out.println(i);
			i++;
		}
		//reverse
		int a=10;
		while(a>0)
		{
			System.out.println(a);
			a--;
		}
		//int k=1;
		int j=1;
		do {
		//	System.out.println(k);
			System.out.println(j);//j=1 condition will be checked on second iteration
			//k++;
			j++;
		//	System.out.println(j);//j=2
		}while(j<10);
		 int o = 1;
	        while (o < 5) { // The loop will continue until i is not less than 5
	            System.out.println(o);
	            //! negation convert the true to false, false to true
	            if (!(o == 3)) {
	                // Print a message only if i is not equal to 3
	                System.out.println(o+" is not 3");
	            }
	            o++;
	        }
	}

}
