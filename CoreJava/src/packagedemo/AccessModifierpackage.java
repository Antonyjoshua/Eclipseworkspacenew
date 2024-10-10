package packagedemo;

import com.corejave.AccessModifier;

public class AccessModifierpackage extends AccessModifier{

	public static void main(String[] args) {
		// default modifier->it can be accessed anywhere only in the package not outside
		// of it->we need to change it to public to access the method outside of the
		// package even if we imported the package
		AccessModifier am= new AccessModifier();
		am.getdata3();
		System.out.println(am.j);
		AccessModifierpackage amp= new AccessModifierpackage();
		amp.getdata4();
		Accessmodifierpackage2 am2= new Accessmodifierpackage2();
		
		
	    
		
		

	}

}
