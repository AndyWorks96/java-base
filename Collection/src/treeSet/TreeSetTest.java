package treeSet;


import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetTest {
	public static void main(String[] args) {
		
		//�����
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
		
		
		//ָ��treeSet�ıȽ���
		//��NavigableSetһ����TreeSet�ĵ����������¿�������Ϊ���࣬
		//һ��ʱ�ṩԪ����ĵ�������������ĳ��Ԫ�أ���һ��ʱ�ṩ���ϵĵ�������������ĳ�����ϡ�
		NavigableSet<Item> sortByDescription=new TreeSet<>(
				Comparator.comparing(Item::getDescription));
		//lambda���ʽ�ķ�������
		
		sortByDescription.addAll(parts);
		System.out.println(sortByDescription);
		
		
	}
}
	