package priorityQueue;

import java.time.LocalDate;
import java.util.PriorityQueue;



public class priorityQueueTest {
	public static void main(String[] args) {
			
		PriorityQueue<LocalDate> pQueue=new PriorityQueue<>();
		pQueue.add(LocalDate.of(1902, 12, 9));
		pQueue.add(LocalDate.of(1815, 12, 10));
		pQueue.add(LocalDate.of(1903, 12, 3));
		pQueue.add(LocalDate.of(1910, 6, 22));
		System.out.println("Iterating over elements...");
		for(LocalDate date :pQueue)
			System.out.println(date);
		System.out.println("É¾³ýºó");
		while(!pQueue.isEmpty()){
			System.out.println(pQueue.remove());
		}
	}
	
}
