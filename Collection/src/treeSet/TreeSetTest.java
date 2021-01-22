package treeSet;


import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		
		//红黑树
//		SortedSet<String> sorter=new TreeSet<>();
//		sorter.add("Bob");
//		sorter.add("Amy");
//		sorter.add("Carl");
//		for(String s:sorter) 
//			System.out.println(s);
		SortedSet<Item> parts=new TreeSet<>();
		parts.add(new Item("Toaster",1234));
		parts.add(new Item("Widget",4562));
		parts.add(new Item("Modem",3912));
		System.out.println(parts);
		
		
		//指定treeSet的比较器
		//和NavigableSet一样，TreeSet的导航方法大致可以区分为两类，
		//一类时提供元素项的导航方法，返回某个元素；另一类时提供集合的导航方法，返回某个集合。
		NavigableSet<Item> sortByDescription=new TreeSet<>(
				Comparator.comparing(Item::getDescription));
		//lambda表达式的方法引用
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
		
		
	}
}
	