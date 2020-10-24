package objectAnalyzer;

import java.util.ArrayList;


//在运行时使用反射分析对象
public class objectAnalyzerTest {
	public static void main(String[] args) {
		ArrayList<Integer> squares=new ArrayList<>();
		for(int i=1;i<=5;i++)
		{
			squares.add(i*i);
		}
		System.out.println(new objectAnalyzer().toString(squares));
	}
}
