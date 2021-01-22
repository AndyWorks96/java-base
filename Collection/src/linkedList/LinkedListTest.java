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
		
		//������������кϲ�
		//�б������
		ListIterator<String> aIter=a.listIterator();
		Iterator<String > bIter=b.iterator();
		
		while(bIter.hasNext())
		{
			if(aIter.hasNext()) aIter.next();
			aIter.add(bIter.next());
		}
		System.out.println(a);
		
		//���¶���bIter����Ϊ������λ�÷����ı�
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
		
		//ɾ��a��b������Ԫ��
		a.removeAll(b);
		System.out.println(a);
		
		
		
		
		
	}
}
