package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

//ʹ�÷����д�����������
public class CopyOfTest {
	public static void main(String[] args) {
		int[] a={1,2,3};
		a=(int[])goodCopyOf(a,10);//��̬��������
		System.out.println(Arrays.toString(a));
		
		String[] b={"Tom","Dick","Harry"};
		System.out.println("����һ���쳣");
		//b=(String [])badCopyOf(b, 10);
		b=(String[])goodCopyOf(b, 10);
		System.out.println(Arrays.toString(b));
	}
	
	//����Ϊ��������
	public static Object[] badCopyOf(Object[] a,int newLength)
	{
		Object[] newArray=new Object[newLength];
		System.arraycopy(a, 0, newArray, 0, Math.min(a.length, newArray.length));;
		return newArray;
	}
	//����ΪObject����,��Ϊ��������int[]����ת����object��������ת���ɶ������顣
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
