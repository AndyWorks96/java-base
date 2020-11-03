package methods;

import java.lang.reflect.Method;

public class MethodTableTest {
/*
 * �������ⷽ��
 * 
 */
	public static void main(String[] args) throws Exception {
		Method square=MethodTableTest.class.getMethod("square01", double.class);
		Method sqrt =Math.class.getMethod("sqrt", double.class);
		printTable(1, 10, 10, square);
		printTable(1, 10, 10, sqrt);
	
	}
	public static double square01(double x){
		
		return x*x;
	}
	public static void printTable(double from,double to,int n,Method f){
		System.out.println(f);
		//���f����ǩ��		
		double dx=(to-from)/(n-1);
		for(double x=from;x<=to;x+=dx)
		{
			try {
				//��һ��Ϊ��ʽ����������Ϊ��ʽ����
				//�˴�Ϊ�˲鿴Դ�������Դ�����ӣ���Ҫ����jdk���ҵ�src.zip���ļ���
				//printf�����ڸ�ʽת��������Ҫע�ⲻ�ǻ��������ֻ���ھ���ת��
				double y=(Double) f.invoke(null, x);
				System.out.printf("%10.4f | %10.4f%n",x,y);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
}
