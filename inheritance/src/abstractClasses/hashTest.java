package abstractClasses;

import java.awt.Point;
import java.util.Arrays;

import com.sun.istack.internal.logging.Logger;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

public class hashTest {
	
	public static void main(String[] args) {
		
		String s="ok";
		StringBuilder sb=new StringBuilder(s);
		System.out.println(s.hashCode()+" "+sb.hashCode());
		String t=new String("ok");
		StringBuilder tb=new StringBuilder(t);
		System.out.println(t.hashCode()+" "+tb.hashCode());
		Point p=new Point(10,20);
		String message="the "+p;
		System.out.println(message);
		//toString部分方法
		int [] luckyNumbers={2,3,5};
		String string=""+luckyNumbers;	
		String ss=Arrays.toString(luckyNumbers);
		System.out.println(string);
		System.out.println(ss);
	}

}
