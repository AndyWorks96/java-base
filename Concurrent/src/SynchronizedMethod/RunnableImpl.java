package SynchronizedMethod;

public class RunnableImpl implements Runnable {
	//��Ʊ����
	/*
	 * �������̰߳�ȫ����
	 * �����˲����ڵ�Ʊ���ظ���Ʊ
	 * ����̰߳�ȫ�����һ�ַ�����ʹ��ͬ�������
	 * ��ʽ��
	 * 		synchronized(������){
	 * 				���ܳ����̰߳�ȫ�Ĵ��루 �����˹������ݵĴ��룩
	 * 						}
	 * ע�⣺
	 * 	1.ͨ�������е����������ʹ���������
	 *  2.�����뱣֤����߳�ʹ�õ������������ͬһ��
	 *  3.���������ã�
	 *  	��ͬ���������ס��ֻ��һ���߳���ͬ���������ִ��
	 */
	private int ticket=100;
	
	//����������
	private Object obj=new Object();
	
	@Override
	public void run() {
		while(true){
			synchronized (obj) {
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
		
	}
}
