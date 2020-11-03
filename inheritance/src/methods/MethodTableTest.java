package methods;

import java.lang.reflect.Method;

public class MethodTableTest {
/*
 * 调用任意方法
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
		//输出f方法签名		
		double dx=(to-from)/(n-1);
		for(double x=from;x<=to;x+=dx)
		{
			try {
				//第一个为隐式参数，其他为显式参数
				//此处为了查看源码加入了源码链接，主要是在jdk下找到src.zip的文件。
				//printf常用于格式转换，但需要注意不是换行输出，只用于精度转换
				double y=(Double) f.invoke(null, x);
				System.out.printf("%10.4f | %10.4f%n",x,y);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}	
}
