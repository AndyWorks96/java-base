package linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {
	public static void main(String[] args) {
		
		List<String> a=new LinkedList<>();
		a.add("A");
		a.add("C");
		a.add("E");
		
		List<String> b=new LinkedList<>();
		b.add("B");
		b.add("D");
		b.add("F");
		b.add("G");
		
		//将两个链表进行合并
		//列表迭代器
		ListIterator<String> aIter=a.listIterator();
		Iterator<String > bIter=b.iterator();
		
		while(bIter.hasNext())
		{
			if(aIter.hasNext()) aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println(a);
		
		//重新定义bIter，因为迭代器位置发生改变
		bIter=b.iterator();
		while(bIter.hasNext())
		{
			bIter.next();
			if(bIter.hasNext())
			{
				bIter.next();
				bIter.remove();
			}
		}
		System.out.println(b);
		
		//删除a中b的所有元素
		a.removeAll(b);
		System.out.println(a);
		
		
		
		
		
	}
}
