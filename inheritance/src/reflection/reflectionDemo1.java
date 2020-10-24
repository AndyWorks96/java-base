package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;


//利用反射分析类的能力
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
			//打印类名和超类名如果不为object类
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
	//打印一个所有的构造函数
	public static void printConstructors(Class cl)
	{
		Constructor[] constructors=cl.getConstructors();
		for(Constructor c:constructors)
		{
			String name=c.getName();
			System.out.print(" ");
			//描述public和static这样的修饰符使用情况
			String modifiers=Modifier.toString(c.getModifiers());
			if(modifiers.length()>0)System.out.print(modifiers+" ");
			System.out.print(name+"(");
			
			//打印参数类型
			Class[] paramTypes=c.getParameterTypes();
			for(int j=0;j<paramTypes.length;j++)
			{
				if(j>0) System.out.print(", ");
				System.out.print(paramTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	//打印一个类所有方法
	public static void printMethods(Class cl)
	{
		Method[] methods=cl.getDeclaredMethods();
		for(Method m:methods)
		{
			Class reType=m.getReturnType();
			String name=m.getName();
			System.out.print(" ");
			//打印修饰符，返回类型和方法名
			String modifiers=Modifier.toString(m.getModifiers());
			if(modifiers.length()>0)
				System.out.print(modifiers+" ");
			System.out.print(reType.getName()+" "+name+"(");
			//打印参数类型
			Class[] paraTypes=m.getParameterTypes();
			for(int j=0;j<paraTypes.length;j++)
			{
				if(j>0)System.out.print(",");
				System.out.print(paraTypes[j].getName());
			}
			System.out.println(");");
		}
	}
	
	//打印一个类的所有域
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
