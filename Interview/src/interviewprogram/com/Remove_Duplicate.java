package interviewprogram.com;

public class Remove_Duplicate {

	public static void main(String[] args) {
		String original="Programming";
		String filtered="";
		for(int i=0; i<original.length();i++)
		{
			char c = original.charAt(i);
			//✅ -1 → if the character c is not found in the string filtered.
			//✅ an index number (0, 1, 2, ...) → if the character exists in the string.
			if(filtered.indexOf(c)==-1)
			{
				filtered=filtered+original.charAt(i);
				//filtered += c;
			}
		}
		System.out.println(filtered);
	}
}
