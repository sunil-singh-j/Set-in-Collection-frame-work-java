package set;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class Overview {
	public static void main(String[] args) {
		// Set is a collection that cannot contain duplicate elements
		//faster operation
		//set -->hashSet,LinkedHashSet, TreeSet,EnumSet
		
		Set<Integer> set = new HashSet<Integer>();
		set.add(100);
		set.add(12);
		set.add(54);
		set.add(122);
		System.out.println(set);//[54, 122, 12]//here output is not ordered to do so we should use LinkedHasMap
		
		Set<Integer> set1= new LinkedHashSet<Integer>();
		set1.add(100);
		set1.add(12);
		set1.add(54);
		set1.add(122);
		
		System.out.println(set1);//[100, 12, 54, 122] here the output is in given order but not sorted to do so use TreeSet();
		Set<Integer> set2= new TreeSet<Integer>();
		set2.add(100);
		set2.add(12);
		set2.add(54);
		set2.add(122);
		
		System.out.println(set2);//[12, 54, 100, 122]
		set.clear();
		System.out.println(set);//[]
		
		//for thread safety
		
		Set <Integer> integers= Collections.synchronizedSet(set1);//with we can synchronization but is not efficient so we use 
		//concurrentSkipListSet
		System.out.println(integers);//[100, 12, 54, 122]
		
		NavigableSet< Integer> set4= new ConcurrentSkipListSet<Integer>();
		set4.add(45);
		set4.add(500);
		set4.add(12);
		System.out.println(set4);//[12, 45, 500]
		
		//unmodifiable map---not like map here we can have more than 10 values also
		Set<Integer> set5= Set.of(1,3,4,68,8,2,5,12,35,67,14);
		//set5.add(100);//UnsupportedOperationException
		
		
		Set set5view= Collections.unmodifiableSet(set2);//will return unmodifiable copy of orignal set
	//	set5view.add(11);//UnsupportedOperationException
		set2.remove(12);
		set2.add(111);
		
		
		System.out.println(set2);//[54, 100, 111, 122]
		
		System.out.println(set5view);//[54, 100, 111, 122]
		
		
		
		
		
		
	}

}
