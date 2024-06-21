package Collections;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class HashTable {

	public static void main(String[] args) {
		// same like hashmap- but hashtable doesn't allow null values, synchronized and
		// use emumerator to iterate the values
		//hashtable is a class implements hasttable
		Hashtable<Integer, String> hm = new Hashtable<Integer, String>();
		hm.put(0, "Antony");
		hm.put(1, "joshua");
		hm.put(2, "Bca");
		hm.put(3, "Arkashya");
	//hm.put(4, null); it doesn't accept null pointer
		System.out.println(hm);
		System.out.println(hm.containsValue("Bca"));
		System.out.println(hm.get(3));
		hm.replace(3, "Congnizant");
		System.out.println(hm);
		// tranverse to the map
		// we need to change the map to set
//		Set<Entry<Integer, String>> entrySet = hm.entrySet();
//		Iterator<Entry<Integer, String>> iterator = entrySet.iterator();
//		while (iterator.hasNext()) {
//			System.out.println(iterator.next());
//		}

		// to separate the key and value

//		Set entrySet1 = hm.entrySet();
//		Iterator iterator1 = entrySet1.iterator();
//		while (iterator1.hasNext()) {
//
//			Map.Entry me = (Map.Entry) iterator1.next();
//			System.out.println(me.getKey());
//			System.out.println(me.getValue());
//		}
		
		Enumeration<Integer> keys = hm.keys();
		
		while(keys.hasMoreElements())
		{
			Integer ne = keys.nextElement();
			System.out.println(ne);
			System.out.println(hm.get(ne));
			
		}
		Collection<String> values = hm.values();
		System.out.println(values);
	}

}
