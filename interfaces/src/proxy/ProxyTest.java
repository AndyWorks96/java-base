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
			 * 我们可以对InvocationHandler看做一个中介类，中介类持有一个被代理对象，
			 * 在invoke方法中调用了被代理对象的相应方法。
			 * 通过聚合方式持有被代理对象的引用，把外部对invoke的调用最终都转为对被代理对象的调用。
			 * 
			 * 生成的代理类：$Proxy0 extends Proxy implements Comparable，
			 * 我们看到代理类继承了Proxy类，所以也就决定了java动态代理只能对接口进行代理，
			 * Java的继承机制注定了这些动态代理类们无法实现对class的动态代理。 
			 */
			InvocationHandler handler=new TraceHandler(value);
			//interface java.lang.Comparable,函数的参数是数组类型的，所以要传递一个数组进去。
			Class[] interfaces=new Class[]{Comparable.class};
			//new Class<?>[]
			//System.out.println(Comparable.class.getSuperclass());
			
			//proxy->$proxy0
			Object proxy = Proxy.newProxyInstance(null, interfaces, handler);
			
			elements[i]=proxy;
		}
		
		//疑问1：什么时候触发调用处理器
		
		//构造一个随机整数
		Integer key=new Random().nextInt(elements.length)+1;
		System.out.println(key);
		
		//测试触发调用处理器
		Comparable test = (Comparable)elements[245];
		test.compareTo(key);
		System.out.println(elements[245]);
		
		
		//二分查找key
		int result=Arrays.binarySearch(elements, key);
		//找到打印
		//打印tostring方法是因为println方法调用了代理对象的toString方法，这个调用会被重定向到调用处理器上
		if(result>=0)System.out.println(elements[result]);
	}
}

//定义调用处理器
//InvocationHandler接口只有一个invoke方法，需要实现该方法,invoke方法中执行被代理对象target的相应方法
class TraceHandler implements InvocationHandler{
	private Object target;
	public TraceHandler(Object t){
		target=t;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		
		//打印隐式参数
		System.out.print(target);
		//打印方法名
		System.out.print("."+method.getName()+"(");
		//打印显示参数
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