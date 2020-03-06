package listConcepts_Java_collection_frameworks;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map.Entry;
import java.util.Set;



public class Hashtableconcepts {

	@SuppressWarnings({ "rawtypes", "unchecked"})
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// It is similar to hashmap
		// It is synchronised
		// Stores in Key value pair
		// Key -----> object ------> hashcode
		
		
		// Hashcode is a java object number, it's a 32 bit signed integer number.
		
		
		Hashtable h1 = new Hashtable();
		h1.put(1, "Test");
		h1.put(2, "TOM");
		h1.put(3, "JAVA");
		
		// Create a clone copy or shallow copy
		

		Hashtable h2 = new Hashtable();
		h2=(Hashtable) h1.clone();
		
		System.out.println(h1);
		System.out.println(h2);
		
		h1.clear();
		
		System.out.println(h1);
		System.out.println(h2);
		
		// Cointains value
		
		Hashtable st = new Hashtable();
		st.put(1, "rahul");
		st.put(2, "ram");
		st.put(3, "bob");
		
		System.out.println(st.containsValue("rahul"));
		
		// Iterate all the value from hashtable using enumeration
		
		Enumeration e = st.elements();
		System.out.println("print values from st");
		
		while(e.hasMoreElements()) {
			System.out.println(e.nextElement());
		}
		
		// get all the values from hashtable using entry set
		
		System.out.println("Print values from St using Entry set");
		
		Set s = st.entrySet();
		System.out.println(s);
		
		
		// To Check if both the hashtables are equal or not
		
		Hashtable st1 = new Hashtable();
		st1.put(1, "rahul");
		st1.put(2, "ram");
		st1.put(3, "bob");
		
		if(st.equals(st1)) {
			System.out.println("Both the object variables are equal");
		}
		
		// to get a value from a key
		
		System.out.println(st1.get(1));
		
		// Get the hash value
		System.out.println(st1.hashCode());
	
		
		
		
		
		
	}

}
