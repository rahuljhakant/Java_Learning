package listConcepts_Java_collection_frameworks;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListConcepts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LinkedList<String> ll = new LinkedList<String>();

		ll.add("test");
		ll.add("QTP");
		ll.add("selenium");
		ll.add("rpa");
		
		System.out.println("Contens of linked list : "+ll);
		
		// add first
		ll.addFirst("first");
		
		// add last
		ll.addLast("last");
		
		System.out.println("Contens of linked list : "+ll);
		
		// get
		System.out.println(ll.get(3));
		
		//set
		ll.set(0, "set index");
		System.out.println(ll.get(0));
		
		// remove first and last element
		ll.removeFirst();
		ll.removeLast();
		
		
		System.out.println("Contens of linked list : "+ll);
		
		// how to print / iterate all the values of Linkedlist
		// for loop
		System.out.println("***********************");
		System.out.println("Using for loop");


		for(int i=0;i<ll.size();i++) {
			System.out.println(ll.get(i));
		}

		System.out.println("***********************");
		System.out.println("Using while loop");

		// while loop
		int num=0;
		while(ll.size()>num) {
			System.out.println(ll.get(num));
			num++;
		}
		
		System.out.println("***********************");

		// iterator
		System.out.println("Using Iterator");
		Iterator<String> it =ll.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println("***********************");

		
		// advanced for each loop
		System.out.println("Using advanced for each loop");

		for(String str:ll) {
			System.out.println(str);
		}

	}

}
