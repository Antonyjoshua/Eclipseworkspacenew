package Collections;

import java.util.ArrayList;
import java.util.Iterator;

public class Arraylist {

	public static void main(String[] args) {
		// can accept duplicate values
		// ArraList,LinkedList,vector- Implementing List interface
		// array have fixed size where as arraylist can grow dynamicaly
		//you can access and insert any value in any index 
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("Antony");
		ar.add("joshua");
		System.out.println(ar);
        ar.add(0, "Dr");
        System.out.println(ar);
       System.out.println(ar.isEmpty());
       System.out.println(ar.contains("Dr"));
       System.out.println(ar.get(2));
       ar.remove(2);
       System.out.println(ar);
       System.out.println(ar.size());
       for (int i = 0; i < ar.size(); i++) {
		System.out.println(ar.get(i));
	}
     
       
       
       
	}

}
