package safetyThreadlock;

public class waitTest {
	public static Object obj = new Object();
	
	public static void main(String[] args) 
	{
		// ��ʾwaiting
		//��һ���̣߳��ȴ��߳�
		new Thread(new Runnable() {
			@Override 
			public void run() { 
				while (true){ 
					synchronized (obj){ 
						try {
							System.out.println( Thread.currentThread().getName()
								+"=== ��ȡ�������󣬵���wait����������waiting״̬���ͷ�������");
							obj.wait(); //���޵ȴ� 
							//obj.wait(5000); //��ʱ�ȴ�, 5�� ʱ�䵽���Զ����� 
							} 
						catch (InterruptedException e) { e.printStackTrace(); }
				
					}
				}
			}
		},"�ȴ��߳�").start();
		
		//�ڶ����̣߳������߳�
		new Thread(new Runnable() 
		{ 
			@Override public void run() 
			{ while (true){ 
				//ÿ��3�� ����һ�� 
				try {
					System.out.println( Thread.currentThread().getName() +"�\�\�\�\�\ �ȴ�3����"); 
					Thread.sleep(3000); 
					} 
				catch (InterruptedException e) 
				{ 
					e.printStackTrace(); 
				}
				synchronized (obj)
				{ 
					System.out.println( Thread.currentThread().getName() +"�\�\�\�\�\ ��ȡ������ ��,����notify�������ͷ�������"); 
					obj.notify(); 
					} 
			} 
			 } 
			},"�����߳�").start();
			
		
		
	
		
		
		
		
		
	}
}
