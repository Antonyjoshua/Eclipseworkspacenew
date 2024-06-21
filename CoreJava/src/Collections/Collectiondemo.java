package Collections;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Collectiondemo {

	public static void main(String[] args) {
		// Write a java program to remove the duplicate number
		int a[] = { 4, 5, 5, 5, 4, 6, 4, 6, 9 };
		List<Integer> collect = IntStream.of(a).distinct().boxed().collect(Collectors.toList());
		System.out.println(collect);
		// print unique values in a array and its count
		int b[] = { 4, 5, 5, 5, 4, 6, 4, 6, 9 };
		ArrayList<Integer> al = new ArrayList<Integer>();
		for (int i = 0; i < b.length; i++) 
		{
			int k = 0;
			if (!al.contains(b[i])) 
			{
				al.add(b[i]);
				k++;
				for ( int j = i + 1; j < b.length; j++) 
				{
					if (b[i] == b[j]) 
					{
						k++;
					}
				}
			
			System.out.println(b[i]);
			System.out.println(k);
			if(k==1)
				System.out.println(a[i]+"Unique number");
			}
		}

	}

}
