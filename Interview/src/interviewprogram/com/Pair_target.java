package interviewprogram.com;

public class Pair_target {

	public static void main(String[] args) {
		int a[]= {2,4,6,8,9,1};
		int target=10;
		System.out.println(a.length);
		for(int i=0; i<a.length; i++)
		{
			for (int j=i+1;j<a.length; j++)
			{
				if(a[i]+a[j]==target)
				{
					System.out.println("{"+a[i]+","+a[j]+"}");
				}
			}
		}
		

	}
	/*Why if(a[i] + a[j] == target) compares values and not references

In Java, data types are divided into primitive types and reference types.

Primitive types (like int, float, char, boolean) store actual values.

Reference types (like String, Integer, arrays, classes) store memory references — i.e., the address where the object is located in memory.

In this example:

int a[] = {2, 4, 6, 8, 9, 1};
int target = 10;

for (int i = 0; i < a.length; i++) {
    for (int j = i + 1; j < a.length; j++) {
        if (a[i] + a[j] == target) {
            System.out.println("{" + a[i] + "," + a[j] + "}");
        }
    }
}


Here, a[i], a[j], and target are all primitive int values.
So when we write:

if (a[i] + a[j] == target)


Java compares the numerical values, not memory references.
That’s why the condition correctly checks whether the sum of two numbers equals the target value.

If these were objects (like Integer, String, or any custom class),
then == would compare the references (memory addresses), not the actual content.
In that case, we’d use .equals() for content comparison.

✅ Summary
Type	Example	What == Compares
Primitive	int, float, char	Actual value
Reference	String, Integer, Object	Memory address*/

}
