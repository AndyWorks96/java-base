package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

//使用反射编写泛型数组代码
public class CopyOfTest {
	public static void main(String[] args) {
		int[] a={1,2,3};
		a=(int[])goodCopyOf(a,10);//动态创建数组
		System.out.println(Arrays.toString(a));
		
		String[] b={"Tom","Dick","Harry"};
		System.out.println("将报一个异常");
		//b=(String [])badCopyOf(b, 10);
		b=(String[])goodCopyOf(b, 10);
		System.out.println(Arrays.toString(b));
	}
	
	//声明为对象数组
	public static Object[] badCopyOf(Object[] a,int newLength)
	{
		Object[] newArray=new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newArray.length));;
		return newArray;
	}
	//声明为Object对象,因为整型数组int[]可以转换成object，但不能转换成对象数组。
	public static Object goodCopyOf(Object a,int newLength)
	{
		Class class1=a.getClass();
		if(!class1.isArray()) return null;
		Class componetType=class1.getComponentType();
		int length=Array.getLength(a);
		Object newArray=Array.newInstance(componetType, newLength);
		System.arraycopy(a, 0, newArray, 0, Math.min(length, newLength));
		return newArray;
		
	}
	
	
}
