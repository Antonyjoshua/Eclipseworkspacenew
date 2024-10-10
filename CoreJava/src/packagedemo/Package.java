package packagedemo;

import com.corejave.Final;
import com.corejave.Finalchild;

//import packagename.classname
//User defined package
//we can create object for a class in another class, if its from the same package. If not you need to import the package
public class Package extends Final {

	public static void main(String[] args) {
		Finalchild fd = new Finalchild();
		fd.getdata1();
		Final f = new Final();
		f.getdata1();

	}

}
