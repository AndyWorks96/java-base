 package lambda;

import java.util.Arrays;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

//labda���ʽ����һ������飬�Լ��������ı����淶�������������ı��ʽ��
//6.3.2���ʽ���﷨

public class LambdaDemo {
	public static void main(String[] args) {
	
		String[] planets=new String[]{"Mercury","Venus","Earth","Mars",
				"Jupiter","Saturn","Uranus","Neptune"};
//		System.out.println(planets);
		System.out.println("ԭ˳��:");
		System.out.println(Arrays.toString(planets));
		System.out.println("�����:");
		Arrays.sort(planets);
		System.out.println(Arrays.toString(planets));
		System.out.println("����Ԫ�س�������:");
		//Arrays.sort����Ϊһ��string������󣬺ͷ��Ͷ��󣬴˴�first�г��ȿ����ƶ�firstΪstring���ͣ����úܶ����������
		Arrays.sort(planets,(first,second)->first.length()-second.length());
		System.out.println(Arrays.toString(planets));
		
//		Timer t=new Timer(1000,event->System.out.println("The time is "+new Date()));
		Timer t=new Timer(1000, System.out::println);
		t.start();
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
		
	}
}
