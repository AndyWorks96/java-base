package SynchronizedDemo;

public class RunnableImpl implements Runnable {
	//��Ʊ����
	/*
	 * �������̰߳�ȫ����
	 * �����˲����ڵ�Ʊ���ظ���Ʊ
	 * ����̰߳�ȫ�����һ�ַ�����ʹ��ͬ�������
	 * ͬ������
	 * ��������this��new RunnableImpl(),
	
	 */
	private static int ticket=100;
	
	
	
	@Override
	public void run() {
		System.out.println("this"+this);
		while(true){
			
			sellTicket();
		}
		
	}
//	public synchronized void sellTicket(){
//	
//			if(ticket>0){
//				try {
//					Thread.sleep(10);
//				} catch (Exception e) {
//					// TODO: handle exception
//				}
//				System.out.println(Thread.currentThread().getName()+"-->"+ticket);
//				ticket--;
//			
//		}
	//��̬ͬ������
	//��������this���Ǳ����class����
	public static synchronized void sellTicket(){
		
				if(ticket>0){
					try {
						Thread.sleep(10);
					} catch (Exception e) {
						// TODO: handle exception
					}
					System.out.println(Thread.currentThread().getName()+"-->"+ticket);
					ticket--;
				
			}
	}
}
