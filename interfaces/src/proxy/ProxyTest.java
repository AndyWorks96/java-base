package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {
	
	public static void main(String[] args) {
		Object[] elements=new Object[1000];
		for(int i=0;i<elements.length;i++){
			Integer value=i+1;
			
			/**
			 * ���ǿ��Զ�InvocationHandler����һ���н��࣬�н������һ�����������
			 * ��invoke�����е����˱�����������Ӧ������
			 * ͨ���ۺϷ�ʽ���б������������ã����ⲿ��invoke�ĵ������ն�תΪ�Ա��������ĵ��á�
			 * 
			 * ���ɵĴ����ࣺ$Proxy0 extends Proxy implements Comparable��
			 * ���ǿ���������̳���Proxy�࣬����Ҳ�;�����java��̬����ֻ�ܶԽӿڽ��д���
			 * Java�ļ̳л���ע������Щ��̬���������޷�ʵ�ֶ�class�Ķ�̬���� 
			 */
			InvocationHandler handler=new TraceHandler(value);
			//interface java.lang.Comparable,�����Ĳ������������͵ģ�����Ҫ����һ�������ȥ��
			Class[] interfaces=new Class[]{Comparable.class};
			//new Class<?>[]
			//System.out.println(Comparable.class.getSuperclass());
			
			//proxy->$proxy0
			Object proxy = Proxy.newProxyInstance(null, interfaces, handler);
			
			elements[i]=proxy;
		}
		
		//����1��ʲôʱ�򴥷����ô�����
		
		//����һ���������
		Integer key=new Random().nextInt(elements.length)+1;
		System.out.println(key);
		
		//���Դ������ô�����
		Comparable test = (Comparable)elements[245];
		test.compareTo(key);
		System.out.println(elements[245]);
		
		
		//���ֲ���key
		int result=Arrays.binarySearch(elements, key);
		//�ҵ���ӡ
		//��ӡtostring��������Ϊprintln���������˴�������toString������������ûᱻ�ض��򵽵��ô�������
		if(result>=0)System.out.println(elements[result]);
	}
}

//������ô�����
//InvocationHandler�ӿ�ֻ��һ��invoke��������Ҫʵ�ָ÷���,invoke������ִ�б��������target����Ӧ����
class TraceHandler implements InvocationHandler{
	private Object target;
	public TraceHandler(Object t){
		target=t;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//��ӡ��ʽ����
		System.out.print(target);
		//��ӡ������
		System.out.print("."+method.getName()+"(");
		//��ӡ��ʾ����
		if(args!=null){
			for(int i=0;i<args.length;i++)
			{
				System.out.print(args[i]);
				if(i<args.length-1)System.out.print(",");
			}
		}
		System.out.println(")");
		return method.invoke(target, args);
		
	}
	
}