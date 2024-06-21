package com.corejave;

public class MultiDimentional_Array {

	public static void main(String[] args) {
		//123
		//123
		//123
		int a[][]= new int[3][3];
        a[0][0]=1;
        a[0][1]=2;
        a[0][2]=3;
        a[1][0]=4;
        a[1][1]=5;
        a[1][2]=6;
        a[2][0]=7;
        a[2][1]=8;
        a[2][2]=9;
        System.out.println(a[1][1]);
        //to print all the datas in the multi-dimensional array
        for (int i = 0; i < a.length; i++) {//row
			for (int j = 0; j < a.length; j++) {//column
			 System.out.println(a[i][j]);	
			}
			
		}
        int b[][]= {{1,2},{4,5},{7,8},{10,11}};
        for (int i = 0; i < b.length; i++) {//row
			for (int j = 0; j < 2; j++) {//column
			 System.out.println(b[i][j]);	
			}
			
		}
        
        //four rows, two column in the above array
        System.out.println(b.length);
        System.out.println(b[2][0]);
        String str= "Antony";
        str.length();
     
	}

}
