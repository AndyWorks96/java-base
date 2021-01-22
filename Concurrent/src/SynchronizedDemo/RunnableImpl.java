package SynchronizedDemo;

public class RunnableImpl implements Runnable {
	//卖票案例
	/*
	 * 出现了线程安全问题
	 * 卖出了不存在的票和重复的票
	 * 解决线程安全问题的一种方案：使用同步代码块
	 * 同步方法
	 * 锁对象是this，new RunnableImpl(),
	
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
	//静态同步方法
	//锁对象不是this，是本类的class属性
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
