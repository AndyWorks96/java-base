package safetyThread;

public class RunnableImpl implements Runnable {
	//ÂôÆ±°¸Àý
	private int ticket=100;
	
	@Override
	public void run() {
		while(true){
			
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
