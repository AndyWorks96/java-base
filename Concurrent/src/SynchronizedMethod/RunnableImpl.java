package SynchronizedMethod;

public class RunnableImpl implements Runnable {
	//卖票案例
	/*
	 * 出现了线程安全问题
	 * 卖出了不存在的票和重复的票
	 * 解决线程安全问题的一种方案：使用同步代码块
	 * 格式：
	 * 		synchronized(锁对象){
	 * 				可能出现线程安全的代码（ 访问了共享数据的代码）
	 * 						}
	 * 注意：
	 * 	1.通过代码中的锁对象可以使用任意对象
	 *  2.但必须保证多个线程使用的锁对象必须是同一个
	 *  3.锁对象作用：
	 *  	把同步代码块锁住，只让一个线程在同步代码块中执行
	 */
	private int ticket=100;
	
	//创建锁对象
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
