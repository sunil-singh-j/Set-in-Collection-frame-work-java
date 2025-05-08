package copyOnWriteArraySetDemo;

import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;

public class Demo {
	public static void main(String[] args) {
		//Thread -safe
		//Copy on write Mechanism
		//Iterators Do not Reflect Modification
		
		CopyOnWriteArraySet<Integer> arraySet=new CopyOnWriteArraySet<Integer>();
		
		ConcurrentSkipListSet<Integer> concurrentSkipListSet= new ConcurrentSkipListSet<Integer>();
		
		for(int i=1;i<=5;i++) {
			arraySet.add(i);
			concurrentSkipListSet.add(i);
		}
		System.out.println("initial copyOnwriteArrayset: "+arraySet);
		System.out.println("inital concurrentSkipListSet: "+concurrentSkipListSet);
		
		System.out.println("\n Interating and modifying CopyOnWriteArraySet: ");
		

		for(Integer num:arraySet) {
			System.out.println("Reading from copyOnWriteArraySet: " + num);
			//attempting to modify the set During iteration
			arraySet.add(6);
		}
//		 Interating and modifying CopyOnWriteArraySet: 
//			 Reading from copyOnWriteArraySet: 1
//			 Reading from copyOnWriteArraySet: 2
//			 Reading from copyOnWriteArraySet: 3
//			 Reading from copyOnWriteArraySet: 4
//			 Reading from copyOnWriteArraySet: 5
//		
		System.out.println(arraySet);//[1, 2, 3, 4, 5, 6]
		
		
		for(Integer num:concurrentSkipListSet) {
			System.out.println("Reading from copyOnWriteArraySet: " + num);
			//attempting to modify the set During iteration
			concurrentSkipListSet.add(6);
		}
//		Reading from copyOnWriteArraySet: 1
//		Reading from copyOnWriteArraySet: 2
//		Reading from copyOnWriteArraySet: 3
//		Reading from copyOnWriteArraySet: 4
//		Reading from copyOnWriteArraySet: 5
//		Reading from copyOnWriteArraySet: 6
		System.out.println(concurrentSkipListSet);//[1, 2, 3, 4, 5, 6]

		
	}

}
