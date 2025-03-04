package practice.com;

import java.io.IOException;

import java.util.ArrayList;

public class Testsample {

	public static void main(String[] args) throws IOException {
//		Exceldriven ed= new Exceldriven();
//		ArrayList<String> getdata = ed.getdata("Clair J.");
//		System.out.println(getdata);
//		System.out.println(getdata.get(2));
//		System.out.println(getdata.get(4));
//		Exceldriver_Rahulcode er= new Exceldriver_Rahulcode();
//		ArrayList<String> data = er.getData("Clair J.");
//		System.out.println(data);
//		        Exceldriven_chatgpt ed = new Exceldriven_chatgpt();
//		        ArrayList<String> data = ed.getData("Clair J.");
//		        
		        // Print the retrieved data
		     //   for (String entry : data) {
		    //        System.out.println(data);
		       // }
		
		Exceldriven_test et= new Exceldriven_test();
		
		ArrayList<String> getdata = et.getdata("Kelly M.");
		for (String data : getdata) {
			System.out.println(data);
			
		}
		System.out.println(getdata.get(4));
		    }
		}

