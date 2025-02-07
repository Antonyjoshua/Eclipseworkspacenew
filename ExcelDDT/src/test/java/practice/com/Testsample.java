package practice.com;

import java.io.IOException;
import java.util.ArrayList;

public class Testsample {

	public static void main(String[] args) throws IOException {
		Exceldriven ed= new Exceldriven();
		ArrayList<String> getdata = ed.getdata("Clair J.");
		System.out.println(getdata);
		System.out.println(getdata.get(2));
	}

}
