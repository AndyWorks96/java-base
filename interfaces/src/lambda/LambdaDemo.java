 package lambda;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

//labda表达式就是一个代码块，以及传入代码的变量规范（带参数变量的表达式）
//6.3.2表达式的语法

public class LambdaDemo {
	public static void main(String[] args) {
	
		String[] planets=new String[]{"Mercury","Venus","Earth","Mars",
				"Jupiter","Saturn","Uranus","Neptune"};
//		System.out.println(planets);
		System.out.println("原顺序:");
		System.out.println(Arrays.toString(planets));
		System.out.println("排序后:");
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		System.out.println("依据元素长度排序:");
		//Arrays.sort里面为一个string数组对象，和泛型对象，此处first有长度可以推断first为string类型，利用很多个排序函数。
		Arrays.sort(planets,(first,second)->first.length()-second.length());
		System.out.println(Arrays.toString(planets));
		
//		Timer t=new Timer(1000,event->System.out.println("The time is "+new Date()));
		Timer t=new Timer(1000, System.out::println);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
		
	}
}
