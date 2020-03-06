package listConcepts_Java_collection_frameworks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class array_list_iteration {
	
	public static void main(String args[]) {
		
		ArrayList<String> tvSeries = new ArrayList<String>();
		
		tvSeries.add("Game of throne");
		tvSeries.add("Breaking Bad");
		tvSeries.add("The big bang theory");
		tvSeries.add("The walking dead");
		tvSeries.add("Prison break");
		
		// Using java 8 with  for each loop and lambda expression
		
		tvSeries.forEach(shows -> {
			System.out.println(shows);
		});
		
		// Using Iterator
		
		System.out.println("******************");
		System.out.println("******************");
		
		Iterator<String> iterator = tvSeries.iterator();
		while(iterator.hasNext()) {
			String showString = iterator.next();
			System.out.println(showString);
		}
		
		System.out.println("******************");

		// using iterator Java lambda 8 and foreachremaining method()
		
		iterator= tvSeries.iterator();
		iterator.forEachRemaining(swaps ->{
			System.out.println(swaps);
		});
		
		System.out.println("******************");
		
		// using simple for each loop
		for(String eArrayList : tvSeries ) {
			System.out.println(eArrayList);
		}
		
		System.out.println("******************");

		// using for loop with order of Index
		for(int i =0;i<tvSeries.size();i++) {
		
			System.out.println(tvSeries.get(i));
		}
		
		System.out.println("******************");

		// using List iterator to traverse in both the directions
		
		ListIterator<String> listIterator	=	tvSeries.listIterator(tvSeries.size());
		while(listIterator.hasPrevious()) {
			String showString= listIterator.previous();
			System.out.println(showString);
		}		
	}
	}
