package reflection;

import java.util.Random;

public class ReflectionTest {
	public static void main(String[] args) throws  Exception {
		//获得class类的三种方法
		//第一种
		Random random=new Random();
		Class cl=random.getClass();
		String name=cl.getName();
		System.out.println(name);
		System.out.println(cl);
		//第二种
		String className="java.util.Random";
		Class c2=Class.forName(className);
		Object m=Class.forName(className).newInstance();//常见这个类的一个实例
		System.out.println(c2);
		System.out.println(m);
		//第三种
		Class c3=int.class;
		System.out.println(c3);
		Class c4=Double[].class;
		System.out.println(c4);
	}
}
