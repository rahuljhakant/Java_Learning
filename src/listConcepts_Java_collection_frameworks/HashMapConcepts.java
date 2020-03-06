package listConcepts_Java_collection_frameworks;

import java.util.HashMap;
import java.util.Map.Entry;


public class HashMapConcepts {

	@SuppressWarnings("rawtypes")
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Hashmap is a class which implements map interface and Extends Abstractmap
		
		// Cointain only unique elements
		// Stores in Key value pair
		// It may have one null key and multiple null values
		
		// It maintains no order
		
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(1, "Selenium");
		hashMap.put(2, "Test Complete");
		hashMap.put(3, "Mocha");
		
		System.out.println(hashMap.get(1));

		System.out.println(hashMap.get(2));

		System.out.println(hashMap.get(3));
		
		for(Entry m : hashMap.entrySet()) {
			
			System.out.println(m.getKey() +  "  "  +  m.getValue());
			
		}
		
		System.out.println(hashMap);

		hashMap.remove(1);
		
		System.out.println(hashMap);
		
		HashMap<Integer, Employee> emp = new HashMap<Integer, Employee>();
		
		Employee e1 = new Employee("Rahul", 21, "Admin");
		Employee e2 = new Employee("Ram", 22, "QA");
		Employee e3 = new Employee("Roy", 23, "Manager");
		
		
		emp.put(1, e1);
		emp.put(2, e2);
		emp.put(3, e3);
		
		
		
		// traverse the hasmap
		for(Entry <Integer,Employee> m: emp.entrySet()) {
			int key= m.getKey();
			Employee value= m.getValue();
			
			System.out.println(key +" Info");
			System.out.println(value.name +"  " + value.age +"  " + value.department);
		}
		

		
		
		

	}

}
