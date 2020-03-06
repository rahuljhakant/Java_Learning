package listConcepts_Java_collection_frameworks;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListConcept {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static <E> void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// dynamic array Array List
		// 1. It can cointain duplicate values
		// 2. It maintaines insertion order
		// 3. Synchronised
		// 4. Randon access to fetch the element because it store the value based on index.
		
		ArrayList arrayList = new ArrayList();	
		
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(40);
		
		
		System.out.println(arrayList.size()); // size of array
		
		
		arrayList.add(50);
		arrayList.add(60);
		
		arrayList.add("test");
		
		System.out.print(arrayList.size());
		
		
		System.out.println(arrayList.get(3)); // to get the value from an Index
		
		// To print all the values from an ArrayList using for loop
		
		for(int i=0;i<arrayList.size();i++) {
			System.out.println(arrayList.get(i));
		}
		
		
		// Non generics v/s generics
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(88);
		
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("test");
		a2.add("Selenium");
		
		ArrayList<E> a3 = new ArrayList<E>();
		a3.add((E) "ttttt");
		
		
		
		// Employee class object
		Employee e1 = new Employee("Rahul", 27, "QA");
		Employee e2 = new Employee("ram", 28, "DEV");
		Employee e3 = new Employee("shayam", 29, "ADMIN");
		
		
		// Create ArrayList
		ArrayList<Employee> ar4 = new ArrayList<Employee>();
		ar4.add(e1);
		ar4.add(e2);
		ar4.add(e3);
		
		
		// Iterator to traverse the values
	    Iterator<Employee> iterator =	ar4.iterator();
	    while(iterator.hasNext()) {
	    Employee emp=	iterator.next();
	    System.out.println(emp.name);
	    System.out.println(emp.age);
	    System.out.println(emp.department);
	    }
		
		
		
		
		// Add all method in ArrayList
	    ArrayList<String> ar5 = new ArrayList<String>();
	    ar5.add("one");
	    ar5.add("two");
	    ar5.add("three");
	    
	    ArrayList<String> ar6 = new ArrayList<String>();
	    ar6.add("four");
	    ar6.add("five");
	    ar6.add("six");
	    
	    
	    ar5.addAll(ar6);
	    
	    
	    System.out.println("***********************");
	    
	    
	    
	    for(int i=0;i<ar5.size();i++) {
	    	System.out.println(ar5.get(i));
	    }
	    
	    System.out.println("***********************");

	    
	    // remove all
	    ar5.removeAll(ar6);
	    for(int i=0;i<ar5.size();i++) {
	    	System.out.println(ar5.get(i));
	    }
	    
	    
	    
	    
	    System.out.println("***********************");

		// retain all
	    
	    ArrayList<String> ar7 = new ArrayList<String>();
	    ar7.add("test");
	    ar7.add("Selenium");
	    ar7.add("QTP");
	    
	    ArrayList<String> ar8 = new ArrayList<String>();
	    ar8.add("test");
	    ar8.add("java");
	    ar8.add("Selenium");


	    
	    ar7.retainAll(ar8);
	    
	    for(int i=0;i<ar7.size();i++) {
	    	System.out.println(ar7.get(i));
	    }
	    
	    
	    
	    
	    
		
		
		
		
		
		
		

	}

}
