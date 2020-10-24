package reflection;

import java.util.Random;

public class ReflectionTest {
	public static void main(String[] args) throws  Exception {
		//���class������ַ���
		//��һ��
		Random random=new Random();
		Class cl=random.getClass();
		String name=cl.getName();
		System.out.println(name);
		System.out.println(cl);
		//�ڶ���
		String className="java.util.Random";
		Class c2=Class.forName(className);
		Object m=Class.forName(className).newInstance();//����������һ��ʵ��
		System.out.println(c2);
		System.out.println(m);
		//������
		Class c3=int.class;
		System.out.println(c3);
		Class c4=Double[].class;
		System.out.println(c4);
	}
}
