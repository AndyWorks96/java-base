package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;


//���÷�������������
public class reflectionDemo1 {
	public static void main(String[] args) {
		String name;
		if(args.length>0) name=args[0];
		else
		{
			Scanner in=new Scanner(System.in);
			System.out.println("Enter class name(e.g. java.util.Date)");
			name=in.next();
			System.out.println(name);
		}
		try {
			//��ӡ�����ͳ����������Ϊobject��
			Class cl=Class.forName(name);
			Class superCl=cl.getSuperclass();
			System.out.println(superCl.getName());
			String modifiers=Modifier.toString(cl.getModifiers());
			if(modifiers.length()>0)System.out.print(modifiers+" ");
			System.out.print("class "+name);
			if(superCl!=null&&superCl!=Object.class)System.out.print(" extends "+superCl.getName());
			
			System.out.print("\n{\n");
			printConstructors(cl);
			System.out.println();
			printMethods(cl);
			System.out.println();
			printFileds(cl);
			System.out.println("}");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	//��ӡһ�����еĹ��캯��
	public static void printConstructors(Class cl)
	{
		Constructor[] constructors=cl.getConstructors();
		for(Constructor c:constructors)
		{
			String name=c.getName();
			System.out.print(" ");
			//����public��static���������η�ʹ�����
			String modifiers=Modifier.toString(c.getModifiers());
			if(modifiers.length()>0)System.out.print(modifiers+" ");
			System.out.print(name+"(");
			
			//��ӡ��������
			Class[] paramTypes=c.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++)
			{
				if(j>0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	//��ӡһ�������з���
	public static void printMethods(Class cl)
	{
		Method[] methods=cl.getDeclaredMethods();
		for(Method m:methods)
		{
			Class reType=m.getReturnType();
			String name=m.getName();
			System.out.print(" ");
			//��ӡ���η����������ͺͷ�����
			String modifiers=Modifier.toString(m.getModifiers());
			if(modifiers.length()>0)
				System.out.print(modifiers+" ");
			System.out.print(reType.getName()+" "+name+"(");
			//��ӡ��������
			Class[] paraTypes=m.getParameterTypes();
			for(int j=0;j<paraTypes.length;j++)
			{
				if(j>0)System.out.print(",");
				System.out.print(paraTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	//��ӡһ�����������
	public static void printFileds(Class cl)
	{
		Field[] fields=cl.getDeclaredFields();
		for(Field f:fields)
		{
			Class type=f.getType();
			String name=f.getName();
			System.out.print(" ");
			String modifiers=Modifier.toString(f.getModifiers());
			if(modifiers.length()>0)
				System.out.print(modifiers+" ");
			System.out.println(type.getName()+" "+name+";");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
