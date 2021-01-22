package set;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;


//ɢ�м�

public class setTest {
	public static void main(String[] args) throws FileNotFoundException {
		Set<String> words=new HashSet<>();//����һ���յ�ɢ�м���Ҳ���Թ���һ��ָ��������ɢ�м���
		long totalTime=0;
		File file=new File("src/alice.txt");
		
		//ת��ʱ��
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String dateStr = dateformat.format(System.currentTimeMillis());
		
		try(Scanner in=new Scanner(file))
		{
			while(in.hasNext()){
				String word =in.next();
				long callTime=System.currentTimeMillis();
				words.add(word);
				callTime=System.currentTimeMillis()-callTime;
				System.out.println("======"+callTime+"======");
				totalTime +=callTime;
				System.out.println("****"+totalTime+"****");
			}
			
		}
		
		//������
		Iterator<String> iter=words.iterator();
		for(int i=1;i<=100&&iter.hasNext();i++){
			System.out.println(iter.next());
		}
		//System.out.println("...");
		System.out.println(words.size()+" distinct words.+ "+totalTime+"millseconds");
		
		
		
		
	}
}
