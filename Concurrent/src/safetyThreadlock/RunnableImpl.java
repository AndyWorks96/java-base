package safetyThreadlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class RunnableImpl implements Runnable {
	//ÂôÆ±°¸Àý
	private int ticket=100;
	Lock lock =new ReentrantLock();
	@Override
	public void run() {
		while(true){
			lock.lock();
			if(ticket>0){
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println(Thread.currentThread().getName()+"-->"+ticket);
				ticket--;
			}
			lock.unlock();
		}
		
	}
}
